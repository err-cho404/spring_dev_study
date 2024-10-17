package kr.co.yangdoll.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.persistence.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AnnoTest {

	@Autowired
	BoardService service;
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void getBoardTest() {
		BoardVO inData1 = new BoardVO();
		inData1.setTitle("새로 입력한 자료 제목22");
		inData1.setContent("새로 입력해 넣은 컨텐츠 내용입니다~22");
		inData1.setWriter("뉴 작성자22");
		
		mapper.insertBoardGetBno(inData1);
		System.out.println("===========\n" + inData1);
		
		BoardVO getVo = mapper.getBoard(inData1.getBno());
		System.out.println("===========\n" + getVo);
		
		assertEquals(inData1, getVo); 
	}
}
