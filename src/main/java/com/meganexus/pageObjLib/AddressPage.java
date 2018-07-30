package com.meganexus.pageObjLib;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.meganexus.GenericLib.TestBase;

public class AddressPage extends TestBase {

	private static final Logger log = LogManager.getLogger(AddressPage.class);
	
	@FindBy(xpath = "//button[contains(.,'CRC Service Users')]")
	private WebElement btn_crcServiceUsers;
	@FindBy(xpath = "//a[@id='filter']")
	private WebElement lnk_filter;
	@FindBy(xpath = "//input[@id='caseReferenceNumber']")
	private WebElement input_crn;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btn_search;
	@FindBy(xpath = "//button[contains(.,'aa')]")
	private WebElement btn_view_serviceUser;
	@FindBy(xpath = "//button[contains(.,'Contact Details')]")
	private WebElement btn_contactDetails;
	@FindBy(xpath = "//a[contains(.,'ADDRESS')]")
	private WebElement lnk_Address;
	@FindBy(xpath = "//button[@title='Add Record']")
	private WebElement btn_addAddress;
	@FindBy(xpath = "//select[@id='addressStatusId']")
	private WebElement dropdown_Adddress_Status;
	@FindBy(xpath="//option[@value='2']")
	private WebElement address_status_value;
	@FindBy(xpath = "//input[@id='startDate']")
	private WebElement input_calander;
	@FindBy(xpath = "//input[@id='buildingName']")
	private WebElement input_buildingName;
	@FindBy(xpath = "//button[contains(.,'SUBMIT')]")
	private WebElement btn_Submit;
	@FindBy(xpath = "//button[@id='address_view0']")
	private WebElement btn_viewAddress;
	@FindBy(xpath = "//ul[@class='breadcrumb']")
	private WebElement breadcrumb;

	public void addAddress() throws InterruptedException {

		try {
			//waitForElement(btn_crcServiceUsers);
			Thread.sleep(40000);
			btn_crcServiceUsers.click();
			//waitForElementToClickable(lnk_filter);
			Thread.sleep(10000);
			lnk_filter.click();
			//waitForElementToClickable(input_crn);
			Thread.sleep(10000);
			input_crn.sendKeys("X020694");
			//waitForElementToClickable(btn_search);
			Thread.sleep(10000);
			btn_search.click();
			//waitForElementToClickable(btn_view_serviceUser);
			Thread.sleep(10000);
			btn_view_serviceUser.click();
			//waitForElementToClickable(btn_contactDetails);
			Thread.sleep(10000);
			btn_contactDetails.click();
			//waitForElementToClickable(btn_addAddress);
			Thread.sleep(20000);
			btn_addAddress.click();
			Thread.sleep(20000);
			//waitForElementToSelectable(dropdown_addressAdddress);
			selectElement(dropdown_Adddress_Status);
			//Select se = new Select(address_status_value);
			//se.selectByValue("Previous");
			input_calander.sendKeys("11/10/2017");
			input_buildingName.sendKeys("pentagoan");
			btn_Submit.click();
			driver.navigate().refresh();
		} catch (ElementNotFoundException e) {
		log.error(e.getMessage(), e);
		
		}
	}

	public void viewAddress() {
		driver.navigate().refresh();
		lnk_Address.click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(btn_viewAddress));
		btn_viewAddress.click();

	}

	public String verifyBreadcrumb() {
		return breadcrumb.getText().trim();
	}

}
