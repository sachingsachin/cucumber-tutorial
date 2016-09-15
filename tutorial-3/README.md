
Hello world of Cucumber integrated with Junit

```bash
mvn clean test

# -------------------------------------------------------
#  T E S T S
# -------------------------------------------------------
# Running com.prismoskills.tutorials.RunCukesTest
# 
# 1 Scenarios (1 passed)
# 3 Steps (3 passed)
# 0m0.073s
# 
# Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.301 sec
# 
# Results :
# 
# Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

Good part here is that the tests run as part of mvn build process.

Secondly, we do not need to create a shaded jar file (as done in previous tests) which can be quite a time-consuming process.

Important part to note here is:

1. We need to have a class defined separately `RunCukesTest.java` whose only task is to be a host
   for the annotations: `RunWith` and `CucumberOptions`
2. Just like the `--glue` option, the path in features need not be the full-path where features file is present.
   `"src/test"` works just as fine as `"src/test/resources"`




# Number of tests run

This is the most important part.

Each of your step-definition and the scenario is considered a test in itself !

It might be a surprise for people coming from Junit or other backgrounds.

Even the steps correspodning to `Given` statements are considered a test and their count is included in the final count.

Personally, I think this is a bit of a mis-representation because I am not really testing
anything with the `Given` statements and several `And` statements. But that is how it is.
And in the next tutorial, you will see why that is so.

