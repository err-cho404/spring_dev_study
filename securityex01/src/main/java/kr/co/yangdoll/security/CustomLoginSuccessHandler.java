package kr.co.yangdoll.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("successHandler")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		List<String> roleName = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			roleName.add(authority.getAuthority());
		});

		String contextpath="/yangdoll";  //인터페이스에 만들어주면 모든 곳에서 활용가능해서 더 좋음
		if(roleName.contains("ROLE_ADMIN")) {
			response.sendRedirect(contextpath+"/sample/admin");
			return;
		}
		
		if(roleName.contains("ROLE_MEMBER")) {
			response.sendRedirect(contextpath+"/sample/member");
			return;
		}
		response.sendRedirect(contextpath);
	}

}
