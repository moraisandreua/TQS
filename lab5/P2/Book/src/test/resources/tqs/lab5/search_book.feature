Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.

  Scenario: Search books by author
    Given a book called 'Deus est Machina' which author is 'Andre Morais', published at 2020-03-21
    And another book called 'Um pedaço da minha vida' which author is 'Andre Morais', published at 2020-02-21
    And another book called 'Diário do Diabo' which author is 'Andre Morais', published at 2020-01-21
    When the customer searches for book which author is 'Andre Morais'
    Then 3 books should have been found
    And Book 1 should have the title 'Deus est Machina'
    And Book 2 should have the title 'Um pedaço da minha vida'
    And Book 3 should have the title 'Diário do Diabo'

  Scenario: Search books by date
    Given a book called 'Colen' which author is 'Maria Azevedo', published at 2002-03-21
    And another book called 'Polen' which author is 'Maria Azevedo', published at 2005-02-21
    And another book called 'Lolen' which author is 'Maria Azevedo', published at 2008-01-21
    When the customer searches for books published between 2002 and 2005
    Then 2 books should have been found
    And Book 1 should have the title 'Colen'
    And Book 2 should have the title 'Polen'