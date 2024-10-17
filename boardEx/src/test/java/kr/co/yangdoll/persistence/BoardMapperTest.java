package kr.co.yangdoll.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.util.PageInfoVO;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	ApplicationContext context;
	
	//테스트 하고자하는 클래스를 필드로 선언(클래스 상위 인터페이스가 있다면 인터페이스 타입으로 설정 -> mybatis는 인터페이스만 있음)
	@Autowired
	BoardMapper mapper;
	
	
	@Test
	public void mapperDITest() {
		assertNotNull(mapper);
	}
	
	@Test
	public void insertBoardTest() {
		int initCount = mapper.getCount(); //현재(초기에 만든 5개) 테이블에 저장된 자료의 개수 세어옴
		//테스트용 입력할 자료 만들기
		BoardVO inData1 = new BoardVO();
		inData1.setTitle("새로 입력한 자료 제목11");
		inData1.setContent("새로 입력해 넣은 컨텐츠 내용입니다~11");
		inData1.setWriter("뉴 작성자");
		
		int result = mapper.insertBoard(inData1);
		assertEquals(1, result);
		
		int afterCount = mapper.getCount(); //새 자료 입력 후 테이블에 저장된 자료의 개수 세어옴
		assertEquals(initCount+1,afterCount);
		
		System.out.println("=========게시판 번호=========>" + inData1.getBno()); /*참조타입인 Integer이면 null int면 0이 나올 것임*/
	}
		
	@Test
	public void insertBoardGetBnoTest() {
		int initCount = mapper.getCount(); 
		//테스트용 입력할 자료 만들기
		BoardVO inData1 = new BoardVO();
		inData1.setTitle("새로 입력한 자료 제목22");
		inData1.setContent("새로 입력해 넣은 컨텐츠 내용입니다~22");
		inData1.setWriter("뉴 작성자22");
		System.out.println("====입력 실행전 vo 객체의 bno =====> " + inData1.getBno());
			
		int result = mapper.insertBoardGetBno(inData1);
		assertEquals(1, result);
			
		int afterCount = mapper.getCount(); 
		assertEquals(initCount+1,afterCount);
			
		System.out.println("=========게시판 번호=========>" + inData1.getBno()); 
	}
	
/*	@Test
	public void getBoardTest() {
		BoardVO getBoardVO = mapper.getBoard(3);
		log.info("\n=================>" + getBoardVO);
	}
*/	
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
		
		assertEquals(inData1, getVo); //BoardVO에 @Data를 사용하면 무조건 실패 
	}
	
	@Test
	public void getBoardListTest() {
		int allCnt = mapper.getCount();
		PageInfoVO pageInfo = new PageInfoVO(1, 10, allCnt);
		List<BoardVO> getList = mapper.getBoardList(pageInfo);
		for(BoardVO vo : getList ) {
			System.out.println("=============>" + vo);
		}
	}	
	
	@Test
	public void updateNdeleteBoardTest() {
		BoardVO inData1 = new BoardVO();
		inData1.setTitle("새로 입력한 자료 제목345");
		inData1.setContent("새로 입력해 넣은 컨텐츠 내용입니다~345");
		inData1.setWriter("뉴 작성자345");
		mapper.insertBoardGetBno(inData1); //새 내용 입력
		System.out.println(mapper.getBoard(inData1.getBno())); //수정전
		
		inData1.setContent("바뀐 내용입니다. 변경 후 컨텐츠내용");
		inData1.setTitle("바뀐 제목입니다");
		int result = mapper.updateBoard(inData1);
		assertEquals(result, 1);
		System.out.println(mapper.getBoard(inData1.getBno())); //수정후
		
		result  = mapper.deleteBoard(inData1.getBno());
		assertEquals(result, 1);
		
	}
	
}
