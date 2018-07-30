package com.meganexus.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.meganexus.GenericLib.TestBase;
import com.meganexus.pageObjLib.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

/*@Listeners(AutomationReporting.class)*/
@Listeners(ScreenShots.class)
public class LoginTest {
	LoginPage lp = new LoginPage();

	@BeforeMethod
	public void openApps() throws InterruptedException {
		lp.Startup();
		lp=PageFactory.initElements(TestBase.driver, LoginPage.class);
		lp.entercredentials();
	}

	@Test(priority = 0, description = "NEO-TR Title verifying, enabled = true")
	public void verfyLoginPageTitleTest() throws Exception {
		lp=PageFactory.initElements(TestBase.driver, LoginPage.class);
		String expected = "My Service Users";
		String actual = lp.getTitle();
		Assert.assertEquals(actual, expected, "title not matched");
		if (actual.equals(
				expected)) {
			ExtentReport.test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			ExtentReport.test.log(LogStatus.FAIL, "verify Title of the page");
		}
		ExtentReport.report.endTest(ExtentReport.test);
		ExtentReport.report.flush();
	}
	

	@AfterMethod
	public void logOut() throws InterruptedException {
		lp=PageFactory.initElements(TestBase.driver, LoginPage.class);
		Thread.sleep(4000);;
		lp.logOut();
	}
	@AfterClass
	public void closeBrowserInstance(){
		lp.teardown();
	}

}
