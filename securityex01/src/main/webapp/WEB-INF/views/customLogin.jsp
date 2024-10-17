<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String result=request.getSession().getId();
%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand  navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인 페이지</h1>
		</div>
	</div>
	<div class="container">
		<br/>
		<br/>
		<form class="form-horizontal" action="/yangdoll/login" method="post">
			<fieldset>
				<legend>로그인 정보 입력창</legend>
				<div class="form-group row">
					<label class="col-sm-2 control-label">ID</label>
					<div class="col-sm-3">
						<input type="text" name="username" class="form-control" required="required"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-3">
						<input type="password" name="password" class="form-control"  required="required"/>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="login" />
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>