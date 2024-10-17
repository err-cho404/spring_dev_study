<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<!-- 아래의 form내용은 로그인을 하지 않았을대 나와야하는 내용이다. 로그인 상태에서는 나오지 말아야함 or 다른 내용이 나와야함  -->
	<!-- form>input:text+br+input:password+br+button{로그인} -->

		<c:if test="${empty sesVO}"> <%-- <c:when test="${sesVO == null}">  --%>
			<p>로그인 하지 않은 상태</p>
			<form action="/login" method="post">
				<input type="text" name="memId" id="" placeholder="user id" required="required"/><br />
				<input type="password" name="memPwd" id="" placeholder="user password" required/><br />
				<button>로그인</button>
			</form>
		</c:if>
		<c:if test="${!empty sesVO}">
			<p>로그인한 상태</p>
			<p>${sesVO.memId} </p>
      		<p>${sesVO.memPwd} </p>
      		<p><a href="./logout">로그아웃</a></p>
		</c:if>
		<c:if test="${sesVO.grade >= 5}"> <!-- grade가 5일때 관리자라고 가정 -->
			<p>관리자 로그인되었습니다.</p>
			<!-- 아래는 관리자만 볼 수 있는 내용 -->
			<a href="/getAll">전체회원보기</a>
		</c:if>
		<p>기본정보들 나옴001</p>
		<p>기본정보들 나옴002</p>
		<p>기본정보들 나옴003</p>
</body>
</html>
