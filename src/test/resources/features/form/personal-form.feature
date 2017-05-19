@component:ui 
@version:Release-2 
@issue:PS-102
Feature: Fill the form
  User should be able to fill and submit the form

  Scenario Outline: Fill the user details form
    Given I am logged in as an user
    When I fill the form with the details as '<firstname>' and '<lastname>' and '<email>' and '<place>'
    Then I should find submit button enabled
    Examples: 
      | firstname | lastname | email       |	place			|
      | kk        | pp       | kp@gmai.com |	Ontario		|
      | ss        | zz       | sr@gmai.com |	Ontario	  |
      
