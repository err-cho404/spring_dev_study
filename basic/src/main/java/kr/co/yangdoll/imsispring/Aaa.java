package kr.co.yangdoll.imsispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Aaa {
//	@Autowired   //프레임워크에게 필요한 객체를 넣어주세요(DI:Dependence Injection) 
	CalcuService obj ;
	
	public CalcuService getObj() {
		return obj;
	}

	public void setObj(CalcuService obj) {
		this.obj = obj;
	}
//곱셈은 Ccc 덧셈은 Bbb 클래스가 필요. 필요한 것을 만들어야 한다. new Bbb or new Ccc
//스프링 프레임 워크에게 객체생성을 위임한다=> 제어(생성)의 역전(IOC)
	public void use() {
		
		int result = obj.calcu(100, 300);
		System.out.println(result);
	}
}
