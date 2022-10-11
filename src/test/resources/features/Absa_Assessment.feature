Feature: Selenium Cucumber Automation

  Scenario: Shopping Cart Order Confirmation
    Given Launch chrome and navigate to shopping cart Website
    Then  Add 2 products to shopping cart
    Then  Add Information for first name,last name, postal code
    Then  confirm that the total price is correct which is the sum of the two products
    Then  Finish the order and Confirm that the order confirmation screen is displayed


