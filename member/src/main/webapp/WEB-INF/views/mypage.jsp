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
	<h1>My Page</h1>
	
	<p>아이디 : ${vo.getMemId()} </p>
	<p>비밀번호 : ${vo.getMemPwd()}</p>
	<p>이름 : ${vo.memName}</p>
	<p>이메일 : ${vo.memEmail}</p>
	<p>주소 : ${vo.memAddr}</p>
	<p>가입일 : ${vo.hireDate}</p>
	<p>최근접속일 : ${vo.lastDate}</p>
</body>
</html>