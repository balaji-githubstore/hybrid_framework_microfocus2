package com.microfocus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;
import com.microfocus.pages.LoginPage;
import com.microfocus.utilities.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLoginTest(String username, String password, String expectedUrl) {

		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		// wait for page load
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		String actualError = LoginPage.getInvalidErrorMessage(driver);
		Assert.assertEquals(actualError, expectedError);
	}

}
