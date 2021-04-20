Feature: Teste Selenium
  10-minute tutorial to integrate selenium

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"