package com.naukri.reporting;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getTest() {

		return extentTest.get();

	}

	public static void startTest(String Testname) {

		ExtentTest test = ExtentManager.getInstance().createTest(Testname);
		extentTest.set(test);

	}

	public static void endTest() {

		extentTest.remove();
	}

}
