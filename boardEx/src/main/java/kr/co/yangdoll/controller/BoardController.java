package kr.co.yangdoll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.service.BoardService;
import kr.co.yangdoll.util.PageInfoVO;

@Controller
@RequestMapping(value = "/board/")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void/*String*/ list(int pageNum,int limit, Model model) {
//		int totalCount = service.getCount(); 아래에 바로 넣어서 구문 줄임
		PageInfoVO pageInfo = new PageInfoVO(pageNum,limit,/*totalCount*/service.getCount());
		
//		List<BoardVO> list = service.getBoardList(pageInfo); 아래에 바로 넣어서 구문 줄임
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list",/*list*/  service.getBoardList(pageInfo));
//		return "/board/list"; -> String 으로 쓸 때 필요
	}
	
	@RequestMapping("/yangdoll/*") // /뒤 뭐가 오든지 받음
	public void all(Model mo) {
		// 192.168.0.117/board/yangdoll/a로 요청하면 void는 /board/yangdoll/a로 매핑한다.
		// 192.168.0.117/board/yangdoll/b로 요청하면 void는 /board/yangdoll/b로 매핑한다.
		// 192.168.0.117/board/yangdoll/c로 요청하면 void는 /board/yangdoll/c로 매핑한다.
	}
	
	/* @RequestMapping(value = "/board/register" , method = RequestMethod.GET) */
	@GetMapping("/regform")
	public String registerForm() {
		return "/board/regform";
	}
	
	@RequestMapping(value = "/board/register" , method = RequestMethod.POST)
	@PostMapping(value = "register")
	public String register(BoardVO vo) {
		int result = service.insertBoard(vo, false);
		System.out.println(result + "개의 게시글이 입력 되었습니다");
		return "redirect:/board/list?pageNum=1&limit=10";
	}
	
	@RequestMapping("/get")
	public String getBoard(int bno, Model model) {
		model.addAttribute("vo",service.getBoard(bno));
		return "/board/detail";
	}
	
	@PostMapping("modify")
	public String modify(BoardVO vo, Model model) {
		int result = service.updateBoard(vo);
		BoardVO modifyVO = service.getBoard(vo.getBno());
		model.addAttribute("modifyVO", modifyVO);
		return "/board/modifyResult";
//		return "redirect:/board/list?pageNum=1&limit=10"; // DB에 추가했으니 list로 재접속해라
	}//잘못된 수정 방식 -> 조건(글쓴 작성자의 password 입력)없이 아무나 수정이 가능함 
	
	@RequestMapping("/boardVO")  //java script object 형태로(JSON)
	@ResponseBody
	public BoardVO rtnBoard() {
		System.out.println("============================");
		BoardVO vo = new BoardVO();
		vo.setContent("sdfsgsdgsdfassdgfgfgfdg");
		vo.setTitle("dsfg제목");
		vo.setWriter("김씨");
		vo.setBno(12345);
		System.out.println("=========" + vo);
		return vo;
	}
	
	@GetMapping("delete")
	public String deleteBoard(int bno, Model model) {
		int result = service.deleteBoard(bno);
		model.addAttribute("bno",service.deleteBoard(bno));
		return "/board/deleteInfo";
	}

/*	
	@RequestMapping("/boardVO")
	@ResponseBody
	public int rtnBoard() {
		System.out.println("============================");
		
		return 125;
	}
*/
}





