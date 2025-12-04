package com.naukri.utils;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String getBase6Bas4Screenshot(WebDriver driver) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			return Base64.getEncoder().encodeToString(src);

		} catch (Exception e) {
		}

		return null;

	}

}
