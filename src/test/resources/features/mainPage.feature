Feature: User is on the amazon relay page and directs to the loadboard and set parameters


  Scenario: User tries to book a load
    Given User is on the relay page
    When User inputs the requirements
    Then makes sure that the price_perMile is above 2.20 dollars
