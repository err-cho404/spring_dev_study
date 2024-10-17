package kr.co.yangdoll.dao;

import java.util.List;

import kr.co.yangdoll.vo.UserVO;

public interface UserDao {
	int userInsert (UserVO vo);
	int userPwdUpdate (String userId);
	int userNameUpdate (String userId);
	UserVO getUser (String userId);
	List<UserVO> selectAll();
	int deleteUser (String userId);
}
