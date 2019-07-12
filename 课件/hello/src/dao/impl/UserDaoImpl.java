package dao.impl;

import dao.UserDao;
import pojo.UserDto;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean saveUser(UserDto user) throws Exception {
		String sql = "insert into user (id,name,age) values ("+user.getId()+","+user.getName()+","+user.getAge()+")";
		System.out.println(sql);
		return true;
	}

}
