package com.caojian.spring.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

//public class DaoTest extends JdbcDaoSupport {
public class DaoTest {
	
	private JdbcTemplate jdbc;
	
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void testQuery () {
		List<Map<String, Object>> lt = this.jdbc.queryForList("select * from tby_buyer");
		for (Map<String, Object> map : lt) {
			System.out.println(map);
		}
	}

}
