package com.ldrago.sample.cucumbersample.cucumber.clients.configuration;

public class FeignTestException extends RuntimeException {
    public FeignTestException(String message) {
        super(message);
    }
}
