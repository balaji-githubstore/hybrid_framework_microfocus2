package com.microfocus.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExtent {
	
	public static void main(String[] args) {
		
		//run only once in the beginning of the suite //@BeforeSuite
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		//create a test in the report //run before each @Test method //@BeforeMethod
		ExtentTest test= extent.createTest("MyFirstTest-MicroFocus");
		
		//@Test
		
		//log the result //run after each @Test method //@AfterMethod
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");
		
		
		//run at the end to generate the report //@AfterSuite
		extent.flush();
		
	}

}
