package com.microfocus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.microfocus.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By errorLocator = By.xpath("//p[contains(@class,'alert-content-text')]");

//	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
	}

	public void enterUsername(String username) {
		typeUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		typeUsingLocator(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickUsingLocator(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return getTextUsingLocator(errorLocator);
	}

	public String getUsernamePlaceholder() {
		return getAttributeUsingLocator(usernameLocator, "placeholder");
	}

	public String getPasswordPlaceholder() {
		return getAttributeUsingLocator(passwordLocator, "placeholder");
	}
}
