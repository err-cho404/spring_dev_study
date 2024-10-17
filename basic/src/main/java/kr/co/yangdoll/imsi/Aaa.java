package kr.co.yangdoll.imsi;

public class Aaa { //사용하는 클래스 ==> 클라이언트클래스(요청하는 클래스)
	/*
	  public void use() { Bbb obj = new Bbb(); //직접 필요한 클래스를 생성 <= 두 클래스가 강하게
	  연결되어있음(스트롱 커풀링) int result = obj.calcu(100, 300); System.out.println(result);
	  }
	 */
	public void use() {
		Ccc obj = new Ccc();
		int result = obj.calcu(100, 300);
		System.out.println(result);
	}
}
