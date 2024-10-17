package kr.co.yangdoll.imsispring;

import org.springframework.stereotype.Component;

import kr.co.yangdoll.imsispring.CalcuService;

//@Component
public class Bbb implements CalcuService{ //사용되어지는 클래스 ==>서버클래스
	public int calcu(int data1, int data2) {
		int result = 0;
		result = data1+data2;
		return result;
	}
}
//1.맨처음 요청 => 두 수를 더하는 프로그램 개발
//2.요구사항 변경 => 곱셈으로 