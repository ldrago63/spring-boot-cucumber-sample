package com.ldrago.sample.cucumbersample.documents;

import java.util.Date;

public class PersonsBuilder {


    private Persons toBuild = new Persons();

    public PersonsBuilder withFirstName(String firstName) {
        toBuild.setFirstName(firstName);
        return this;
    }

    public PersonsBuilder withLastName(String lastName) {
        toBuild.setLastName(lastName);
        return this;
    }

    public PersonsBuilder withBirthDate(Date birthDate) {
        toBuild.setBirthDate(birthDate);
        return this;
    }

    public Persons build() {
        return toBuild;
    }


}
