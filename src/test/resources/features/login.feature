Feature: Login page


  Scenario: Verify that TLA logo, email and password input boxes are present
    Given Login page should be displayed
    Then I verify that logo is displayed
    Then I verify that "email" input box is enabled
    Then I verify that "password" input box is enabled