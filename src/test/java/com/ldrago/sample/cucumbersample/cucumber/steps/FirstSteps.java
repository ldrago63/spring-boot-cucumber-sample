package com.ldrago.sample.cucumbersample.cucumber.steps;

import com.ldrago.sample.cucumbersample.cucumber.CucumberConfiguration;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstSteps extends CucumberConfiguration {

    @Autowired
    private PersonsRepository personsRepository;

    String stupidMessageTest;

    @When("I try to write '(.*)' in message test.")
    public void writeMessage(String message) {
        this.stupidMessageTest = message;
    }

    @Then("Writted message is '(.*)'.")
    public void assertMessage(String message) {
        assertThat(message).isEqualTo(message);
        assertThat(personsRepository).isNotNull();
    }

}
