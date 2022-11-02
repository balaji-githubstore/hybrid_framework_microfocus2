package com.microfocus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;
import com.microfocus.pages.LoginPage;

public class LoginUITest extends AutomationWrapper {
	
	@Test(priority = 1)
	public void validateTitleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(priority = 2)
	public void validatePlaceholderTest() {
		LoginPage login=new LoginPage(driver);
		String actualUserNamePlaceholder=login.getUsernamePlaceholder();
		//String actualPasswordPlaceholder=driver.findElement(By.name("password")).getAttribute("placeholder");
		
		Assert.assertEquals(actualUserNamePlaceholder, "Username");
		Assert.assertEquals(login.getPasswordPlaceholder(), "Password");
	}
	
}
