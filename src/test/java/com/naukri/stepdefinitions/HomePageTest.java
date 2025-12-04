package com.naukri.stepdefinitions;

import com.company.pages.HomePage;
import com.company.pages.LoginPage;

import io.cucumber.java.en.Then;

public class HomePageTest {

	private HomePage homepage = new HomePage();

	@Then("User navigate to the Update profile page")
	public void user_navigate_to_the_update_profile_page() {

		homepage.clickMenuIcon();
		homepage.clickUpdateProfile();
		

	}

	@Then("User update the Resumeheadlines and save")
	public void user_update_the_resumeheadlines_and_save() {

		homepage.clickResumeHeadlineEditIcon();
		homepage.updateResumeHeadline();
		homepage.clickSaveButton();
	}

}
