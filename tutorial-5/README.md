
A tutorial on passing params from feature files to the functions bound to step definitions.

Run it as:

```bash
mvn clean test
```

# Capture Groups

Any regular expression between parentheses is called a `capture group` and becomes an argument to the mapped function.
Example:

```java
@Given("^An integer (\\d+), a word \"(\\w+)\" and a string \"(.*)\"$")
public void method_with_params(int some_num, String some_word, String some_str) throws Throwable {
    // Now you can pass the params in feature files
}
```

And then pass different params from feature files:
```yaml
Feature: Passing params from feature-files to method params.

  Scenario: Pass integer, word and a string to the method.
    Given An integer 5, a word "hello" and a string "Cucumber uses behavior driven development"
    And An integer 7, a word "hi" and a string "Cucumber uses Gherkin"
    Then An integer 10, a word "hey" and a string "Cucumber uses natural language"
    But An integer 11, a word "ohai" and a string "Given, And, Then keywords can be used interchangeably in Cucumber"
```

Double escaping is required because a single escape in strings is intepreted by Java to escape the next character.
Where as we want to pass an uninterpreted escape to the underlying Cucumber framework.
Hence double escaping leads Java to interpret it as a single escape character which is not escaping the character following it.

Bottom-line: You will need to use double-escapes most of the time.


# List arguments

To pass lists to a function, use the `(.*)` matcher in the Java annotations and for the argument's type, just
use the type of list you expect to pass. Cucumber will automatically convert it as necessary.

Example:
```yaml
  Scenario: Pass lists to methods
    * Pass list of integers to a function: 1, 2, 3
    * Pass list of strings to a function: hi, hello, hey
```

```java
    @Given("^Pass list of integers to a function: (.*)$")
    public void function_with_list_of_ints(List<Integer> ints) throws Throwable {
        System.out.println("----------------------");
        System.out.println("integers="+ ints +"\n");
    }

    @Given("^Pass list of strings to a function: (.*)$")
    public void function_with_list_of_strings(List<String> words) throws Throwable {
        System.out.println("----------------------");
        System.out.println("words="+ words +"\n");
    }
```

# Map and table arguments

Example: Two-column table in feature-file:
```yaml
  Scenario: Pass maps to methods
    * Pass simple map to a function
       | hello | 5  |
       | hi    | 11 |
```

can be received as a map in Java-function:
```java
    @Given("^Pass simple map to a function$")
    public void function_with_map(Map<String, Integer> map) throws Throwable {
        System.out.println("----------------------");
        System.out.println("map: "+ map +"\n");
    }
```


And a table with more than two columns:
```yaml
  Scenario: Pass tables to methods
    * Pass three column table to a function
       | word1 | num | word2 |
       | hello | 5   | foo   |
       | hi    | 11  | bar   |
```

can be received as a list of custom-objects in the Java-function:
```java
   @Given("^Pass three column table to a function$")
    public void function_with_three_column_table(List<MyPojo> table) throws Throwable {
        System.out.println("----------------------");
        System.out.println("table="+ table +"\n");
    }

// Custom-class definition
class MyPojo {
    String word1;
    Integer num;
    String word2;

    public String toString() {
        return "MyPojo [word1=" + word1 + ", num=" + num + ", word2=" + word2 + "]";
    }
}
```


# Results for mvn clean test

```bash
mvn clean test

#-------------------------------------------------------
# T E S T S
#-------------------------------------------------------
#Running com.prismoskills.tutorials.RunCukesTest
#Feature: Passing params from feature-files to method params.
#----------------------
#num=5
#word=hello
#string=Cucumber uses behavior driven development
#
#----------------------
#num=7
#word=hi
#string=Cucumber uses Gherkin
#
#----------------------
#num=10
#word=hey
#string=Cucumber uses natural language
#
#----------------------
#num=11
#word=ohai
#string=Given, And, Then keywords can be used interchangeably in Cucumber
#
#
#  Scenario: Pass integer, word and a string to the method.                                                            # features/feature_to_method_params.feature:4
#    Given An integer 5, a word "hello" and a string "Cucumber uses behavior driven development"                       # StepDefinitions.method_with_params(int,String,String)
#    And An integer 7, a word "hi" and a string "Cucumber uses Gherkin"                                                # StepDefinitions.method_with_params(int,String,String)
#    Then An integer 10, a word "hey" and a string "Cucumber uses natural language"                                    # StepDefinitions.method_with_params(int,String,String)
#    But An integer 11, a word "ohai" and a string "Given, And, Then keywords can be used interchangeably in Cucumber" # StepDefinitions.method_with_params(int,String,String)
#----------------------
#integers=[1, 2, 3]
#
#----------------------
#words=[hi, hello, hey]
#
#
#  Scenario: Pass lists to methods                        # features/feature_to_method_params.feature:10
#    * Pass list of integers to a function: 1, 2, 3       # StepDefinitions.function_with_list_of_ints(Integer>)
#    * Pass list of strings to a function: hi, hello, hey # StepDefinitions.function_with_list_of_strings(String>)
#----------------------
#map: {hello=5, hi=11}
#
#
#  Scenario: Pass maps to methods    # features/feature_to_method_params.feature:14
#    * Pass simple map to a function # StepDefinitions.function_with_map(String,Integer>)
#----------------------
#table=[MyPojo [word1=hello, num=5, word2=foo], MyPojo [word1=hi, num=11, word2=bar]]
#
#
#  Scenario: Pass tables to methods          # features/feature_to_method_params.feature:19
#    * Pass three column table to a function # StepDefinitions.function_with_three_column_table(MyPojo>)
#
#4 Scenarios (4 passed)
#8 Steps (8 passed)
#0m0.084s
#
#Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.341 sec
```
