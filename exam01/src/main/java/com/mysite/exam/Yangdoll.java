package com.mysite.exam;

import java.lang.reflect.Method;
import java.util.List;

import com.mysite.entity.Employee;

public class Yangdoll {
	
	public List<Employee> findByEmpName(String empName){
		return null;
	}
	
	public List<Employee> findByEmpNameAndEmpAddress(String empName,String empAddress){
		return null;
	}
	
	public List<Employee> findByEmpNameGreaterThanEqualAndEmpNameLessThanEqual(String start, String end){
		return null;
	}
	
//	public void methodListPrint() {
//		Method[] methods = this.getClass().getDeclaredMethods();
//		int i = 0;
//		for(Method m : methods) {
//			i=i+1;
//			String methodName = i + "번째 메서드 이름 : " + m.getName();
//			String methodName = m.getName().substring(6);
//			System.out.println(methodName);
//			System.out.println(methodName instanceof String); //methodName가 문자열이냐
//		}
//	}
}
