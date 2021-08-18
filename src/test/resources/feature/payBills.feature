Feature: Pay Bills Functionality

  Background:
    Given the user is on the login page
    And User logins with username "username" and password "password"

  Scenario: Date Format
    Given Learn Date and DateFormat

Scenario: Pay Bills Successful payment
  And the user navigates to "Pay Bills" menu
  Then the Account Activity page should be displayed
  When User completes a successful Pay Operation
  Then "The payment was successfully submitted." alert should be displayed

  @wip
  Scenario: Negative payment test
    And the user navigates to "Pay Bills" menu
    Then the Account Activity page should be displayed
    When User tries to make a payment without entering the amount or date
    Then "Please fill out this field." alert should be displayed