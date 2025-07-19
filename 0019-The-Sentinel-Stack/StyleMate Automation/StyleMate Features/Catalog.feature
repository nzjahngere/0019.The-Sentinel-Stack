@tag
Feature: Procut Details & Catalog
  I want to validate product catalog

  @tag1
  Scenario: Verify Search with Valid Keywords
    Given I want to validate the search feature
    When I locate search and input valid keywords
    And I click the search icon
    Then I verify the relevant search outcomes

  @tag2
  Scenario: Verify Search with Invalid Keywords
    Given I want to verify the search feature
    When I locate search & input invalid keywords
    And I click the search icon
    Then I verify the system behavior

  @tag3
  Scenario: Verify Search with Empty Fields
    Given I want to verify the search behavior
    When I leave the input field empty and click search
    Then I validate the system behavior

  @tag4
  Scenario: Verify Product Filter
    Given I want to validate the product filter
    When I locate and choose a filter option
    Then I verify the relevant products are displayed

  @tag5
  Scenario: Verify Sorting Feature
    Given I want to validate the sorting feature
    When I locate and choose a sorting option
    Then I verify the relevant sorted category

  @tag6
  Scenario: Verify Product Detail Page
    Given I want to validate the product detail page
    When I locate click a product card/image
    Then I verify navigation and product info on the page

  @tag7
  Scenario: Verify Product Image Gallery
    Given I want to validate the product image gallery
    When I locate and click different thumbnail images
    Then I verify the main image changes accordingly
