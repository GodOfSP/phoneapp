package com.caojian.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* com.caojian.spring.beans.*.*(..))")
	private void allMethod(){}

	@Pointcut("execution(* com.caojian.spring.beans.*.query*(..))")
	private void queryMethod(){}

	//@Before("allMethod()")
	@Before("execution(* com.caojian.spring.beans.*.*(..))")
	public void before (JoinPoint jp) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用前】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
	}
	
	@After("allMethod()")
	public void after (JoinPoint jp) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用后】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
	}
	
	@AfterReturning(value="allMethod()",returning="result")
	public void afterReturn (JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法调用后】the method 【" + methodName + "】 " + "返回值："+result);
	}
	
	@AfterThrowing(value="allMethod()",throwing="exception")
	public void afterException (JoinPoint jp, RuntimeException exception) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("【方法出现异常】the method 【" + methodName + "】  Exception:"+exception.getMessage());
	}
	
	@Before("queryMethod()")
	public void beforeQuery (JoinPoint jp) {
		String methodName = jp.getSignature().getName(); 
		System.out.println("执行查询："+methodName);
	}

}
