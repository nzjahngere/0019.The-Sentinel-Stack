@tag
Feature: Verify Checkout Feature
  I want to validate the checkout process and functionality

  @tag1
  Scenario: Validate checkout functionality
    Given I want to test the checkout process
    When I navigate to the cart page with items
    Then I click checkout button and verify details
