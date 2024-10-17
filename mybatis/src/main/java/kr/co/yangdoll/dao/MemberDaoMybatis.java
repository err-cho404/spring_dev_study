package kr.co.yangdoll.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yangdoll.vo.MemberVO;

@Repository
public class MemberDaoMybatis implements MemberDao {
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<MemberVO> selectAll() {
		
		return session.selectList("MemberMapper.selectAll");
	}

	@Override
	public MemberVO selectGetId(String memId) {
		
		return session.selectOne("MemberMapper.selectGetId",memId);
	}

	@Override
	public int insertMember(MemberVO vo) {
	
		return session.update("MemberMapper.insertMember",vo);
	}

}
