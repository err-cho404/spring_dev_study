package kr.co.yangdoll.security;

import org.springframework.security.crypto.password.PasswordEncoder;
//비밀번호를 암호화 하지 않고 db에 저장하고자 할 때(spring 5점대 이상인 버전에서 부터 의무적)
public class MyCustomNoOpPwEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();//암호를 변형 안하는 방식
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}
	
}
