package com.ybveg.ls.phoneapp.module.service.impl;



import com.ybveg.ls.phoneapp.module.dao.UserDao;
import com.ybveg.ls.phoneapp.module.dao.impl.UserDaoImpl;
import com.ybveg.ls.phoneapp.module.pojo.User;
import com.ybveg.ls.phoneapp.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl dao ;
	@Override
	public boolean saveUser(User user) throws Exception {
		int r = dao.saveUser(user);
		return r == 1 ? true : false;
	}

	@Override
	public String getUserId(String userName) throws Exception {
		return dao.getUserId(userName);
	}

	@Override
	public String getUserPassword(String userName) throws Exception {
		return dao.getPassword(userName);
	}

}
