@tag
Feature: Cart and Wishlist Feature
  I want to use validate the cart and wishlist operations

  @tag1
  Scenario: Verify adding items to cart from the product page
    Given I want to validate add to cart feature
    When I select product options and click Add button
    Then I validate quantity increase in cart

  @tag2
  Scenario: Verify cart from product listing
    Given verify adding items to cart from the product listing
    When I navigate to the page and locate and click add button
    Then I verify the cart count increases

  @tag3
  Scenario: Verify item increases from the cart
    Given I validate the incremental feature from the cart
    When I locate and click + button
    Then I verify the item count and price increases respectively
    And I do the same using - button and validate outcomes

  @tag4
  Scenario: Verify empty cart handling
    Given I validate the empty cart
    When I locate and click the cart icon
    Then I verify appropriate message alert with empty cart

  @tag5
  Scenario: Verify Wishlist feature
    Given I validate the wishlist functionality
    When I locate and click the heart icon on product page
    Then I verify product is added to the wishlist
    And I click remove icon and verify item is removed
    And I click add to cart and verify item is moved to cart
