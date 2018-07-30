package com.meganexus.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.meganexus.GenericLib.TestBase;
import com.meganexus.pageObjLib.AddressPage;
import com.meganexus.pageObjLib.LoginPage;

@Listeners(ScreenShots.class)
public class AddressTest {
	LoginPage lp=new LoginPage();

	@BeforeMethod
	public void openApps() throws InterruptedException {
		lp.Startup();
		lp = PageFactory.initElements(TestBase.driver, LoginPage.class);
		lp.entercredentials();
	}

	@Test(priority = 1, description = "address page testing")
	public void addressTest() throws Exception {
		AddressPage ap = PageFactory.initElements(TestBase.driver, AddressPage.class);
		//Thread.sleep(20000);
		ap.addAddress();
		// ap.viewAddress();
		String expected = "CRC Service Users Profile Contact Details Add Address";
		String actual = ap.verifyBreadcrumb();
		Assert.assertEquals(actual, expected, " breadcrumb not match of view address");
	}

	@AfterMethod
	public void logOut() throws InterruptedException {
		lp = PageFactory.initElements(TestBase.driver, LoginPage.class);
		Thread.sleep(4000);

		lp.logOut();
	}

	@AfterClass
	public void closeBrowserInstance() {
		lp.teardown();
	}

}
