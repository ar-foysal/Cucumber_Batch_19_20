Feature: Login feature

  Scenario: User try to login with valid credentials
    Given User is on the login page
    When User input username "standard_user"
    And User input password "secret_sauce"
    And User click on the login button
    Then User successfully logged in
    And User should see the inventory page

  Scenario: User try to login without password
    Given User is on the login page
    When User input username "standard_user"
    And User click on the login button
    Then User should be on the log in page
    And User should see an error message "Epic sadface: Password is required"

