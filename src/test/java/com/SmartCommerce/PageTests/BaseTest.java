package com.SmartCommerce.PageTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest {

	private WebDriver driver;
	protected static Properties prop;
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	LoggerContext context = (LoggerContext) LogManager.getContext(false);
	File file = new File("src/test/resources/properties/log4j2.xml");

	public WebDriver initializeDriver() throws IOException {
		prop = loadConfig();
		context.setConfigLocation(file.toURI());
		String browserName = prop.getProperty("browser");
		String browserURL = prop.getProperty("urlsso");
		//String fileUpload = prop.getProperty("IMAGE_FILE_UPLOAD_PATH");
		ChromeOptions options = new ChromeOptions();

		log.debug("Running on browser: " + browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe");
			options.addArguments("user-data-dir=C:/Users/hashimfarooq/AppData/Local/Google/Chrome/User Data Hash/");
			options.addArguments("--profile-directory=Profile 4");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-popup-blocking");

			// TO CATER THE RESTORE PAGE OPTION
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.exit_type", "Normal");
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			driver.get(browserURL);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/IEDriverServer");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(browserName + " is not a valid browser");
		}
		return driver;
	}

	public Properties loadConfig() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		prop.load(fis);
		return prop;
	}
}
