package com.yuanben.jee.module.dao.impl;

import com.caojian.dao.basedao.impl.BaseDaoImpl;
import com.yuanben.jee.module.User;
import com.yuanben.jee.module.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao  {

	@Override
	public int saveUser(User user) throws Exception {
		String sql = "INSERT into user (userName,realName,password,birthday,address) values (?,?,?,?,?)";
		return this.executeUpdate(sql, new Object[] {user.getUserName(),user.getRealName(),user.getPassword(),user.getBirthday(),user.getAddress()});
	}

}
