<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css?version9" />
<link rel="stylesheet" href="css/mobile.css" media="(max-width:480px)" />
<title>Insert title here</title>
</head>
<body>
<%
	// 로그인 회원가입은 외부(common)에서 만들어서 include
%>
<!-- menu 영역 (top)-->

<div class="top-menu">
	<jsp:include page="common/topMenu.jsp" flush="true" />
</div>


<!-- header 영역 -->

<div class="header">
	<jsp:include page="common/header.jsp" flush="true" />
</div>

<!-- navigator 영역 -->

<div class="nav">
	<jsp:include page="common/nav.jsp" flush="true" />
</div>

<!-- main content 영역 -->
<div class="row">
	<jsp:include page="goods/goodsRetrieve.jsp" flush="true" />
</div>	


<!-- foooter 영역 -->
<jsp:include page="common/footer.jsp" flush="true" />
</body>
</html>