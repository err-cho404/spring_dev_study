package com.yangdoll.aspectprj.annoservice;

import org.springframework.stereotype.Component;

@Component
public class AnnoTargetOne {
	
	public void me1() {
		System.out.println(this.getClass().getName());
		System.out.println("1111111111111");
	}
	public void me2() {
		System.out.println(this.getClass().getName());
		System.out.println("2222222222222");
	}
	public void me3() {
		System.out.println(this.getClass().getName());
		System.out.println("3333333333333");
	}
	public void me4() {
		System.out.println(this.getClass().getName());
		System.out.println("4444444444444");
	}
	public void me5() throws Exception{
		System.out.println(this.getClass().getName());
		System.out.println("5555555555555");
		throw new NullPointerException();
	}
	
}
