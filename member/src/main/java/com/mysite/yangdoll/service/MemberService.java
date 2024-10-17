package com.mysite.yangdoll.service;

import java.util.List;

import com.mysite.yangdoll.entity.Members;

public interface MemberService {
	public Members getMember(Integer memId);
	public List<Members> getMemberAll();
	public void updateMember(Members mem);
	public int registerMember(Members member);
	public void updateCondition();

	
}
