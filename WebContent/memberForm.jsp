<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css?version8" />
<link rel="stylesheet" href="css/mobile.css" media="(max-width:480px)" />
<title>Insert title here</title>
</head>
<body>
<%
	// 로그인 회원가입은 외부(common)에서 만들어서 include
%>
<div class="top-menu">
	<jsp:include page="common/topMenu.jsp" flush="true" />
</div>

<h1>회원 등록 화면입니다.</h1>
<hr>
<jsp:include page="member/memberForm.jsp" flush="true" /> 
</body>
</html>