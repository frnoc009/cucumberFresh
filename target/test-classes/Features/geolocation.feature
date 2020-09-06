#Author: Fernando Castillo
#Date: 8/26/20
#Description: This is the Geolocation page for a cucumber framework

@SmokeRegression
Feature: User is able to find their geolocation

  @SmokeTest
  Scenario: User is able to enable geolocation
    Given User is on the geolocation page
    When Where am I button is clicked
    Then the Longitude and latitude are presented