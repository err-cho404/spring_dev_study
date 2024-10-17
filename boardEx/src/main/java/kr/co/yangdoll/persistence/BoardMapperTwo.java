package kr.co.yangdoll.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.yangdoll.domain.BoardVO;
import kr.co.yangdoll.domain.SearchVO;

public interface BoardMapperTwo {
	/* BoardVO getMultiConBoard(SearchVO vo); */
	
	BoardVO getMultiConBoardTwo(HashMap hm);
	
	BoardVO getMultiConBoardThree(@Param("searchNum") int searchNum, @Param("searchTitle") String searchTitle);
	
	int addBoard(BoardVO vo);
	
	List<BoardVO> getConditionWhereList(HashMap svo);
	
	List<BoardVO> getConditionTrimList(HashMap svo);
	
	int updateBoard(BoardVO vo);
}
