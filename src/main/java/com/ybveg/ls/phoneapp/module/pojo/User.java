package com.ybveg.ls.phoneapp.module.pojo;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String userName;
	
	private String password;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;

	}

}
