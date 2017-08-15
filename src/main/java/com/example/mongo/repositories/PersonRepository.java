package com.example.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.mongo.models.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>, QueryDslPredicateExecutor<Person>{
	int countById(String id);
}
