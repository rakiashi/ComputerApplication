@test
Feature: Create a computer
  As a user
  I want to create one computer



  Background: Computer data base
    Given I launch computer data base application

  Scenario: Create one Computer
    Given I add an new computer as "ACE 2022" name
    Then I see computer has been created
    When I search for computer name as "ACE 2022"
    Then I see computer "ACE 2022" listed in result table

  Scenario: To verify cancel functionality
    Given I add an new computer
    When I tried to create computer and i see name is required
    When I cancel computer details
    Then I see redirecting to computer database

  Scenario: To verify field errors while creating computer
    When I add an new computer
    And I enter computer "name" as "Dell India"
    And I enter computer "introduced" as "23MAR2019"
    When I tried to create computer and i see date format is incorrect
    When I cancel computer details
    Then I see redirecting to computer database
