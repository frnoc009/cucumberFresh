#Author: Fernando Castillo
#Date: 8/15/20
#Description: This is the login page for a cucumber framework

@SmokeRegression
Feature: Login and Logout of App.

  @SmokeTest
  Scenario: User is able to login with valid credentials
    Given the user is on the Login page
    And enters valid username and valid password
    When user clicks the login button
    Then the user is navigated to the Secure Area page

  Scenario: User is not able to login with invalid credentials
    Given the user is on the Login page
    And enters invalid username and invalid password
    When user clicks the login button
    Then the user is not able to login
    And error message appears

  Scenario: User is able to logout after login has occurred
    Given the user is in the Secure Area page
    When user clicks the logout button
    Then the user is navigated to the Login page