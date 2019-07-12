package com.caojian.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.caojian.spring.dao.TestDao;
import com.caojian.spring.service.TestService;

public class TestServiceImpl implements TestService {
	
	@Autowired
	TestDao dao;

	@Override
	@Transactional(rollbackFor=RuntimeException.class)
	public void saveStudent() {
		dao.saveStudent();
		//int i = 1/0;
		dao.saveTeacher();
	}

}
