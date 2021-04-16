Feature: Login page


  Scenario: Verify that TLA logo, email and password input boxes are present
    Given Login page should be displayed
    Then I verify that logo is displayed
    Then I verify that "email" input box is enabled
    Then I verify that "password" input box is enabled


  Scenario Outline: Test user ability to login
    Given Login page should be displayed
    Then I enter "<email>" in the email input box
    Then I enter "<password>" in the password input box
    Then I click Login button
    Then I should see "<message>"

    Examples:
      | email              | password | message                     |
      | JohnCena@gmail.com | 123      | Welcome test!               |
      | John1111@gmail.com | 123      | Incorrect username/password |
      | JohnCena@gmail.com | 123456   | Incorrect username/password |
      | John1111@gmail.com | 123456   | Incorrect username/password |