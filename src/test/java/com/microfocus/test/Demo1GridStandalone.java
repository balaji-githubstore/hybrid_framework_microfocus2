package com.microfocus.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo1GridStandalone {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		WebDriver driver =new RemoteWebDriver(new URL("http://192.168.1.5:4444/"), cap);
		
		driver.get("http://google.com/");
		
		System.out.println(driver.getTitle());
		
		driver =new RemoteWebDriver(new URL("http://192.168.1.5:4444/"), cap);
		
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
