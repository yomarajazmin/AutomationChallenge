Feature: Shopping two items as a new user

  @Test @Shopping
  Scenario: As a new user I want to select two items so that I can buy them

    Given I am at the "main" page

    And I select the Laptops category
    When I click on a "MacBook air" item
    Then I add the selected product to the shopping card in the item page
    And I click on OK in the popup of the item page
    And I go to Home in main page
    And I select the Laptops category
    When I click on a "Dell i7 8gb" item
    Then I add the selected product to the shopping card in the item page
    And I click on OK in the popup of the item page

    When I go to Cart in main page
    Then I check all items added are listed in shopping card view
    Then I check total is the sum of the prices in shopping card view
    And I click on "Place Order" from shopping card page

    And I write test user in name field of shopping form page
    And I write country in country field of shopping form page
    And I write city in city field of shopping form page
    And I write 4411111111 in credit card number field of shopping form page
    And I write 12 in credit card month field of shopping form page
    And I write 26 in credit card year field of shopping form page
    When I click on "Purchase" of shopping form page
    #Currently failing because date of purchase is not the current date
    Then I check the summary of the purchase in shopping form page
    And I click on OK to close the summary of the purchase in shopping form page