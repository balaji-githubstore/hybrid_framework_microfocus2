package com.microfocus.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microfocus.base.WebDriverKeywords;

public class MainPage extends WebDriverKeywords {
	private By adminLocator=By.xpath("//span[text()='Admin']");
	private By pimLocator=By.xpath("//span[text()='PIM']");
	
	//private WebDriver driver;

	public MainPage(WebDriver driver)
	{
		super(driver);
		//this.driver=driver;
	}
	
	public void clickOnAdmin()
	{
		clickUsingLocator(adminLocator);
	}
	
	public void clickOnPIM()
	{
		driver.findElement(pimLocator).click();
	}
	
	public void waitForPresenceOfAdmin()
	{
		waitForPresenceOfLocator(adminLocator);
	}

	public String getMainPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
