@smoke
Feature: Login and update the Profile 
As a vlaid user login and update the Userprofile 
and Logout
Scenario: Update the Profile and Logout 
#Given User Open the Application and navigate into login page
When User enter Username
And User enter Password
And User clicks Login button
Then User successfully navigate to the Dashboardpage
Then User navigate to the Update profile page
Then User update the Resumeheadlines and save
Then Click logout button