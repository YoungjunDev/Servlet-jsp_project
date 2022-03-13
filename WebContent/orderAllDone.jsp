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
	<jsp:include page="cart/orderAllDone.jsp" flush="true" />
</div>


<!-- foooter 영역 -->
<jsp:include page="common/footer.jsp" flush="true" />
</body>
</html>