package com.caojian.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caojian.bootdemo.dao.TestDao;
import com.caojian.bootdemo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public void doQuery() {
		dao.doQuery();
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveStudent() {
		dao.saveStudent();
//		int i = 1/0;
		dao.saveTeacher();
	}

}
