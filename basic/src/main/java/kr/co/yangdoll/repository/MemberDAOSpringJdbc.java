package kr.co.yangdoll.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.yangdoll.vo.MemberVO;
import lombok.NonNull;

@Repository
public class MemberDAOSpringJdbc implements MemberDAO{
	
	@Autowired
	JdbcTemplate template;
	
	RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO vo = new MemberVO();
			vo.setGrade(rs.getInt("Grade"));
			vo.setHireDate(rs.getString("HireDate"));
			vo.setLastDate(rs.getString("LastDate"));
			vo.setMemAddr(rs.getString("MemAddr"));
			vo.setMemEmail(rs.getString("MemEmail"));
			vo.setMemName(rs.getString("MemName"));
			vo.setMemPwd(rs.getString("MemPwd"));
			vo.setMemId(rs.getString("MemId"));
			return vo;
		}
	};
	
	@Override
	public int insertMember(MemberVO vo) {
		return template.update("insert into members values(?,?,?,?,?,sysdate,sysdate,1)",
				vo.getMemId(),
				vo.getMemPwd(),
				vo.getMemName(),
				vo.getMemEmail(),
				vo.getMemAddr()
				);
	}

	@Override
	public int deleteMemberAll() {
		// TODO Auto-generated method stub
		return template.update("delete from members");//test용
	}

	@Override
	public int getMemberCount() {//select count(*) from members
		// TODO Auto-generated method stub
		return template.queryForObject("select count(*) from members", Integer.class);
	}

	@Override
	public MemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		return template.queryForObject("select * from members where memId = ?",new Object[] {memId},rowMapper);
	}

	@Override
	public List<MemberVO> getALL() {
		// TODO Auto-generated method stub
		return template.query("select * from members order by memId",rowMapper);
	}

	@Override
	public int updateMember(MemberVO vo) {
		
		return template.update("update members set lastDate = sysdate, memAddr = ? where memId = ?",
				vo.getMemAddr(),vo.getMemId());
	}

	@Override
	public int delOne( String memId) {
		// TODO Auto-generated method stub
		return template.update("delete from members where memId = ?",memId);
	}
	
}