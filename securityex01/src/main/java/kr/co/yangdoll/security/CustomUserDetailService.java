package kr.co.yangdoll.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.co.yangdoll.domain.CustomUserVO;
import kr.co.yangdoll.domain.MemberVO;
import kr.co.yangdoll.mapper.MemberMapper;

@Component
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO vo = mapper.read(username);
		return vo == null ? null : new CustomUserVO(vo);
	}
	
}
