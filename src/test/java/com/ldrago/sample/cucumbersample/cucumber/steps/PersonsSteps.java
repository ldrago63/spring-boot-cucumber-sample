package com.ldrago.sample.cucumbersample.cucumber.steps;


import com.ldrago.sample.cucumbersample.cucumber.clients.PersonsClient;
import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.documents.PersonsBuilder;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonsSteps {

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    private Persons apiResponse;

    @Autowired
    private PersonsClient client;

    @When("I create the person with first name '(.*)', last name '(.*)' and birth date '(.*)'.")
    public void createPersonStep(String firstName, String lastName, String birthDate) throws ParseException {
        Date parsedDate = dateFormatter.parse(birthDate);
        apiResponse = client.create(new PersonsBuilder().withFirstName(firstName).withLastName(lastName).withBirthDate(parsedDate).build());
    }

}
