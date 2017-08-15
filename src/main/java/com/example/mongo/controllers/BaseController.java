package com.example.mongo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
	@ModelAttribute
	public void prepare(HttpServletRequest request){};
}
