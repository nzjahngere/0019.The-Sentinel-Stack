@tag
Feature: Homepage Navigation
  I want to use this verify homepage navigation

  @tag1
  Scenario: Homepage Loading
    Given I am on the home page of the website
    When the page loads completely
    Then I validate the logo display

  @tag2
  Scenario: Navbar Functionality
    Given I am on the home page of the website
    When I click on the each menu item
    Then I expect to be redirected to their respective pages

  @tag3
  Scenario: Featured Product Section
    Given I am on the home page of the website
    When I scroll to the featured products section
    Then I verify product details
