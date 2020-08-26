#Author: Fernando Castillo
#Date: 8/21/20
#Description: This is the Dynamic Controls page for a cucumber framework

Feature: Use different dynamic elements in the app

  @SmokeTest
  Scenario: User is able to use the check box
    Given the user is on the Dynamic Controls page
    When user clicks the checkbox
    Then check box is checked
