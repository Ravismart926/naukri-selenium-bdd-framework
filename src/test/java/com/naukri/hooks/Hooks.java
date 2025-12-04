package com.naukri.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.naukri.drivers.BrowserFactory;
import com.naukri.drivers.DriverManager;
import com.naukri.reporting.ExtentManager;
import com.naukri.reporting.ExtentTestManager;
import com.naukri.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup() {
        ConfigReader.loadconfig();
        
        driver = BrowserFactory.launchBrowser();   // IMPORTANT: use class variable
        DriverManager.setDriver(driver);
        
        driver.get(ConfigReader.get("baseurl"));
        System.out.println("Browser Launched and Application opened");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String testname = scenario.getName();
        ExtentTestManager.startTest(testname);
    }

    @After
    public void afterScenario(Scenario scenario) {

        try {
            if (scenario.isFailed()) {

                String base64 = ((TakesScreenshot) DriverManager.getDriver())
                                .getScreenshotAs(OutputType.BASE64);

                ExtentTestManager.getTest().fail("Scenario failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Failure Screenshot").build()
                );

            } else {
                ExtentTestManager.getTest().pass("Scenario passed");
            }

        } catch (Exception e) {

            ExtentTestManager.getTest().warning("Could not attach screenshot: " + e.getMessage());
        }

        ExtentManager.getInstance().flush();
        ExtentTestManager.endTest();

        DriverManager.unloadDriver();
        System.out.println("Browser closed successfully");
    }

}
