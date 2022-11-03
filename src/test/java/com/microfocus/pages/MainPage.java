package com.microfocus.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private By adminLocator=By.xpath("//span[text()='Admin']");
	private By pimLocator=By.xpath("//span[text()='PIM']");
	
	private WebDriver driver;

	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnAdmin()
	{
		driver.findElement(adminLocator).click();
	}
	
	public void clickOnPIM()
	{
		driver.findElement(pimLocator).click();
	}
	
	public void waitForPresenceOfAdmin()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(adminLocator));
	}

	public String getMainPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
