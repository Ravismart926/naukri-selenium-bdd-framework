package com.company.pages;

//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import com.naukri.pageHelper.BasePage;
import com.naukri.utils.ConfigReader;
import com.naukri.utils.WaitUtils;

public class LoginPage extends BasePage {

	private By loginlable = By.id("login_Layer");
	private By username = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
	private By password = By.xpath("//input[@placeholder='Enter your password']");
	private By loginbutton = By.xpath("//button[@class='btn-primary loginButton']");

	// ACTION METHODS

	public void loginlabel() {

		WaitUtils.waitForClickable(loginlable).click();

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
		// Assert.assertEquals(FrameworkConstants.HOME_PAGE_TITLE, Title);
	}

}
