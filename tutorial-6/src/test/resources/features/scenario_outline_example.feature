
Feature: Passing params from feature-files to method params.

  Scenario Outline: Pass integer, word and a string to the method.
    Given An integer <num>, a word "<word>" and a string "<string>"

    Examples:
      | num | word  | string |
      |  5  | hello | Cucumber uses behavior driven development |
      |  7  | hi    | Cucumber uses Gherkin |
      |  10 | hey   | Cucumber uses natural language |
      |  11 | ohai  | Given, And, Then keywords can be used interchangeably |

