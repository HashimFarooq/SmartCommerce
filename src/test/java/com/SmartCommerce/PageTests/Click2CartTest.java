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

import com.SmartCommerce.PageObjects.Click2CartPage;
import com.SmartCommerce.Reports.ExtentReporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Click2CartTest extends BaseTest {

	private WebDriver driver;
	private Click2CartPage C2C;
	private WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(Click2CartTest.class);
	private ExtentReporting reporting;
	private static ExtentTest logger;
	private ExtentReports reporter = ExtentReporting.getReport();
	public static String winHandleBefore;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("*************************Test Starting***************************");
		log.info("Driver is initialized...");
		C2C = new Click2CartPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		reporting = new ExtentReporting(driver);
	}

	@Test(priority = 1, description = "Verify all the Click2Cart Links", groups = { "SC_Smoke" })
	public void C2C_Verify_Existing_URLS() {

		logger = reporter.startTest("SC_C2C_001");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		Boolean linkStatus = C2C.verifyClick2CartLinks();
		if (linkStatus.equals(true)) {
			log.info("C2C_Verify_Existing_URLS: Test Passed.");
			logger.log(LogStatus.PASS, "Link worked Successfully ", "Test Passed");
		} else {
			log.info("C2C_Verify_Existing_URLS: Test Failed.");
			logger.log(LogStatus.FAIL, "Some issue with the Link, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("allURLs.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/allURLs.png"));
		}
	}

	@Test(priority = 2, description = "Verify Creating a Click2Cart link using name.", groups = { "SC_Smoke" })
	public void C2C_CREATE_USING_NAME() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_002");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartCreateUsingName();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		C2C.clickCreatedClick2CartLink();
		log.info("Clicking on Created Click2Cart Link.");

		try {
			Assert.assertTrue(C2C.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_NAME: Test Passed.");
			logger.log(LogStatus.PASS, "C2C link using Product name Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_NAME: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLusingName.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLusingName.png"));
		}
	}
	
	@Test(priority = 3, description = "Verify Creating a Click2Cart link using UPC.", groups = { "SC_Smoke" })
	public void C2C_CREATE_USING_UPC() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_003");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartCreateUsingUPC();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		C2C.clickCreatedClick2CartLink();
		log.info("Clicking on Created Click2Cart Link.");

		try {
			Assert.assertTrue(C2C.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_UPC: Test Passed.");
			logger.log(LogStatus.PASS, "C2C link using UPC Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_UPC: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLusingUPC.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLusingUPC.png"));
		}
	}
	
	@Test(priority = 4, description = "Verify Creating a Click2Cart link using Wild Card.", groups = { "SC_Smoke" })
	public void C2C_CREATE_USING_WILDCARD() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_004");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartCreateUsingWildCard();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		C2C.clickCreatedClick2CartLink();
		log.info("Clicking on Created Click2Cart Link.");

		try {
			Assert.assertTrue(C2C.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_WILDCARD: Test Passed.");
			logger.log(LogStatus.PASS, "C2C link using WildCard Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_CREATE_USING_WILDCARD: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not created successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLusingWildCard.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLusingWildCard.png"));
		}
	}
	
	@Test(priority = 5, description = "Verify Clicking a Click2Cart link.", groups = { "SC_Smoke" })
	public void C2C_Click_On_Existing_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_005");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		C2C.clickClick2CartLink();
		log.info("Clicking on Click2Cart Link from List.");

		try {
			Assert.assertTrue(C2C.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_Verify_Existing_URLS: Test Passed.");
			logger.log(LogStatus.PASS, "Carting was Successfully ", "Test Passed");
		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_Verify_Existing_URLS: Test Failed.");
			logger.log(LogStatus.FAIL, "Carting was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("ClickURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/ClickURL.png"));
		}
	}

	@Test(priority = 6, description = "Verify Editing and Saving a Click2Cart link.", groups = { "SC_Smoke" })
	public void C2C_EDIT_AND_SAVE() {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_006");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartEditURL();

		try {
			Assert.assertTrue(C2C.verifyClick2CartEditURL());
			log.info("C2C_EDIT_AND_SAVE(): Test Passed.");
			logger.log(LogStatus.PASS, "URL Edited Successfully.", "Test Passed");
		} catch (Error e) {
			log.info("C2C_EDIT_AND_SAVE(): Test Failed.");
			logger.log(LogStatus.FAIL, "Editing URL was not successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("EditURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/EditURL.png"));
		}
	}
	


	@Test(priority = 7, description = "Verify Copying a Click2Cart link.", groups = { "SC_Smoke" })
	public void C2C_Copy_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_007");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartCopyURL();
		log.info("Clicked on Copy URL button.");

		try {
			Assert.assertTrue(C2C.verifyClick2CartCopyURL());
			log.info("C2C_Copy_URL: Test Passed.");
			logger.log(LogStatus.PASS, "Copy URL was Successful.", "Test Passed");
		} catch (Error e) {
			log.info("C2C_Copy_URL: Test Failed.");
			logger.log(LogStatus.FAIL, "Copying URL was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("CopyURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CopyURL.png"));
		}
	}

	@Test(priority = 8, description = "Verify Deleting a Click2Cart link.", groups = { "SC_Smoke" })
	public void C2C_Delete_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_008");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartDeleteURL();

		try {
			Assert.assertTrue(C2C.verifyClick2CartDeleteURL());
			log.info("C2C_Delete_URL: Test Passed.");
			logger.log(LogStatus.PASS, "URL Deleted Successfully.", "Test Passed");
		} catch (Error e) {
			log.info("C2C_Delete_URL: Test Failed.");
			logger.log(LogStatus.FAIL, "URL was not Deleted, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("DeleteURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/DeleteURL.png"));
		}
	}
	
	@Test(priority = 9, description = "Verify Adding a Label For Manufacturer.", groups = { "SC_Smoke" })
	public void C2C_ADD_LABEL_MANUFACTURER() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_009");
		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartAddLableManufacturer();
		// Save the current window handle
		//winHandleBefore = driver.getWindowHandle();
		//C2C.clickCreatedClick2CartLink();
		//log.info("Clicking on Created Click2Cart Link.");

		try {
			//Assert.assertTrue(C2C.verifyNewPage());
			Assert.assertTrue(C2C.saveLabelText.equals("testManufacturerLabel123"));
			// Switch back to original browser (first window)
			//driver.switchTo().window(winHandleBefore);
			log.info("C2C_ADD_LABEL_MANUFACTURER: Test Passed.");
			logger.log(LogStatus.PASS, "C2C Manufacturer Label Added Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_ADD_LABEL_MANUFACTURER: Test Failed.");
			logger.log(LogStatus.FAIL, "C2C Manufacturer Label not Added Successfully, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("AddLabelManufacturer.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/AddLabelManufacturer.png"));
		}
	}
	
	@Test(priority = 10, description = "Verify Adding a Label For Agency.", groups = { "SC_Smoke1" })
	public void C2C_ADD_LABEL_AGENCY() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_C2C_010");
		
		C2C.clickClientType();
		log.info("Select Agency Client Type.");
		
		Thread.sleep(2000);
		
		C2C.clickClientImplementation();
		log.info("Select Implementation.");
		
		Thread.sleep(2000);
		
		C2C.clickHeadPatner();
		log.info("Select Head Partner.");
		
		Thread.sleep(2000);
		
		C2C.clickEShops();
		log.info("Select E Shop.");
		
		Thread.sleep(2000);

		C2C.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.click2cart));
		C2C.clickClick2Cart();
		log.info("Clicked on Click2Cart from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(C2C.urlColumn));
		C2C.clickClick2CartAddLableAgency();
		// Save the current window handle
		//winHandleBefore = driver.getWindowHandle();
		//C2C.clickCreatedClick2CartLink();
		//log.info("Clicking on Created Click2Cart Link.");

		try {
			//Assert.assertTrue(C2C.verifyNewPage());
			Assert.assertTrue(C2C.saveLabelText.equals("testAgencyLabel123"));
			// Switch back to original browser (first window)
			//driver.switchTo().window(winHandleBefore);
			log.info("C2C_ADD_LABEL_AGENCY: Test Passed.");
			logger.log(LogStatus.PASS, "C2C Manufacturer Label Added Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("C2C_ADD_LABEL_AGENCY: Test Failed.");
			logger.log(LogStatus.FAIL, "C2C Manufacturer Label not Added Successfully, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("AddLabelAgency.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/AddLabelAgency.png"));
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
