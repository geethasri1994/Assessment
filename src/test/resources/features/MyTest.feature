Feature: Selenium Cucumber Automation

  Scenario: Booking Appointment
    Given Launch chrome
    And   navigate to Booking Website
    Then  Login with correct credentials
    Then  fill in with mandatory details
    Then  book appointment
    Then  return facility name
