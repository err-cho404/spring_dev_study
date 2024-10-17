package com.mysite.yangdoll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mysite.yangdoll.entity.Members;

public interface MemberRepository extends JpaRepository<Members, Integer>{
	
	@Query (value = "UPDATE members SET grade = grade+1 where count >= 10", nativeQuery = true)// ->이 대신에 jpql쿼리를 써야함
	public void updateConditionalAll();
	
}
