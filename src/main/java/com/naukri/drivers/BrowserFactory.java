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
			
			boolean isCI = System.getenv("JENKINS_HOME") != null 
	                || System.getenv("GITHUB_ACTIONS") != null;

			if (isCI) {
			    System.out.println("Running in CI environment → Headless Chrome enabled");
			    options.addArguments("--headless=new");
			    options.addArguments("--no-sandbox");
			    options.addArguments("--disable-dev-shm-usage");
			    options.addArguments("--window-size=1920,1080");
			    options.addArguments("--disable-gpu");
			    options.addArguments("--enable-javascript");
			    options.addArguments("--disable-blink-features=AutomationControlled");
			    options.addArguments("--headless=new");
			    options.addArguments("--disable-gpu");
			    options.addArguments("--no-sandbox");
			    options.addArguments("--disable-dev-shm-usage");
			    options.addArguments("--window-size=1920,1080");
			}
			
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();

			driver = new EdgeDriver(options);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
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
		DriverManager.unloadDriver();
	}
}
