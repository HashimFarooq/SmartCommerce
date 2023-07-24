package com.SmartCommerce.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SmartCommerce.Utilities.CommonFunctions;
import com.SmartCommerce.Utilities.Constants;

import org.openqa.selenium.JavascriptExecutor;

public class SCLoginPage {

	private WebDriver driver;
	public CommonFunctions functions;
	public WebDriverWait wait ;
	
	// All objects should be defined here
	public By clientkey = By.xpath("//input[@id='clientcode']");
	public By username = By.xpath("//input[@id='username']");
	public By pass = By.xpath("//input[@id='password']");
	public By loginBtn = By.xpath("//button[@id='submit-form']");
	public By logoutBtn = By.xpath("//a[@class='btn btn-primary rounded-pill']");
	public By Main = By.xpath("//*[@id=\"main-container\"]/div/main/div[1]/div/div/div/div/div/h5");
	public By ManagePreferences = By.xpath("/html/body/div[2]/div/main/div/div/div/div/div/div/h4");
	public By ManagePreferencesCheckBox = By.xpath("//*[@id=\"firstTimeCheckbox\"]");
	public By ManagePreferencesContinue = By.xpath("//*[@id=\"initialPageContinue\"]");
	//public By googleAppOptions = By.xpath("//*[@id=\"gbwa\"]");
	
	public By googleAppOptions = By.className("gb_9c");

	public By smartSuiteStageIcon = By.xpath("//li[13]//a[1]//img[1]");

	public SCLoginPage(WebDriver driver) {
		this.driver = driver;
		functions = new CommonFunctions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String verifyPerefernces() {

		return driver.findElement(ManagePreferences).getText();
	}

	public void checkPerefernces() {

		driver.findElement(ManagePreferencesCheckBox).click();
	}

	public void continuePerefernces() {

		driver.findElement(ManagePreferencesContinue).click();
	}

	public void enterClientKey() {

		driver.findElement(clientkey).clear();
		driver.findElement(clientkey).sendKeys(Constants.ClientKey);
	}

	public void enterEmailToSignin() {

		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(Constants.ValidUsername);
	}

	public void enterCorrectPassword() {
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(Constants.CorrectPassword);
	}

	public void enterIncorrectPassword() {
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(Constants.CorrectPassword);
	}

	public void clickOnLoginButton() {
		driver.findElement(loginBtn).click();
	}

	public void clickOnLogoutButton() {
		driver.findElement(logoutBtn).click();
	}
	
	public void clickOnGoogleApps() {
		 
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(googleAppOptions));
		driver.findElement(googleAppOptions).click();
	}
	
	public void scrollBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", smartSuiteStageIcon);	
	}
	
	public void clickSmartSuiteStaging() {
		driver.findElement(smartSuiteStageIcon).click();	
	}
	
	
	
	
	
	
	

	public String MainText() {
		return driver.findElement(Main).getText();

	}

}
