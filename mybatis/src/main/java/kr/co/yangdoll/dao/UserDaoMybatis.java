package kr.co.yangdoll.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yangdoll.vo.UserVO;

@Repository
public class UserDaoMybatis implements UserDao{
	
	@Autowired
	SqlSession session;
	
	@Override
	public int userInsert(UserVO vo) {
		
		return session.insert("UserMapper.insertUser",vo);
	}

	@Override
	public int userPwdUpdate(String userId) {
		
		return session.update("UserMapper.updatePwd",userId);
	}

	@Override
	public int userNameUpdate(String userId) {
		
		return session.update("UserMapper.updateName",userId);
	}

	@Override
	public UserVO getUser(String userId) {
		
		return session.selectOne("UserMapper.selectaGetId",userId);
	}

	@Override
	public List<UserVO> selectAll() {
		
		return session.selectList("UserMapper.selectaGetAll");
	}
	
	
	@Override
	public int deleteUser(String userId) {
		
		return session.delete("UserMapper.deleteUser", userId);
	}

}
