package com.caojian.spring.beans;

public class MyService {
	
	public String doSomething (String arg) {
		System.out.println("doSomething,args:"+arg);
		//int i = 1/0;
		return "Done something";
	}
	
	public void querySomeData () {
		System.out.println("doQuery.....");
	}
	
}
