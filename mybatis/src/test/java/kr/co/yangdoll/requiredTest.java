package kr.co.yangdoll;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class requiredTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Test
	public void contextTest() {
		assertNotNull(context);
	}
	
	@Test
	public void findeAllBean() {
		String [] beanList = context.getBeanDefinitionNames();
	    for( String beanName : beanList) {
	    	System.out.println("==>" + beanName);
	    }
	}	 
	
	@Test
	public void connectionTest() {
		assertNotNull(ds);
		try {
			Connection con = ds.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
