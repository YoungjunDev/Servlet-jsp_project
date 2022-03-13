<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function validcheck(){
	// 필수 항목 입력 확인
	var id = document.querySelector("#userid").value;
	if(id.length!=0){
		
		
	}else{
		alert("아이디 필수");
		event.preventDefault();
	}
}
</script>

<form action="LoginServlet" method="get" onsubmit="validcheck()">
아이디:<input type="text" name="userid" id="userid"><br>
비밀번호:<input type="text" name="passwd" id="passwd" ><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
