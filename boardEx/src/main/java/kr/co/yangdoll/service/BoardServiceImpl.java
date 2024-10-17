package kr.co.yangdoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.persistence.BoardMapper;
import kr.co.yangdoll.util.PageInfoVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

/*	
	public void setBoardMapper(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	} //boardMapper의 setter메서드->mybeans.xml에 property속성으로 만듦
*/
	
	@Override
	public int insertBoard(BoardVO vo, boolean selectKey) {
		if (selectKey) return boardMapper.insertBoardGetBno(vo);
		
		return boardMapper.insertBoard(vo);
	} //dao로 넘기기 전에 선행처리

	@Override
	public int deleteBoard(Integer bno) {
		return boardMapper.deleteBoard(bno);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardMapper.updateBoard(vo);
	}

	@Override
	public int getCount() {
		return boardMapper.getCount();
	}

	@Override
	public BoardVO getBoard(Integer bno) {
		return boardMapper.getBoard(bno);
	}


	@Override
	public List<BoardVO> getBoardList(PageInfoVO pageInfo) {
		return boardMapper.getBoardList(pageInfo);
	}

}
