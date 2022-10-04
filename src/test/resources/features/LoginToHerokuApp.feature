@login
Feature: Login to Heroku App

  Background: User is on the internet page and clicks on Form authentication
    Given User is on the main page
    Then clicks on form authentication

  Scenario Outline: inputting usernames and passwords
    When user inputs "<username>" and "<password>"
    And clicks on login
    Then user should be logged in to heroku app

    Examples: 
      | username  | password             |
      | tomsmith  | SuperSecretPassword! |
      | wrongUser | SuperSecretPassword! |
      | tomsmith  | wrongpass            |
