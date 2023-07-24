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

import com.SmartCommerce.PageObjects.ShopperChoicePage;
import com.SmartCommerce.Reports.ExtentReporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShopperChoiceTest extends BaseTest {

	private WebDriver driver;
	private ShopperChoicePage SC;
	private WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(ShopperChoiceTest.class);
	private ExtentReporting reporting;
	private static ExtentTest logger;
	private ExtentReports reporter = ExtentReporting.getReport();
	public static String winHandleBefore;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("*************************Test Starting***************************");
		log.info("Driver is initialized...");
		SC = new ShopperChoicePage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		reporting = new ExtentReporting(driver);
	}

	@Test(priority = 1, description = "Verify Creating a Shoppers Choice Retailer link using Name.", groups = {
			"SC_Smoke" })
	public void SHOPPERCHOICE_CREATE_RETAILER_USING_NAME() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_001");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerUsingName();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_NAME: Test Passed.");
			logger.log(LogStatus.PASS, "New Link Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_NAME: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRETAILERNAME.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCRETAILERNAME.png"));
		}
	}

	@Test(priority = 2, description = "Verify Creating a Shoppers Choice Retailer link using a Wild Card.", groups = {
			"SC_Smoke" })
	public void SHOPPERCHOICE_CREATE_RETAILER_USING_WILDCARD() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_002");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerUsingWildCard();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_WILDCARD: Test Passed.");
			logger.log(LogStatus.PASS, "New Link Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_WILDCARD: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRETAILERWILDCARD.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger
					.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCRETAILERWILDCARD.png"));
		}
	}

	@Test(priority = 3, description = "Verify Creating a Shoppers Choice Retailer link using a UPC.", groups = {
			"SC_Smoke" })
	public void SHOPPERCHOICE_CREATE_RETAILER_USING_UPC() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_003");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerUsingUPC();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_UPC: Test Passed.");
			logger.log(LogStatus.PASS, "New Link Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER_USING_UPC: Test Failed.");
			logger.log(LogStatus.FAIL, "Create URL was not successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRETAILERUPC.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCRETAILERUPC.png"));
		}
	}

	@Test(priority = 4, description = "Verify Clicking a Shopper's Choice link.", groups = { "SC_Smoke" })
	public void ShopperChoice_Click_On_Existing_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_004");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Shoppers Choice Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickShoppersChoiceLink();
		log.info("Clicking on Shoppers Choice Existing Link from List.");

		try {
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("ShopperChoise_Click_On_Existing_URL: Test Passed.");
			logger.log(LogStatus.PASS, "Carting was Successfully ", "Test Passed");
		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("ShopperChoise_Click_On_Existing_URL: Test Failed.");
			logger.log(LogStatus.FAIL, "Carting was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("ClickURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/ClickURL.png"));
		}
	}

	@Test(priority = 5, description = "Verify Editing a Shoppers Choice Retailer link.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_EDIT_RETAILER() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_005");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceEditURL();
		winHandleBefore = driver.getWindowHandle();
		SC.clickEditedShoppersChoiceLink();

		try {
			// Assert.assertTrue(SC.verifyShopperChoiceEditURL());
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_EDIT_RETAILER: Test Passed.");
			logger.log(LogStatus.PASS, "Link Edited Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_EDIT_RETAILER: Test Failed.");
			logger.log(LogStatus.FAIL, "Edit URL was not successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("EDITURLRETAILER.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/EDITURLRETAILER.png"));
		}
	}

	@Test(priority = 6, description = "Verify Copying Shopper's Choice link.", groups = { "SC_Smoke" })
	public void ShopperChoice_Copy_Existing_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_006");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Shoppers Choice Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCopyURL();
		log.info("Clicked on Copy URL button.");

		try {
			Assert.assertTrue(SC.verifyShopperChoiceCopyURL());
			log.info("ShopperChoice_Copy_Existing_URL(): Test Passed.");
			logger.log(LogStatus.PASS, "Copy URL was Successful.", "Test Passed");
		} catch (Error e) {
			log.info("ShopperChoice_Copy_Existing_URL(): Test Failed.");
			logger.log(LogStatus.FAIL, "Copying URL was not successfull, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("CopySCURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CopySCURL.png"));
		}
	}

	@Test(priority = 7, description = "Verify Deleting a Shoppers Choice link.", groups = { "SC_Smoke" })
	public void ShopperChoice_Delete_URL() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_007");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShopperChoiceDeleteURL();

		try {
			Assert.assertTrue(SC.verifyShoppersChoiceDeleteURL());
			log.info("ShopperChoice_Delete_URL: Test Passed.");
			logger.log(LogStatus.PASS, "URL Deleted Successfully.", "Test Passed");
		} catch (Error e) {
			log.info("ShopperChoice_Delete_URL: Test Failed.");
			logger.log(LogStatus.FAIL, "URL was not Deleted, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("SCDeleteURL.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/SCDeleteURL.png"));
		}
	}

	@Test(priority = 8, description = "Verify Creating a Shoppers Choice Smart Shelf link.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_CREATE_SMARTSHELF() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_008");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerandProductChoice();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceLink();
		log.info("Clicking on Created Shoppers Choice Smart Shelf Link.");

		try {
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_SMARTSHELF: Test Passed.");
			logger.log(LogStatus.PASS, "Smart Shelf Link Created Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_CREATE_RETAILER: Test Failed.");
			logger.log(LogStatus.FAIL,
					"SmartShelf URL was not created successfull, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("CreateURLSmartShelf.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSmartShelf.png"));
		}
	}

	@Test(priority = 9, description = "Verify Editing a Shoppers Choice Smart Shelf link.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_EDIT_SMARTSHELF() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_009");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceSmartShelfEditURL();
		winHandleBefore = driver.getWindowHandle();
		SC.clickEditedShoppersChoiceLink();

		try {
			// Assert.assertTrue(SC.verifyShopperChoiceSmartShelfEditURL());
			Assert.assertTrue(SC.verifyNewPage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_EDIT_SMARTSHELF: Test Passed.");
			logger.log(LogStatus.PASS, "Smart Shelf Link Edited Successfully.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_EDIT_SMARTSHELF: Test Failed.");
			logger.log(LogStatus.FAIL, "SmartShelf URL was not Edited successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("EditURLSmartShelf.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/EditURLSmartShelf.png"));
		}
	}

	@Test(priority = 10, description = "Verify Copying a Shoppers Choice Smart Shelf link.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_COPY_SMARTSHELF() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_010");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceSmartShelfCopyURL();
		log.info("Clicked on Copy URL button.");

		try {
			Assert.assertTrue(SC.verifyShopperChoiceSmartShelfCopyURL());
			log.info("SHOPPERCHOICE_COPY_SMARTSHELF: Test Passed.");
			logger.log(LogStatus.PASS, "Smart Shelf Link Copied Successfully.", "Test Passed");

		} catch (Error e) {
			log.info("SHOPPERCHOICE_COPY_SMARTSHELF: Test Failed.");
			logger.log(LogStatus.FAIL, "SmartShelf URL was not Copied successfull, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CopyURLSmartShelf.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CopyURLSmartShelf.png"));
		}
	}

	@Test(priority = 11, description = "Verify Deleting a Shoppers Choice Smart Shelf link.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_DELETE_SMARTSHELF() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_011");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShopperChoiceSmartShelfDeleteURL();
		log.info("Clicked on Delete URL button.");

		try {
			Assert.assertTrue(SC.verifyShoppersChoiceSmartShelfDeleteURL());
			log.info("SHOPPERCHOICE_DELETE_SMARTSHELF: Test Passed.");
			logger.log(LogStatus.PASS, "Smart Shelf Link Deleted Successfully.", "Test Passed");

		} catch (Error e) {
			log.info("SHOPPERCHOICE_DELETE_SMARTSHELF: Test Failed.");
			logger.log(LogStatus.FAIL,
					"SmartShelf URL was not Deleted successfull, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("DeleteURLSmartShelf.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/DeleteURLSmartShelf.png"));
		}
	}

	@Test(priority = 12, description = "Verify Marketing assets are displayed correctly in a Shopper Choice campaign.", groups = {
			"SC_Smoke" })
	public void SHOPPERCHOICE_MARKETING_ASSETS() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_012");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerWithMarketingAssets();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceMarketingAssetsLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyNewPageWithMarketingAssets());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_MARKETING_ASSETS: Test Passed.");
			logger.log(LogStatus.PASS, "Marketing assets are displayed correctly in a Shoppers Choice campaign.",
					"Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_MARKETING_ASSETS: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Marketing assets are not displayed correctly in a Shoppers Choice campaign, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRETAILERMarketingAssets.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(
					System.getProperty("user.dir") + "/reports/CreateURLSCRETAILERMarketingAssets.png"));
		}
	}

	@Test(priority = 13, description = "Verify Background assets are displayed correctly in a Shopper Choice campaign.", groups = {
			"SC_Smoke" })
	public void SHOPPERCHOICE_BACKGROUD_ASSETS() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_013");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateRetailerWithBackGroundAssets();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceBackgroundAssetsLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyNewPageWithBackGroundAssets());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_BACKGROUD_ASSETS: Test Passed.");
			logger.log(LogStatus.PASS, "Background assets are displayed correctly in a Shoppers Choice campaign.",
					"Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_BACKGROUD_ASSETS: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Background assets are not displayed correctly in a Shoppers Choice campaign, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRETAILERBackgroundAssets.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(
					System.getProperty("user.dir") + "/reports/CreateURLSCRETAILERBackgroundAssets.png"));
		}
	}

	@Test(priority = 14, description = "Verify Local Retailers after Activating them.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_ACTIVATE_LOCAL_RETAILER() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_014");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateLocalRetailer();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceLocalLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyLocalRetailer());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_ACTIVATE_LOCAL_RETAILER: Test Passed.");
			logger.log(LogStatus.PASS, "URL created successfully for Local Retailer.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_ACTIVATE_LOCAL_RETAILER: Test Failed.");
			logger.log(LogStatus.FAIL,
					"URL not created successfully for Local Retailer, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCLOCALRETAILER.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger
					.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCLOCALRETAILER.png"));
		}
	}

	@Test(priority = 15, description = "Verify WTB Retailers after Activating them.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_ACTIVATE_WTB_RETAILER() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_015");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceCreateWTBRetailer();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceWTBLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyWTBRetailer());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_ACTIVATE_WTB_RETAILER: Test Passed.");
			logger.log(LogStatus.PASS, "URL created successfully for WTB Retailer.", "Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_ACTIVATE_WTB_RETAILER: Test Failed.");
			logger.log(LogStatus.FAIL,
					"URL not created successfully for WTB Retailer, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCWTBRETAILER.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCWTBRETAILER.png"));
		}
	}

	@Test(priority = 16, description = "Verify WTB Retailers selected Language.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_WTB_RETAILER_SELECTED_LANGUAGE() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_016");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceWTBRetailerLanguage();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		SC.clickCreatedShoppersChoiceWTBLanguageLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyWTBRetailerLanguage());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE__WTB_RETAILER_SELECTED_LANGUAGE: Test Passed.");
			logger.log(LogStatus.PASS,
					"Language Header and Footer showing successfully for WTB Retailer. Alternative Language showing as well.",
					"Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE__WTB_RETAILER_SELECTED_LANGUAGE: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Alternative Language and Text for WTB Retailer not showing correctly, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCWTBRETAILERLanguage.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger
					.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCWTBRETAILERLanguage.png"));
		}
	}
	
	@Test(priority = 17, description = "Verify Toggle Manual Selection for retailers.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_MANUAL_RETAILER_SELECTION() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_017");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceManualRetailerSelection();
		// Save the current window handle
		winHandleBefore = driver.getWindowHandle();
		//SC.checkSelectionOrder();
		SC.clickShoppersChoiceCustomLink();
		log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.verifyCustomRetailerOrder());
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_MANUAL_RETAILER_SELECTION: Test Passed.");
			logger.log(LogStatus.PASS,
					"Manually selected Retailers showing in correct order successfully.",
					"Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_MANUAL_RETAILER_SELECTION: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Manually selected Retailers not showing correctly, need to check the Logs for details.",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCManualRETAILERSelection.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger
					.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCManualRETAILERSelection.png"));
		}
	}
	
	@Test(priority = 18, description = "Verify Toggle Random Selection for retailers.", groups = { "SC_Smoke" })
	public void SHOPPERCHOICE_RANDOM_RETAILER_SELECTION() throws InterruptedException {

		// log.info("*************************Test
		// Starting***************************");
		logger = reporter.startTest("SC_ShopperChoice_018");
		SC.clickMakeandManage();
		log.info("Clicked on Make and Manage from Menu.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.shopperchoice));
		SC.shoppersChoice();
		log.info("Clicked on Shoppers Choice from with in the Menu.");
		// Waiting for the visibility of list to populate.
		wait.until(ExpectedConditions.visibilityOfElementLocated(SC.urlColumn));
		SC.clickShoppersChoiceRandomRetailerSelection();
		// Save the current window handle
		//winHandleBefore = driver.getWindowHandle();
		//SC.checkRandomOrder();
		//SC.clickShoppersChoiceCustomLink();
		//log.info("Clicking on Created Shoppers Choice Link.");

		try {
			Assert.assertTrue(SC.checkRandomOrder());
			// Switch back to original browser (first window)
			//driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_RANDOM_RETAILER_SELECTION: Test Passed.");
			logger.log(LogStatus.PASS,
					"Random selected Retailers showing correctly.",
					"Test Passed");

		} catch (Error e) {
			// Switch back to original browser (first window)
			//driver.switchTo().window(winHandleBefore);
			log.info("SHOPPERCHOICE_RANDOM_RETAILER_SELECTION: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Random selected Retailers not showing correctly, need to check the Logs for details",
					"Test Failed");
			reporting.captureScreenShot("CreateURLSCRandomRETAILERSelection.png");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger
					.addScreenCapture(System.getProperty("user.dir") + "/reports/CreateURLSCRandomRETAILERSelection.png"));
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
