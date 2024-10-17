<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>상세 게시글 보기</h1>
	<form action="/board/modify" method="post" id="actionForm">
		게시글 번호 : <input type="text" name="bno" value="${vo.bno}" readonly="readonly" /><br />
		
		제목 : <input type="text" name="title" value="${vo.title}" /><br />
		내용 : <br />
		<textarea name="content" cols="30" rows="10">${vo.content}</textarea><br />
		
		작성자 : <input type="text" name="writer" value="${vo.writer}" /><br />
		
		작성일 : <input type="text" value="${vo.regdate}" readonly="readonly" /><br />
		
		최근 수정일 : <input type="text" value="${vo.updatedate}" readonly="readonly" /><br />	
	</form>
		<button class="modifySubmit">수정하기</button>
		<button class="deleteSubmit">삭제하기</button>
		<button class="listView">목록보기</button>
	<script>
		$('.modifySubmit').click(function(){
			$('#actionForm').submit();
		});
		$('.listView').click(function(){
			self.location = "/board/list?pageNum=${pageInfo.pageNum}&limit=${pageInfo.limit}";
		});
		
		$('.deleteSubmit').click(function(){
			self.location = "/board/delete?bno=${vo.bno}";
		});
	</script>
</body>
</html>