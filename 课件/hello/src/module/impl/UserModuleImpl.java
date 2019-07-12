package module.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import module.UserModule;
import pojo.UserDto;

public class UserModuleImpl implements UserModule {
	
	UserDao dao = new UserDaoImpl();

	@Override
	public boolean saveNewUser(UserDto user) throws Exception {
		return dao.saveUser(user);
	}

}
