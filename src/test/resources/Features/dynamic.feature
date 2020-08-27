#Author: Fernando Castillo
#Date: 8/21/20
#Description: This is the Dynamic Controls page for a cucumber framework

@SmokeRegression
Feature: Use different dynamic elements in the app

  Scenario: User is able to use the check box
    Given the user is on the Dynamic Controls page
    When user clicks the checkbox
    Then check box has been checked

  @SmokeTest
  Scenario: User is able to remove and re-click checkbox
    Given the user is on the Dynamic Controls page
    And Checkbox is marked checked
    When user clicks the Remove button
    Then user adds check box
    And checkbox will be rechecked

  @SmokeTest
  Scenario: User is able to enable text field
    Given the user is on the Dynamic Controls page
    When enable button is clicked
    Then the text field is enabled and text can be entered
