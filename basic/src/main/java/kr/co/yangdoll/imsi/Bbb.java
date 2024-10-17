package kr.co.yangdoll.imsi;

public class Bbb { //사용되어지는 클래스 ==>서버클래스
	public int calcu(int data1, int data2) {
		int result = 0;
		result = data1+data2;
		return result;
	}
}
//1.맨처음 요청 => 두 수를 더하는 프로그램 개발
//2.요구사항 변경 => 곱셈으로 