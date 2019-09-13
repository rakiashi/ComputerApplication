@test
Feature: View and Search one computer
  As a user
  I want to view and search one computer

  Background: Computer database
    Given I launch computer data base application

  Scenario: View and Search one Computer from database
    Given I add an new computer as "ACE 2024" name
    When I search for computer name as "ACE 2024"
    Then I see computer "ACE 2024" listed in result table

  Scenario: View and Search Computer which is not in database
    Given I search for computer name as "Test computer"
    When I see nothing to display