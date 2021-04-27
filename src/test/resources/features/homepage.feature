Feature: HomePage features

  Scenario: Test user ability to login
    Given Login page should be displayed
    Then I enter "admin@gmail.com" in the email input box
    And I enter "admin123" in the password input box
    And I click Login button
    Then I should see ""