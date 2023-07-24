package com.SmartCommerce.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ShopperChoicePage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(ShopperChoicePage.class);
	private WebDriverWait wait;
	public String copyProductName;
	public String copyProductNameAfterCopy;
	public String copyProductNameAfterDelete;
	public String createSuccessMessage;
	public String editSuccessMessage;
	public String srcBeforeURLGenerated;
	public String srcAfterURLGenerated;
	public String bkGroundImageFileName;
	public String TopText;
	public String FooterText;
	public String Spanish;
	public String Retailer1;
	public String Retailer2;
	public String Retailer1Order;
	public String Retailer2Order;
	public String RandomOrder;
	
	WebElement upload_btn;

	// All objects should be defined here
	public By addFile;
	public By makeandmanage = By.xpath("//span[normalize-space()='Make & Manage']");
	public By titleMakeandManage = By.xpath("//h5[normalize-space()='Make & Manage']");
	public By shopperchoice = By.xpath("//a[@id='shopperchoice-makemanage']");
	public By urlColumn = By.xpath("//th[@class='d2c-col-xlong']");
	
	
	public By walmart = By.xpath("//div[@id='listado_supers']//img[@alt='Walmart.com']");
	public By amazon = By.xpath("//div[@id='listado_supers']//img[@alt='Amazon']");
	
	public By lblrandomOrder = By.xpath("//span[normalize-space()='Random order']");
											
	
	public By walmartCartOrder = By.xpath("//span[contains(text(),'Save to your Walmart.com Cart')]");
													
	public By amazonCartOrder = By.xpath("//span[contains(text(),'Save to your Amazon Cart')]");
	
	public By plkurl = By.partialLinkText("https://stage.click2");
	public By productname = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public By copyurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[3]/i[1]");
	public By btncopyurl = By.xpath("//a[@class='btn btn-primary rounded-pill modalBtnSubmit']");
	public By productnameaftercopy = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public By deleteurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[6]/i[1]");
	public By btndeleteurl = By.xpath("//button[normalize-space()='delete URL']");
	public By productnameafterdelete = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) span:nth-child(1)");
	public By btncreatenewurl = By.xpath("//a[@class='btn btn-primary rounded-pill button-style-change']");
	public By brandeduiretailer = By.xpath("//img[@alt='branded product choice example']");
	public By retailerandproductchoice = By.xpath("//img[@alt='branded retailer and product choice example']");
	public By btnNextStep1 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep2 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep3 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep4 = By.xpath("//button[normalize-space()='Next step']");
	public By btnNextStep5 = By.xpath("//button[normalize-space()='Next step']");
	public By btnSaveStep6 = By.xpath("//button[@type='button'][normalize-space()='Save']");
	public By toggleSmartShelf = By.xpath("//div[@class='row pb-2 mb-2']//div[@class='col-12']//input[@role='switch']");
	public By toggleAddExistingGroup = By.xpath("//input[@id='productGroupCfg']");
	public By selectExistingProductGroup = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[15]/div[1]/div[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]");
	public By btnAddProductGroup = By.xpath("//button[normalize-space()='+ Add Product Group']");
	public By btnAddSelectedProductGroup = By.xpath(
			"//div[@class='modal fade modal-info show']//button[@class='btn btn-primary rounded-pill'][normalize-space()='Save']");
	public By txtSearch = By.xpath("//input[@placeholder='Search']");
	public By btnClearRetailer = By.xpath("//button[@id='retailers-filter-btn']");
	public By toggleCustomeRetailerOption = By.xpath("//input[@id='customRetOpt']");
	public By radioCustomOrder = By.xpath("//input[@class='retailer-order-options-1']");
	public By radioRandomOrder = By.xpath("//input[@class='retailer-order-options-0']");
	public By enterRetailer = By.xpath("//input[@placeholder='Search']");
	public By searchProduct = By.xpath("//input[@aria-label='Search']");
	public By btnsearchproduct = By
			.xpath("//div[@class='col-lg-5 col-md-6 mb-3']//button[@type='button'][normalize-space()='search']");
	public By selectRetailer = By.xpath(
			"//button[@class='position-relative btn btn-outline-light list-supers-eshop button-super']//img[@title='Amazon - US']");
	public By selectWallMartRetailer = By.xpath(
			"//img[@title='Walmart.com - US']");
	public By selectLocalRetailer = By.xpath(
			"//img[@title='Instacart - US']");
	public By selectWTBRetailer = By.xpath(
			"//img[@title='Chewy - US']");
	public By lbloutofstockproducts = By
			.xpath("//label[normalize-space()='Out of Stock Products for Selected Retailers']");
	public By lblinstockproducts = By.xpath("//label[normalize-space()='In Stock Products for Selected Retailers']");
	public By lblproducts = By.xpath("//td[@class='col-products']");
	public By lblname = By.xpath(
			"//thead[@class='text-uppercase small bg-body sticky-header']//td[@class='col-name'][normalize-space()='Name']");
	
	public By btnaddproduct = By.xpath("(//button[contains(text(),'Add')])[1]");
	public By txtinternalurl = By.xpath("//input[@required='required']");
	public By btngenerateurl = By.xpath("//button[@id='generate']");
	public By btnupdate = By.xpath("//div[@class='card-footer']//button[@type='button'][normalize-space()='Save']");
	public By titlegeneratedURL = By.xpath("//div[contains(text(),'URL generated correctly')]");
	public By editurl = By.xpath(
			"//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[2]");
	
	public By radioAddImage = By.xpath("//label[@for='selector_assets_image']");
	public By radioAddBackGroundImage = By.xpath("//input[@id='bgTypeRadioImg']");
	
	
	public By upload = By.xpath("//label[@for='assetInpImg']//i[@class='fa fa-plus-circle']");
	public By toggleCustomerOptions = By.xpath("//input[@id='customDisplayOpt']");
	
	public By changeORAddNewAsset= By.xpath("//div[@id='displayAssetOptionImages']//button[@class='btn btn-link'][normalize-space()='Change or add a new asset']");
			
	public By btnuploadAsset = By.xpath("//label[@for='assetInpImg']//i[@class='fa fa-plus-circle']");
	
	public By imageupload = By.xpath("//*[@id=\"dflt_image_asset_uploaded\"]");
	
	public By imageuploadid = By.id("assetInpImg");
	public By imageAddBackground = By.id("imgInp");
	
	
	public By uploadedImageXpath = By.xpath("//div[@class='showImageAssetsInside text-center selected']//img[@title='MarketingAsset.png']");
	public By uploadedBackGroundImageXpath = By.xpath("//div[@id='custom_images_upload']//div//div//img[@title='BackGroundImage.jpg']");
	public By imageSrcafterURL = By.xpath("//div[@class='banner-img ng-star-inserted']//img	");
	public By bgimageSrcafterURL = By.xpath("//div[@class='shopper-choice ng-star-inserted']");
	
	public By toggleLocal = By.xpath("//input[@id='localRetailers']");
	public By togglePDPRetailer = By.xpath("//input[@id='wtbRetailers']");
	public By toggleCustomeMessaging = By.xpath("//input[@id='customTextOpt']");
	public By listAlternativeLanguage = By.xpath("//option[@id='alter_language_2']");
	public By tabAlternativeLanguage = By.xpath("//ul[@id='tabs-language']//button[@class='nav-link tab-language-button'][normalize-space()='Spanish']");
	public By txtTopTextContainer = By.xpath("//div[@id='topTitleContainer-2']//div[@role='textbox']");
	public By txtFooterTextContainer = By.xpath("//div[@id='footerTextContainer-2']//div[@role='textbox']");

	public By c2clblTopLanguage = By.xpath("//p[normalize-space()='spanish top']");
	public By c2clblFooterLanguage = By.xpath("//p[normalize-space()='spanish footer']");
	public By iconLanguage = By.xpath("//i[@class='fa fa-language']");
	public By iconLocation = By.xpath("//span[@class='current-zip']");
	public By spanishLanguage = By.xpath("//div[normalize-space()='Spanish']");
	
	
	public By lblbummer = By.xpath("//h1[normalize-space()='Bummer!']");
	public By lblZipcode = By.xpath("//span[@class='label']");
	public By inputZipcode = By.xpath("//input[@id='inp']");
	
	public By txtzipcode = By.xpath("//input[@placeholder='Enter your zipcode']");
	public By btnChangeZipCode = By.xpath("//button[normalize-space()='Change zip code']");
	
	public By storeurl = By.xpath("//div[@class='retailer-button-container ng-star-inserted']");
	
	
	
	
	
	

	public ShopperChoicePage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public void clickMakeandManage() {

		driver.findElement(makeandmanage).click();
	}

	public void shoppersChoice() {

		driver.findElement(shopperchoice).click();
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Check if Text "Cart" is present on the Page.
		if (driver.getPageSource().contains("Click2Cart")) {
			log.info("URL Opened Successfully.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}
	
	public boolean verifyNewPageWithMarketingAssets() {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement getSourceafterclick = driver.findElement(imageSrcafterURL);
		srcAfterURLGenerated = getSourceafterclick.getAttribute("src");
		
		// Check if Text "Cart" is present on the Page.
		if (driver.getPageSource().contains("Click2Cart") && srcBeforeURLGenerated.equals(srcAfterURLGenerated)) {
			log.info("URL Opened Successfully and Image Uploaded Successfully.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}
	
	public boolean verifyLocalRetailer() throws InterruptedException {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> elems = driver.findElements(lblbummer);

		if (elems.size() == 0) {
			Thread.sleep(5000);
			driver.findElement(storeurl).click();

		} else {

			driver.findElement(txtzipcode).clear();
			driver.findElement(txtzipcode).sendKeys("10001");
			driver.findElement(txtzipcode).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(storeurl).click();
		}

		if (driver.getPageSource().contains("Click2Cart") || driver.getPageSource().contains("Instacart")) {
			log.info("URL Opened Successfully .");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}

	public boolean verifyWTBRetailer() throws InterruptedException {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> elems = driver.findElements(lblbummer);

		if (elems.size() == 0) {
			Thread.sleep(5000);
			driver.findElement(storeurl).click();

		} else {

			driver.findElement(txtzipcode).clear();
			driver.findElement(txtzipcode).sendKeys("10001");
			driver.findElement(txtzipcode).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(storeurl).click();
		}

		if (driver.getPageSource().contains("Click2Cart") || driver.getPageSource().contains("Chewy")) {
			log.info("URL Opened Successfully .");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}
	
	
	
	public boolean verifyWTBRetailerLanguage() throws InterruptedException {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		
		List<WebElement> elems = driver.findElements(lblbummer);

		if (elems.size() == 0) {
			
			driver.findElement(iconLanguage).click();
			Thread.sleep(2000);
			driver.findElement(spanishLanguage).click();
			Thread.sleep(5000);
			TopText = driver.findElement(c2clblTopLanguage).getText();
			FooterText = driver.findElement(c2clblFooterLanguage).getText();
			//driver.findElement(iconLanguage).click();
			//Spanish = driver.findElement(spanishLanguage).getText();
			//Thread.sleep(5000);
			//driver.findElement(storeurl).click();

		} else {

			driver.findElement(txtzipcode).clear();
			driver.findElement(txtzipcode).sendKeys("10001");
			driver.findElement(txtzipcode).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(storeurl).click();
		}

		if (driver.getPageSource().contains("Click2Cart") && TopText.equals("spanish top") && FooterText.equals("spanish footer")) {
			log.info("Language Top and Footer Text showing correctly, Also the Alternative Language showing on C2c.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}
	
	public boolean verifyCustomRetailerOrder() throws InterruptedException {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> elems = driver.findElements(lblbummer);

		if (elems.size() == 0) {
			
			/*
			 * driver.findElement(iconLanguage).click(); Thread.sleep(2000);
			 * driver.findElement(spanishLanguage).click(); Thread.sleep(5000);
			 */
			
			Retailer1Order=driver.findElement(walmartCartOrder).getText();
			Retailer2Order=driver.findElement(amazonCartOrder).getText();
			

			//driver.findElement(iconLanguage).click();
			//Spanish = driver.findElement(spanishLanguage).getText();
			//Thread.sleep(5000);
			//driver.findElement(storeurl).click();

		} else {

			driver.findElement(txtzipcode).clear();
			driver.findElement(txtzipcode).sendKeys("10001");
			driver.findElement(txtzipcode).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(storeurl).click();
		}

		if (driver.getPageSource().contains("Click2Cart") && Retailer1Order.contains("Walmart.com") && Retailer2Order.contains("Amazon")) {
			log.info("Checking Retailer Order.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}
	
	
	public boolean verifyNewPageWithBackGroundAssets() {

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String getSourceafterclick = driver.findElement(By.xpath("//body")).getAttribute("style");

		// Check if Text "Cart" is present on the Page.
		if (driver.getPageSource().contains("Click2Cart") && getSourceafterclick.contains(bkGroundImageFileName)) {
			log.info("URL Opened Successfully and Back Ground Image Uploaded Successfully.");
			driver.close();
			return true;
		} else {
			log.info("Something Went Wront with the Link...");
		}
		// Close the newly opened window
		driver.close();
		return false;
	}

	public void clickShoppersChoiceCopyURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(copyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncopyurl));
		driver.findElement(btncopyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);
	}

	public boolean verifyShopperChoiceCopyURL() {

		copyProductNameAfterCopy = driver.findElement(productnameaftercopy).getText();
		if (copyProductNameAfterCopy.contains(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickShopperChoiceDeleteURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(deleteurl).click();
		log.info("Clicked on Delete button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btndeleteurl));
		driver.findElement(btndeleteurl).click();
		log.info("Clicked on Delete URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);

	}

	public boolean verifyShoppersChoiceDeleteURL() {

		copyProductNameAfterDelete = driver.findElement(productnameafterdelete).getText();
		if (!copyProductNameAfterDelete.equals(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickShoppersChoiceCreateRetailerUsingName() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURLName");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 5.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	public void clickShoppersChoiceCreateRetailerUsingWildCard() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("%");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURLWildCard");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 5.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	public void clickShoppersChoiceCreateRetailerUsingUPC() {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("041508200202");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testproductURLUPC");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 5.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickCreatedShoppersChoiceLink() throws InterruptedException {

		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickCreatedShoppersChoiceMarketingAssetsLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickCreatedShoppersChoiceBackgroundAssetsLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickCreatedShoppersChoiceLocalLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickCreatedShoppersChoiceWTBLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickCreatedShoppersChoiceWTBLanguageLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void clickShoppersChoiceCustomLink() throws InterruptedException {
		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}
	
	public void checkSelectionOrder() throws InterruptedException {
		
		Retailer1=driver.findElement(walmart).getText();
		Retailer2=driver.findElement(amazon).getText();
		
	}
	
	public boolean checkRandomOrder() throws InterruptedException {

		RandomOrder=driver.findElement(lblrandomOrder).getText();
		if (RandomOrder.contains("Random order")) {
			return true;
		}else
			return false;
	}
	
	

	public void clickEditedShoppersChoiceLink() throws InterruptedException {

		driver.findElement(plkurl).click();
		Thread.sleep(10000);
	}

	public void clickShoppersChoiceEditURL() {

		driver.findElement(editurl).click();
		log.info("Clicked on Edit button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("Update ");
		log.info("Update Internal URL name.");
		driver.findElement(btnupdate).click();
		log.info("Clicked on Save button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		editSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public boolean verifyShopperChoiceEditURL() {

		if (editSuccessMessage.contains("URL generated correctly")) {
			return true;
		}
		return false;
	}

	public void clickShoppersChoiceCreateRetailerandProductChoice() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(retailerandproductchoice).click();
		log.info("Clicked on Retailer and Product Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(toggleSmartShelf).click();
		log.info("Clicked on Smart Shelf Toggle to turn it ON.");
		driver.findElement(btnAddProductGroup).click();
		log.info("Clicked on Add Product Group button.");
		driver.findElement(toggleAddExistingGroup).click();
		log.info("Clicked on Choose Existing Toggle to turn it ON.");	
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblname));
		driver.findElement(selectExistingProductGroup).click();
		log.info("Select Existing Product Group from the List");
		driver.findElement(btnAddSelectedProductGroup).click();
		log.info("Press Save button to Select Existing Product Group from the List");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnNextStep3));
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testSmartShelfURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public void clickShoppersChoiceCreateRetailerWithMarketingAssets() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");	
		driver.findElement(toggleCustomerOptions).click();
		log.info("Click on Custom options toggle.");
		driver.findElement(radioAddImage).click();
		log.info("Click on Add Image Radio button under Marketing assets.");
		Thread.sleep(2000);
		driver.findElement(changeORAddNewAsset).click();
		log.info("Click on Change or Add New assets.");
		upload_btn = driver.findElement(imageuploadid);
		log.info("Get the ID of Upload button.");
		Thread.sleep(2000);
		//upload image from the set Path
		upload_btn.sendKeys("C:\\Users\\hashimfarooq\\eclipse-workspace\\SmartCommerce\\src\\test\\resources\\assets\\MarketingAsset.png");
		log.info("Upload Image from the Set Path");
		Thread.sleep(5000);	
		//Get Image SRC	
		WebElement getSource = driver.findElement(uploadedImageXpath);
		getSource.click();
		System.out.println("Src attribute is: "+ getSource.getAttribute("src"));
		//Save Image Src in a String
		srcBeforeURLGenerated = getSource.getAttribute("src");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testShopperChoiseMarketingURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	public void clickShoppersChoiceCreateRetailerWithBackGroundAssets() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");	
		driver.findElement(toggleCustomerOptions).click();
		log.info("Click on Custom options toggle.");
		driver.findElement(radioAddBackGroundImage).click();
		log.info("Click on Add Background Image Radio button under Customize your background.");
		Thread.sleep(2000);
		upload_btn = driver.findElement(imageAddBackground);
		log.info("Get the ID of Add Background button.");
		Thread.sleep(2000);
		//upload image from the set Path
		upload_btn.sendKeys("C:\\Users\\hashimfarooq\\eclipse-workspace\\SmartCommerce\\src\\test\\resources\\assets\\BackGroundImage.jpg");
		log.info("Upload Background Image from the Set Path");
		bkGroundImageFileName = "BackGroundImage.jpg";
		Thread.sleep(10000);	
		//Get Image SRC	
		WebElement getSourceBG = driver.findElement(uploadedBackGroundImageXpath);
		getSourceBG.click();
		System.out.println("Src BG attribute is: "+ getSourceBG.getAttribute("src"));
		//Save Image Src in a String
		srcBeforeURLGenerated = getSourceBG.getAttribute("src");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testShopperChoiseBackGroundImage");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	public void clickShoppersChoiceCreateLocalRetailer() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(toggleLocal).click();
		log.info("Clicked on Local Retailer Toggle button.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Insta");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectLocalRetailer).click();
		log.info("Select Local Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("Smartwater");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");	
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testShopperChoiseLocalRetailerURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	
	
	
	public void clickShoppersChoiceCreateWTBRetailer() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(togglePDPRetailer).click();
		log.info("Clicked on WTB Retailer Toggle button.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("chewy");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectWTBRetailer).click();
		log.info("Select Local Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");	
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testShopperChoiseWTBRetailerURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	public void clickShoppersChoiceWTBRetailerLanguage() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(togglePDPRetailer).click();
		log.info("Clicked on WTB Retailer Toggle button.");
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("chewy");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectWTBRetailer).click();
		log.info("Select WTB Retailer.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		driver.findElement(searchProduct).sendKeys("water");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
	
		
		driver.findElement(toggleCustomeMessaging).click();
		log.info("Clicked on Custom Messaging Toggle.");	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(listAlternativeLanguage));
		
		driver.findElement(listAlternativeLanguage).click();
		log.info("Clicked Spanish to select Alternative Language.");
		
		Thread.sleep(2000);
		driver.findElement(tabAlternativeLanguage).click();
		log.info("Clicked on Spanish tab.");
		
		Thread.sleep(2000);
		driver.findElement(txtTopTextContainer).click();
		log.info("Clicked on Top Text Container.");
		
		driver.findElement(txtTopTextContainer).sendKeys("spanish top");
		log.info("Enter Spanish Text in Top Container.");
		
		driver.findElement(txtFooterTextContainer).click();
		log.info("Clicked on Footer Text Container.");

		driver.findElement(txtFooterTextContainer).sendKeys("spanish footer");
		log.info("Enter Spanish Text in Footer Container.");
		
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testShopperChoiseWTBRetailerLanguageURL");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	
	public void clickShoppersChoiceManualRetailerSelection() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("walmart.com");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectWallMartRetailer).click();
		log.info("Select Retailer.");
		
		Thread.sleep(2000);
		
		driver.findElement(btnClearRetailer).click();
		log.info("Clear Retailer.");
		
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		
		Thread.sleep(2000);
		
		driver.findElement(toggleCustomeRetailerOption).click();
		log.info("Enable Customer Retailer Option.");
		
		driver.findElement(radioCustomOrder).click();
		log.info("Select Custom Order Option.");
		
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		
		driver.findElement(searchProduct).sendKeys("washing");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testmanualselection");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 5.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	
	
	
	public void clickShoppersChoiceRandomRetailerSelection() throws InterruptedException {

		driver.findElement(btncreatenewurl).click();
		log.info("Clicked on Create New URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(brandeduiretailer).click();
		log.info("Clicked on Branded UI Retailer Choice.");
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("walmart.com");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectWallMartRetailer).click();
		log.info("Select Retailer.");
		
		Thread.sleep(2000);
		
		driver.findElement(btnClearRetailer).click();
		log.info("Clear Retailer.");
		
		driver.findElement(txtSearch).click();
		log.info("Clicked on Search Text field.");
		driver.findElement(enterRetailer).sendKeys("Amazon");
		log.info("Enter Retailer in Search Field.");
		driver.findElement(selectRetailer).click();
		log.info("Select Retailer.");
		
		Thread.sleep(2000);
		
		driver.findElement(toggleCustomeRetailerOption).click();
		log.info("Enable Customer Retailer Option.");
		
		Thread.sleep(2000);
		
		driver.findElement(radioRandomOrder).click();
		log.info("Select Random Order Option.");
		
		Thread.sleep(2000);
		
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		
		driver.findElement(searchProduct).click();
		log.info("Clicked on Product Search Field.");
		
		driver.findElement(searchProduct).sendKeys("washing");
		log.info("Enter Product in Search Field.");
		driver.findElement(btnsearchproduct).click();
		log.info("Press Search button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblinstockproducts));
		driver.findElement(btnaddproduct).click();
		log.info("Add Product.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("testrandomselection");
		log.info("Enter Internal URL name.");
		driver.findElement(btngenerateurl).click();
		log.info("Clicked on Generate button on Step 5.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		createSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}
	

	public void clickShoppersChoiceSmartShelfCopyURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(copyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncopyurl));
		driver.findElement(btncopyurl).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);
	}

	public boolean verifyShopperChoiceSmartShelfCopyURL() {

		copyProductNameAfterCopy = driver.findElement(productnameaftercopy).getText();
		if (copyProductNameAfterCopy.contains(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickShopperChoiceSmartShelfDeleteURL() throws InterruptedException {

		copyProductName = driver.findElement(productname).getText();
		driver.findElement(deleteurl).click();
		log.info("Clicked on Delete button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btndeleteurl));
		driver.findElement(btndeleteurl).click();
		log.info("Clicked on Delete URL button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(urlColumn));
		Thread.sleep(3000);

	}

	public boolean verifyShoppersChoiceSmartShelfDeleteURL() {

		copyProductNameAfterDelete = driver.findElement(productnameafterdelete).getText();
		if (!copyProductNameAfterDelete.equals(copyProductName)) {
			return true;
		}
		return false;
	}

	public void clickShoppersChoiceSmartShelfEditURL() {

		driver.findElement(editurl).click();
		log.info("Clicked on Edit button.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMakeandManage));
		driver.findElement(btnNextStep1).click();
		log.info("Clicked on Next button for Step 1.");
		driver.findElement(btnNextStep2).click();
		log.info("Clicked on Next button for Step 2.");
		driver.findElement(btnNextStep3).click();
		log.info("Clicked on Next button for Step 3.");
		driver.findElement(btnNextStep4).click();
		log.info("Clicked on Next button for Step 4.");
		driver.findElement(btnNextStep5).click();
		log.info("Clicked on Next button for Step 5.");
		driver.findElement(txtinternalurl).click();
		log.info("Click on Internal Name of URL field.");
		driver.findElement(txtinternalurl).sendKeys("Update ");
		log.info("Update Internal URL name.");
		driver.findElement(btnupdate).click();
		log.info("Clicked on Save button on Step 6.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titlegeneratedURL));
		editSuccessMessage = driver.findElement(titlegeneratedURL).getText();
	}

	public boolean verifyShopperChoiceSmartShelfEditURL() {

		if (editSuccessMessage.contains("URL generated correctly")) {
			return true;
		}
		return false;
	}
}
