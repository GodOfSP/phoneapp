package com.caojian.spring.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Test {
	
	public void init () {
		System.out.println("init.....");
	}
	public void destory () {
		System.out.println("destory.....");
	}
	
	private String name;
	
	private int age;
	
	private String phone;
	
	private String address;

	public Test() {
		
		System.out.println("构造函数.....");
		
	}
	
	//@Qualifier("person")//autowired默认采用byType的注入方式，如果一个接口有多个实现类，需要配合@Qualifier来指定具体的类
	@Autowired
	private Person person;
	
	//@Resource默认采用byName的方式注入，也可以指定type
//	@Resource
//	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Test(String name, int age, String phone, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public void tk () {
		person.talk();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
