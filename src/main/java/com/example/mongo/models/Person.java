package com.example.mongo.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Person")
public class Person extends ORM {
	@Id
	private String id;
	@CreatedDate
	private Date createdDate = new Date(System.currentTimeMillis());
	private PersonDetails person;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PersonDetails getPerson() {
		return this.person;
	}

	public void setPerson(PersonDetails person) {
		this.person = person;
	}
	
	public Date getCreatedDate(){
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
	

}
