package kr.co.yangdoll.imsispring;

import org.springframework.stereotype.Component;

//@Component
public class Ccc implements CalcuService{

	public int calcu(int data1 ,int data2) {
		return data1 * data2;
	}
}
