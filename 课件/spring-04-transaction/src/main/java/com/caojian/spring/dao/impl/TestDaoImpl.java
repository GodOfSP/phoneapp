package com.caojian.spring.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.caojian.spring.dao.TestDao;

public class TestDaoImpl extends JdbcDaoSupport implements TestDao {
	
	@Override
	public void saveStudent() {
		String sql = "insert into student (studentName,sno,address) values (?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[] {"张三丰5","9527","成都"});
	}

	@Override
	public void saveTeacher() {
		String sql = "insert into teacher (teacherName) values (?)";
		this.getJdbcTemplate().update(sql, new Object[] {"苍井空5苍井空5苍井空5苍井空5苍井空5苍井空5苍井空5苍井空5苍井空5"});
	}

}
