package kr.co.yangdoll.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.yangdoll.domain.AuthVO;
import kr.co.yangdoll.domain.MemberVO;


public interface MemberMapper {
	public MemberVO read(String userId);
	
	@Insert("insert into tbl_member(userId,userPw,userName) values(#{userId},#{userPw},#{userName})")
	public void insertMember(MemberVO voMem);
	
	@Insert("insert into tbl_member_auth(userId,auth) values(#{userId},#{auth})")
	public void insertAuth(AuthVO voAut);
}
