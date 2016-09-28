
Shows Dependency Injection (DI) in Cucumber by using [cucumber-picocontainer](https://cucumber.io/blog/2015/07/08/polymorphic-step-definitions)

# Problem Statement

How to inject arguments in the contructor of your `StepDefinitions` class?

```java
// You want to have a constructor like:
public StepDefinitions(Car a, Bike b, Plane c) {
   // ...
}
```

Since cucumber instantiates the `StepDefinitions` class itself, how do you instruct
cucumber to pass all those arguments above?


## Why not create those instances yourself inside the no-arg constructor?

The problem is with Dependency Injection:

1. What if the arguments you want to pass are interfaces and you need to pass different implementations for different tests?
2. What if the arguments are costly objects and you want to create only a single instance of those classes?


# Cucumber Picocontainer

`cucumber-picocontainer` is a DI framework to solve the above requirements.

All you need to do is add the cucumber-picocontainer dependency to your pom.xml and picocontainer will manage the DI automatically for you.



# Sample run

```bash
mvn clean test

# -------------------------------------------------------
#  T E S T S
# -------------------------------------------------------
# Running com.prismoskills.tutorials.RunCukesTest
# Got object: com.prismoskills.tutorials.Dummy1@9cb8225
# Got object: com.prismoskills.tutorials.Dummy1@9cb8225
# Got object: com.prismoskills.tutorials.Dummy2@376a0d86
# Got object: com.prismoskills.tutorials.Dummy2@376a0d86
# Got object: com.prismoskills.tutorials.Dummy2@376a0d86
# 2016-09-28 11:19:16 INFO  StepDefinitions:24 - logging 1
# 2016-09-28 11:19:16 INFO  StepDefinitions:29 - logging 2
# 2016-09-28 11:19:16 INFO  StepDefinitions:34 - logging 3
# 
# 1 Scenarios (1 passed)
# 3 Steps (3 passed)
# 0m0.111s
# 
# Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.341 sec
```

# Behold !

Objects of the same class are not created twice.

Cucumber-picocontainer creates only a single instance of each class and passes them wherever required.

