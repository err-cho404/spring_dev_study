<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P><a href="/board/list?pageNum=1&limit=10">게시글보기</a></P>
<button id="getBoardBtn">5번자료 가져오기</button>
<div id="result"></div>
<script>
	$(document).ready(function(){
		$("#getBoardBtn").click(function(){
			let innerGetHTML = "";
			$.ajax({
				   url: "/data/getVo",
				   type: "GET",
				   dataType: "json", //서버로부터 넘겨받을 데이터 타입
				   contentType: "application/json",
				   data: {
				    	dataNum:5
				   },//서버로 전달할 데이터(key:value 형태의 객체 or String)
				   success : function(data) {
				    innerGetHTML += "<P> 게시글 내용 : "+ data['bno'] + "</P>";
					innerGetHTML += "<P> 제목 : "+ data['title'] + "</P>";
					innerGetHTML += "<P> 내용 : "+ data['content'] + "</P>";
					innerGetHTML += "<P> 작성자 : "+ data['writer'] + "</P>";
					innerGetHTML += "<P> 작성일 : "+ data['regdate'] + "</P>";
					$("#result").html(innerGetHTML);
				   }
			});
		});
	});
</script>
</body>
</html>
