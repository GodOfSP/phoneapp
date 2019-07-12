package com.yuanben.jee.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements HttpSessionAttributeListener,ServletContextAttributeListener,ServletRequestAttributeListener  {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Session--�������ԣ�"+event.getName()+":"+event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Session--ɾ�����ԣ�"+event.getName()+":"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Session--�޸����ԣ�"+event.getName()+":"+event.getValue());
	}
	
	
	

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("Request--�������ԣ�"+event.getName()+":"+event.getValue());		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("Request--ɾ�����ԣ�"+event.getName()+":"+event.getValue());			
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("Request--�޸����ԣ�"+event.getName()+":"+event.getValue());			
	}
	
	
	

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Context--�������ԣ�"+event.getName()+":"+event.getValue());			
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Context--ɾ�����ԣ�"+event.getName()+":"+event.getValue());		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Context--�޸����ԣ�"+event.getName()+":"+event.getValue());		
	}

}
