package com.ldrago.sample.cucumbersample.documents;


import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;


public class PersonsBuilderTest {

    @Test
    public void shouldCorrectelyCreatePersons() {

        Date birthDate = new Date();
        Persons created = new PersonsBuilder().withFirstName("Lucas").withLastName("DRAGO").withBirthDate(birthDate).build();

        assertThat(created.getFirstName()).isEqualTo("Lucas");
        assertThat(created.getLastName()).isEqualTo("DRAGO");
        assertThat(created.getBirthDate()).isEqualTo(birthDate);
        assertThat(created.getId()).isNotBlank();

        try {
            UUID.fromString(created.getId());
        } catch (IllegalArgumentException e) {
            fail("Bad uuid persons generation");
        }


    }

}