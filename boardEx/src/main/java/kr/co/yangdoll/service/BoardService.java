package kr.co.yangdoll.service;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.util.PageInfoVO;

@Component
public interface BoardService {
	int insertBoard(BoardVO vo, boolean selectKey);
	
	/* int insertBoardGetBno(BoardVO vo); */
	
	int deleteBoard(Integer bno);
	
	int updateBoard(BoardVO vo);
	
	int getCount();
	
	BoardVO getBoard(Integer bno);
	
	List<BoardVO>getBoardList(PageInfoVO pageInfo);
	
}
