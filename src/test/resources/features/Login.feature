@smoke
Feature: Login functionality
As a valid user 
I want to login into the application
so That i can access my Dashboard

Scenario: Login with valid credentials
Given User Open the Application and navigate into login page
When User enter Username
And User enter Password
And User clicks Login button
Then User successfully navigate to the Dashboardpage
Then User navigate to the Update profile page
Then User update the Resumeheadlines and save
Then Click logout button
