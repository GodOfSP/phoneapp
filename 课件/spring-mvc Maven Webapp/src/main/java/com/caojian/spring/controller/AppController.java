package com.caojian.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caojian.spring.dto.Person;
import com.caojian.spring.service.PersonService;

@RestController
public class AppController {
	
	@Autowired
	private PersonService service;

	@RequestMapping(value="/app/getperson", method=RequestMethod.GET)
	public Person query (Person p) {
		service.savePerson(p);
		return p;
	}
	
}
