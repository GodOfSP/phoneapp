package com.caojian.bootdemo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.caojian.bootdemo.dao.TestDao;

@Repository
public class TestDaoImol implements TestDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void doQuery() {
		List<Map<String, Object>> lt = jdbc.queryForList("select * from teacher");
		for (Map<String, Object> map : lt) {
			System.out.println(map);
		}
		
//		String sql = "insert into student (studentName,sno,address) values (?,?,?)";
//		jdbc.update(sql, new Object[] {"习近平222","9527","成都"});
	}
	
	@Override
	public void saveStudent() {
		String sql = "insert into student (studentName,sno,address) values (?,?,?)";
		jdbc.update(sql, new Object[] {"习近平222","9527","成都"});
	}

	@Override
	public void saveTeacher() {
		String sql = "insert into teacher (teacherName) values (?)";
		jdbc.update(sql, new Object[] {"孔夫子222"});
	}

}
