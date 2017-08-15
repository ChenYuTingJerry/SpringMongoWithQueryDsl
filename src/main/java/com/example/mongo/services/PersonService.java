package com.example.mongo.services;

import java.util.List;

import com.example.mongo.models.Person;


public interface PersonService extends BaseService<Person>{
	List<Person> getPersonByAge(int age);
	List<Person> getAllPerson();
	List<Person> getPersonByAgeBetween(int from, int to);
}
