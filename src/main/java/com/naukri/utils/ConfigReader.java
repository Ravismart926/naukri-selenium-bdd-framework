package com.naukri.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static void loadconfig() {

		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
			prop.load(fis);

		}

		catch (IOException e) {

			System.out.println("Failure Reason" + e.getMessage());

		}
	}

	public static String get(String key) {

		return prop.getProperty(key);

	}

}
