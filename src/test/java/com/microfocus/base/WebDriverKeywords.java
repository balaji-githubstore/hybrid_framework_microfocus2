package com.microfocus.base;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverKeywords {

	protected WebDriver driver;
	private WebDriverWait wait;

	public WebDriverKeywords(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}

	public void typeUsingLocator(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void clickUsingLocator(By locator) {
		driver.findElement(locator).click();
	}

	public String getTextUsingLocator(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getAttributeUsingLocator(By locator,String attribute) {
		return driver.findElement(locator).getAttribute(attribute);
	}

	public void switchToWindow(String title) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

		for (String win : windows) {
			driver.switchTo().window(win);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}
	
	public void waitForPresenceOfLocator(By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
