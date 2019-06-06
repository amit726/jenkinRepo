package orgGeneric;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties webElements;
	public static Properties config;
	public static WebElement ele;
	public static By by;
	public static WebDriverManager wdmanager;
	public static Logger logs = null;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest extentlogs;
	public static ExtentReports extent=new ExtentReports();
	public static ITestResult result;
	public static Properties xlProperties;
	public static String path=null;
	public static String sheet=null;
	public static String testcaseName=null;

	public static void initialiseBrwPrg() {
		try {
			config = new Properties();
			config.load(new FileInputStream("D:\\Nov_java program\\AmitMaven\\amitfolder\\config.properties"));
			logs.info("config properties loadedd successfully");
		} catch (Exception e) {
			logs.info("error while loading config file");
			logs.info(e.getMessage());
		}
	}


	public static void launchBrowser(String browser) {
		if (config.getProperty(browser).equals("Chrome")) {
			logs.info("Opening chrome browser");
			wdmanager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

		} else if (config.getProperty(browser).equals("Firefox")) {
			logs.info("Opening firefox browser");
			wdmanager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser(WebDriver driver) {
		try { logs.info("closing the browser");
			driver.quit();
		} catch (Exception e) {
			logs.info("could not cloe the browser");
			logs.info(e.getMessage());
		}
	}
	
	public static void enterURL() {
		try { logs.info("Opening URL"+config.getProperty("URL"));
			driver.get(config.getProperty("URL"));
		} catch (Exception e) {
			logs.info("Counld not load the url");
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public static void initialiseEleloctr()
	{

		try {
			webElements = new Properties();
			webElements.load(new FileInputStream("D:\\Nov_java program\\AmitMaven\\amitfolder\\Locator.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement getElement(WebDriver driver, String element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String locator = webElements.getProperty(element);
		String[] objects = locator.split("-");
		String locatorType = objects[0];
		String locatorValue = objects[1];

		if (locatorType.equals("xpath")) {
			by = By.xpath(locatorValue);
			ele = driver.findElement(by);
		} else if (locatorType.equals("id")) {
			by = By.id(locatorValue);
			ele = driver.findElement(by);
		} else if (locatorType.equals("className")) {
			by = By.className(locatorValue);
			ele = driver.findElement(by);
		} else if (locatorType.equals("cssSelector")) {
			by = By.cssSelector(locatorType);
			ele = driver.findElement(by);
		} else if (locatorType.equals("name")) {
			by = By.name(locatorType);
			ele = driver.findElement(by);
		} else if (locatorType.equals("linkText")) {
			by = By.linkText(locatorValue);
		} else if (locatorType.equals("partialLinkText")) {
			by = By.partialLinkText(locatorValue);
			ele = driver.findElement(by);
		} else if (locatorType.equals("tagName")) {
			by = By.tagName(locatorValue);
			ele = driver.findElement(by);
		}
		return ele;

	}

}
