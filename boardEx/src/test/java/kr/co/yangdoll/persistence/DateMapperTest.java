package kr.co.yangdoll.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DateMapperTest {
	
	@Autowired
	ApplicationContext context;
	
	//테스트 하고자하는 클래스를 필드로 선언(클래스 상위 인터페이스가 있다면 인터페이스 타입으로 설정 -> mybatis는 인터페이스만 있음)
	@Autowired
	DateMapper datemapper;
	
	@Test
	public void dateMapperDITest() {
		assertNotNull(datemapper);
		System.out.println("=============" + datemapper.getClass().getName());
	}
	
	@Test
	public void getServerDateTest() {
		String serverDate = datemapper.getServerDate();
		System.out.println("=============>" + serverDate);
	}
	
	@Test
	public void getServerDate2Test() {
		String serverDate = datemapper.getServerDate2();
		System.out.println("=============>" + serverDate);
	}
}
	