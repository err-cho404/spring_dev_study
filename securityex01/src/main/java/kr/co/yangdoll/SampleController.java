package kr.co.yangdoll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample/*")
public class SampleController {
	
	//-> AuthenticationSuccessHandler 로그인 성공시 이동 페이지 제어 가능
	
	
	@GetMapping("/all")
	public String all() {
		return "/sample/all/allpage1";
	}
	
	@GetMapping("/member")
	public String member() {
		return "/sample/member/mempage1";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "/sample/admin/adminpage1";
	}
}
