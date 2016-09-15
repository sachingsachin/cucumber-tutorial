# cucumber-tutorial

[Cucumber](https://github.com/cucumber/cucumber) is is a tool that supports [Behaviour-Driven Development (BDD)](https://en.wikipedia.org/wiki/Behavior-driven_development).

In layman's terms, this is what it means:

1. It should be possible to use english-like language to write tests at a high-level.
2. This makes the test easier to write, read and re-use for other tests because admit it ... english is easier to understand than code (and poor you thought otherwise? sad...)
3. If you map your english-phrases to specific methods in your code, then it is possible to re-use them better.
   Example: A phrase like "Give a database with 5 person entities".
   If many tests need the above pre-condition for testing, then it is easier to define the Java method once and then use the
   above phrase at all the places.
4. If you have several such phrases (general enough to suit all tests), then some new tests can be written by just calling those specific phrases. (Assuming that there mappings to methods are written well enough to suit all cases.)
5. Whatever you do in the write part, reading english is easier than read code (hey, we established that already ... sorry mate!).

Cucumber uses [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) language for writing english phrases and we will call files containing such phrases as `feature` files.

1. [tutorial-1](./tutorial-1): Specifies the bare-minimum pom.xml and the command-line to run cucumber.
2. [tutorial-2](./tutorial-2): Runs a hello-world of Cucumber with a single feature and step-definitions bound to that feature.
3. [tutorial-3](./tutorial-3): Hello world of Cucumber integrated with Junit
4. [tutorial-4](./tutorial-4): Get to know the meaning of Cucumber keywords and some cool options to make output more palatable.


# Gherkin corner

1. Uses indentation to define structure.
2. Most lines start with a keyword.
3. Comments begin with a #
4. Feature files contain `features`.
5. A `Feature` contains `Scenarios`.
6. A `Scenario` contains `Steps`
7. A `Step` needs to be mapped to a `specific method`.
