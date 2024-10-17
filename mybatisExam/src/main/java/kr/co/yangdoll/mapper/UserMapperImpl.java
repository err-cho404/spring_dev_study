package kr.co.yangdoll.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yangdoll.domain.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	SqlSession session;

	@Override
	public int addUser(UserVO vo) {		
		return session.update("kr.co.yangdoll.mapper.UserMapper.addUser",vo);
	}

	@Override
	public int deleteUser(String userId) {		
		return session.update("UserMapper.deleteUser",userId);
	}

	@Override
	public int modifyUser(UserVO vo) {		
		return session.update("UserMapper.modifyUser",vo);
	}

	@Override
	public UserVO getOne(String userId) {		
		return session.selectOne("UserMapper.getOne",userId);
	}

	@Override
	public List<UserVO> getAll() {		
		return  session.selectList("kr.co.yangdoll.mapper.UserMapper.getAll");
	}

	@Override
	public Integer getCount() {		
		return session.selectOne("kr.co.yangdoll.mapper.UserMapper.getCount");
	}

}
