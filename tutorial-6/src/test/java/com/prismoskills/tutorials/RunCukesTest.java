package com.prismoskills.tutorials;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty",
              "html:target/cucumber",
              "rerun:target/cucumber/rerun.txt",
              "usage:target/cucumber/usage.txt"
        },
    features="src/test/resources"
)
public class RunCukesTest {
}
