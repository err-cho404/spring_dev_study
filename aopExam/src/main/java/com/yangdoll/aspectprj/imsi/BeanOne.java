package com.yangdoll.aspectprj.imsi;

import org.springframework.stereotype.Component;

@Component("beanData")//이름 지정안하면 클래스 명의 첫글자만 소문자로 바꿔서 beanOne이 이름이 된다. ("beanData")로 이름 지정
public class BeanOne {
	int data1; //필드 기본값 0
	String data2; //필드 기본ㄱ밧 null

	public void setData1(int data1 /*변수*/) {
		this.data1 = data1;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
}
