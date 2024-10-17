package kr.co.yangdoll.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yangdoll.dao.MemberDAO;
import kr.co.yangdoll.vo.MemberVO;


@Service
public class MemberServiceJdbc implements MemberService{
	
	@Autowired
	private MemberDAO dao;

	@Override
	public int memberInsert(MemberVO vo) {
		int result = dao.memberInsert(vo);
		return result;
	}
	@Override
	public int memberDelete(String memId) {
		return dao.memberDelete(memId);
	}
	@Override
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	@Override
	public MemberVO getOne(String memId) {
		return dao.getMember(memId);
	}
	
	@Override
	public int loginProc(String memId, String memPwd, HttpServletRequest request) {
		// memId를 넘겨주면서 조회를 함
		MemberVO vo = dao.getMember(memId);
		// 결과를 받는다. => 결과가 null 이면 아이디가 잘못되었다.
/*		if(vo == null) {
			return 0; //아이디가 없을때, 입력자료가 오류가 있을 때 0반환
		}else { //입력한 아이디 있을 때
			if(vo.getMemPwd().equals(memPwd)) {//입력한 아이디에 비밀번호 일치
				return 1;
			}else {//입력한 아이디에 비밀번호 불일치
				return 0;
			}
		} */
		
		//짧게 변경 조기리턴을 이용한 조건문 -> 성능 문제를 해결할 수 있음
		if(vo != null && vo.getMemPwd().equals(memPwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("sesVO", vo);
			return 1;
		}
		return 0;
	
		// 결과가1명이라면 아이디는 맞음 => 비밀번호를 체크한다.
		// 비밀번호 까지 맞으면 로그인 성공
		// 비밀번호가 틀리면 아이디가 맞지만 비밀번호가 틀렸다는 신호를 줘야함.
	}
	@Override
	public int logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("sesVO", 0);
		return 0;
	}
	
}
