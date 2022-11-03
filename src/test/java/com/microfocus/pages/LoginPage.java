package com.microfocus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//page objects
public class LoginPage {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By errorLocator = By.xpath("//p[contains(@class,'alert-content-text')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}

	public String getUsernamePlaceholder() {
		return driver.findElement(usernameLocator).getAttribute("placeholder");
	}

	public String getPasswordPlaceholder() {
		return driver.findElement(passwordLocator).getAttribute("placeholder");
	}
}
