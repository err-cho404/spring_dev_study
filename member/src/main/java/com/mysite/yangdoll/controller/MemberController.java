package com.mysite.yangdoll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.yangdoll.entity.Members;
import com.mysite.yangdoll.service.MemberService;


@Controller //restcontroller사용하면 보기편하게 사용가능
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/list")
//	@ResponseBody
	public String list(Model model){
		model.addAttribute("member", service.getMemberAll());
		return "MemberList";
	}
	
	@GetMapping("/listjson")
	@ResponseBody
	public List<Members> listjson(){
		return service.getMemberAll();
	}
}
