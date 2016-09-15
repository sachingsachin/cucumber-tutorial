
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

    @Given("^Pass simple map to a function$")
    public void function_with_map(Map<String, Integer> map) throws Throwable {
        System.out.println("----------------------");
        System.out.println("map: "+ map +"\n");
    }

    @Given("^Pass three column table to a function$")
    public void function_with_three_column_table(List<MyPojo> table) throws Throwable {
        System.out.println("----------------------");
        System.out.println("table="+ table +"\n");
    }
}

class MyPojo {
    String word1;
    Integer num;
    String word2;

    public String toString() {
        return "MyPojo [word1=" + word1 + ", num=" + num + ", word2=" + word2 + "]";
    }
}
