#Author: Fernando Castillo
#Date: 8/20/20
#Description: This is the JS Alert page for a cucumber framework

Feature: Trigger different JS Alerts boxes in the app

  Scenario: User is able to trigger a JS Alert box
    Given the user is on the JavaScript Alerts page
    When user clicks JS Alert button
    Then a JS alert box is displayed

  Scenario: User is able to trigger a JS Confirm box
    Given the user is on the JavaScript Alerts page
    When user clicks JS Confirm button
    Then a JS Confirm box is displayed

  Scenario: User is able to trigger a JS Prompt box
    Given the user is on the JavaScript Alerts page
    When user clicks JS Prompt button
    Then a JS Prompt box is displayed