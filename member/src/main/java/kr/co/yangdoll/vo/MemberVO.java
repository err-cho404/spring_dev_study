package kr.co.yangdoll.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String memId;  
	private String memPwd;  
	private String memName; 
	private String memEmail; 
	private String memAddr; 
	private String hireDate;
	private String lastDate;
	private int grade;
}
