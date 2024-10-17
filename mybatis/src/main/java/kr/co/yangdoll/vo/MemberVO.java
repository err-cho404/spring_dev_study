package kr.co.yangdoll.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MemberVO {
	@NonNull
	private String memId;  
	@NonNull
	private String memPwd;  
	@NonNull
	private String memName; 
	private String memEmail; 
	private String memAddr; 
	private String hireDate;
	private String lastDate;
	private int grade;
	public MemberVO(@NonNull String memId, @NonNull String memPwd, String memName, String memEmail, String memAddr) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memAddr = memAddr;
	}
	
}

