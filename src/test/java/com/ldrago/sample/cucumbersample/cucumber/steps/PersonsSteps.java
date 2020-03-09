package com.ldrago.sample.cucumbersample.cucumber.steps;


import com.ldrago.sample.cucumbersample.cucumber.clients.PersonsClient;
import com.ldrago.sample.cucumbersample.cucumber.clients.configuration.FeignTestException;
import com.ldrago.sample.cucumbersample.cucumber.steps.webpages.DisplayPersonPage;
import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.documents.PersonsBuilder;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsSteps {

    private static final Logger logger = LoggerFactory.getLogger(PersonsSteps.class);

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd") {{
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }};

    private Persons apiResponse;

    @Autowired
    private PersonsClient client;

    @Autowired
    private PersonsRepository repository;

    @Autowired
    private WebDriver webDriver;

    @When("I create the person with first name '(.*)', last name '(.*)' and birth date '(.*)'.")
    public void createPersonStep(String firstName, String lastName, String birthDate) throws ParseException {
        Date parsedDate = dateFormatter.parse(birthDate);
        try {
            apiResponse = client.create(new PersonsBuilder().withFirstName(firstName).withLastName(lastName).withBirthDate(parsedDate).build());
        } catch (FeignTestException e) {
            logger.warn("FeignTestException caught, maybe is just to verify http error code in next step ?");
        }
    }

    @When("I get the last created person by her id.")
    public void getPersonStep() {
        try {
            apiResponse = client.get(apiResponse.getId());
        } catch (FeignTestException e) {
            logger.warn("FeignTestException caught, maybe is just to verify http error code in next step ?");
        }
    }

    @When("I get a person with id '(.*)'.")
    public void getPersonStep(String id) {
        try {
            apiResponse = client.get(id);
        } catch (FeignTestException e) {
            logger.warn("FeignTestException caught, maybe is just to verify http error code in next step ?");
        }
    }

    @When("I get the last created person by id.")
    public void getLastPersonStep() {
        apiResponse = client.get(apiResponse.getId());
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

    @When("I open the web browser to display last created user.")
    public void displayLastCreated() {
        this.webDriver.get("http://localhost:8080/persons/" + apiResponse.getId());
    }

    @When("I open the web browser to display the person with id '(.*)'")
    public void displayForId(String id) {
        this.webDriver.get("http://localhost:8080/persons/" + id);
    }


    @Then("The person page displays :")
    public void verifyDisplayedPerson(DataTable person) {
        DisplayPersonPage personPage = new DisplayPersonPage();
        PageFactory.initElements(this.webDriver, personPage);
        assertThat(personPage.getResult().getText()).isEqualTo(person.asList().get(0));
        if(!"User not found".equals(person.asList().get(0))) {
            assertThat(personPage.getDisplayedFirstName().getText()).isEqualTo(person.asList().get(1));
            assertThat(personPage.getDisplayedLastName().getText()).isEqualTo(person.asList().get(2));
        }
    }

    @Then("I close the web browser.")
    public void closeBrowser() {
        this.webDriver.quit();
    }


}
