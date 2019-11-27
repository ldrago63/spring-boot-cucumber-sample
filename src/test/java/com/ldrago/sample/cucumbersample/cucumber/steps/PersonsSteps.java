package com.ldrago.sample.cucumbersample.cucumber.steps;


import com.ldrago.sample.cucumbersample.cucumber.clients.PersonsClient;
import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.documents.PersonsBuilder;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsSteps {

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd") {{
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }};

    private Persons apiResponse;

    @Autowired
    private PersonsClient client;

    @Autowired
    private PersonsRepository repository;

    @When("I create the person with first name '(.*)', last name '(.*)' and birth date '(.*)'.")
    public void createPersonStep(String firstName, String lastName, String birthDate) throws ParseException {
        Date parsedDate = dateFormatter.parse(birthDate);
        apiResponse = client.create(new PersonsBuilder().withFirstName(firstName).withLastName(lastName).withBirthDate(parsedDate).build());
    }

    @Then("A person is returned with first '(.*)', last name '(.*)' and birth date '(.*)'.")
    public void assertReturn(String firstName, String lastName, String birthDate) throws ParseException {
        assertThat(apiResponse.getFirstName()).isEqualTo(firstName);
        assertThat(apiResponse.getLastName()).isEqualTo(lastName);
        assertThat(apiResponse.getBirthDate()).isEqualTo(dateFormatter.parse(birthDate));
    }

    @Then("Person '(.*)' '(.*)' is found in database with returned object id.")
    public void assertPersisted(String firstName, String lastName) throws ParseException {
        Persons found = this.repository.findById(apiResponse.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getFirstName()).isEqualTo(firstName);
        assertThat(found.getLastName()).isEqualTo(lastName);
    }

}
