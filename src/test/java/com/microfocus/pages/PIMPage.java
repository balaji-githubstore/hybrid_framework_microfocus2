package com.microfocus.pages;

import org.openqa.selenium.WebDriver;

import com.microfocus.base.WebDriverKeywords;

public class PIMPage extends WebDriverKeywords {

	private WebDriver driver;

	public PIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
