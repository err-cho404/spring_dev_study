package com.yangdoll.aspectprj.service;

import org.springframework.stereotype.Component;

@Component
public class TargetService {
	
	public int targetMethod1() {
		System.out.println("targetMethod의 실제 동작 비지니스 로직입니다.");
		System.out.println("이 곳에서 db에 접근할 수 있습니다.");
		System.out.println("다양한 핵심 로직이 동작합니다.");
		return 1;
	}
	
	public String targetMethod2() {
		System.out.println("targetMethod2의 실제 동작 비지니스 로직입니다.");
		System.out.println("이 곳에서 db에 접근할 수 있습니다.");
		System.out.println("다양한 핵심 로직이 동작합니다.");
		return "영구없다";
	}

}
