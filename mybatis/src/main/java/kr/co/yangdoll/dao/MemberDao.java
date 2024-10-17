package kr.co.yangdoll.dao;

import java.util.List;

import kr.co.yangdoll.vo.MemberVO;

public interface MemberDao {
	List<MemberVO> selectAll();
	MemberVO selectGetId(String memId);
	int insertMember(MemberVO vo);
}
