package kr.co.yangdoll.domain;

import java.util.Objects;

public class UserVO {
	 public String userId ;
	 public String userPwd ;
	 public String userName ;
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(String userId, String userPwd, String userName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, userPwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPwd, other.userPwd);
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + "]";
	}
	 
}
