package kr.co.yangdoll.controller;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.persistence.BoardMapper;
import kr.co.yangdoll.service.BoardService;

@RestController  //이 안의 모든 데이터를 json형태로 반환하겠다. @responsebody 가 기본적으로 들어가있다고 보면된다.
@RequestMapping("/data/*")
public class BoardDataController {
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/getString", method = RequestMethod.GET)
	public String getString() {
		return "나는 data폴더의 getString.jsp파일 입니다";   //  경로 : /data/getString
	}
	
	@GetMapping("/getVo")
	public BoardVO getVo(Integer dataNum, HttpServletRequest request) {
		System.out.println("접속자ip => " + request.getRemoteAddr());
		return service.getBoard(dataNum);
/*		
		BoardVO vo = new BoardVO();
		vo.setBno(123456);
		vo.setTitle("하나짜리 객체 제목");
		return vo;     경로 : /data/getVo
*/
	}

	
	@GetMapping("/getListVo")
	public List<BoardVO> getListVo() {
		  List<BoardVO> list = new Vector<BoardVO>(); //Vector 는 기본적으로 스레드 지원
		  	//arraylist는 메서드로 스레드 추가해주면 된다. 
		  BoardVO vo = new BoardVO(); vo.setBno(100);
		  vo.setTitle("첫번째 제목"); 
		  list.add(vo); vo = new BoardVO(); 
		  vo.setBno(200);
		  vo.setTitle("두번째 제목"); 
		  vo.setContent("두번째 글의 내용이다."); 
		  list.add(vo);
		 
		return list;   
	}
	
	@RequestMapping("/getVoResponEntity")
	public ResponseEntity<BoardVO> getVoResponEntity() { //ResponseEntity 조건에따라 상태값을 전달 추가해야할 경우에
		BoardVO vo = new BoardVO();
		vo.setBno(120);
		vo.setTitle("이 자료는 DB에서 가져온 현재의 자료");
		vo.setContent("dsffds내용입니다");
		vo.setWriter("박씨");
		
		ResponseEntity<BoardVO> result = null;
		if(vo.getBno() < 100) { // 요청한 조건, 결과에 따라서 판단
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@RequestMapping("/proc/{tableName}/{tNo}")  // data/proc/member/1     data/proc/board/100   
	public String[] getPath(@PathVariable("tableName") String tableName, @PathVariable("tNo") String tNo) {
		return new String[] {"tableName : " + tableName, "tNo : " + tNo};
	}
	
	//예전 방식
	@GetMapping("/procOld")  // data/procOld?tableName=member&tNo=1
	public String[] getOld(String tableName, String tNo) {
		return new String[] {"tableName : " + tableName, "tNo : " + tNo};
	}
	
	// @PutMapping("") public void aaa() {}   ->update용도
	// @DeleteMapping("") public void bbb() {}   ->delete용도
	// @GetMapping("") public void ccc() {}  ->select용도
	// @PostMapping("") public void ddd() {}   ->insert용도
}






