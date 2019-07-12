package com.caojian.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caojian.spring.dao.PersonDao;
import com.caojian.spring.dto.Person;
import com.caojian.spring.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;
	
	@Override
	public void savePerson(Person p) {
		dao.savePerson(p);
	}

}
