package com.SmartCommerce.PageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartSitePage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(SmartSitePage.class);
	private WebDriverWait wait;
	Actions builder;
	public String copyProductName;
	public String copyProductNameAfterCopy;
	public String copyProductNameAfterDelete;
	public String createSuccessMessage;
	public String editSuccessMessage;

	// All objects should be defined here
	public By makeandmanage = By.xpath("//span[normalize-space()='Make & Manage']");
	public By titleMakeandManage = By.xpath("//h5[normalize-space()='Make & Manage']");
	public By smartsite = By.xpath("//a[@id='widget']");
	public By urlColumn = By.xpath("//th[@class='d2c-col-xlong']");
	public By internalNameColumn = By.xpath("//a[normalize-space()='Internal Name']");
	public By plkurl = By.partialLinkText("https://stage.click2");

	public By btncreatenewwidget = By.xpath("//a[@id='createnewurl']");
	public By txtSearch = By.xpath("//input[@placeholder='Search']");
	public By enterRetailer = By.xpath("//input[@placeholder='Search']");
	public By searchProduct = By.xpath("//input[@aria-label='Search']");
	public By ddProductSelection = By.xpath("//span[@id='select2-type-condition-container']");
	public By txtSearchProductSelection = By.xpath("//input[@aria-label='Search']");

	public By ddBrandSelection = By.xpath("(//span[@class='selection'])[2]");
	public By txtSearchProduct = By.xpath("//input[@id='search-prods']");
	public By selectProduct = By.xpath("//div[@class='row']//div[1]//div[1]//div[2]//div[1]//button[1]");
	public By toggleAvailableProducts = By.xpath("//input[@id='availableproductscheckbox']");
	public By txtBrandSelection = By.xpath(
			"//span[@class='select2 select2-container select2-container--bootstrap-5 select2-container--above select2-container--focus']//textarea[@aria-label='Search']");

	public By ddWidgetSelection = By.xpath("//span[@id='select2-widget-type-container']");
	public By txtWidgetSelection = By.xpath("//input[@aria-label='Search']");

	public By txtWidgetName = By.xpath("//input[@id='nameWidget']");

	public By btnsearchproduct = By
			.xpath("//div[@class='col-lg-5 col-md-6 mb-3']//button[@type='button'][normalize-space()='search']");
	public By selectRetailer = By.xpath(
			"//button[@class='position-relative btn btn-outline-light list-supers-eshop button-super']//img[@title='Amazon - US']");
	public By btnNextStep1 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep2 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep3 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep4 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep5 = By.xpath("//button[normalize-space()='Next step']");
	public By btnSaveStep6 = By.xpath("//button[@type='button'][normalize-space()='Save']");

	public By btnClickSave2Cart = By.xpath("//button[normalize-space()='Click to Save to Cart']");
	public By cartIcon = By.xpath("//img[@class='cart-icon']");

	public By btnSSNextStep2 = By.xpath("//button[@id='step2']");
	public By btnSSNextStep3 = By.xpath(
			"//div[@class='tab-pane active']//button[@class='btn btn-primary rounded-pill btn-large after'][normalize-space()='Next step']");
	public By btnSSNextStep4 = By.xpath(
			"//div[@class='col-12']//button[@class='btn btn-primary rounded-pill btn-large after'][normalize-space()='Next step']");
	public By btnSSSaveStep5 = By.xpath("//a[@id='generate']");

	public By btnSignIN = By.xpath("//span[@class='action-inner']");
	public By editurl = By.xpath("//tbody/tr[1]/td[11]/a[2]");
	public By productname = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");

	public By copyurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/a[3]/i[1]");
	public By btncopyurl = By.xpath("//a[@id='go_copy_url']");
	public By view = By.xpath("//tbody/tr[1]/td[11]/a[1]");
	public By productnameaftercopy = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	
	public By deleteurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/a[6]/i[1]");
	public By btndeleteurl = By.xpath("//button[@id='trushurl']"); 
	public By productnameafterdelete = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");

	public SmartSitePage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public void clickMakeandManage() {

		driver.findElement(makeandmanage).click();
	}

	public void clickSmartSite() {

		driver.findElement(smartsite).click();
	}

	public void clickShoppersChoiceLink() throws InterruptedException {

		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}

	public boolean verifyNewPage() {
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Check if Text "Cart" is present on the Page.
		if (driver.getPageSource().contains("Cart")) {
			log.info("URL Opened Successfully.");
			driver.close();
			// wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}

	public void clickSmartSiteCreateNewWidgetUsingName() throws InterruptedException {

		driver.findElement(btncreatenewwidget).click();
		log.info("Clicked on Create New Widget button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));

		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");

		// Product Selection
		driver.findElement(ddProductSelection).click();
		log.info("Clicked on Product Selection Drop Down.");

		driver.findElement(txtSearchProductSelection).click();
		log.info("Click within the Search text box.");

		driver.findElement(txtSearchProductSelection).sendKeys("By Brand");
		log.info("Enter the Product details in Search Field.");

		driver.findElement(txtSearchProductSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Product");

		// Brand Selection
		driver.findElement(ddBrandSelection).click();
		log.info("Clicked on Brand Selection Drop Down.");

		builder = new Actions(driver);

		builder.sendKeys("acqua panna").perform();
		log.info("Enter the Brand details in Search Field.");

		builder.sendKeys(Keys.ENTER).perform();
		log.info("Press Enter.");

		driver.findElement(btnSSNextStep2).click();
		log.info("Clicked on Next button for Step 2.");

		// Widget Type
		driver.findElement(ddWidgetSelection).click();
		log.info("Clicked on Widget Selection Drop Down.");

		driver.findElement(txtWidgetSelection).sendKeys("master product smartbutton");
		log.info("Enter the Widget type details in Search Field.");

		driver.findElement(txtWidgetSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Widget");

		driver.findElement(btnSSNextStep3).click();
		log.info("Clicked on Next button for Step 3.");

		driver.findElement(btnSSNextStep4).click();
		log.info("Clicked on Next button for Step 4.");

		driver.findElement(txtWidgetName).click();
		log.info("Clicked on Widget Name Text Field.");

		driver.findElement(txtWidgetName).sendKeys("testWidgetName");
		log.info("Enter the Widget Name in Text Field.");

		driver.findElement(btnSSSaveStep5).click();
		log.info("Clicked on Save button for Step 5.");

		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));

		driver.findElement(btnClickSave2Cart).click();
		log.info("Click on Click 2 Save 2 Cart Button.");

	}
	
	public void clickSmartSiteCreateNewWidgetUsingWildCard() throws InterruptedException {

		driver.findElement(btncreatenewwidget).click();
		log.info("Clicked on Create New Widget button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));

		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");

		// Product Selection
		driver.findElement(ddProductSelection).click();
		log.info("Clicked on Product Selection Drop Down.");

		driver.findElement(txtSearchProductSelection).click();
		log.info("Click within the Search text box.");

		driver.findElement(txtSearchProductSelection).sendKeys("Product List");
		log.info("Enter the Product details in Search Field.");

		driver.findElement(txtSearchProductSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Product");

		// Search Product
		
		driver.findElement(toggleAvailableProducts).click();
		log.info("Clicked on Available Product Toggle.");
		
		driver.findElement(txtSearchProduct).click();
		log.info("Clicked on Search Product TextBox.");

		builder = new Actions(driver);

		builder.sendKeys("%").perform();
		log.info("Enter the Wild Card  in Search Field.");

		builder.sendKeys(Keys.ENTER).perform();
		log.info("Press Enter.");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectProduct));
		
		driver.findElement(selectProduct).click();
		log.info("Selected the Searched Product.");

		driver.findElement(btnSSNextStep2).click();
		log.info("Clicked on Next button for Step 2.");

		// Widget Type
		driver.findElement(ddWidgetSelection).click();
		log.info("Clicked on Widget Selection Drop Down.");

		driver.findElement(txtWidgetSelection).sendKeys("master product smartbutton");
		log.info("Enter the Widget type details in Search Field.");

		driver.findElement(txtWidgetSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Widget");

		driver.findElement(btnSSNextStep3).click();
		log.info("Clicked on Next button for Step 3.");

		driver.findElement(btnSSNextStep4).click();
		log.info("Clicked on Next button for Step 4.");

		driver.findElement(txtWidgetName).click();
		log.info("Clicked on Widget Name Text Field.");

		driver.findElement(txtWidgetName).sendKeys("testWidgetWildCard");
		log.info("Enter the Widget Name in Text Field.");

		driver.findElement(btnSSSaveStep5).click();
		log.info("Clicked on Save button for Step 5.");

		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));

		driver.findElement(btnClickSave2Cart).click();
		log.info("Click on Click 2 Save 2 Cart Button.");

	}
	
	public void clickSmartSiteCreateNewWidgetUsingUPC() throws InterruptedException {

		driver.findElement(btncreatenewwidget).click();
		log.info("Clicked on Create New Widget button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));

		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");

		// Product Selection
		driver.findElement(ddProductSelection).click();
		log.info("Clicked on Product Selection Drop Down.");

		driver.findElement(txtSearchProductSelection).click();
		log.info("Click within the Search text box.");

		driver.findElement(txtSearchProductSelection).sendKeys("Product List");
		log.info("Enter the Product details in Search Field.");

		driver.findElement(txtSearchProductSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Product");

		// Search Product
		
		driver.findElement(toggleAvailableProducts).click();
		log.info("Clicked on Available Product Toggle.");
		
		driver.findElement(txtSearchProduct).click();
		log.info("Clicked on Search Product TextBox.");

		builder = new Actions(driver);

		builder.sendKeys("041508200202").perform();
		log.info("Enter the Wild Card  in Search Field.");

		builder.sendKeys(Keys.ENTER).perform();
		log.info("Press Enter.");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectProduct));
		
		driver.findElement(selectProduct).click();
		log.info("Selected the Searched Product.");

		driver.findElement(btnSSNextStep2).click();
		log.info("Clicked on Next button for Step 2.");

		// Widget Type
		driver.findElement(ddWidgetSelection).click();
		log.info("Clicked on Widget Selection Drop Down.");

		driver.findElement(txtWidgetSelection).sendKeys("master product smartbutton");
		log.info("Enter the Widget type details in Search Field.");

		driver.findElement(txtWidgetSelection).sendKeys(Keys.ENTER);
		log.info("Press Enter for Selection of Widget");

		driver.findElement(btnSSNextStep3).click();
		log.info("Clicked on Next button for Step 3.");

		driver.findElement(btnSSNextStep4).click();
		log.info("Clicked on Next button for Step 4.");

		driver.findElement(txtWidgetName).click();
		log.info("Clicked on Widget Name Text Field.");

		driver.findElement(txtWidgetName).sendKeys("testWidgetUPC");
		log.info("Enter the Widget Name in Text Field.");

		driver.findElement(btnSSSaveStep5).click();
		log.info("Clicked on Save button for Step 5.");

		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));

		driver.findElement(btnClickSave2Cart).click();
		log.info("Click on Click 2 Save 2 Cart Button.");

	}

	public void clickSmartSiteEditWidget() throws InterruptedException {

		driver.findElement(editurl).click();
		log.info("Clicked on Edit button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));

		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");

		driver.findElement(btnSSNextStep2).click();
		log.info("Clicked on Next button for Step 2.");

		driver.findElement(btnSSNextStep3).click();
		log.info("Clicked on Next button for Step 3.");

		driver.findElement(btnSSNextStep4).click();
		log.info("Clicked on Next button for Step 4.");

		driver.findElement(txtWidgetName).click();
		log.info("Clicked on Widget Name Text Field.");

		driver.findElement(txtWidgetName).sendKeys("Update");
		log.info("Update the Widget Name in Text Field.");

		driver.findElement(btnSSSaveStep5).click();
		log.info("Clicked on Save button for Step 5.");

		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));

		driver.findElement(btnClickSave2Cart).click();
		log.info("Click on Click 2 Save 2 Cart Button.");

	}

	public void clickSmartSiteCopyWidget() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(copyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncopyurl));
		driver.findElement(btncopyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(internalNameColumn));
		Thread.sleep(3000);

	}
	
	public void clickSmartSiteViewWidget() throws InterruptedException {

		driver.findElement(view).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnClickSave2Cart));
		driver.findElement(btnClickSave2Cart).click();
		log.info("Click on Click 2 Save 2 Cart Button.");
		Thread.sleep(3000);

	}
	
	
	
	
	public void clickSmartSiteDeleteWidget() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(deleteurl).click();
		log.info("Clicked on Delete button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btndeleteurl));
		driver.findElement(btndeleteurl).click();
		log.info("Clicked on Delete URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(internalNameColumn));
		Thread.sleep(3000);

	}
	
	public boolean verifySmartSiteDeleteWidget() {

		copyProductNameAfterDelete = driver.findElement(productnameafterdelete).getText();
		if (!copyProductNameAfterDelete.equals(copyProductName)) {
			return true;
		}
		return false;
	}

	public boolean verifySmartSiteCopyWidget() {

		copyProductNameAfterCopy = driver.findElement(productnameaftercopy).getText();
		if (copyProductNameAfterCopy.contains(copyProductName)) {
			return true;
		}
		return false;
	}

	public boolean clickSmartSiteWidgetURL() throws InterruptedException {

		if (driver.findElement(cartIcon).isDisplayed()) {
			driver.findElement(cartIcon).click();
			log.info("Click on Cart Icon.");
			Thread.sleep(5000);
			return true;
		} else
			return false;
	}

}
