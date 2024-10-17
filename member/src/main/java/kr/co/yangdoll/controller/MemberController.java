package kr.co.yangdoll.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.yangdoll.service.MemberService;
import kr.co.yangdoll.vo.MemberVO;
import lombok.Value;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "memInsertForm")
	public String memInsertForm(){
		
		return"memInsertForm";
	}
	
	@RequestMapping(value = "memberInsert")
	public String memberInsert(MemberVO vo, Model model){
		int result = service.memberInsert(vo);
		model.addAttribute("result",result);
		model.addAttribute("message","가입");
		return "jobResult";
	}
	
	@RequestMapping(value = "memDeleteForm")
	public String memDeleteForm(){
		
		return"memDeleteForm";
	}
	
	//memberDelete?memId=아이디명
	@RequestMapping(value = "memberDelete")
	public String memberDelete(String memId, Model model) {
		int result = service.memberDelete(memId);
		model.addAttribute("result",result);
		model.addAttribute("message","탈퇴");
		return "jobResult";
	}	
	
	
	@RequestMapping("getAll") //value 생략 가능
	public String getAll(Model model) {
		List<MemberVO> list = service.getAll();
		model.addAttribute("list",list);  //jsp에서 작성할 경우 =>  request.setAttribute("list",list);
		return "memberList";
	}
	
	@RequestMapping(value = "getOne") //value 생략 가능
	public String getOne(String memId, Model model) {
		MemberVO vo =  service.getOne(memId);
		model.addAttribute("vo", vo);  
		return "mypage";
	}
	
	@PostMapping(value = "/login") //login 요청을 받아서
	public String loginProc(String memId,String memPwd, Model model, HttpServletRequest request) {
		int result = service.loginProc(memId,memPwd, request); //service에게 일을 시키고 할당을 통해 int result에 결과 저장
		if(result == 0) { //아이디나 비밀번호가 틀리거나 회원없을시
//			return "home"; -> 포워딩 으로 연결을 유지한다
			return "redirect:/"; //접두어 redirect가 붙음 -> "/"로 돌아가라는 새로운 요청으로 그전 요청연결은 끊김 jsp페이지로 연결해주는게 아닌 하나의 요청(value = "/login")같은 것이다.
		}
		//결과자료를 응답페이지에 전달
		model.addAttribute("result",result); 
		model.addAttribute("message","로그인");
		return "jobResult";
	}
	// 요청을 받아서 서비스에게 일을 시킨 후 결과를 응답페이지에 자료를 전달해주는 역할
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request){
		int result = service.logout(request);
		if(result == 0) {
		return "logout";
		}
		return "home";
	}
}
