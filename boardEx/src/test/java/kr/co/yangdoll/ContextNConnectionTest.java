package kr.co.yangdoll;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ContextNConnectionTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactoryBean sessionFactoryBean;
	
	@Test
	public void beanCreateTest() {
		assertNotNull(context);
		assertNotNull(ds);
		assertNotNull(sessionFactoryBean);
	}
	
	@Test
	public void connectionTest() {
		Connection con = null;
		try {
			con = ds.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
