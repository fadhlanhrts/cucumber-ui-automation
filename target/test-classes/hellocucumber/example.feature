Feature: User Visit Website

  Scenario: User Wants to Select Options from Menu
    Given User go to "https://demoqa.com/select-menu"
    When User in "select menu" page
    And User choose select value “Another root option”
    And User choose select one “Other”
    And User choose old style select menu “Aqua”
    And User choose multi select drop down “all color”
    Then User success input all select menu

    Scenario: User Wants to Search for QA Engineer Book
      Given User navigate to "https://demoqa.com/books"
      When User is in "Book Store" page
      And User search book "qa engineer"
      Then User see "No rows found"

  Scenario: User Wants to Search for Git Pocket Guide Book
    Given User visit "https://demoqa.com/books"
    When User is located in "Book Store" page
    And User look up "Git Pocket Guide"
    And User click book "Git Pocket Guide"
    Then User can see "Git Pocket Guide"

  Scenario: User Wants to See Response for 20 Beers
    Given User uses API with 20 beers
    When User is at URI
    Then User can see result of 20 beers
