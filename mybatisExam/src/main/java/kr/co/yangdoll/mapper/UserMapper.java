package kr.co.yangdoll.mapper;

import java.util.List;

import kr.co.yangdoll.domain.UserVO;

public interface UserMapper {
	int addUser(UserVO vo);
	int deleteUser(String userId);
	int modifyUser(UserVO vo);
	UserVO getOne(String userId);
	List<UserVO> getAll();
	Integer getCount();
}
