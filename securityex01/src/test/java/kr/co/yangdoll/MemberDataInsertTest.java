package kr.co.yangdoll;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.AuthVO;
import kr.co.yangdoll.domain.MemberVO;
import kr.co.yangdoll.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberDataInsertTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	//security에서 기본저긍로 제공하는 암호화 클래스 BcryptPasswordEncoder 를 이용한다.

	@Test
	public void insertMemberAndAuth() {
		//10명의 자료를 입력한다.
		//1~6번은 일반사용자 7~8번은 운영자 9~10은 관리자 

		for(int i=1; i<7;i++) {
			MemberVO voMem = new MemberVO();
			voMem.setUserId("user"+i);
			voMem.setUserPw(passwordEncoder.encode("user"+i));
			voMem.setUserName("일반사용자"+i);
			mapper.insertMember(voMem);
			AuthVO voAut = new AuthVO();
			voAut.setUserId(voMem.getUserId());
			voAut.setAuth("ROLL_USER");
			mapper.insertAuth(voAut);
		}
		for(int i=7; i<9;i++) {
			MemberVO vo = new MemberVO();
			vo.setUserId("user"+i);
			vo.setUserPw(passwordEncoder.encode("user"+i));
			vo.setUserName("운영자"+i);
			mapper.insertMember(vo);
			AuthVO voAut = new AuthVO();
			voAut.setUserId(vo.getUserId());
			voAut.setAuth("ROLL_USER");
			mapper.insertAuth(voAut);
			AuthVO voAut2 = new AuthVO();
			voAut2.setUserId(vo.getUserId());
			voAut2.setAuth("ROLL_MEMBER");
			mapper.insertAuth(voAut2);
		}
		for(int i = 9; i <11; i++) {
	         MemberVO vo = new MemberVO();
	         vo.setUserId("user"+i);
	         vo.setUserPw(passwordEncoder.encode("user"+i));
	         vo.setUserName("관리자"+i);
	         mapper.insertMember(vo);
	         AuthVO voAut = new AuthVO();
	         voAut.setUserId(vo.getUserId());
	         voAut.setAuth("ROLE_USER");
	         mapper.insertAuth(voAut);
	         AuthVO voAut2 = new AuthVO();
	         voAut2.setUserId(vo.getUserId());
	         voAut2.setAuth("ROLE_MEMBER");
	         mapper.insertAuth(voAut2);
	         AuthVO voAut3 = new AuthVO();
	         voAut3.setUserId(vo.getUserId());
	         voAut3.setAuth("ROLE_ADMIN");
	         mapper.insertAuth(voAut3);
	      }
		
	}
}
