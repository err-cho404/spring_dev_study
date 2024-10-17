package kr.co.yangdoll.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	
	List<AuthVO> authlist;
}
