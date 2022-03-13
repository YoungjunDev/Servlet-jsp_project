<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록보기</h2>
<table border="1">
   <tr>
    <th>번호</th>
   	<th>글번호</th>
   	<th>제목</th>
   	<th>카테고리</th>
   	<th>작성자</th>
   	<th>작성일</th>
   	<th>조회수</th>
   </tr>
 <c:forEach var="dto" items="${listAll}" varStatus="status">
	<tr>
	 <td>${status.count}</td>
	 <td>${dto.num}</td>
<!-- <td><a href="BoardRetrieveServlet?num=${dto.num}">${dto.title}</a></td> -->
	 <td>${dto.title}</td>
	 <td>${dto.scategory}</td>
	 <td>${dto.userid}</td>
	 <td>${dto.writeday}</td>
	 <td>${dto.readcnt}</td>
	</tr>
</c:forEach>
</table>
   
   
   
</table>
<a href="BoardWriteUIServlet">글쓰기</a>
</body>
</html>