package com.yangdoll.aspectprj.annoadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnoAdviceTest {
	
	@Before("execution(public * com.yangdoll.aspectprj.annoservice..*(..))")
	public void beforeAdvice() {
		System.out.println("!!! before !!!");
	}
	@Around("execution(public * com.yangdoll.aspectprj.annoservice.AnnoTargetOne.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		System.out.println("@@@ around before @@@");
		try {
			joinPoint.proceed();
		} finally {
			System.out.println("### around after ###");
			return null;
		}
	}
	@After("execution(public * com.yangdoll.aspectprj.annoservice..*(..))")
	public void afterAdvice() {
		System.out.println("$$$ after $$$");
	}
	@AfterReturning("execution(public * com.yangdoll.aspectprj.annoservice..*(..))")
	public void afterReturnAdvice() {
		System.out.println("%%% after returning %%%");
	}
	@AfterThrowing("execution(public * com.yangdoll.aspectprj.annoservice..*(..))")
	public void afterThrowAdvice() {
		System.out.println("### after Throwing ###");
	}
}
