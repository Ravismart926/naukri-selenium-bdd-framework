package com.company.pages;

import java.sql.DriverManager;
import java.util.List;

//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.pageHelper.BasePage;
import com.naukri.utils.ConfigReader;
import com.naukri.utils.WaitUtils;

public class LoginPage extends BasePage {

	private By loginLable = By.xpath("//a[@id='login_Layer' or normalize-space(text())='Login']");
	private By username = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
	private By password = By.xpath("//input[@placeholder='Enter your password']");
	private By loginbutton = By.xpath("//button[@class='btn-primary loginButton']");
	
	private By Dismisspopup=By.xpath("//*[contains(text(),'Got it')]");

	// ACTION METHODS

	/*
	 * public void loginlabel() {
	 * 
	 * WaitUtils.sleep(1500); WebElement element =
	 * WaitUtils.waitForVisibility(loginlable);
	 * 
	 * WaitUtils.sleep(1500); try { WaitUtils.waitForClickable(loginlable).click();
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("Normal click failed → Trying JS Click.");
	 * jsclick(element); }
	 * 
	 * }
	 */

	public void loginlabel() {

	    // Extra wait for CI slow loading
	    WaitUtils.sleep(3000);

	    try {

	        WebElement element = WaitUtils.waitForVisibility(loginLable);

	        try {
	        	scrollToElement(element);
	            WaitUtils.waitForClickable(loginLable).click();
	        } catch (Exception e) {
	            System.out.println("Normal click failed → Trying JS Click.");
	            jsclick(element);
	        }

	    } catch (Exception ex) {

	        System.out.println("Login button not visible → Retrying...");

	        // Retry for CI
	        WaitUtils.sleep(3000);

	        try {
	            WebElement element = driver.findElement(loginLable);
	            jsclick(element);
	        } catch (Exception f) {
	            throw new RuntimeException(
	                "Login button still NOT found after retries → Page not fully loaded in CI.");
	        }
	    }
	}

	
	public void enterUsername() {

		WaitUtils.waitForClickable(username).sendKeys(ConfigReader.get("username"));

	}

	public void enterpassword() {
		WaitUtils.waitForClickable(password).sendKeys(ConfigReader.get("password"));
	}

	public void clickloginbutton() {

		WaitUtils.waitForClickable(loginbutton).click();
	}

	public void pagetitle() {

		String Title = getTitle();
		System.out.println("Page Title is==>" + Title);
		
	}
	
	public void popupHandles() {
	    try {
	        List<WebElement> popups = driver.findElements(Dismisspopup);

	        if (!popups.isEmpty()) {
	            System.out.println("Popup detected → closing...");
	            WaitUtils.waitForClickable(Dismisspopup).click();
	        } else {
	            System.out.println("No popup found → continuing test...");
	        }

	    } catch (Exception e) {
	        System.out.println("Popup not present → continue execution.");
	    }
	}
	
	

}
