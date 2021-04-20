Feature: Scrapping Blaze
  scrap scrap scrap no idea how to rap

  Scenario: From a place to a destination
    Given I want to go from 'Portland' to 'Berlin'
    And My name is 'Andre'
    And My address is 'rua'
    And My city is 'cidade'
    And My state is 'estado'
    And My zip code is 'codigopostal'
    And My card type is 'American Express'
    And My card number is 12345678
    And My card name is 'Andre M.'
    And customer clicks on checkbox
    When customer purchase
    Then some text must appear 'Thank you for your purchase today!'
