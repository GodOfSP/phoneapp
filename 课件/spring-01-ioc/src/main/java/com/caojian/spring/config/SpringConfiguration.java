package com.caojian.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.caojian.spring.beans.Person;
import com.caojian.spring.beans.Test;

@Configuration
public class SpringConfiguration {

//	@Scope("prototype")
	@Bean
	public Test test () {
		Test test = new Test();
		test.setName("xxxx");
		test.setPerson(person ());
		return test;
	}
	
	@Bean
	public Person person () {
		return new Person();
	}
	
}
