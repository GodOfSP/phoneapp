package com.caojian.bootdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * spring 权限验证拦截器，拦截所有请求进行处理，并包含登录状态检查 <p> 权限验证规则： 1：注解优先级：方法级的权限注解优先于类级的权限注解（包含：@GreenLight,@Login,@GrantTo
 * 三个注解） 2：权限级别优先级：级别低的优先于级别高的 权限级别从低到高依次为：跳过验证（skipAuthValidationUrlsLt中包含的url）,@GreenLight,@Login,@GrantTo,配置于数据库中的权限体系（最高级别）
 *
 * @author CaoJian
 */
public class TestInterceptor extends HandlerInterceptorAdapter {

  private static final Logger log = LoggerFactory.getLogger(TestInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandler.......");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("preHandle.......");
		//response.sendRedirect("http://www.baidu.com");
		return true;
	}

  
}
