<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./memberInsert" method="post">
		아이디 : <input type="text" name="memId" required="required"/><br />
		비밀번호 : <input type="password" name="memPwd" required="required"/><br />
		회원명 : <input type="text" name="memName" required="required"/><br />
		Email : <input type="email" name="memEmail"/><br />
		주소 : <input type="text" name="memAddr"/><br />
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>