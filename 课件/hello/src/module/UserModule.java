package module;

import pojo.UserDto;

public interface UserModule {

	boolean saveNewUser (UserDto user) throws Exception;
	
}
