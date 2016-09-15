
A tutorial that shows some more of the Cucumber features.

Run it as:

```bash
mvn clean test
```

# CucumberOptions

We have extended the CucumberOptions with a plugin attribute.
```java
@CucumberOptions(
    plugin = {"pretty",
              "html:target/cucumber"
        },
    features="src/test/resources"
)
```

## What plugins can I use in CucumberOptions?

The documentation to specify the same is very sparse again.

One way it to look inside the `--help` section as shown in [tutorial-2](../tutorial-2)

```
java -cp target/cucumber-tutorial-1.0.0-SNAPSHOT.jar cucumber.api.cli.Main . --help

# Usage: java cucumber.api.cli.Main [options] [[[FILE|DIR][:LINE[:LINE]*] ]+ | @FILE ]

# 
# Options:
# 
#  -g, --glue PATH                        Where glue code (step definitions, hooks
#                                         and plugins) are loaded from.
#  -p, --[add-]plugin PLUGIN[:PATH_OR_URL]
#                                         Register a plugin.
#                                         Built-in formatter PLUGIN types: junit,
#                                         html, pretty, progress, json, usage, rerun,
#                                         testng. Built-in summary PLUGIN types:
#                                         default_summary, null_summary. PLUGIN can
#                                         also be a fully qualified class name, allowing
#                                         registration of 3rd party plugins.
#                                         --add-plugin does not clobber plugins of that 
#                                         type defined from a different source.
#
```

The first plugin-option "pretty" helps to print the tests as they are run with coloring.

Hence it looks very nice on the console.

```bash
mvn clean test

# -------------------------------------------------------
#  T E S T S
# -------------------------------------------------------
# Running com.prismoskills.tutorials.RunCukesTest
# Feature: Cucumber Hello World
#  
#  You can add any line here to describe the feature.
#  Good candidates to put here are links to your documentation, JIRA tickets, surveys etc.
#
#  Scenario: First Test                           # features/cucumber_keywords.feature:7
#    
#    Similar to feature description, you can add scenario description too.
#    All descriptions can be spread across multi-line and can even be out-of-indent !
#
#    Given some existing state of my system       # StepDefinitions.some_existing_state_of_my_system()
#    When I do some action                        # StepDefinitions.i_do_some_action()
#    Then I expect a change to occur in the state # StepDefinitions.i_expect_a_change_to_occur_in_the_state()
# 
# Feature: Cucumber Hello World without Given, When, Then Keywords
#  
#  You can add any line here to describe the feature.
#  Good candidates to put here are links to your documentation, JIRA tickets, surveys etc.
#
#  Scenario: First Test                        # features/cucumber_no_keywords.feature:7
#    
#    Similar to feature description, you can add scenario description too.
#    All descriptions can be spread across multi-line and can even be out-of-indent !
#
#    * some existing state of my system        # StepDefinitions.some_existing_state_of_my_system()
#    * I do some action                        # StepDefinitions.i_do_some_action()
#    * I expect a change to occur in the state # StepDefinitions.i_expect_a_change_to_occur_in_the_state()
#
# 2 Scenarios (2 passed)
# 6 Steps (6 passed)
# 0m0.083s
#
# Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.334 sec
```

Second option is that of `html:target/cucumber` which helps in the generation of `target/cucumber/index.html`

This html contains a nice summary of the tests and can be viewed in a browser.


# The keywords Given, When, Then etc have no specific meaning.

This might come as a surprise to you.

But those keywords have no specific meaning.

In fact, the following feature-file would work just as well:

```yaml
Feature: Cucumber Hello World without Given, When, Then Keywords

  Scenario: First Test

    When some existing state of my system
 	
    When I do some action
 	
    When I expect a change to occur in the state
```

And so does this feature file:
```yaml
Feature: Cucumber Hello World without Given, When, Then Keywords

  Scenario: First Test

    But some existing state of my system
 	
    And I do some action
 	
    When I expect a change to occur in the state
```


So the keywords Given, When, Then, And, But etc. are just for convenience.

Cucumber does not interpret them as anything special.

Infact, you can replace them with anything you want :) !!!
```yaml
Feature: Cucumber Hello World without Given, When, Then Keywords

  Scenario: First Test

    Foo some existing state of my system
 	
    Bar I do some action
 	
    Toto I expect a change to occur in the state
```
