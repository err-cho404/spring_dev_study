<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영페이지</title>
</head>
<body>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
	<nav class="navbar navbar-expand  navbar-dark bg-dark">  
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./home">Home</a>
            </div>
        </div>
    </nav> 
    <div class="jumbotron">  
        <div class="container">
            <h1 class="display-9">${greeting}</h1>
        </div>
    </div>
    <div class="container">   
        <div class="text-center">
            <h3>${strapline}</h3>
        </div>
    </div> 
    <footer class = "container">  
        <hr>
        <p>&copy; WebMarket</p>
    </footer> 
</body>
</html>