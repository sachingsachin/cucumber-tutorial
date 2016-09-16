
package com.prismoskills.tutorials;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Given;

public class StepDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    @Given("^An integer (\\d+), a word \"(\\w+)\" and a string \"(.*)\"$")
    public void method_with_params(int some_num, String some_word, String some_str) throws Throwable {
        logger.info("logger says hi");
        System.out.println("----------------------");
        System.out.println("num="+ some_num + "\nword="+some_word + "\nstring="+some_str+"\n");
    }
}
