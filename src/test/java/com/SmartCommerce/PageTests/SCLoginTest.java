package com.SmartCommerce.PageTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SmartCommerce.Reports.ExtentReporting;
import com.SmartCommerce.Utilities.CommonFunctions;
import com.SmartCommerce.PageObjects.SCLoginPage;

public class SCLoginTest extends BaseTest {

	private WebDriver driver;
	private SCLoginPage loginPage;
	private CommonFunctions actions;
	private static final Logger log = LogManager.getLogger(SCLoginTest.class);
	private ExtentReporting reporting;
	private static ExtentTest logger;
	private ExtentReports reporter = ExtentReporting.getReport();
	public WebDriverWait wait;

	/**
	 * initializes driver
	 * 
	 **/

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized...");
		reporting = new ExtentReporting(driver);
		actions = new CommonFunctions(driver);
		loginPage = new SCLoginPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	/**
	 * testNG data provider for tests
	 * 
	 * @return - Object[][]
	 */

	/*
	 * @DataProvider public Object[][] getData() { return new Object[][] { {
	 * "hashim.farooq@nxb.com.pk", "intex123" }, { "hashim.farooq@nxb.com.pk", "abc"
	 * } }; }
	 */

	/**
	 * actual test, creates objects of pages, runs end-to-end and asserts the result
	 * 
	 * @param Login    - from data provider
	 * @param Password - from data provider
	 * @throws InterruptedException
	 */

	/* @Test(dataProvider = "getData") */

	@Test

	public void loginSC_NonSSOUser() throws InterruptedException {

		Boolean Display = driver.findElement(loginPage.ManagePreferences).isDisplayed();

		if (Display.equals(true)) {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.ManagePreferences));

			// String txtActualManagePreferences = loginPage.verifyPerefernces();

			// if
			// (txtActualManagePreferences.equalsIgnoreCase(Constants.txtManagePreferences))
			// {
			loginPage.checkPerefernces();
			loginPage.continuePerefernces();
			log.info("Login Page opened...");
			actions.navigateTo(prop.getProperty("url"));
			log.info("*************************Test Starting***************************");
			log.info("Login_001: Verify Smart Commerce Login Page is Opened.");
			logger = reporter.startTest("SCLogin_001");
			log.info("Step 1: Enter Client Key.");
			loginPage.enterClientKey();
			log.info("Step 1: Enter Valid Email.");
			loginPage.enterEmailToSignin();
			log.info("Step 2: Enter Correct Password.");
			loginPage.enterCorrectPassword();
			log.info("Step 3: Click Login Button.");
			loginPage.clickOnLoginButton();

			// Verify Title of the Site
			String Expected_Title = "Main";
			String Actual_Title = loginPage.MainText();

			if (Actual_Title.equalsIgnoreCase(Expected_Title)) {
				log.info("Logged In with Valid Credentials...");
				logger.log(LogStatus.PASS, "Successfully Logged into SC Smart Suite.", "Test Passed");
				loginPage.clickOnLogoutButton();
				log.info("Logging Out...");
				Thread.sleep(2000);
			} else {
				log.info("Login Page opened...");
				actions.navigateTo(prop.getProperty("url"));
				log.info("*************************Test Starting***************************");
				log.info("Login_001: Verify Smart Commerce Login Page is Opened.");
				logger = reporter.startTest("SCLogin_001");
				log.info("Step 1: Enter Client Key.");
				loginPage.enterClientKey();
				log.info("Step 1: Enter Valid Email.");
				loginPage.enterEmailToSignin();
				log.info("Step 2: Enter Correct Password.");
				loginPage.enterCorrectPassword();
				log.info("Step 3: Click Login Button.");
				loginPage.clickOnLoginButton();

				// Verify Title of the Site
				Expected_Title = "Main";
				Actual_Title = loginPage.MainText();

				if (Actual_Title.equalsIgnoreCase(Expected_Title)) {
					log.info("Logged In with Valid Credentials...");
					logger.log(LogStatus.PASS, "Successfully Logged into SC Smart Suite.", "Test Passed");
					loginPage.clickOnLogoutButton();
					log.info("Logging Out...");
					Thread.sleep(2000);

				}
				log.info("Credentials are not Valid...");
				logger.log(LogStatus.FAIL, "User Credentials were incorrect", "Test Failed");
				reporting.captureScreenShot("UserInvalidCredentials.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/UserInvalidCredentials.png"));

			}
		}
	}

	@Test /* (groups = { "regression","smoke"}) */

	/*
	 * public void loginSC_SSOUSer() throws InterruptedException {
	 * 
	 * logger = reporter.startTest("SCLogin_002");
	 * driver.get(Constants.Dashboard_Page_url);
	 * wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.Main));
	 * 
	 * Boolean Display =
	 * driver.findElement(loginPage.ManagePreferences).isDisplayed();
	 * 
	 * if (Display.equals(true)) {
	 * 
	 * loginPage.checkPerefernces(); loginPage.continuePerefernces();
	 * 
	 * } // Verify Title of the Page String Expected_Title = "Main"; String
	 * Actual_Title = loginPage.MainText();
	 * 
	 * if (Actual_Title.equalsIgnoreCase(Expected_Title)) {
	 * log.info("Logged In with Valid Credentials..."); logger.log(LogStatus.PASS,
	 * "Successfully Logged into SC Smart Suite.", "Test Passed");
	 * loginPage.clickOnLogoutButton(); log.info("Logging Out...");
	 * 
	 * String txtManagePreferences = "Manage Preferences";
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.
	 * ManagePreferences)); String txtActualManagePreferences =
	 * loginPage.verifyPerefernces();
	 * 
	 * if (txtActualManagePreferences.equalsIgnoreCase(txtManagePreferences)) {
	 * loginPage.checkPerefernces(); loginPage.continuePerefernces();
	 * 
	 * 
	 * Thread.sleep(2000); } else { log.info("Credentials are not Valid...");
	 * logger.log(LogStatus.FAIL, "User Credentials were incorrect", "Test Failed");
	 * reporting.captureScreenShot("UserInvalidCredentials.png");
	 * logger.log(LogStatus.INFO, "Snapshot below: " +
	 * logger.addScreenCapture(System.getProperty("user.dir") +
	 * "/reports/UserInvalidCredentials.png"));
	 * 
	 * }} }
	 */

	/**
	 * closes driver
	 */

	@AfterTest
	public void teardown() {

		reporter.endTest(logger);
		reporting.closeReport();
		driver.close();
		log.info("Driver is closed...");
		log.info("*************************Test Ending***************************");

	}
}
