package dao;

import pojo.UserDto;

public interface UserDao {

	boolean saveUser (UserDto user) throws Exception;
	
}
