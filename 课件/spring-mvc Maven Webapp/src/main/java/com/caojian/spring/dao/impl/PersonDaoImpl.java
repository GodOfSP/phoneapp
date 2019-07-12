package com.caojian.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.caojian.spring.dao.PersonDao;
import com.caojian.spring.dto.Person;

@Repository("personDaoImpl")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson(Person p) {
		System.out.println("保存："+p.getName());
	}

}
