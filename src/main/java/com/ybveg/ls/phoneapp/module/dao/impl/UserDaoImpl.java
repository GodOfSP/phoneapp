package com.ybveg.ls.phoneapp.module.dao.impl;


import com.ybveg.ls.phoneapp.module.dao.UserDao;
import com.ybveg.ls.phoneapp.module.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl  implements UserDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public int saveUser(User user) throws Exception {
		String sql = "INSERT into t_user (userName,password) values (?,?)";
		return jdbc.update(sql, new Object[] {user.getUserName(),user.getPassword()});
	}

	@Override
	public String getUserId(String userName) throws Exception {
		String sql = "select id from t_user where userName = ?";
		return jdbc.queryForObject(sql,String.class,new Object[]{userName});
	}

	@Override
	public String getPassword(String userName) throws Exception {
		String sql = "select password from t_user where userName = ?";
		return jdbc.queryForObject(sql,String.class,new Object[]{userName});
	}


}
