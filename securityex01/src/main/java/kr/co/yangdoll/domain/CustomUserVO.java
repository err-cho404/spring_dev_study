package kr.co.yangdoll.domain;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUserVO extends User{
	
	private static final long serialVersionUID = 1L;
	private MemberVO member;

	public CustomUserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUserVO(MemberVO vo) { 
		super(	vo.getUserId(), vo.getUserPw(),
				vo.getAuthlist().stream().map(
						auth -> new  SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()) );
	 this.member = vo; 
	}

}
