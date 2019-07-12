package com.caojian.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caojian.spring.beans.Test;
import com.caojian.spring.config.SpringConfiguration;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ){
    	
    	//new App().testXmlConf();
    	new App().testJavaConf();
    	
    }
	
	private void testXmlConf() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		
    	
    	Test test1 = (Test)app.getBean("test");
    	Test test2 = (Test)app.getBean("test");
    	System.out.println(test1.getName());
    	
    	test1.setName("beyond");
    	
    	System.out.println(test1.getName());
    	System.out.println(test2.getName());
    	
    	app.close();		
	}
    
	private void testJavaConf() {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		Test test1 = (Test)app.getBean("test");
    	Test test2 = (Test)app.getBean("test");
    	System.out.println(test1.getName());
    	
    	test1.setName("beyond");
    	
    	System.out.println(test1.getName());
    	System.out.println(test2.getName());
    	
    	test1.tk();
    	
    	app.close();		
		
	}

}
