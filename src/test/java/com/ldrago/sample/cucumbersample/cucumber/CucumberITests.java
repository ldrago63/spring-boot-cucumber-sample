package com.ldrago.sample.cucumbersample.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = {"src/test/resources/features"}, plugin = {"pretty", "html:target/cucumber/cucumber-sample-app"})
public class CucumberITests {
}
