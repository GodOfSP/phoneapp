package com.caojian.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class XmlCfgAspect {
	
	public void before (JoinPoint jp) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用前】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
	}
	
	public void after (JoinPoint jp) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用后】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
	}
	
	public void afterReturn (JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用后】the method 【" + methodName + "】 " + "返回值："+result);
	}
	
	public void afterException (JoinPoint jp, RuntimeException exception) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法出现异常】the method 【" + methodName + "】  Exception:"+exception.getMessage());
	}
}
