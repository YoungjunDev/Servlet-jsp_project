<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function sameAddress(n) {
		console.log(n, n.checked);
		  if(n.checked){
			  var mname = document.querySelector("#mname").value;
			  document.querySelector("#orderName").value = mname;
			  var mpost = document.querySelector("#mpost").value;
			  document.querySelector("#post1").value = mpost;
			  
			  var maddress1 = document.querySelector("#maddress1").value;
			  document.querySelector("#addr1").value = maddress1;
			  var maddress2 = document.querySelector("#maddress2").value;
			  document.querySelector("#addr2").value = maddress2;
			  
			  var mphone = document.querySelector("#mphone").value;
			  document.querySelector("#phone").value = mphone;
		  }else{
			  document.querySelector("#orderName").value = "";
			  document.querySelector("#post1").value = "";
			  document.querySelector("#addr1").value = "";
			  document.querySelector("#addr2").value = "";
			  document.querySelector("#phone").value = "";
		  }

	}
	//input type button은 submit이 안됨
	function orderDone(f) {
		
		f.action="GoodsOrderDoneServlet";
		f.method="get";
		f.submit();
	}
</script>	
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daum.js"></script>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
<!-- GET으로 잠시 바꿈 뭐가 넘어가는지 보기위해 차후에  POST로 바꿀것-->
<form name="myForm" method="get" action="GoodsOrderDoneServlet">
<!-- 상품정보  -->
<input type="hidden" name="gCode" value="${cDTO.gCode}">
<input type="hidden" name=gName value="${cDTO.gName}">
<input type="hidden" name="gPrice" value="${cDTO.gPrice}">
<input type="hidden" name="gSize" value="${cDTO.gSize}">
<input type="hidden" name="gColor" value="${cDTO.gColor}">
<input type="hidden" name="gAmount" value="${cDTO.gAmount}">
<input type="hidden" name="gImage" value="${cDTO.gImage}">

<!-- Cart에서 삭제할 num값 -->
<input type="hidden" name="cartNum" value="${cDTO.num}">
<!-- 상품정보  -->


	<table width="80%" cellspacing="0" cellpadding="0">

		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>주문상품 확인</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>

		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="5">
		</tr>

		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="td_default" align="center"><strong>주문번호</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
						<td class="td_default" align="center"><strong>판매가</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>

					</tr>

					<tr>
						<td colspan="4">
							<hr size="1" color="CCCCCC">
						</td>
					</tr>

					<tr>
						<td class="td_default" width="80">${cDTO.num}</td>
						<td class="td_default" width="80"><img
							src="images/items/${cDTO.gImage}.gif" border="0" align="center"
							width="80" /></td>
						<td class="td_default" width="300" style='padding-left: 30px'>${cDTO.gName}
							<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${cDTO.gSize})
								, 색상(${cDTO.gColor})]
						</font></td>
						<td class="td_default" align="center" width="110">${cDTO.gPrice}
						</td>
						<td class="td_default" align="center" width="90">${cDTO.gAmount}</td>

					</tr>


					<tr>
						<td height="30"></td>
						<td class="td_default" align="right">총 결제 금액 :</td>
						<td class="td_default" align='right'>${cDTO.gPrice * cDTO.gAmount}원</td>
					</tr>
				</table> <tr>
			<td>
					<hr size="1" color="CCCCCC">
				</td>
			</tr>

		</td>
	</tr><!--  고객 정보 시작-->
		<tr>
		<td height="30">
	
		</tr>

	<tr>
		<td><b>고객 정보</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>


	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						
						이 름
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mname" size="20"
							maxlength="20" value="${mDTO.username}"></input>
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						우편번호
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mpost" size="4"
							maxlength="3" value="${mDTO.post}" readonly></input>
						
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						주 소
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="maddress1" size="35"
							maxlength="200" value="${mDTO.addr1}" readonly></input><br>
						<input class="input_default" type="text" id="maddress2" size="35"
							maxlength="200" value="${mDTO.addr2}" readonly></input>
					</td>
				</tr>
				
				<tr>
					<td height="35" class="td_default">
						휴대전화
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mphone" size="15"
							maxlength="15" value="${mDTO.phone1}-${mDTO.phone2}-${mDTO.phone3}"></input>
						
					</td>
				</tr>
			</table>							
		</td>
	</tr>
<!--  고객 정보 끝-->
	<tr>
		<td height="30">
	
		</tr>

	<tr> 
		<td class="td_default">
			 <input type="checkbox" name="same"
				onclick="javascript:sameAddress(this);"> 배송지가 동일할 경우 선택하세요.
		</td>
	</tr>
<!--  배송지 정보 시작-->
	<tr>
		<td height="30">
	
		</tr>

	<tr>
		<td><b>배송지 정보</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>


	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						
						이 름
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="orderName"
							name="orderName" size="20" maxlength="20" value=""></input>
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						우편번호
					</td>
					<td height="35" class="td_default">
<!-- 다음주소 시작-->
	<input name="post1" id="post1" size="5" readonly="">
	<input onclick="openDaumPostcode()" type="button" value="우편번호찾기">
	<br>
	<input name="addr1" id="addr1" size="40" readonly=""
		placeholder="도로명주소">
	<br>
	<span style="line-height: 10%;"><br></span>
	<input name="addr2" id="addr2" size="40" placeholder="지번주소">
<!-- 다음주소 끝 -->
					</td>
				</tr>
				
				<tr>
					<td height="35" class="td_default">
						
						휴대전화
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="phone"
							name="phone" size="15" maxlength="15" value=""></input>
					
					</td>
				</tr>
			</table>							
		</td>
	</tr>
<!--  배송지 정보 끝-->

	<tr>
		<td height="30">
	
		</tr>
	<tr>
		<td><b>결제수단</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						<input type="radio" name="payMethod" value="신용카드" checked>신용카드</input>
						
						<input type="radio" name="payMethod" value="계좌이체">계좌이체</input>
						
						<input type="radio" name="payMethod" value="무통장 입금">무통장 입금</input>
					</td>
					
				</tr>
				
			</table>							
		</td>
	</tr>
	
	<tr>
		<td height="30">
	
		</tr>


	<tr>
		<td class="td_default" align="center">
			<input type='button' value='취소' onclick="javascript:history.back()">	
			<input type='button' value='결제하기' onclick="orderDone(myForm)">
			<input type="submit" value="결제하기2">
			<button>결제하기3</button>
		</td>
	</tr>

</table>

</form>

<%
	// daum address.jsp 복사한것
%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>