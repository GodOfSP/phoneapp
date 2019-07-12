package com.caojian.bootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caojian.bootdemo.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping("/sayhello")
	@ResponseBody
	public String sayHello () {
		return "hello!";
	}
	
	@GetMapping(value="/hello")
	public String hello () {
		service.doQuery();
		return "hello";
	}
	
	@GetMapping(value="/tx")
	@ResponseBody
	public String tx () {
		service.saveStudent();
		return "SpringBoot Transaction Test";
	}
	
}
