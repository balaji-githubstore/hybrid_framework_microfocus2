package com.microfocus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microfocus.base.AutomationWrapper;
import com.microfocus.pages.LoginPage;
import com.microfocus.pages.MainPage;
import com.microfocus.utilities.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProviderForJson", dataProviderClass = DataUtils.class,groups = {"smoke","login"})
	public void validLoginTest(String username, String password, String expectedUrl) {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
		

		MainPage main = new MainPage(driver);
		main.waitForPresenceOfAdmin();

		String actualUrl = main.getMainPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProvider = "commonDataProviderForJson", dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) {

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}

}
