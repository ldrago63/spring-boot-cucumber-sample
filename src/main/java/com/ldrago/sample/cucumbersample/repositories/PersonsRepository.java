package com.ldrago.sample.cucumbersample.repositories;

import com.ldrago.sample.cucumbersample.documents.Persons;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Persons, String> {
}
