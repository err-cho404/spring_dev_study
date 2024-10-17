package kr.co.yangdoll.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserVO {
	@NonNull
	private String  userId;
	private String  userPwd;
	private String  userName;
	public UserVO(@NonNull String userId, String userPwd, String userName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
}
