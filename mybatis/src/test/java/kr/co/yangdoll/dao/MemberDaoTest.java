package kr.co.yangdoll.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
public class MemberDaoTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MemberDao dao;
	
	@Test
	@Ignore
	public void daoInjectionTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void insertTest() {
		MemberVO sampleDataVo = new MemberVO("doll", "doll1234", "양돌doll", "yangdoll@naver.com", "경기도 수원시");
		
		int result = dao.insertMember(sampleDataVo);	
		assertEquals(result, 1);
		MemberVO getMember = dao.selectGetId(sampleDataVo.getMemId());
		System.out.println(getMember);
		
		System.out.println("입력전 자료 \n" + sampleDataVo);
		System.out.println("DB에 저장된 자료 \n" + getMember);
		assertEquals(sampleDataVo.getMemId(), getMember.getMemId()); 
		assertEquals(sampleDataVo.getMemPwd(), getMember.getMemPwd()); 
		assertEquals(sampleDataVo.getMemName(), getMember.getMemName()); 
		assertEquals(sampleDataVo.getMemEmail(), getMember.getMemEmail()); 
		assertEquals(sampleDataVo.getMemAddr(), getMember.getMemAddr()); 
	}
	
	@Test
	public void getAllTest() {
		List<MemberVO> list = dao.selectAll();
		for( int i = 0 ; i < list.size(); i = i + 1) {
			System.out.println(list.get(i));
		}
	}
}
