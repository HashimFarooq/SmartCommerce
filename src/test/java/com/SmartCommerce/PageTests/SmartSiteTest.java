package com.SmartCommerce.PageTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SmartCommerce.PageObjects.SmartSitePage;
import com.SmartCommerce.Reports.ExtentReporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SmartSiteTest extends BaseTest {

	private WebDriver driver;
	private SmartSitePage SS;
	private WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(SmartSiteTest.class);
	private ExtentReporting reporting;
	private static ExtentTest logger;
	private ExtentReports reporter = ExtentReporting.getReport();
	public static String winHandleBefore;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("*************************Test Starting***************************");
		log.info("Driver is initialized...");
		SS = new SmartSitePage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		reporting = new ExtentReporting(driver);
	}

	@Test(priority = 1, description = "Verify Creating a Smart Site Widget using Name.", groups = { "SC_Smoke" })
	public void SMARTSITE_CREATE_WIDGET_USING_NAME() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_001");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteCreateNewWidgetUsingName();

		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();

		boolean status = SS.clickSmartSiteWidgetURL();

		if (status == true) {
			try {
				Assert.assertTrue(SS.verifyNewPage());
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_NAME: Test Passed.");
				logger.log(LogStatus.PASS, "Smart Site Widget Created Successfully.", "Test Passed");

			} catch (Error e) {
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_NAME: Test Failed.");
				logger.log(LogStatus.FAIL,
						"Smart Site Widget was not created successfull, need to check the Logs for details.",
						"Test Failed");
				reporting.captureScreenShot("CreateWidgetSmartSiteUsingName.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSiteUsingName.png"));
			}

		} else {
			// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);
			log.info("SMARTSITE_CREATE_WIDGET: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Smart Site Widget was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSite.png"));
		}
	}
	
	@Test(priority = 2, description = "Verify Creating a Smart Site Widget using Wild Card.", groups = { "SC_Smoke" })
	public void SMARTSITE_CREATE_WIDGET_USING_WILDCARD() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_002");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteCreateNewWidgetUsingWildCard();

		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();

		boolean status = SS.clickSmartSiteWidgetURL();

		if (status == true) {
			try {
				Assert.assertTrue(SS.verifyNewPage());
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_WILDCARD: Test Passed.");
				logger.log(LogStatus.PASS, "Smart Site Widget Created Successfully.", "Test Passed");

			} catch (Error e) {
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_WILDCARD: Test Failed.");
				logger.log(LogStatus.FAIL,
						"Smart Site Widget was not created successfull, need to check the Logs for details.",
						"Test Failed");
				reporting.captureScreenShot("CreateWidgetSmartSiteWildCard.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSiteWildCard.png"));
			}

		} else {
			// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);
			log.info("SMARTSITE_CREATE_WIDGET: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Smart Site Widget was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSite.png"));
		}
	}
	
	@Test(priority = 3, description = "Verify Creating a Smart Site Widget using UPC.", groups = { "SC_Smoke" })
	public void SMARTSITE_CREATE_WIDGET_USING_UPC() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_003");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteCreateNewWidgetUsingUPC();

		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();

		boolean status = SS.clickSmartSiteWidgetURL();

		if (status == true) {
			try {
				Assert.assertTrue(SS.verifyNewPage());
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_WILDCARD: Test Passed.");
				logger.log(LogStatus.PASS, "Smart Site Widget Created Successfully.", "Test Passed");

			} catch (Error e) {
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_CREATE_WIDGET_USING_WILDCARD: Test Failed.");
				logger.log(LogStatus.FAIL,
						"Smart Site Widget was not created successfull, need to check the Logs for details.",
						"Test Failed");
				reporting.captureScreenShot("CreateWidgetSmartSiteWildCard.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSiteWildCard.png"));
			}

		} else {
			// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);
			log.info("SMARTSITE_CREATE_WIDGET: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Smart Site Widget was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateWidgetSmartSite.png"));
		}
	}
	
	
	@Test(priority = 4, description = "Verify Editing a Smart Site Widget.", groups = { "SC_Smoke" })
	public void SMARTSITE_EDIT_WIDGET() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_004");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteEditWidget();

		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();

		boolean status = SS.clickSmartSiteWidgetURL();

		if (status == true) {
			try {
				Assert.assertTrue(SS.verifyNewPage());
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_EDIT_WIDGET: Test Passed.");
				logger.log(LogStatus.PASS, "Smart Site Widget Edited Successfully.", "Test Passed");

			} catch (Error e) {
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_EDIT_WIDGET: Test Failed.");
				logger.log(LogStatus.FAIL,
						"Smart Site Widget was not Edited successfull, need to check the Logs for details.",
						"Test Failed");
				reporting.captureScreenShot("EditWidgetSmartSite.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/EditWidgetSmartSite.png"));
			}

		} else {
			// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);
			log.info("SMARTSITE_EDIT_WIDGET: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Smart Site Widget was not Edited successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("EditWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/EditWidgetSmartSite.png"));
		}
	}
	
	@Test(priority = 5, description = "Verify Copying a Smart Site Widget.", groups = { "SC_Smoke" })
	public void SMARTSITE_COPY_WIDGET() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_005");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteCopyWidget();
		log.info("Clicked on Copy Widget button.");

		try {
			Assert.assertTrue(SS.verifySmartSiteDeleteWidget());
			log.info("SMARTSITE_COPY_WIDGET(): Test Passed.");
			logger.log(LogStatus.PASS, "Copying Widget was Successful.", "Test Passed");
		} catch (Error e) {
			log.info("SMARTSITE_COPY_WIDGET(): Test Failed.");
			logger.log(LogStatus.FAIL, "Copying Widget was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("CopyWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CopyWidgetSmartSite.png"));
		}
	}
	
	@Test(priority = 6, description = "Verify Viewing a Smart Site Widget.", groups = { "SC_Smoke" })
	public void SMARTSITE_VIEW_WIDGET() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_006");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteViewWidget();
		log.info("Clicked on View Widget button.");
		
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();

		boolean status = SS.clickSmartSiteWidgetURL();

		if (status == true) {
			try {
				Assert.assertTrue(SS.verifyNewPage());
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_VIEW_WIDGET: Test Passed.");
				logger.log(LogStatus.PASS, "Smart Site Widget Viewed Successfully.", "Test Passed");

			} catch (Error e) {
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				log.info("SMARTSITE_VIEW_WIDGET: Test Failed.");
				logger.log(LogStatus.FAIL,
						"Smart Site Widget was not Viewed successfull, need to check the Logs for details.",
						"Test Failed");
				reporting.captureScreenShot("ViewWidgetSmartSite.png");
				logger.log(LogStatus.INFO, "Snapshot below: " + logger
						.addScreenCapture(System.getProperty("user.dir") + "/reports/ViewWidgetSmartSite.png"));
			}

		} else {
			// Switch back to original browser (first window)
						driver.switchTo().window(winHandleBefore);
			log.info("SMARTSITE_EDIT_WIDGET: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Smart Site Widget was not Edited successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("EditWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/EditWidgetSmartSite.png"));
		}
	}
	
	@Test(priority = 7, description = "Verify Deleting a Smart Site Widget.", groups = { "SC_Smoke" })
	public void SMARTSITE_DELETE_WIDGET() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_SmartSite_007");
		SS.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.smartsite));
		SS.clickSmartSite();
		log.info("Clicked on Smart Site from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SS.internalNameColumn));

		SS.clickSmartSiteDeleteWidget();
		log.info("Clicked on Delete Widget button.");

		try {
			Assert.assertTrue(SS.verifySmartSiteDeleteWidget());
			log.info("SMARTSITE_DELETE_WIDGET(): Test Passed.");
			logger.log(LogStatus.PASS, "Deleting Smart Site Widget was Successful.", "Test Passed");
		} catch (Error e) {
			log.info("SMARTSITE_DELETE_WIDGET(): Test Failed.");
			logger.log(LogStatus.FAIL, "Deleting Smart Site Widget was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("DeleteWidgetSmartSite.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/DeleteWidgetSmartSite.png"));
		}
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		log.info("Closing Driver...");
		log.info("*************************Test Ending*****************************");
		reporter.endTest(logger);
		reporting.closeReport();
		driver.close();
	}

}
