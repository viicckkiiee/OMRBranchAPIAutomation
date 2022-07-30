@Login
Feature: Login Module API Automation

  Scenario: Verify User login to the application through API
    Given User should add header
    And User should add basic authorization for login
    When User should send "POST" request to login endpoint
    Then User should verify the status code is 200
    And User should verify the login response body firstName present as "Vignesh" and get the logtoken
