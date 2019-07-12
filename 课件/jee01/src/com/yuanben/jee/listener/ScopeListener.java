package com.yuanben.jee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ��������������request session  application��ServletContext������������
 * @author CaoJian
 *
 */
public class ScopeListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		System.out.println("request���٣�"+request.getRequestURI());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
		System.out.println("request��ʼ����"+request.getRequestURI());
	}


	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("����SESSION��ID��"+event.getSession().getId());		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("����SESSION��ID��"+event.getSession().getId());
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("����ServletContext:"+event.getServletContext().getRealPath("/"));
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("����ServletContext:"+event.getServletContext().getRealPath("/"));
	}

}
