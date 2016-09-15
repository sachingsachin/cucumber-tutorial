
package com.prismoskills.tutorials;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class StepDefinitions {

    @Given("^An integer (\\d+), a word \"(\\w+)\" and a string \"(.*)\"$")
    public void method_with_params(int some_num, String some_word, String some_str) throws Throwable {
        System.out.println("----------------------");
        System.out.println("num="+ some_num + "\nword="+some_word + "\nstring="+some_str+"\n");
    }
}
