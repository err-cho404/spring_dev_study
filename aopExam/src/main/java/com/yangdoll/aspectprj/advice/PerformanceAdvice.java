package com.yangdoll.aspectprj.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect //AOP를 적용한 어노테이션(spring어노테이션이 아님) -> advice 하는 클래스를 의미

public class PerformanceAdvice {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			System.out.println("메서드 실행시간" + System.nanoTime()-startTime);
		}
	}
	public void afterAdv(JoinPoint joinPoint) {
		System.out.println("나의 살던 고향은");
		System.out.println("======>" + joinPoint.getSignature().getName());
		System.out.println("======>" + joinPoint.getSignature().getDeclaringTypeName());
	}
}
