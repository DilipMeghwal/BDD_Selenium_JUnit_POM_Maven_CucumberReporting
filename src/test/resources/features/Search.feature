Feature: To validate the search options and generated results.

  Scenario: Verify search button icon basic properties.
    Given User is on Home Page.
    When User click on Search icon.
    Then Verify an inputbox should be displayed with text "Search Digg".

  Scenario: Verify search button icon basic properties.
    Given User is on Home Page.
    When User click on Search button.
    Then Verify an inputbox should be displayed with text "Search Digg".

  Scenario Outline: Verify search button functionality.
    Given User is on Home Page.
    When User click on Search button.
    And User enter <key> and press enter button.
    Then Verify search results displayed.

    Examples: 
      | key     |
      | Youtube |

  Scenario Outline: Verify valid search results are displayed.
    Given User is on Home Page.
    When User click on Search button.
    And User enter <key> and press enter button.
    Then Verify search results are displayed having total number of results.

    Examples: 
      | key     |
      | Youtube |
      
  Scenario Outline: Verify Search button displayed with search results.
    Given User is on Home Page.
    When User click on Search button.
    And User enter <key> and press enter button.
    Then Search box displayed with search results having text <key>.

    Examples: 
      | key     |
      | Youtube |
