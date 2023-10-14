Feature: feature to test some airbnb functions

  Scenario: checking login procedure
    Given launch the browser
    And Navigate to the URL
    When the user opens the main menu
    And the user selects the sign-up/login option
    And the user enters a phone number
    And clicks continue
    Then the user closes the login window

  Scenario: User searches for accommodation
    Given the user opens the main search menu
    When the user enters the destination
    And adds guests (e.g., 5 adults and 5 children)
    And selects check-in and check-out dates
    And performs the search
    And includes taxes in the search
    And the user should see search results
		Then closes the browser