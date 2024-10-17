package kr.co.yangdoll;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ContextAndConnectionTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	SqlSessionFactoryBean sessionFactoryBean;
	
	@Test
	public void contextDataSourceDiTest() {
		assertNotNull(context);
		assertNotNull(ds);
	}
	
	@Test
	public void connectionTest() {
		Connection con = null;
		try {
			con = ds.getConnection();
			assertNotNull(con);
			System.out.println(con + "=================");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void mybatisEnvTest() {
		assertNotNull(sqlSession);
		assertNotNull(sessionFactoryBean);
	}
	
}

