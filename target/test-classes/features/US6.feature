@wip
Feature: As a data consumer, I want UI and DB book categories match.

  Scenario Outline: verify book categories with DB
    Given User sends his info "<username>" and "<password>"
    And I navigate to "Books" page
    And I take all book categories in UI
    And I execute a query to get book categories
    Then verify book categories must match the book_categories table from DB.

    Examples:
      | username           | password |
      | librarian1@library | qU9mrvur |
      | librarian2@library | uYrhHmmj |
      | librarian3@library | DFvU4b1i |
      | librarian4@library | 3lwxJ1Kk |
      | librarian5@library | hj65YBiE |
      | librarian6@library | QaG7mkXA |
      | librarian7@library | C5WUiPUP |