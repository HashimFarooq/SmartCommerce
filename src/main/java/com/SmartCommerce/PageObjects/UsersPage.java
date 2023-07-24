package com.SmartCommerce.PageObjects;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SmartCommerce.Utilities.Constants;
import org.openqa.selenium.support.ui.Select;

public class UsersPage {
	
	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(Click2CartPage.class);
	private WebDriverWait wait;
	public By btnSettings = By.xpath("//button[normalize-space()='Settings']");
	public By users = By.xpath("//a[@class='dropdown-item'][normalize-space()='Users']");
	public By tabusers = By.xpath("//span[normalize-space()='Users']");
	public By btnCreateUser = By.xpath("//button[@id='adduser']");
	public By txtUserName = By.xpath("//input[@id='user']");
	public By role = By.xpath("//select[@id='role']");
	public By roleClientViewer = By.xpath("//select[@id='role']//option[@value='5'][normalize-space()='Client Viewer']");
	public By implementation = By.xpath("//select[@id='implementations-create-user']");
	public By implementationUS = By.xpath("//option[@value='16'][contains(text(),'SmartCommerce - SmartCommerce - US Playground for Testing')]");
	public By loginType = By.xpath("//select[@id='loginType']");
	public By loginTypeStandard = By.xpath("//select[@id='loginType']//option[@value='1'][normalize-space()='Standard']");
	public By txtEmail = By.xpath("//input[@id='mailuser']");
	public By txtPassword = By.xpath("//input[@id='passworduser']");
	public By btncreate = By.xpath("//button[@id='create_user_eshop']");
	public By btnlogout = By.xpath("//a[@class='btn btn-primary rounded-pill']");
	
	public By txtClientKey = By.xpath("//input[@id='clientcode']");
	public By txtLoginUserName = By.xpath("//input[@id='username']");
	public By txtLoginPassword = By.xpath("//input[@id='password']");
	public By btnLogin = By.xpath("//button[@id='submit-form']");
	public By lblWelcome = By.xpath("//h1[normalize-space()='Welcome to SmartSuite']");
	public By checkCookies = By.xpath("//*[@id=\"firstTimeCheckboxLabel\"]");
	public By btnContinue = By.xpath("//*[@id=\"initialPageContinue\"]");
	
	
	public String WelcomeMessageText = "Welcome to SmartSuite";
	public String WelcomeMessage;
	public String testCVEmail;
	public String testCIEmail;
	public String testCVUserName;
	public String testCIUserName;
	
	public UsersPage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public void clickUsers() {

		driver.findElement(btnSettings).click();
		driver.findElement(users).click();
	}
	
