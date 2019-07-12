package com.yuanben.jee.module.service.impl;

import com.yuanben.jee.module.User;
import com.yuanben.jee.module.dao.UserDao;
import com.yuanben.jee.module.dao.impl.UserDaoImpl;
import com.yuanben.jee.module.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();

	@Override
	public boolean saveUser(User user) throws Exception {
		int r = dao.saveUser(user);
		return r == 1 ? true : false;
	}

}
