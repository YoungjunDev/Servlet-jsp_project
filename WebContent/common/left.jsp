<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// common/left.jsp
	// include는 기존 내용 다 지워야 한다.
%>
<Script type="text/javascript">
function purchase(n) {
	location.href="/shop/GoodsListServlet";
}
function purchase2(n) {
	location.href="GoodsListServlet?gCategory=dress";
}
function purchase3(n) {
	location.href="GoodsListServlet?gCategory=outer";
}
function purchase4(n) {
	location.href="GoodsListServlet?gCategory=bottom";
}

</Script>
 


<div class="left">
		<div class="container">
			<h2>오늘의 발견</h2>
			<h5>| 엄선한 가장 Hot한 상품</h5>
			<div class="con1">
				<div class="fakeimg1">Image
					<div class="middle">
    					<div class="purchase"  onclick="javascript:purchase(this)">구매하기</div>
  					</div>
  				</div>
  			</div>
  			<div class="con2">
				<div class="fakeimg2">Image
					<div class="middle2">
    					<div class="purchase2" onclick="javascript:purchase2(this)">구매하기</div>
  					</div>
				</div>
			</div>
			
		</div>
		<div class="container">
			<h2>오늘의 쇼핑 제안</h2>
			<div class="con3">
				<div class="fakeimg3">Image
					<div class="middle3">
    					<div class="purchase3"  onclick="javascript:purchase3(this)">구매하기</div>
  					</div>
  				</div>
  			</div>
  			<div class="con4">
				<div class="fakeimg4">Image
					<div class="middle4">
    					<div class="purchase4" onclick="javascript:purchase4(this)">구매하기</div>
  					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<h2>지금 이 상품이 필요하신가요?</h2>
			<h5>예시 미니 프로젝트 </h5>
			<div class="fakeimg" style="height:200px">Image</div>
			<h5>1. 내용</h5>
				<p>이 내용은 아직 넣을 내용이 없어 대충 넣은 내용입니다.</p>
				<p>내용 1</p>
		</div>
	</div>