package com.SmartCommerce.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	/**
	 * helper method to wait for element
	 * 
	 * @param ele - WebElement
	 * @return - boolean
	 */
	public boolean waitForElement(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele)) != null ? true : false;
	}
	
	public void click(WebElement element) {
		element.click();
		
	}
	
	public void enterText(WebElement inputfield, String value) {
		inputfield.sendKeys(value);
	}
	
	public void navigateTo(String url) {
		driver.get(url);	
	}
	
	public void selectFromDropdown(WebElement dropdown, String value) {
		Select dd = new Select(dropdown);
		dd.selectByValue(value);
	}

}
