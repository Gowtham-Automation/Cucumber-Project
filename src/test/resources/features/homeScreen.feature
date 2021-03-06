@HomeScreen
Feature: Retrieve the product price from the flipkart home screen

  @Scenario_1
  Scenario:Verify the use able to search the product
    Given the user login to the Flipkart application
    When user search for the mobile products
    Then user able to find and get the product price amount

  @Scenario_2
  Scenario:Verify the use able to clear the cell
    Given the user login to the Flipkart application
    When user clear the cell value
