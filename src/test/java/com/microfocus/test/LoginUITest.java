package com.microfocus.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {
	
	@Test(priority = 1)
	public void validateTitleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(priority = 2)
	public void validatePlaceholderTest() {
		String actualUserNamePlaceholder=driver.findElement(By.name("username")).getAttribute("placeholder");
		String actualPasswordPlaceholder=driver.findElement(By.name("password")).getAttribute("placeholder");
		
		Assert.assertEquals(actualUserNamePlaceholder, "Username");
		Assert.assertEquals(actualPasswordPlaceholder, "Password");
	}
	
}
