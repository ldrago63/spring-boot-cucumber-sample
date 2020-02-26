package com.ldrago.sample.cucumbersample.cucumber.steps;

import com.ldrago.sample.cucumbersample.cucumber.clients.configuration.ClientsConfiguration;
import com.ldrago.sample.cucumbersample.cucumber.clients.configuration.Interceptors;
import feign.codec.Decoder;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    @Autowired
    private Interceptors interceptors;

    @Then("Http code is '(\\d+)'")
    public void verifyHttpCode(int code) {
        assertThat(interceptors.getHttpCode()).isEqualTo(code);
    }
}
