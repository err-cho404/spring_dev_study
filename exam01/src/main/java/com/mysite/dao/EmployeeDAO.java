package com.mysite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mysite.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByEmpName(String empName);
	
	public List<Employee> findByEmpNameAndEmpAddress(String empName,String empAddress);
	// select * from employee where empName=? and empAddress=?

	public List<Employee> findByEmpNameGreaterThanEqualAndEmpNameLessThanEqual(String start, String end);
	
//	public List<Employee> findByEmpNameLessThanEqual(String empName);
	//select * from employee where empName =< ?
	
	//한글로만 이름이 된 사람 추출 쿼리문
	//select * from employee where empName >= 'ㄱ' and empName =< '힣';
	//findByEmpNameGreatThanEqualAndLessThanEqual(String empName,String empName)
	//select * from employee where empName between 'ㄱ' with '힣';
	//findByEmpNameBetween(String empName,String empName)
	
	//JPQL => Java Persistence Query Language -> 동적쿼리 만들때 필요, 일반 쿼리랑 다름
	
}
