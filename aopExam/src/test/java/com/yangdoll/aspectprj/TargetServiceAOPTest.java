package com.yangdoll.aspectprj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangdoll.aspectprj.advice.PerformanceAdvice;
import com.yangdoll.aspectprj.service.TargetService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TargetServiceAOPTest {
	
	@Autowired
	ApplicationContext context;

	@Autowired  //ctrl shift o ->임포트시 오류날때 
	TargetService target;
	
	@Test
	public void beanTest() {
		assertNotNull(context);
		assertNotNull(target);
	}
	
	@Test
	public void aopAroungExam() {
		String result = target.targetMethod2();
		assertEquals(result, "영구없다");
	}
	
	@Test
	public void aopBeforeExam() {
		String result = target.targetMethod2("DGFDGG","FDGDFG");
		assertEquals(result, "영구없다");
	}
	
	@Test
	public void aopAfterExam() {
		String result = target.targetMethod2("나의살던","고향은");
		assertEquals(result, "영구없다");
	}
	
}
