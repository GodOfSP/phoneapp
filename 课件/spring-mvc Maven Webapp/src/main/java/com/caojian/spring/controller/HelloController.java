package com.caojian.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.caojian.spring.dto.Person;

@Controller
@RequestMapping("/base")
public class HelloController {
	
	@Autowired
	HttpServletRequest request;
	
	/**
	 * 跳转页面，返回String，hello代表一个页面
	 * @return
	 */
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView hello (HttpSession session , ModelAndView mv) {
		mv.addObject("key", "毛泽东");
		mv.setViewName("hello");
		return mv;
	}
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public String hello2 () {
		request.setAttribute("key", "hello2");
		return "hello";
	}
	@RequestMapping(value="/hello3", method=RequestMethod.GET)
	public String hello3 (ModelMap map) {
		map.addAttribute("key", "hello3");
		return "hello";
	}
	
	/**
	 * 重定向
	 */
	@RequestMapping(value="/hello4", method=RequestMethod.GET)
	public String hello4 (ModelMap map) {
		return "redirect:http://wwww.baidu.com";
	}
	
	/**
	 * 返回数据，用于接口，返回类型为JSON
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> save () {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> lt = new ArrayList<String>();
		lt.add("caojian");
		lt.add("曹建");
		lt.add("毛泽东");
		result.put("data", lt);
		return result;
	}
	
	/**
	 * 参数接收
	 */
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query (String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> lt = new ArrayList<String>();
		lt.add("caojian");
		lt.add("曹建");
		lt.add("毛泽东");
		result.put("data", lt);
		result.put("id", id);
		return result;
	}
	
	@RequestMapping(value="/query2", method=RequestMethod.GET)
	@ResponseBody
	public Person query (Person p) {
		return p;
	}
	
	/**
	 * RESTFULL风格的URL
	 * @param guid
	 * @return
	 */
	@RequestMapping(value="/query3/{guid}", method=RequestMethod.GET)
	@ResponseBody
	public String query2 (@PathVariable String guid) {
		return guid;
	}
	
}
