<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
>>>>>>>>>>>${oList}
<c:set var="xxx" value="${oList}" />
<c:set var="userid" value="${xxx[0].userid}" />
<c:set var="orderName" value="${xxx[0].orderName}" />
<c:set var="post" value="${xxx[0].post}" />
<c:set var="addr1" value="${xxx[0].addr1}" />
<c:set var="addr2" value="${xxx[0].addr2}" />
<c:set var="phone" value="${xxx[0].phone}" />
<c:set var="payMethod" value="${xxx[0].payMethod}" />

<table width="70%" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30">
	</tr>
	<tr>
		<td><b>주문완료</b></td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center"><b>주문해주셔서 감사합니다.</b></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
<!--  -->
	<tr>
		<td class="td_default" align="center"><b>${userid}</b> 님의 주문이
			안전하게 처리되었습니다.</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>상품 및 배송정보</b>
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 받으시는 분</td>
					<td class="td_default" height="35">${orderName}</td>
				</tr>
				<tr>
					<td class="td_default" height="35"> 주소</td>
					<td class="td_default" height="35"> (${post})<br>
						${addr1}${addr2}
					</td>
				</tr>
				
				<tr>
					<td class="td_default" height="35"> 휴대전화</td>
					<td class="td_default" height="35"> ${phone}</td>
				</tr>
			</table>
	</tr>
	</td>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td width="250" class="td_default" height="35" align="center"><strong>상품명</strong></td>
					<td width="100" class="td_default" height="35" align="center"><strong>판매가</strong></td>
					<td class="td_default" width="50" height="35" align="center"><strong>수량</strong></td>
					<td class="td_default" width="100" height="35" align="center"><strong>합계</strong></td>
				</tr>
 		
   <!--  변수 선언 -->
   <c:forEach var="cart" items="${oList}">
    <!-- 누적 -->
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">${cart.gName}</span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">${cart.gPrice}</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">${cart.gAmount}</span>
					</td>
					<td height="35" class="td_default" align="center">
						<span>${cart.gAmount * cart.gPrice}</span>원
					</td>
				</tr>
</c:forEach>

			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>결제정보</b></td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 결제금액</td>
					<td class="td_default" height="35" align = 'right'> 
					<input type = 'text' id = 'total' value = '<%--sum --%>' readonly>원
					</td>
				</tr>
				<tr>
					<td class="td_default" width="150" height="35"> 결제수단</td>
					<td class="td_default" height="35" align = 'right'> 
					<span><%-- payMethod--%></span>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default" align="center"><a class="a_default"
			href="OrderListDetailServlet?mem_id=guest">주문조회 페이지로 이동</a></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

</table>