package com.caojian.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.caojian.spring.beans.MyService;

@Configuration
@ImportResource("classpath:/application.xml")
public class SpringConfiguration {

	@Bean
	public MyService myService () {
		return new MyService();
	}
	
}
