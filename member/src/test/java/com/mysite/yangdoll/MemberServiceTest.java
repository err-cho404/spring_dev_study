package com.mysite.yangdoll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.yangdoll.entity.Members;
import com.mysite.yangdoll.service.MemberService;

@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberService ser;
	
	//입력테스트할 자료를 스스로 선언한 것
	Members mem1,mem2,mem3;
	
	@BeforeEach //junit 4.12 ->@before사용  junit 5에서는 다름
	public void init() {
		mem1 = new Members();
		mem1.setCount(0);
		mem1.setEmail("qwert");
		mem1.setGrade(1);
		mem1.setMemName("강감찬");
		mem1.setMemId(2);
		mem1.setMemPwd("asdfag");
		mem1.setPhone("01011112222");
	}
	
	@Test
	public void insertMemberTest() {
		int result = ser.registerMember(mem1);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateOneTest() {
		ser.updateMember(mem1);
	}
	
	@Test
	public void updateConditionalTest() {
		ser.updateCondition();
	}
}
