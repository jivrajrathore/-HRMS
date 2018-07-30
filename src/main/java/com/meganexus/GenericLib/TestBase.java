package com.meganexus.GenericLib;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	static WebDriverWait wait;

	public static void open_Browser(String browserName) {
		// String propValue =
		// ReadProperties.getInstance().getProperty("browserType");
		// System.out.println(propValue);
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "src//main//resources//driver//geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("disable-extensions");
				co.addArguments("--start-maximized");
				System.setProperty("webdriver.chrome.driver", "src//main//resources//driver//chromedriver.exe");
				driver = new ChromeDriver(co);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else if (browserName.equalsIgnoreCase("IE")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				System.setProperty("webdriver.ie.driver", "src//main//resources//driver//IEDriverServer.exe");
				capabilities.setCapability("initialBrowserUrl", "");
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				capabilities.setCapability("ignoreZoomSettings", true);
				capabilities.setCapability("ie.ensureCleanSession", true);
				capabilities.setCapability("requireWindowFocus", true);
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				capabilities.setCapability("InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS",
						true);
				driver = new InternetExplorerDriver(capabilities);
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enter_URL(String testsiteBaseURL) {
		driver.navigate().to(testsiteBaseURL);
	}

	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
			
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public void enter_Text(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}

	public void close_Browser() {
		driver.quit();
	}

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToSelectable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public static void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

	}

	public void takeScreenShots(String folderName, String fileName) {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("E:\\AutomationTestingWorkspace\\App Project\\ExcecutionReports\\"
					+ folderName + fileName + ".png"));
			/*
			 * String image = ExtentReport.test .addScreenCapture(
			 * "E:\\AutomationTestingWorkspace\\App Project\\ExcecutionReports\\"+folderName+ fileName+"
			 * .jpg"); ExtentReport.test.log(LogStatus.FAIL,
			 * "verify logo of  the application", image);
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void selectElement(WebElement element) {
		Select se = new Select(element);
		se.selectByIndex(4);
	}
	
}
