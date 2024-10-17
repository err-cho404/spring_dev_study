package kr.co.yangdoll.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yangdoll.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserDaoTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDao dao;
	
	UserVO vo;
	
	@Test
	@Ignore
	public void daoInjectionTest() {
		assertNotNull(dao);
	}
	
	@Test
	public void insertTest() {
		UserVO UserDataVo = new UserVO("ididid", "pwd1234", "choirum");
		
		int result = dao.userInsert(UserDataVo);	
		assertEquals(result, 1);
		UserVO getUser = dao.getUser(UserDataVo.getUserId());
		System.out.println(getUser);
		
		System.out.println("입력전 자료 \n" + UserDataVo);
		System.out.println("DB에 저장된 자료 \n" + getUser);
		assertEquals(UserDataVo.getUserId(), getUser.getUserId()); 
		assertEquals(UserDataVo.getUserPwd(), getUser.getUserPwd()); 
		assertEquals(UserDataVo.getUserName(), getUser.getUserName()); 
	}
	
	@Test
	public void getAllTest() {
		List<UserVO> list = dao.selectAll();
		for( int i = 0 ; i < list.size(); i = i + 1) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void UpdateTest() {
		List<UserVO> list = dao.selectAll();
		list.get(0).setUserName("바꾼이름");
		list.get(0).setUserPwd("changepwd");
		System.out.println("변경후 UserName========>" + list.get(0).getUserName());
		System.out.println("변경후 UserPwd========>" + list.get(0).getUserPwd());
		
		for( int i = 0 ; i < list.size(); i = i + 1) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void deleteUser() {
		List<UserVO> list = dao.selectAll();

//		dao.deleteUser(vo.getUserId("ididid"));
		dao.deleteUser(list.get(0).getUserId());
		
		for( int i = 0 ; i < list.size(); i = i + 1) {
			System.out.println(list.get(i));
		}
	}
}
