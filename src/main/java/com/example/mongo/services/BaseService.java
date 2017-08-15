package com.example.mongo.services;


public interface BaseService<T> {
	T add(T model);
	T modify(T model);
	int remove(T model);
}
