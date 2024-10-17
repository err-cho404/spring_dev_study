package kr.co.yangdoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yangdoll.domain.MemberVO;
import kr.co.yangdoll.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberVO getMember(String userId) {
		return mapper.read(userId);
	}

}
