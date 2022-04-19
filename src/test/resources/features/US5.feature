@wip
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario Outline: Verify book information with DB
    Given User sends his info "<username>" and "<password>"
    And I navigate to "Books" page
    When I open book "Chordeiles minor"
    Then book information must match the Database

    Examples:
      | username           | password |
      | librarian1@library | qU9mrvur |
      | librarian2@library | uYrhHmmj |
      | librarian3@library | DFvU4b1i |
      | librarian4@library | 3lwxJ1Kk |
      | librarian5@library | hj65YBiE |
      | librarian6@library | QaG7mkXA |
      | librarian7@library | C5WUiPUP |