Feature: Homework page

  @BCAMP-4
  Scenario: User should be able to navigate to Homework Page
    Given Login page should be displayed
    Then I enter "JohnCena@gmail.com" in the email input box
    And I enter "123" in the password input box
    And I click Login button
    Then I click Homework button
    Then I verify Homework page is displayed containing:
      | CSS Selector task 1 |
      | Locators            |
      | Multiple windows    |
      | Waits               |
    Then I click "CSS Selector task 1"
    Then I verify homework "CSS Selector task 1" on the page
    And I verify that followed List is displayed:
      | Status:       |
      | Link:         |
      | Instructions: |

    @BCAMP-5
    Scenario: User should be able to leave comment with timestamp and name
      Given Login page should be displayed
      Then I enter "JohnCena@gmail.com" in the email input box
      And I enter "123" in the password input box
      And I click Login button
      Then I click Homework button
      Then I click "CSS Selector task 1"
      Then I verify comment section is displayed
      And I enter comment in comment area
      And I click Add comment button
      Then I check that added "Lorem ipsum dolor" is displayed with timestamp and name

    @BCAMP-6
    Scenario: User should be able to submit homework
      Given Login page should be displayed
      Then I enter "JohnCena@gmail.com" in the email input box
      And I enter "123" in the password input box
      And I click Login button
      Then I click Homework button
      Then I click "CSS Selector task 1"
      Then I verify homework section is displayed
      And I enter "Lorem ipsum dolor sit amet" in homework section
      And I click Save homework button
      Then I check that added "Lorem ipsum dolor sit amet" is displayed
      And I check that status of homework changed to Saved
      Then I clear homework section
      And I click Save homework button

