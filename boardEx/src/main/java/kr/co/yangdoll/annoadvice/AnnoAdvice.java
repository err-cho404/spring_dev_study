package kr.co.yangdoll.annoadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnoAdvice {
	
	@Before("execution(public * kr.co.yangdoll.service.*.getBoardList(..))")
	public void beforeAd() {
		System.out.println("리스트 출력");
	}
	
	@After("execution(public * kr.co.yangdoll.service.*.updateBoard(..))")
	public void afterAd() {
		System.out.println("board 어노테이션 업데이트");
	}
/*	
	@Around("execution(public * kr.co.yangdoll.service.*.insertBoard(..))")
	public Object aroundAd(ProceedingJoinPoint joinPoint) {
		System.out.println("board 새 글쓰기");
		try {
			joinPoint.proceed();
		} finally {
			System.out.println("글쓰기");
			return null;
		}
	}
*/
}
