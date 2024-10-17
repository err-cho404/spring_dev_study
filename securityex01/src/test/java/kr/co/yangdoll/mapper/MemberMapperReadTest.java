package kr.co.yangdoll.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.MemberVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
public class MemberMapperReadTest {
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void readTest() {
		MemberVO vo = mapper.read("user2");
		vo.getAuthlist().forEach(a->log.info(a));
		vo=mapper.read("user10");
//		vo.getAuthlist().forEach(a->log.info(a));
	}
}