	public void clickCreateUser() {
		
		driver.findElement(tabusers).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnCreateUser));
		driver.findElement(btnCreateUser).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncreate));
	}
	
	public void clickLogout() throws InterruptedException {

		driver.findElement(btnlogout).click();
		log.info("Clicked on Logout Button.");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
		Thread.sleep(2000);
		
	}
	
	public void CreateNewClientViewerUser() throws InterruptedException {

		CreateCVUserName();
		
		driver.findElement(txtUserName).click();
		log.info("Clicked on UserName Text Field.");
		driver.findElement(txtUserName).sendKeys(testCVUserName);
		log.info("Enter UserName.");
		
	//	driver.findElement(role).click();
	//	log.info("Clicked on Role Drop Down.");
		
		Select drpRole = new Select(driver.findElement(role));
		drpRole.selectByIndex(0);	
		log.info("Select Client Viewer from Drop Down");
		
		Select drpImplementation = new Select(driver.findElement(implementation));
		drpImplementation.selectByVisibleText("SmartCommerce - SmartCommerce - US Playground for Testing");
		log.info("Select Smart Commerce US Implementation");
		
		Select drpLoginType = new Select(driver.findElement(loginType));
		drpLoginType.selectByIndex(0);
		log.info("Select Standard Login Type");
		CreateCVEmail();
		driver.findElement(txtEmail).click();
		log.info("Clicked on Email Text Field.");
		driver.findElement(txtEmail).sendKeys(testCVEmail);
		log.info("Enter Email.");
		driver.findElement(txtPassword).click();
		log.info("Clicked on Password Text Field.");
		driver.findElement(txtPassword).sendKeys(Constants.CVPassword);
		log.info("Enter Password.");
		driver.findElement(btncreate).click();
		log.info("Clicked on Create User Button.");
		Thread.sleep(3000);
		
	}
	
	public void CreateNewClientImplementerUser() throws InterruptedException {

		CreateCIUserName();
		
		driver.findElement(txtUserName).click();
		log.info("Clicked on UserName Text Field.");
		driver.findElement(txtUserName).sendKeys(testCIUserName);
		log.info("Enter UserName.");
		
	//	driver.findElement(role).click();
	//	log.info("Clicked on Role Drop Down.");
		
		Select drpRole = new Select(driver.findElement(role));
		drpRole.selectByIndex(1);	
		log.info("Select Client Viewer from Drop Down");
		
		Select drpImplementation = new Select(driver.findElement(implementation));
		drpImplementation.selectByVisibleText("SmartCommerce - SmartCommerce - US Playground for Testing");
		log.info("Select Smart Commerce US Implementation");
		
		Select drpLoginType = new Select(driver.findElement(loginType));
		drpLoginType.selectByIndex(0);
		log.info("Select Standard Login Type");
		
		CreateCIEmail();
		
		driver.findElement(txtEmail).click();
		log.info("Clicked on Email Text Field.");
		driver.findElement(txtEmail).sendKeys(testCIEmail);
		log.info("Enter Email.");
		driver.findElement(txtPassword).click();
		log.info("Clicked on Password Text Field.");
		driver.findElement(txtPassword).sendKeys(Constants.CVPassword);
		log.info("Enter Password.");
		driver.findElement(btncreate).click();
		log.info("Clicked on Create User Button.");
		Thread.sleep(3000);
		
	}
	
	public void CreateCVUserName() {
		
		//String cvuser = "testClientViewerUser";
		Random random = new Random();
		int number = random.nextInt(1000000);
		String randoms = String.format("%06d", number);
		testCVUserName = "testClientViewerUser" + randoms;
		//PatientEmail.sendKeys(testEmail);
	}
	
	public void CreateCIUserName() {
		
		//String cvuser = "testClientViewerUser";
		Random random = new Random();
		int number = random.nextInt(1000000);
		String randoms = String.format("%06d", number);
		testCIUserName = "testClientImplementerUser" + randoms;
		//PatientEmail.sendKeys(testEmail);
	}
	
	public void CreateCVEmail() {
		
		String scdomain = "smartcommerce.co";
		Random random = new Random();
		int number = random.nextInt(1000000);
		String randoms = String.format("%06d", number);
		testCVEmail = "hashim.farooq+clientviewer" + randoms + "@" + scdomain;
		//PatientEmail.sendKeys(testEmail);
	}
	
	public void CreateCIEmail() {
		
		String scdomain = "smartcommerce.co";
		Random random = new Random();
		int number = random.nextInt(1000000);
		String randoms = String.format("%06d", number);
		testCIEmail = "hashim.farooq+clientimplementer" + randoms + "@" + scdomain;
		//PatientEmail.sendKeys(testEmail);
	}
	
	public void LoginClientViewer() throws InterruptedException {
		
		try {
			if (driver.findElement(checkCookies).isDisplayed()) {
				
				driver.findElement(checkCookies).click();
				Thread.sleep(1000);
				driver.findElement(btnContinue).click();
				Thread.sleep(2000);
				
				driver.findElement(txtClientKey).click();
				log.info("Clicked on Client Key Text Field.");
				driver.findElement(txtClientKey).sendKeys(Constants.ClientKey);
				log.info("Entered Client Key.");
				Thread.sleep(2000);
				driver.findElement(txtLoginUserName).clear();
				log.info("Clear Login Text Field.");
				driver.findElement(txtLoginUserName).click();
				log.info("Clicked on Login Text Field.");
				driver.findElement(txtLoginUserName).sendKeys(testCVUserName);
				log.info("Entered Client Viewer Username.");
				Thread.sleep(2000);
				driver.findElement(txtLoginPassword).clear();
				log.info("Clear Passowrd Text Field.");
				driver.findElement(txtLoginPassword).click();
				log.info("Clicked on Passowrd Text Field.");
				driver.findElement(txtLoginPassword).sendKeys(Constants.CVPassword);
				log.info("Entered Client Viewer Password.");
				
				
			}
			
		} catch(Exception e) {
			
			driver.findElement(txtClientKey).click();
			log.info("Clicked on Client Key Text Field.");
			driver.findElement(txtClientKey).sendKeys(Constants.ClientKey);
			log.info("Entered Client Key.");
			Thread.sleep(2000);
			driver.findElement(txtLoginUserName).clear();
			log.info("Clear Login Text Field.");
			driver.findElement(txtLoginUserName).click();
			log.info("Clicked on Login Text Field.");
			driver.findElement(txtLoginUserName).sendKeys(testCVUserName);
			log.info("Entered Client Viewer Username.");
			Thread.sleep(2000);
			driver.findElement(txtLoginPassword).clear();
			log.info("Clear Passowrd Text Field.");
			driver.findElement(txtLoginPassword).click();
			log.info("Clicked on Passowrd Text Field.");
			driver.findElement(txtLoginPassword).sendKeys(Constants.CVPassword);
			log.info("Entered Client Viewer Password.");
			
		}

	
		
	}
	
	public void LoginClientImplementer() throws InterruptedException {

		
		try {
			if (driver.findElement(checkCookies).isDisplayed()) {
				
				driver.findElement(checkCookies).click();
				Thread.sleep(1000);
				driver.findElement(btnContinue).click();
				Thread.sleep(2000);
				
				driver.findElement(txtClientKey).click();
				log.info("Clicked on Client Key Text Field.");
				driver.findElement(txtClientKey).sendKeys(Constants.ClientKey);
				log.info("Entered Client Key.");
				Thread.sleep(2000);
				driver.findElement(txtLoginUserName).clear();
				log.info("Clear Login Text Field.");
				driver.findElement(txtLoginUserName).click();
				log.info("Clicked on Login Text Field.");
				driver.findElement(txtLoginUserName).sendKeys(testCIUserName);
				log.info("Entered Client Viewer Username.");
				Thread.sleep(2000);
				driver.findElement(txtLoginPassword).clear();
				log.info("Clear Passowrd Text Field.");
				driver.findElement(txtLoginPassword).click();
				log.info("Clicked on Passowrd Text Field.");
				driver.findElement(txtLoginPassword).sendKeys(Constants.CVPassword);
				log.info("Entered Client Viewer Password.");
				
				
			}
			
		} catch(Exception e) {
			
			driver.findElement(txtClientKey).click();
			log.info("Clicked on Client Key Text Field.");
			driver.findElement(txtClientKey).sendKeys(Constants.ClientKey);
			log.info("Entered Client Key.");
			Thread.sleep(2000);
			driver.findElement(txtLoginUserName).clear();
			log.info("Clear Login Text Field.");
			driver.findElement(txtLoginUserName).click();
			log.info("Clicked on Login Text Field.");
			driver.findElement(txtLoginUserName).sendKeys(testCIUserName);
			log.info("Entered Client Viewer Username.");
			Thread.sleep(2000);
			driver.findElement(txtLoginPassword).clear();
			log.info("Clear Passowrd Text Field.");
			driver.findElement(txtLoginPassword).click();
			log.info("Clicked on Passowrd Text Field.");
			driver.findElement(txtLoginPassword).sendKeys(Constants.CVPassword);
			log.info("Entered Client Viewer Password.");
			
		}
		
		
		
		
		
		

		
	}
	
	public boolean verifyLogin() {

		driver.findElement(btnLogin).click();
		log.info("Clicked on Login button.");	
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblWelcome));
		WelcomeMessage = driver.findElement(lblWelcome).getText();
		
		if (WelcomeMessage.equals(WelcomeMessageText)) {
			return true;
		}
		return false;
		
	}
	
	
	
	
	
	
}
