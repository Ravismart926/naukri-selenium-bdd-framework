package com.naukri.pageHelper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.drivers.DriverManager;

public class BasePage {

	protected WebDriver driver;

	private WebDriverWait wait;

	public BasePage() {

		this.driver = DriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	protected void waitForTheElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	protected void waitforElementtobeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	protected void clickelement(WebElement element) {
		
		waitForTheElementVisible(element);
		element.click();
		
	}
	
	protected void enterText(WebElement element,String Text) {
		waitForTheElementVisible(element);
		element.click();
		element.clear();
		element.sendKeys(Text);
		
	}
	
	protected String  gettext(WebElement element) {
		
		waitForTheElementVisible(element);
		String ElementText=element.getText();
		return ElementText;
		
		
	}
	
	protected String getTitle() {
		
		String Title=driver.getTitle();
		return Title;
		
	}
	

}
