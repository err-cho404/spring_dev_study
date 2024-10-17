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
	<form action="./memberDelete" method="get">
		삭제할 아이디 입력 : <input type="text" name="memId" required="required"/><br />
		<button>탈퇴</button>
	</form>
</body>
</html>