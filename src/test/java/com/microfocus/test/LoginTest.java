package com.microfocus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;
import com.microfocus.pages.LoginPage;
import com.microfocus.utilities.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLoginTest(String username, String password, String expectedUrl) {

		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
	
		// wait for page load
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError) {
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
		
		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}

}
