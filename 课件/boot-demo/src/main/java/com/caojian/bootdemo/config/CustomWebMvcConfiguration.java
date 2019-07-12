package com.caojian.bootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.caojian.bootdemo.interceptor.TestInterceptor;

/**
 * WebAppp全局配置
 * @author CaoJian
 *
 */
@Configuration
public class CustomWebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链  
        // addPathPatterns 用于添加拦截规则  
        // excludePathPatterns 用于排除拦截  
        registry.addInterceptor(testInterceptor()).addPathPatterns("/**").excludePathPatterns("/xxx/**");
        super.addInterceptors(registry);  
	}
	
	@Bean
	public TestInterceptor testInterceptor () {
		return new TestInterceptor();
	}

}
