package com.example.mongo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.models.Person;
import com.example.mongo.services.PersonService;


@RestController
@RequestMapping(value="/demo/person")
public class PersonController extends BaseController{
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/all")
	public List<Person> getAllPersons(){
		return personService.getAllPerson();
	}
	
	@RequestMapping(value="age")
	public List<Person> getPersonByAge(@RequestParam("age") int age){
		return personService.getPersonByAge(age);
	}
	
	@RequestMapping(value="age/range")
	public List<Person> getPersonByAgeBetween(@RequestParam("from") int from, @RequestParam("to") int to){
		return personService.getPersonByAgeBetween(from, to);
	}
	
	@RequestMapping(value="", method=RequestMethod.DELETE)
	public int removePerson(@RequestParam("id") String id){
		Person person = new Person();
		person.setId(id);
		return personService.remove(person);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, consumes={"application/json"})
	public Person modifyPerson(@Valid @RequestBody Person person, @RequestParam("id") String id){
		person.setId(id);
		return personService.modify(person);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST, consumes={"application/json"})
	public Person create(@Valid @RequestBody Person person){
		return personService.add(person);
	}
}
