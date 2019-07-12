package com.ybveg.ls.phoneapp.module.dao;


import com.ybveg.ls.phoneapp.module.pojo.User;

public interface UserDao {

	int saveUser(User user) throws Exception;

	String getUserId(String userName) throws  Exception;

	String getPassword(String userName) throws  Exception;

}
