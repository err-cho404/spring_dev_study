package kr.co.yangdoll.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.yangdoll.vo.MemberVO;


@Repository
public class MemberDAOJdbc implements MemberDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<MemberVO> RowMapper = new RowMapper<MemberVO>() {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO vo = new MemberVO();
			vo.setHireDate(rs.getString("HireDate"));
			vo.setLastDate(rs.getString("LastDate"));
			vo.setMemAddr(rs.getString("MemAddr"));
			vo.setMemEmail(rs.getString("MemEmail"));
			vo.setMemId(rs.getString("MemId"));
			vo.setMemName(rs.getString("MemName"));
			vo.setMemPwd(rs.getString("MemPwd"));
			vo.setGrade(rs.getInt("Grade"));
			return vo;
		}
	};

	@Override
	public int memberInsert(MemberVO vo) {
		String sql = "insert into members values (?,?,?,?,?, sysdate, sysdate,?)";
		int result = jdbcTemplate.update(sql,
				vo.getMemId(),
				vo.getMemPwd(),
				vo.getMemName(),
				vo.getMemEmail(),
				vo.getMemAddr(),
				vo.getGrade()
		);
		return result;
	}
	@Override
	public int memberDelete(String memId) {
		String sql = "delete from members where memId = ?";
		int result = jdbcTemplate.update(sql,memId);
		return result;
	}
	
	@Override
	public List<MemberVO> getAll() {
		 return jdbcTemplate.query( "select * from members",RowMapper);
	}
	
	@Override
	public MemberVO getMember(String memId) {			
		MemberVO vo = null; //처리시 문제없다면
		try { //저장된 자료 반환
			vo = jdbcTemplate.queryForObject("select * from members where memId = ? ",new Object[] {memId}, RowMapper);
		}catch (EmptyResultDataAccessException e) {
			return null; //문제가 있으면 null반환
		}
		return vo;
	}


}

