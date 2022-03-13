<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script type="text/javascript">
 /////////////////////////////////////////////
    var httpRequest;
    var global_num;
 
	function amountUpdate(num){
		httpRequest = new XMLHttpRequest();
		console.dir(httpRequest);
		
		//요청시 응답처리하는 함수 호출
		httpRequest.onreadystatechange=responseFun;

		
		global_num = num;
		var input_amount = document.querySelector("#cart_amount"+num);
		var amount = input_amount.value;
		var url = `GoodsCartUpdateServlet?num=\${num}&amount=\${amount}`;
		httpRequest.open("get",url,true);  
		httpRequest.send(null);  
	}	

	function responseFun(){
	    if(httpRequest.readyState==4 && httpRequest.status == 200){
	    	alert("갯수 수정 성공");
	    	var price = document.querySelector("#cart_price"+global_num).innerText;
	    	var amount = document.querySelector("#cart_amount"+global_num).value;
	        document.querySelector("#sum"+global_num).innerText = price * amount;
	    }
	}
/////////////////////////////////////////////	
    function delCart(num){
    	event.preventDefault();
    	console.log("delCart", num);
      	location.href=`GoodsCartDelServlet?num=\${num}`;
//    	location.href="GoodsCartDelServlet?num="+num;
    	
    }
    function allCheck(){
		var allCheck = document.querySelector("#allCheck");
		console.log(allCheck.checked);
		
		var chk = document.querySelectorAll(".check");  // 
		chk.forEach(function(data,idx){	
			console.log(idx, data);
			data.checked=allCheck.checked;
		});
   }
 
   function delAllCart(f){

	   f.action="GoodsCartDelAllServlet";
	   f.method="get";
	   f.submit();
   }
   function delAllCart2(){
	
	   var f = document.querySelector("form");
	   f.action="GoodsCartDelAllServlet";
	   f.method="get";
	   f.submit();
   }
    
   function order(num){
	   
	   location.href=`GoodsOrderConfirmServlet?num=\${num}`;
   }
   
   function orderAllConfirm(f){
	   f.action="GoodsOrderAllConfirmServlet";
	   f.method="get";
	   f.submit();
   }
     
 </script>
<table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck" onclick="allCheck()"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
<c:forEach var="dto" items="${cartList}" varStatus="status">		
		 <input type="text" name="num" value="${dto.num}" id="${dto.num}">
		<input type="text" name="gImage" value="${dto.gImage}" id="gImage">
		 <input type="text" name="gName" value="${dto.gName}" id="gName">
		  <input type="text" name="gSize" value="${dto.gSize}" id="gSize">
		   <input type="text" name="gColor" value="${dto.gColor}" id="gColor"> 
		   <input type="text" name="gPrice" value="${dto.gPrice}" id="gPrice">
		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check${dto.num}" class="check" value="${dto.num}"></td>
			<td class="td_default" width="80">${dto.num}</td>
			<td class="td_default" width="80"><img
				src="images/items/${dto.gImage}.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'>제나 레이스 스커트
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${dto.gSize})
					, 색상(${dto.gColor})]
			</font></td>
			<td class="td_default" align="center" width="110">
			<span id="cart_price${dto.num}">${dto.gPrice}</span>
						</td>
			<td class="td_default" align="center" width="90">
			
			
			<input
				class="input_default" type="text" name="cart_amount"
				id="cart_amount${dto.num}" style="text-align: right" maxlength="3"
				size="2" value="${dto.gAmount}" data-amount="xxx"></input>
	
				</td>
			<td>
			
			
			<input type="button" value="수정"   
			onclick="amountUpdate(${dto.num})" />
				
				
				</td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'>
				<span id="sum${dto.num}">
				${dto.gPrice * dto.gAmount}
				</span></td>
			<td><input type="button" value="주문"
				onclick="order(${dto.num})"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'><input type="button" value="삭제"
				onclick="delCart('${dto.num}')"></td>
			<td height="10"></td>
		</tr>
</c:forEach>
	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="javascript:delAllCart(myForm)"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="delAllCart2()">전체 삭제하기2</button>
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>