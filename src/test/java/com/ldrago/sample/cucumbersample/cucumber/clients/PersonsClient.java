package com.ldrago.sample.cucumbersample.cucumber.clients;

import com.ldrago.sample.cucumbersample.controllers.api.PersonsController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="personsClient", url = "http://localhost:8080/api/persons")
public interface PersonsClient extends PersonsController {
}
