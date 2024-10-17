package com.yangdoll.aspectprj;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangdoll.aspectprj.annoadvice.AnnoAdviceTest;
import com.yangdoll.aspectprj.annoservice.AnnoTargetOne;
import com.yangdoll.aspectprj.annoservice.AnnoTargetTwo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class annoAOPTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	AnnoAdviceTest annoadviceTest;
	
	@Autowired
	AnnoTargetOne one;
	
	@Autowired
	AnnoTargetTwo two;
	
	@Test
	public void beanTest() {
		assertNotNull(annoadviceTest);
		assertNotNull(one);
		assertNotNull(two);
	}
	
	@Test
	public void methodExeTest() {
		one.me1();
		System.out.println("============================");
		try {
		one.me5();
		}catch (Exception e){
			
		}
	}

	@Test
	public void varExec() {
		var name = "a";
		System.out.println(name + 60);
		name = "300";
		System.out.println(name + 60);
	}
}
