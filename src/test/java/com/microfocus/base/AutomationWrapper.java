package com.microfocus.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microfocus.utilities.PropUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationWrapper {

	protected WebDriver driver;

	private static ExtentReports extent;

	protected ExtentTest test;

	@BeforeSuite(alwaysRun = true)
	public void init() {
		if (extent == null) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
			extent.attachReporter(spark);
		}
	}

	@AfterSuite(alwaysRun = true)
	public void end() {
		extent.flush();
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "node" })
	public void setup(@Optional("ch") String browserName, @Optional("NA") String node, Method method) throws Exception {

		test = extent.createTest(method.getName());

		if (node.equalsIgnoreCase("na")) {
			if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("ff")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (browserName.equalsIgnoreCase("edge")) {
				cap.setBrowserName("edge");
				
			} else if (browserName.equalsIgnoreCase("ff")) {
				cap.setBrowserName("firefox");
			} else {
				cap.setBrowserName("chrome");
			}
			driver = new RemoteWebDriver(new URL(node), cap);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String baseUrl = PropUtils.getValue("test-data/data.properties", "url");

		driver.get(baseUrl);
	}

	public void embedScreenshotToExtent() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(base64);
	}

	public void saveScreenshot() throws IOException {
		String fileName = "sc_" + LocalDateTime.now().toString().replace(":", "-") + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target/screenshot/" + fileName));
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
			embedScreenshotToExtent();
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}

//		saveScreenshot();

		driver.quit();
	}
}
