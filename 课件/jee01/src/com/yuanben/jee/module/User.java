package com.yuanben.jee.module;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String userName;
	
	private String password;
	
	private String realName;
	
	private String birthday;
	
	private String address;

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String userName, String password, String realName, String birthday, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.birthday = birthday;
		this.address = address;
	}

}
