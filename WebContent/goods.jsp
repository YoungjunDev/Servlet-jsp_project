<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css?version2" />
<link rel="stylesheet" href="css/mobile.css" media="(max-width:480px)" />
<title></title>
</head>
<body>
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

<!-- todayImage  영역 -->
<!-- 
<section class="todayImage" style="height:450px">
	<jsp:include page="common/todayImage.jsp" flush="true" />
</section>
-->
<!-- main content 영역 -->
<div class="row">
	<jsp:include page="goods/goodsList.jsp" flush="true" />


<!-- sidebar content 영역 -->

</div>

<!-- foooter 영역 -->
<jsp:include page="common/footer.jsp" flush="true" />
</body>
</html>