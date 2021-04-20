Feature: Basic Arithmetic

  Background: A Calculator
    Given opaaaa que ela ligou-se

  Scenario: Addition
    When I add 4 and 5
    Then the result is 9

  Scenario: Substraction
    When I substract 7 to 2 
    Then the result is 5

  Scenario: Multiplication
    When I multiply 1 by 13
    Then the result is 13

  Scenario: Divide
    When I divide 6 by 2
    Then the result is 3
