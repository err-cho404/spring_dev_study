package kr.co.yangdoll.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.domain.SearchVO;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTwoTest {
		
		@Autowired
		ApplicationContext context;
		
		@Autowired
		BoardMapperTwo mtwo;
		
		@Test
		public void beanTest() {
			assertNotNull(context);
		}
/*		
		@Test //비권장
		public void getMultiConBoardTest() {
			SearchVO vo = new SearchVO();
			vo.setSearchNum(10);
			vo.setSearchTitle("aaa");
			System.out.println(mtwo.getMultiConBoard(vo));
		}
*/		
		
		@Test
		public void getMultiConBoardTwoTest() {
			HashMap<String,Object> data = new HashMap();
			data.put("searchNum", 10);
			data.put("searchTitle", "aaa");
			System.out.println("=====>" + mtwo.getMultiConBoardTwo(data));
		}
		
		@Test
		public void getMultiConBoardThreeTest() {
			System.out.println("===333=====>" + mtwo.getMultiConBoardThree(10,"aaa"));
		}
		
		@Test
		public void getConditionWhereListTest() {
			HashMap vo = new HashMap();
			vo.put("searchTitle", null);
			vo.put("searchNum", null);
			List<BoardVO> list = mtwo.getConditionWhereList(vo);
			System.out.println("############## => " + list.size());
		}
		@Test
		public void getConditionTrimListTest() {
			HashMap vo = new HashMap();
			vo.put("searchTitle", "아");
			vo.put("searchNum", 10);
			List<BoardVO> list = mtwo.getConditionTrimList(vo);
			System.out.println("############## => " + list.size());
		}

/*		@Test
		public void updateBoard() {
			BoardVO vo = new BoardVO();
			vo.setTitle("새title");
			vo.setContent("새Contents 내용 입력하는 중~~~~~");
			vo.setWriter("새Writer");
			mtwo.updateBoard(vo);

			System.out.println("==================>" + mtwo.getBno());
		}
*/
}
