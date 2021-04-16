Feature: Meeting link page


  Scenario Outline: Verify creation of Meeting link page and it has user inputs
    Given Login page should be displayed
    Then I enter "admin@gmail.com" in the email input box
    Then I enter "admin123" in the password input box
    Then I click Login button
    Then I verify meeting links button is enabled
    Then I click on meeting links button
    Then I verify that im on meeting links page
    Then I enter "Google" in the Name input box
    Then I enter "http://google.com" in the Link input box
    Then I select "<Color>" from the Color table
    Then I click add button
    Then I go one page back
    Then I click sign out button
    Examples:
      | Color |
      | Blue  |
      | Gray  |
      | Red   |
      | Green |

    Scenario: I verify that new links are present as GUI
      Given Login page should be displayed
      Then I enter JohnCena@gmail.com in the email input box
      Then I enter 123 in the password input box
      Then I click Login button
      Then I click on meeting links button
      Then I verify that im on meeting links page
      Then I should see four new links