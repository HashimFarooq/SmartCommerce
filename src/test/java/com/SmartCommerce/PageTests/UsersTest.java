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

import com.SmartCommerce.Reports.ExtentReporting;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.SmartCommerce.PageObjects.UsersPage;

public class UsersTest extends BaseTest {

	private WebDriver driver;
	private UsersPage UP;
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
		UP = new UsersPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		reporting = new ExtentReporting(driver);
	}

	@Test(priority = 1, description = "Verify Creating and Logging Into User having Role Client Viewer", groups = {
			"SC_Smoke2" })
	public void CREATE_USER_CLIENTVIEWER() throws InterruptedException {

		logger = reporter.startTest("SC_USER_001");
		UP.clickUsers();
		log.info("Clicked on Users from Settings.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(UP.tabusers));
		UP.clickCreateUser();
		log.info("Clicked on Create User Button.");

		UP.CreateNewClientViewerUser();
		log.info("Client Viewer User Created.");
		UP.clickLogout();
		UP.LoginClientViewer();

		try {
			Assert.assertTrue(UP.verifyLogin());
			log.info("CREATE_USER_CLIENTVIEWER: Test Passed.");
			logger.log(LogStatus.PASS, "Client Viewer User Created Successfully.", "Test Passed");

		} catch (Error e) {
			log.info("CREATE_USER_CLIENTVIEWER: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Client Viewer User Not Created Successfully, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("CVUserCreate.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CVUserCreate.png"));
		}
	}

	
	@Test(priority = 2, description = "Verify Creating and Logging Into User having Role Client Implementer", groups = {
			"SC_Smoke2" })
	public void CREATE_USER_CLIENTIMPLEMENTER() throws InterruptedException {

		logger = reporter.startTest("SC_USER_002");
		UP.clickUsers();
		log.info("Clicked on Users from Settings.");
		// Waiting for the visibility of Click 2 Cart Object in Menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(UP.tabusers));
		UP.clickCreateUser();
		log.info("Clicked on Create User Button.");

		UP.CreateNewClientImplementerUser();
		log.info("Client Implemeter User Created.");
		UP.clickLogout();
		UP.LoginClientImplementer();

		try {
			Assert.assertTrue(UP.verifyLogin());
			log.info("CREATE_USER_CLIENTIMPLEMENTER: Test Passed.");
			logger.log(LogStatus.PASS, "Client Implementer User Created Successfully.", "Test Passed");

		} catch (Error e) {
			log.info("CREATE_USER_CLIENTIMPLEMENTER: Test Failed.");
			logger.log(LogStatus.FAIL,
					"Client Implementer User Not Created Successfully, need to check the Logs for details.", "Test Failed");
			reporting.captureScreenShot("CIUserCreate.png");
			logger.log(LogStatus.INFO, "Snapshot below: "
					+ logger.addScreenCapture(System.getProperty("user.dir") + "/reports/CIUserCreate.png"));
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
