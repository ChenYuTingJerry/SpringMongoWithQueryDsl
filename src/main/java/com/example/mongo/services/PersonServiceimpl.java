package com.example.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.models.Person;
import com.example.mongo.models.QPerson;
import com.example.mongo.repositories.PersonRepository;
import com.querydsl.core.types.Predicate;

@Service
public class PersonServiceimpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getPersonByAge(int age) {
		QPerson qPerson = new QPerson("person");
		Predicate predicate = qPerson.person.age.eq(age);
		return (List<Person>) personRepository.findAll(predicate);
	}

	@Override
	public Person add(Person model) {
		// TODO Auto-generated method stub
		return personRepository.save(model);
	}

	@Override
	public Person modify(Person model) {
		if (personRepository.countById(model.getId()) == 1) {
			return personRepository.save(model);
		} else {
			return null;
		}

	}

	@Override
	public int remove(Person model) {
		personRepository.delete(model.getId());
		return personRepository.countById(model.getId());
	}

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public List<Person> getPersonByAgeBetween(int from, int to) {
		QPerson qPerson = new QPerson("person");
		Predicate predicate = qPerson.person.age.between(from, to);
		return (List<Person>) personRepository.findAll(predicate);
	}

}
