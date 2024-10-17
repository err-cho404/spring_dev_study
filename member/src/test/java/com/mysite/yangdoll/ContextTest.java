package com.mysite.yangdoll;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ContextTest {
	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void objTest() {
		assertNotNull(context);
		String[] beanNames = context.getBeanDefinitionNames();
		for(int i=0; i < beanNames.length ; i=i+1) {//for(String name : beanNames){
			System.out.println("============"+beanNames[i]);
		}
	
	}
}
