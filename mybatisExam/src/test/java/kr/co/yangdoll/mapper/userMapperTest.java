package kr.co.yangdoll.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class userMapperTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void userMapperDITest() {
		assertNotNull(mapper);
	}
	
	@Test
	public void userInsertTest() {
		UserVO testVo1 = new UserVO("test01", "testpwd01", "테스트1");
		UserVO testVo2 = new UserVO("test02", "testpwd02", "테스트둘");
		int result = mapper.addUser(testVo1);
		assertEquals(result, 1); //입력하는게 하나인가
		int count = mapper.getCount();
		assertEquals(count, 1); //입력후 전체 데이터가 1개인가
		
		result = mapper.addUser(testVo2);
		assertEquals(result, 1); //입력하는게 하나인가
		count = mapper.getCount();
		assertEquals(count, 2); //입력후 전체 데이터가 2개인가
		
		/*
		 * mapper.deleteUser(testVo1.getUserId());
		 * mapper.deleteUser(testVo2.getUserId());
		 */
	}
	
	@Test
	public void userModifyTest() {
		UserVO testVo1 = new UserVO("test01", "testpwd01", "테스트1");
		UserVO testVo2 = new UserVO("test02", "testpwd02", "테스트둘");
		int result = mapper.addUser(testVo1);
		assertEquals(result, 1); 
		int count = mapper.getCount();
		assertEquals(count, 1); 
		
		//변경된 자료 확인
		UserVO rtnVo = mapper.getOne(testVo1.userId); 
		assertNotEquals(rtnVo, testVo1); 
		
		
		result = mapper.addUser(testVo2); 
		assertEquals(result, 1); 
		count = mapper.getCount(); 
		assertEquals(count, 2);
		
		
		//변경되지 않았던 자료가 그대로 유지되는지를 반드시 확인 testVo2
		rtnVo = mapper.getOne(testVo2.userId); //testVo1 변경 후 testVo2를 가져와 확인
		assertEquals(rtnVo, testVo2); //기존testVo2데이터와 변경후 vo에 있는 testVo2의 자료를 비교
		
		/*
		 * mapper.deleteUser(testVo1.getUserId());
		 * mapper.deleteUser(testVo2.getUserId());
		 */
	}
	
	@Test(expected = Exception.class) //반드시 Exception 이 발생하는지 테스트
	public void exceptionTest() {
		UserVO testVo1 = new UserVO("test01", "testpwd01", "테스트1");
		int result = mapper.addUser(testVo1);
		UserVO testVo2 = new UserVO("test02", "testpwd02", "테스트둘");
		result = mapper.addUser(testVo2);
	}
}
