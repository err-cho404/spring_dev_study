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
	<h1>전체 회원 명부</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
		<c:forEach var="member" items ="${list}">	
			<tr>
				<td><a href="./getOne?memId=${member.memId}">${ member.memId } </td></a>
				<td><a href="./getOne?memId=${member.memId}">${ member.memName } </td></a>
				<td>${ member.memEmail } </td>
				<td>${ member.memAddr } </td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>