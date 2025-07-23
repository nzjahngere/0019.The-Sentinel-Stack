@tag
Feature: Verify User Management
  I want to test the user management

  @tag1
  Scenario: Verify user registration
    Given I want to test the user registration
    When I locate inputs and enter credentials
    Then I expect to create a user account

  @tag2
  Scenario: Verify user login with valid credentials
    Given I want to test the user login with valid credentials
    When I locate inputs and enter valid credentials
    Then I expect to login to the account

  @tag3
  Scenario: Verify user login with invalid credentials
    Given I want to attempt the user login with invalid credentials
    When I locate inputs and enter invalid credentials
    Then I expect system to handle the situation gracefully

  @tag4
  Scenario: Verify password reset
    Given I want to attempt the password reset
    When I locate and click password reset link
    Then I expect to be redirected to the respective page
