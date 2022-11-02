package com.microfocus.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;
import com.microfocus.utilities.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// wait for page load
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
	}

	@Test(dataProvider = "invalidLoginData",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String actualError = driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

}
