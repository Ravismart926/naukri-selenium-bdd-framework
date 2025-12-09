package com.naukri.stepdefinitions;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;

import com.company.pages.HomePage;
import com.company.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	private LoginPage loginpage = new LoginPage();
	private HomePage homepage = new HomePage();

	@Given("User Open the Application and navigate into login page")
	public void openTheApplication() {

		
		loginpage.popupHandles();
		
		loginpage.loginlabel();

	}

	@When("User enter Username")
	public void user_enter_username() {
		loginpage.enterUsername();

	}

	@When("User enter Password")
	public void user_enter_password() {
		loginpage.enterpassword();

	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		loginpage.clickloginbutton();

	}

	@Then("User successfully navigate to the Dashboardpage")
	public void user_successfully_navigate_to_the_dashboardpage() {
		loginpage.pagetitle();

	}

	@Then("Click logout button")
	public void click_logout_button() throws InterruptedException {

		homepage.clickMenuIcon();
		homepage.clickLogout();

	}

}
