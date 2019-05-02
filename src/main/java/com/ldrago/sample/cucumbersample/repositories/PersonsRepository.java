package com.ldrago.sample.cucumbersample.repositories;

import com.ldrago.sample.cucumbersample.documents.Persons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonsRepository extends MongoRepository<Persons, String> {
}
