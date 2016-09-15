
Feature: Passing params from feature-files to method params.

  Scenario: Pass integer, word and a string to the method.
    Given An integer 5, a word "hello" and a string "Cucumber uses behavior driven development"
    And An integer 7, a word "hi" and a string "Cucumber uses Gherkin"
    Then An integer 10, a word "hey" and a string "Cucumber uses natural language"
    But An integer 11, a word "ohai" and a string "Given, And, Then keywords can be used interchangeably in Cucumber"

  Scenario: Pass lists to methods
    * Pass list of integers to a function: 1, 2, 3
    * Pass list of strings to a function: hi, hello, hey

  Scenario: Pass maps to methods
    * Pass simple map to a function
       | hello | 5  |
       | hi    | 11 |

  Scenario: Pass tables to methods
    * Pass three column table to a function
       | word1 | num | word2 |
       | hello | 5   | foo   |
       | hi    | 11  | bar   |
