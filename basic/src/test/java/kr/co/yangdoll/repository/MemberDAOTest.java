package kr.co.yangdoll.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDAOTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	MemberDAO dao;
	
	///테스트용 데이터 필드 선언
	MemberVO vo1, vo2, vo3;
	
	@Test
	@Ignore //test할 때 빼고 테스트 해라
	public void contextTest() {
		assertNotNull(context);
		assertNotNull(ds);
		assertNotNull(dao);
	}
	
	@Before  //Before를 먼저 실행시키고 Test를 진행하라는 의미
	public void init() {
		vo1 = new MemberVO("qwertyuiop", "asdfg1234", "나일등", "asdfg@bbb.com", "seoul");
		vo2 = new MemberVO("hongildong", "gildong1479", "홍길동", "gildong@bbb.com", "busan");
		vo3 = new MemberVO("yohohoho", "hohoho", "호호호", "hoho@bbb.com", "suwon");
	}
	
	@Test
	public void daoInsertTest() {
		dao.deleteMemberAll(); //dao.deleteMember(vo1.getMemId()); -> vo1만 지우고싶을 때
		int count = dao.getMemberCount();
		assertEquals(count, 0); //데이터를 모두 지웠을때 count는 0개
		int result = dao.insertMember(vo1);
		assertEquals(result, 1); //입력한 결과가 1인지
		assertEquals(dao.getMemberCount(), 1); //데이터 입력 후 에는 1개
		result = dao.insertMember(vo2);
		assertEquals(result, 1);
		assertEquals(dao.getMemberCount(), 2);
		result = dao.insertMember(vo3);
		assertEquals(result, 1);
		assertEquals(dao.getMemberCount(), 3);
		
		MemberVO rtnVo1 = dao.getMember(vo1.getMemId());
		memVoEqual(vo1, rtnVo1);
		rtnVo1 = dao.getMember(vo2.getMemId());
		memVoEqual(vo2, rtnVo1);
		rtnVo1 = dao.getMember(vo3.getMemId());
		memVoEqual(vo3, rtnVo1);
	}
	
	public void memVoEqual(MemberVO source,MemberVO get) {
		assertEquals(source.getMemPwd(), get.getMemPwd());
		assertEquals(source.getMemName(), get.getMemName());
		assertEquals(source.getMemEmail(), get.getMemEmail());
		assertEquals(source.getMemAddr(), get.getMemAddr());
	}
	
	@Test
	public void getAll() { //3개의 데이터 입력후 모든 데이터 가져오기
		
		int count = dao.getMemberCount();
		assertEquals(count, 0);
		dao.insertMember(vo1);
		dao.insertMember(vo2);
		dao.insertMember(vo3);
		List<MemberVO> list = dao.getALL();
		assertEquals(list.size(), dao.getMemberCount());
		for(MemberVO vo : list) {
			System.out.println("=====>" + vo);
		}
		memVoEqual(vo2, list.get(0));
		memVoEqual(list.get(1),vo3);
		memVoEqual(list.get(2),vo1);
	}
	@Test
	public void updateAndDelOneTest(){
		dao.deleteMemberAll(); 
		dao.insertMember(vo1);
		dao.insertMember(vo2);
		dao.insertMember(vo3);
		System.out.println(vo3);
		vo3.setMemAddr("hwasung"); //을지문덕회원의 주소를 화성으로 변경
		System.out.println("변경후========>" + vo3);
		int rtnValue = dao.updateMember(vo3);
		assertEquals(rtnValue, 1);
		MemberVO getVo = dao.getMember(vo3.getMemId());
		assertEquals(getVo.getMemAddr(), "hwasung");
		
		assertEquals(1, dao.delOne(vo1.getMemId()));
		assertEquals(dao.getMemberCount(), 2);
	}
	
}
