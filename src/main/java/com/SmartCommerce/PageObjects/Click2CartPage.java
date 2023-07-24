package com.SmartCommerce.PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click2CartPage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(Click2CartPage.class);
	private WebDriverWait wait;
	Actions builder;
	// All objects should be defined here
	public By makeandmanage = By.xpath("//span[normalize-space()='Make & Manage']");
	public By clienttype = By.xpath("//select[@name='clientTypesSelector']");
	public By clienttypeAgency = By
			.xpath("//select[@id='clientTypesSelector']//option[@value='2'][normalize-space()='Agency']");

	public By clientImplementation = By.xpath("//select[@id='client']");
	public By clientImplementationName = By
			.xpath("//select[@id='client']//option[@value='601'][normalize-space()='AAA Agency']");

	public By headerPartner = By.xpath("//select[@id='headerPartners']");
	public By headerPartnerName = By
			.xpath("//select[@id='headerPartners']//option[@value='21'][normalize-space()='SmartCommerce']");

	public By eShop = By.xpath("//select[@id='eshops']");
	public By eShopName = By.xpath(
			"//select[@id='eshops']//option[@value='16'][normalize-space()='SmartCommerce - US Playground for Testing']");

	public By click2cart = By.xpath("//a[@id='clicktocart']");
	public By titleMakeandManage = By.xpath("//h5[normalize-space()='Make & Manage']");
	public By titleDetailURL = By.xpath("//h5[normalize-space()='Detail URL']");
	public By titlegeneratedURL = By.xpath("//div[contains(text(),'URL generated correctly')]");
	public By urlColumn = By.xpath("//th[@class='d2c-col-xlong']");
	public By c2clinks = By.tagName("a");
	public By plkurl = By.partialLinkText("https://stage.click2");
	public By copyurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[3]/i[1]");
	public By deleteurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[6]/i[1]");
	public By btncreatenewurl = By.xpath("//a[@class='btn btn-primary rounded-pill button-style-change']");
	public By txtSearch = By.xpath("//input[@placeholder='Search']");
	public By enterRetailer = By.xpath("//input[@placeholder='Search']");
	public By searchProduct = By.xpath("//input[@aria-label='Search']");
	public By txtLabelName = By.xpath("//input[@placeholder='Write a new label']");
	public By btnSaveLabel = By.xpath("//a[@class='btn btn-primary btn-block rounded-pill modalBtnSubmit']");
	public By SavedLabel = By.xpath("//span[@class='select2-selection__choice__display']");

	public By availableProduct = By.xpath("//input[@id='availableproductscheckbox']");
	public By btnsearchproduct = By
			.xpath("//div[@class='col-lg-5 col-md-6 mb-3']//button[@type='button'][normalize-space()='search']");
	public By selectRetailer = By.xpath(
			"//button[@class='position-relative btn btn-outline-light list-supers-eshop button-super']//img[@title='Amazon - US']");
	public By lbloutofstockproducts = By
			.xpath("//label[normalize-space()='Out of Stock Products for Selected Retailers']");
	public By btnaddproduct = By.xpath("(//button[contains(text(),'Add')])[1]");
	public By txtinternalurl = By.xpath("//input[@placeholder='set a specific name']");
	public By btngenerateurl = By.xpath("//button[normalize-space()='Generate']");
	public By chooselabels = By.xpath("//textarea[@placeholder='Choose Labels']");

	public By editurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[2]");
	public By btncopyurl = By.xpath("//a[@class='btn btn-primary rounded-pill modalBtnSubmit']");
	public By btndeleteurl = By.xpath("//button[normalize-space()='delete URL']");
	public By btnNextStep1 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep2 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep3 = By.xpath("//button[normalize-space()='Next step']");
	public By btnSaveStep4 = By.xpath("//button[@type='button'][normalize-space()='Save']");
	public By txtnewcopyurl = By.cssSelector(
			"body > div:nth-child(1) > div:nth-child(1) > main:nth-child(4) > div:nth-child(6) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > span:nth-child(1)");
	public By productname = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public By productnameaftercopy = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public By urlSuccess = By.xpath("//div[contains(text(),'URL generated correctly')]");
	public By productnameafterdelete = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public String pageTitle = "Make & Manage";
	public String url = "";
	public HttpURLConnection huc = null;
	int respCode = 200;
	public String copyoff = "Copy Of";
	public String copyProductName;
	public String copyProductNameAfterCopy;
	public String copyProductNameAfterDelete;
	public String editSuccessMessage;
	public String createSuccessMessage;
	public String saveLabelText;

	public Click2CartPage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public String getPageTitle() {

		return driver.findElement(titleMakeandManage).getText();
	}

	public void clickMakeandManage() {

		driver.findElement(makeandmanage).click();
	}

	public void clickClientType() {

		driver.findElement(clienttype).click();
		driver.findElement(clienttypeAgency).click();

	}

	public void clickClientImplementation() {

		driver.findElement(clientImplementation).click();
		driver.findElement(clientImplementationName).click();

	}

	public void clickHeadPatner() {

		driver.findElement(headerPartner).click();
		driver.findElement(headerPartnerName).click();

	}

	public void clickEShops() {

		driver.findElement(eShop).click();
		driver.findElement(eShopName).click();

	}

	public void clickClick2Cart() {

		driver.findElement(click2cart).click();
	}

	public void clickClick2CartLink() throws InterruptedException {

		/*
		 * List<WebElement> links = driver.findElements(plkurl); links.get(new
		 * Random().nextInt(links.size())).click();
		 */
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}

	public void clickCreatedClick2CartLink() throws InterruptedException {

		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}

	public boolean verifyNewPage() {
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Check if Text "Cart" is present on the Page.
		if (driver.getPageSource().contains("Cart")) {
			log.info("C2C URL Created Successfully.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}

	public Boolean verifyClick2CartLinks() {

		List<WebElement> links = driver.findElements(plkurl);
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			verifyAnyBrokenLinks();
		}
		return true;
	}

	public void verifyAnyBrokenLinks() {

		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if (respCode >= 400) {
				System.out.println(url + " is a broken link");
				log.info(url + " is a broken link");
			} else {
				System.out.println(url + " is a valid link");
				log.info(url + " is a valid link");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickClick2CartCopyURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(copyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncopyurl));
		driver.findElement(btncopyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);
	}

	public boolean verifyClick2CartCopyURL() {

		copyProductNameAfterCopy = driver.findElement(productnameaftercopy).getText();
		if (copyProductNameAfterCopy.contains(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickClick2CartDeleteURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(deleteurl).click();
		log.info("Clicked on Delete button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btndeleteurl));
		driver.findElement(btndeleteurl).click();
		log.info("Clicked on Delete URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);

	}

	public boolean verifyClick2CartDeleteURL() {

		copyProductNameAfterDelete = driver.findElement(productnameafterdelete).getText();
		if (!copyProductNameAfterDelete.equals(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickClick2CartCreateUsingName() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lbloutofstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 4.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickClick2CartCreateUsingUPC() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("041508200202");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lbloutofstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 4.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickClick2CartCreateUsingWildCard() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		/*
		 * driver.findElement(availableProduct).click();
		 * log.info("Click on Available Product toggle.");
		 */
		driver.findElement(searchProduct).sendKeys("%");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lbloutofstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 4.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickClick2CartAddLableManufacturer() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lbloutofstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testAddLabelManufacturer");
		log.info("Enter Internal URL name.");
		driver.findElement(chooselabels).click();
		log.info("Clicked on Labels Field.");

		/*
		 * builder = new Actions(driver);
		 * builder.sendKeys("create a new label").perform();
		 * log.info("Select Create a New Label option.");
		 */

		Thread.sleep(2000);
		driver.findElement(chooselabels).sendKeys("create a new label");
		log.info("Select Create a New Label option.");
		driver.findElement(chooselabels).sendKeys(Keys.ENTER);
		log.info("Press Enter");
		Thread.sleep(2000);
		driver.findElement(txtLabelName).sendKeys("testManufacturerLabel123");
		log.info("Enter Label Name");
		driver.findElement(btnSaveLabel).click();
		log.info("Press Save button");

		Thread.sleep(3000);
		saveLabelText = driver.findElement(SavedLabel).getText();
		// driver.findElement(btngenerateurl).click();
		// log.info("Clicked on Generate button on Step 4.");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		// createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickClick2CartAddLableAgency() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lbloutofstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testAddLabelAgency");
		log.info("Enter Internal URL name.");
		driver.findElement(chooselabels).click();
		log.info("Clicked on Labels Field.");

		/*
		 * builder = new Actions(driver);
		 * builder.sendKeys("create a new label").perform();
		 * log.info("Select Create a New Label option.");
		 */

		Thread.sleep(2000);
		driver.findElement(chooselabels).sendKeys("create a new label");
		log.info("Select Create a New Label option.");
		driver.findElement(chooselabels).sendKeys(Keys.ENTER);
		log.info("Press Enter");
		Thread.sleep(2000);
		driver.findElement(txtLabelName).sendKeys("testAgencyLabel123");
		log.info("Enter Label Name");
		driver.findElement(btnSaveLabel).click();
		log.info("Press Save button");

		Thread.sleep(3000);
		saveLabelText = driver.findElement(SavedLabel).getText();
		// driver.findElement(btngenerateurl).click();
		// log.info("Clicked on Generate button on Step 4.");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		// createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public boolean verifyClick2CartCreateURL() {

		if (createSuccessMessage.contains("URL generated correctly")) {
			return true;
		}
		return false;
	}

	public void clickClick2CartEditURL() {

		driver.findElement(editurl).click();
		log.info("Clicked on Edit button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnSaveStep4).click();
		log.info("Clicked on Save button on Step 4.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleDetailURL));
		editSuccessMessage = driver.findElement(urlSuccess).getText();
	}

	public boolean verifyClick2CartEditURL() {

		if (editSuccessMessage.contains("URL generated correctly")) {
			return true;
		}
		return false;
	}

	public boolean verifyClick2CartLinks2() {

		List<WebElement> linkElements = driver.findElements(plkurl);
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		String Title1 = "Cart";
		String Title2 = "Bummer!";
		String Title3 = "Try again";
		// extract the link texts of each link element
		for (WebElement e : linkElements) {
			linkTexts[i] = e.getText();
			i++;
		}
		// test each link
		for (String t : linkTexts) {
			driver.findElement(By.linkText(t)).click();
			if (driver.getPageSource().contains(Title1)) {
				System.out.println("\"" + t + "\"" + " is working.");
				return true;
			} else if (driver.getPageSource().contains(Title2)) {
				System.out.println("\"" + t + "\"" + "Need to enter Zip Code");
				return false;
			} else if (driver.getPageSource().contains(Title3)) {
				System.out.println("\"" + t + "\"" + " is not working.");
				return false;
			} else {
				System.out.println("\"" + t + "\"" + " is not working.");
				return false;
			}
		}
		return false;

	}

}
