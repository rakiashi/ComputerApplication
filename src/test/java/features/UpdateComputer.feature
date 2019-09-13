@test
Feature: Update a computer
  As a user
  I want to update one computer

  Background: Computer data base
    Given I launch computer data base application

  Scenario: Update one Computer and verify its updated or not
    Given I add an new computer as "MAC BOOK 2020" name
    When I search for computer name as "MAC BOOK 2020"
    Then I see computer "MAC BOOK 2020" details
      | MAC BOOK 2020 |
      | 2019-09-02    |
      | 2019-09-30    |
      | RCA           |
    And I update computer name with "MAC BOOK 2021"
    And I update computer introduced date with "2019-10-02"
    When I update computer details
    Then I see computer has been updated
    When I search for computer name as "MAC BOOK 2021"
    Then I see computer "MAC BOOK 2021" details
      | MAC BOOK 2021 |
      | 2019-10-02    |
      | 2019-09-30    |
      | RCA           |
