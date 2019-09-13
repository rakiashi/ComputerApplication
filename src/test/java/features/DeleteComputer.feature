@test
Feature: Delete a computer
  As a user
  I want to delete one computer

  Background: computer data base
    Given I launch computer data base application

  Scenario: Delete one Computer
    Given I add an new computer as "LENOVO 2020" name
    When I search for computer name as "LENOVO 2020"
    When I see computer "LENOVO 2020" details
      | LENOVO 2020  |
      | 2020-01-02   |
      | 2020-12-31   |
      | Lenovo Group |
    When I delete computer details
    Then I see computer has been deleted
    When I search for computer name as "LENOVO 2020"
    Then I see nothing to display
