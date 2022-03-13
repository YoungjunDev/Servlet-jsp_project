<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// common/todayImage.jsp
	// include는 기존 내용 다 지워야 한다.
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	// div(.box2)를 누르거나 마우스 오버할때 이미지 이동
	$(document).ready(function(){
		$(".box1").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/drugstore.jpg");
		});
		
		$(".box2").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/sale.jpg");
		});
	
	
		$(".box3").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/3_days_special_price.jpg");
		});
		

		$(".box4").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/eletronic_products.jpg");
		});
		
		$(".box5").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/spring_products.jpg");
		});
	
		$(".box6").on("click mouseover",function(){
			$(".jb-a").attr("src", "images/todayimg/food.png");
		});
				
	});
	
</script>


<div class="todayimg">
	<img src="images/todayimg/drugstore.jpg" class="jb-a">
	<div class="todayimgcontroller">
		<div class="box1">메뉴1</div>
		<div class="box2">메뉴2</div>
		<div class="box3">메뉴3</div>
		<div class="box4">메뉴4</div>
		<div class="box5">메뉴5</div>
		<div class="box6">메뉴6</div>
	</div>
</div>