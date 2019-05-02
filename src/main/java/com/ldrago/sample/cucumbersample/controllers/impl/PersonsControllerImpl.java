package com.ldrago.sample.cucumbersample.controllers.impl;


import com.ldrago.sample.cucumbersample.controllers.api.PersonsController;
import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsControllerImpl implements PersonsController {


    @Autowired
    private PersonsRepository repository;

    @Override
    public Persons create(Persons persons) {
        return this.repository.save(persons);
    }

    @Override
    public Persons get(String id) {
        return repository.findById(id).get();
    }
}
