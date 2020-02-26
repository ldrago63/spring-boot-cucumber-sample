package com.ldrago.sample.cucumbersample.controllers.impl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person not found")
public class PersonNotFoundException extends RuntimeException {
}