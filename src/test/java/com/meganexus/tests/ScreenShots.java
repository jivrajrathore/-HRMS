package com.meganexus.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.meganexus.GenericLib.TestBase;

public class ScreenShots implements ITestListener {
	TestBase tb = new TestBase();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Capabilities cap = ((RemoteWebDriver) TestBase.driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	   
		Date d = new Date();
		            Timestamp t = new Timestamp(d.getTime());
		            String timeStamp = t.toString();
		            timeStamp = timeStamp.replace(' ', '_');
		            timeStamp = timeStamp.replace(':', '_');
		System.out.println("Taking passed tests screen shots");
		String methodName = result.getName().toString().trim();
		tb.takeScreenShots("PassedScreenShots\\",methodName+" "+timeStamp+" "+browserName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Taking failed tests screen shots");
		String methodName = result.getName().toString().trim();
		tb.takeScreenShots("Failed Case Screenshots\\", methodName+"Fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
