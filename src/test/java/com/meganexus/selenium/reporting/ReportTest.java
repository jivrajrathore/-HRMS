package com.meganexus.selenium.reporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ReportTest {
	
	public static void main (String args[]) {
		System.out.println("aaaaaaaaaaaaaaaaa");
		WebDriver driver = new HtmlUnitDriver();
		
		
		Reporter.initialize();
		driver.get("http://www.ontestautomation.com/files/report_test.html");
		
		for (int i = 1; i <=5; i++) {
			WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
			Reporter.report(el.getAttribute("value"), "Text field " + Integer.toString(i));
		}
		
		Reporter.writeResults();
		driver.close();	
	}
	
}