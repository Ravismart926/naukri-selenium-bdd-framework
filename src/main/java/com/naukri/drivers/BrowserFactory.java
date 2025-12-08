package com.naukri.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.naukri.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver launchBrowser() {

		WebDriver driver = null;
		String browserName = ConfigReader.get("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if (System.getenv("JENKINS_HOME") != null) {

				System.out.println("Running in Jenkins → Headless Chrome enabled");
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--window-size=1920,1080");
			} else {
				options.addArguments("--start-maximized");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			if (System.getenv("JENKINS_HOME") != null) {
				options.addArguments("--headless=new");
			}
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if (System.getenv("JENKINS_HOME") != null) {
				options.addArguments("--headless");
			}

			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();

		} else {
			throw new RuntimeException("Invalid browser name: " + browserName);
		}

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
