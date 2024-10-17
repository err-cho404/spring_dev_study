package kr.co.yangdoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yangdoll.dao.MemberDAO;
import kr.co.yangdoll.vo.MemberVO;

//@Service
public class MemberServiceJdbcUpdate implements MemberService{
	@Autowired
	private MemberDAO dao;

	@Override
	public int memberInsert(MemberVO vo) {
		System.out.println(vo);
		return dao.memberInsert(vo);
		
	}
	@Override
	public int memberDelete(String memId) {
		System.out.println("======================");
		System.out.println(memId);
		int result =  dao.memberDelete(memId);
		return result;
	}
}
