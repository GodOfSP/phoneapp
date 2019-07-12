package com.ybveg.ls.phoneapp.module.service;


import com.ybveg.ls.phoneapp.module.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

	boolean saveUser(User user) throws Exception;
	String getUserId(String userName) throws Exception;
	String getUserPassword(String userName) throws Exception;

}
