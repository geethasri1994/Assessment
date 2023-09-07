Feature: Selenium Cucumber Automation

  Scenario: Adding Users on protractor web table
    Given Launch Edge Browser
    Then  click Add User
    Then  Add Users with details
    Then  Verify whether users are added to the list
