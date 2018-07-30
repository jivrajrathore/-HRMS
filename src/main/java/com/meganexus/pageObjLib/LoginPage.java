package com.meganexus.pageObjLib;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.meganexus.GenericLib.ReadProperties;
import com.meganexus.GenericLib.TestBase;
//import com.meganexus.selenium.reporting.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement tbx_username;
	@FindBy(xpath = "//input[@id='pwd']")
	public static WebElement tbx_password;
	@FindBy(xpath = "//button[text()='Sign in']")
	public static WebElement btn_login;
	@FindBy(xpath = "//button[text()='Log Out']")
	public static WebElement btn_logOut;
	@FindBy(xpath = "//span[contains(.,'My Service Users')]")
	public static WebElement myServiceUserTitle;
	@FindBy(xpath = "//button[contains(.,'Log Out')]")
	public static WebElement btn_logout;

	public void Startup() {
		String browser = ReadProperties.getInstance().getProperty("browserType");
		open_Browser(browser);
		driver.manage().window().maximize();
		String URL = ReadProperties.getInstance().getProperty("testsiteBaseURL");
		TestBase.enter_URL(URL);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void entercredentials() throws InterruptedException {
		try {
			String userName = ReadProperties.getInstance().getProperty("username");
			String passWord = ReadProperties.getInstance().getProperty("password");
			tbx_username.sendKeys(userName);
			tbx_password.sendKeys(passWord);
			btn_login.click();

		} catch (ElementNotVisibleException e) {
			System.out.println("xpath not correct");
		} catch (NullPointerException n) {
			System.out.println("Unable to get property value " + n.getMessage());
		}
	}

	public String getTitle() {
		TestBase.waitForElement(myServiceUserTitle);
		return myServiceUserTitle.getText();
	}

	public void clickOnLogoutBtn() throws InterruptedException {
		try {
			btn_logOut.click();
			wait(2000);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
	}

	/*public void logOut() {
		btn_logout.click();
	}*/

	public void teardown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}
	}

}
