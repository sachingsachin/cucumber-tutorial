
package com.prismoskills.tutorials;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    @Given("^some existing state of my system$")
    public void some_existing_state_of_my_system() throws Throwable {
        logger.info("logging 1");
    }

    @When("^I do some action$")
    public void i_do_some_action() throws Throwable {
        logger.info("logging 2");
    }

    @Then("^I expect a change to occur in the state$")
    public void i_expect_a_change_to_occur_in_the_state() throws Throwable {
        logger.info("logging 3");
    }
}
