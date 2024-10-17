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
	<h1>수정결과</h1>
	번호 : ${modifyVO.bno} <br />
	제목 : ${modifyVO.title} <br />
	내용 : ${modifyVO.content} <br />
	작성자 : ${modifyVO.writer} <br />
	작성일 : ${modifyVO.regdate} <br />
	수정일 : ${modifyVO.updatedate} <br />
	
	<a href="/board/list?pageNum=1&limit=10">목록보기</a>
</body>
</html>