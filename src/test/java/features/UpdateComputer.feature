@test
Feature: Perform Update operation in computer database

  Background: Computer data base
    Given I launch computer data base application

  Scenario: Update Computer
    Given I add an new computer as "MAC BOOK 2020" name
    When I search for computer name as "MAC BOOK 2020"
    When I see computer "MAC BOOK 2020" details
      | MAC BOOK 2020 |
      | 2019-09-02    |
      | 2019-09-30    |
      | RCA           |
    And I update computer "name" with "MAC BOOK 2021"
    And I update computer "introduced" with "2019-10-02"
    When I updated computer details
    Then I see computer has been updated
    When I search for computer name as "MAC BOOK 2021"
    Then I see computer "MAC BOOK 2021" listed in result table