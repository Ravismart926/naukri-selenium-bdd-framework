package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.pageHelper.BasePage;
import com.naukri.utils.WaitUtils;
import com.naukri.constants.FrameworkConstants;

public class HomePage extends BasePage {

	private By menuIcon = By.xpath("//div[@class='nI-gNb-drawer__icon-img-wrapper']");
	private By logout = By.xpath("//*[text()='Logout']");
	private By updateProfile = By.linkText("View & Update Profile");
	private By resumeHeadlineEditIcon = By.xpath("//div[@class='widgetHead']//span[@class='edit icon']");
	private By headlineTextbox = By.xpath("//textarea[@id='resumeHeadlineTxt']");
	private By headlineTextboxSaveBtn = By.xpath("//*[@name='resumeHeadlineForm']/descendant::button");

	// Click menu icon
	public void clickMenuIcon() {
		WaitUtils.waitForClickable(menuIcon).click();
	}

	// Click logout
	public void clickLogout() {
		WaitUtils.waitForClickable(logout).click();
	}

	// Click Update Profile
	public void clickUpdateProfile() {
		WaitUtils.waitForClickable(updateProfile).click();
	}

	// Click Resume Headline Edit icon
	public void clickResumeHeadlineEditIcon() {
		WaitUtils.waitForClickable(resumeHeadlineEditIcon).click();
	}

	// Update Resume Headline text
	public void updateResumeHeadline() {
		WebElement element = WaitUtils.waitForVisibility(headlineTextbox);

	    String currentValue = element.getAttribute("value");

	    String newValue;

	    if (currentValue != null && currentValue.equals(FrameworkConstants.RESUME_HEADLINES_2)) {

	        newValue = FrameworkConstants.RESUME_HEADLINES_1;  // switch to 1

	    } else {

	        newValue = FrameworkConstants.RESUME_HEADLINES_2;  // switch to 2
	    }

	    element.clear();
	    element.sendKeys(newValue);
	}
	// Click save button
	public void clickSaveButton() {
		WaitUtils.waitForClickable(headlineTextboxSaveBtn).click();
	}
}
