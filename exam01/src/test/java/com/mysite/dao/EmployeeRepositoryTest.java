package com.mysite.dao;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.entity.Employee;
import com.mysite.exam.Yangdoll;

@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeDAO dao;
	
	@Test
	public void insertTest() {
		Employee insertSampleData = new Employee();
		insertSampleData.setEmail("aaaa");
		insertSampleData.setEmpid(1);
		insertSampleData.setEmpAddress("suwon");
		insertSampleData.setEmpName("나일등");
		System.out.println(insertSampleData + "====================");
		Employee result = dao.save(insertSampleData);
		System.out.println("입력한 정보 : " + result);
	}
	
	@Test
	public void findEmpTest() {
		Employee result = dao.findById(2).get();
	
		System.out.println(result.getEmail());
		System.out.println(result.getEmpAddress());
		System.out.println(result.getEmpName());
		System.out.println(result.getEmpid());
		
		List<Employee> emplist = dao.findAll();
		System.out.println(emplist);
		for(int i=0 ; i<=emplist.size() ; i=i+1) {
			
		}
	
	}
	@Test
	public void findEmpNameTest() {
		System.out.println(dao.findByEmpName("홍나무").get(0));
	}
	
	@Test
	public void methodPrintResult() {
		Yangdoll obj = new Yangdoll();
		Method[] methods = obj.getClass().getDeclaredMethods();
		int i = 0;
		for(Method m : methods) {
			i=i+1;
			String methodName = m.getName().substring(6);
			System.out.println(methodName);
		}
	}
}
