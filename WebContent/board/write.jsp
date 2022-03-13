<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기 화면</h3>
<form action="BoardWriteServlet" method="post">
제목:<input type="text" name="title"><br>
카테고리:<select><option value="">카테고리</select>
작성자:<input type="text" name="userid"><br>
내용:<textarea rows="10" cols="10" name="content"></textarea>
<input type="submit" value="저장">
</body>
</html>