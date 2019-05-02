package com.ldrago.sample.cucumbersample.controllers.api;


import com.ldrago.sample.cucumbersample.documents.Persons;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/persons")
public interface PersonsController {


    @PostMapping
    Persons create(@RequestBody Persons persons);

    @GetMapping(value = "/{id}")
    Persons get(@PathVariable String id);

}
