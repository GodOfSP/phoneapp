package com.caojian.spring.beans;

public class XmlCfgService {

	public void queryData () {
		System.out.println("Do Query...");
	}
	
	public String saveData(String data) {
		System.out.println("Save Data:"+data);
		//int i = 1/0;
		return "success";
	}
}
