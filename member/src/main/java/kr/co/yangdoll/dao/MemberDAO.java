package kr.co.yangdoll.dao;

import java.util.List;


import kr.co.yangdoll.vo.MemberVO;

public interface MemberDAO {

	int memberInsert(MemberVO vo);

	int memberDelete(String memId);

	List<MemberVO> getAll();

	MemberVO getMember(String memId);

}
