package kr.co.yangdoll.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import kr.co.yangdoll.vo.MemberVO;
import lombok.NonNull;

public interface MemberDAO {

	int insertMember(MemberVO vo1);

	int deleteMemberAll();

	int getMemberCount();

	MemberVO getMember(String memId);

	List<MemberVO> getALL();

	int updateMember(MemberVO vo3);

	int delOne( String memId);

}
