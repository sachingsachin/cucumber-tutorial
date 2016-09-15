
# Scenario Outline

Collapsing multiple scenarios into one to reduce reading burden


# Run as:

```bash
mvn clean test
```

# Need for collapsing scenarios into one

In several tests, you need to test boundary conditions with several sets of data.

The underlying logic-flow remains the same, but the data being passed to the logic-flow is different each time.

If we just copy-paste the scenarios each time, then it becomes:

1. Difficult to read all these scenarios and find out what is different between those similar groups of steps.
2. Difficult to maintain. Changing something requires a careful auditing in all those similar scenarios.

These problems are alleviated by the use of `Scenario Outline` which allows the use of placeholders for data and
use tables to supply data for those placeholders.

An example will make it more clear.

In [tutorial-5](../tutorial-5), one test looked as:
```yaml
Scenario: Pass integer, word and a string to the method.
  Given An integer 5, a word "hello" and a string "Cucumber uses behavior driven development"
  And An integer 7, a word "hi" and a string "Cucumber uses Gherkin"
  Then An integer 10, a word "hey" and a string "Cucumber uses natural language"
  But An integer 11, a word "ohai" and a string "Given, And, Then keywords can be used interchangeably in Cucumber"
```

Here all those values passed can be replaced with a placeholder and a table can be used to populate them if
we use `Scenario Outline`
```yaml
Scenario Outline: Pass integer, word and a string to the method.
    Given An integer <num>, a word "<word>" and a string "<string>"

    Examples:
      | num | word  | string |
      |  5  | hello | Cucumber uses behavior driven development |
      |  7  | hi    | Cucumber uses Gherkin |
      |  10 | hey   | Cucumber uses natural language |
      |  11 | ohai  | Given, And, Then keywords can be used interchangeably |
```

No change is required in the java-function.

Cucumber internally converts each example-row into a full-blown scenario as can be seen while running it:

```bash
mvn clean test

#-------------------------------------------------------
# T E S T S
#-------------------------------------------------------
#Running com.prismoskills.tutorials.RunCukesTest
#Feature: Passing params from feature-files to method params.
#
#  Scenario Outline: Pass integer, word and a string to the method.  # features/scenario_outline_example.feature:4
#    Given An integer <num>, a word "<word>" and a string "<string>"
#
#    Examples: 
#----------------------
#num=5
#word=hello
#string=Cucumber uses behavior driven development
#
#
#  Scenario Outline: Pass integer, word and a string to the method.                              # features/scenario_outline_example.feature:9
#    Given An integer 5, a word "hello" and a string "Cucumber uses behavior driven development" # StepDefinitions.method_with_params(int,String,String)
#----------------------
#num=7
#word=hi
#string=Cucumber uses Gherkin
#
#
#  Scenario Outline: Pass integer, word and a string to the method.       # features/scenario_outline_example.feature:10
#    Given An integer 7, a word "hi" and a string "Cucumber uses Gherkin" # StepDefinitions.method_with_params(int,String,String)
#----------------------
#num=10
#word=hey
#string=Cucumber uses natural language
#
#
#  Scenario Outline: Pass integer, word and a string to the method.                  # features/scenario_outline_example.feature:11
#    Given An integer 10, a word "hey" and a string "Cucumber uses natural language" # StepDefinitions.method_with_params(int,String,String)
#----------------------
#num=11
#word=ohai
#string=Given, And, Then keywords can be used interchangeably
#
#
#  Scenario Outline: Pass integer, word and a string to the method.                                          # features/scenario_outline_example.feature:12
#    Given An integer 11, a word "ohai" and a string "Given, And, Then keywords can be used interchangeably" # StepDefinitions.method_with_params(int,String,String)
#
#4 Scenarios (4 passed)
#4 Steps (4 passed)
#0m0.076s
#
#Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.315 sec
```
