<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 로그인 회원가입은 외부(common)에서 만들어서 include
%>

<h1>회원 등록 화면입니다.</h1>
<div class="top-menu">
	<jsp:include page="common/topMenu.jsp" flush="true" />
<jsp:include page="member/loginForm.jsp" flush="true" />
</body>
</html>