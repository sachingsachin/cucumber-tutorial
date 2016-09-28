# cucumber-tutorial

[Cucumber](https://github.com/cucumber/cucumber) is is a tool that supports [Behaviour-Driven Development (BDD)](https://en.wikipedia.org/wiki/Behavior-driven_development).

In layman's terms, this is what it means:

1. It should be possible to use English-like language to write tests at a high-level.
2. If you map your English-phrases to specific methods in your code, then it is possible to re-use them better.
   
   Example: a phrase like "Give a database with 5 person entities".
   If many tests need the above pre-condition for testing, then it is easier to define the Java method once and somehow use the
   above phrase at all the places instead of calling the method directly. Method-call works perfectly too, but using a phrase
   (ignore the how part for now) makes it easier to read.
3. If you have several such phrases (general enough to suit all tests), then some new tests can be written by just calling those specific phrases. (Assuming that these mappings to methods are written well enough to suit all cases.)
4. Whatever you do in the write part, reading tests becomes much easier and get an undestanding at the high-level.

Cucumber uses [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) for writing English phrases and files containing such phrases are called `feature` files.

1. [tutorial-1](./tutorial-1): Specifies the bare-minimum pom.xml and the command-line to run cucumber.
2. [tutorial-2](./tutorial-2): Runs a hello-world of Cucumber with a single feature and step-definitions bound to that feature.
3. [tutorial-3](./tutorial-3): Hello world of Cucumber integrated with Junit
4. [tutorial-4](./tutorial-4): Get to know the meaning of Cucumber keywords and some cool options to make output more palatable.
5. [tutorial-5](./tutorial-5): Passing arguments, lists, maps and tables from feature-files to methods bound to them.
6. [tutorial-6](./tutorial-6): Scenario Outline - Collapsing multiple scenarios into one to reduce reading burden.
7. [tutorial-7](./tutorial-7): Managing Dependency Injection (DI) with cucumber-picocontainer.


# Gherkin corner

1. Uses indentation to define structure.
2. Most lines start with a keyword.
3. Comments begin with a #
4. Feature files contain `features`.
5. A `Feature` contains `Scenarios`.
6. A `Scenario` contains `Steps`
7. A `Step` needs to be mapped to a `specific method`.
