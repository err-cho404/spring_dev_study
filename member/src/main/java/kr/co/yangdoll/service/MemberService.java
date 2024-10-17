package kr.co.yangdoll.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yangdoll.vo.MemberVO;

public interface MemberService {

	int memberInsert(MemberVO vo);

	int memberDelete(String memId);

	List<MemberVO> getAll();

	MemberVO getOne(String memId);

	int loginProc(String memId, String memPwd, HttpServletRequest request);

	int logout(HttpServletRequest request);


}
