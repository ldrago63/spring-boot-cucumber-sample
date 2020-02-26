package com.ldrago.sample.cucumbersample.controllers.impl;


import com.ldrago.sample.cucumbersample.controllers.api.PersonsController;
import com.ldrago.sample.cucumbersample.controllers.impl.exceptions.PersonNotFoundException;
import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonsControllerImpl implements PersonsController {


    @Autowired
    private PersonsRepository repository;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Persons create(@Valid Persons persons) {
        return this.repository.save(persons);
    }

    @Override
    public Persons get(String id) {
        Optional<Persons> persons = repository.findById(id);
        if(persons.isEmpty()) {
            throw new PersonNotFoundException();
        }
        return persons.get();
    }
}
