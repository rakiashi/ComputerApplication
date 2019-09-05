@test
Feature: Perform Create operation in computer database

  Background: Computer data base
    Given I launch computer data base application

  Scenario: Create Computer
    Given I add an new computer as "ACE 2022" name
    Then I see computer has been created
    When I search for computer name as "ACE 2022"
    Then I see computer "ACE 2022" listed in result table
