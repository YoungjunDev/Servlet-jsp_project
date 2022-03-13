<%@page import="com.dto.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// common/menu.jsp
	// include는 기존 내용 다 지워야 한다.
	// 고객센터에서 board 사용
%>

 <%
	MemberDTO dto =
	(MemberDTO)session.getAttribute("login");

	if(dto == null){		
%>
 <a href="LoginUIServlet">로그인</a>
 <a href="MemberUIServlet">회원가입</a>
 <a href="BoardListServlet">고객센터</a>
<%
	}else{
%>
 <a href="LogoutServlet">로그아웃</a>
 <a href="MyPageServlet">mypage</a>
 <!-- // 장바구니 목록 1번 -->
 <a href="GoodsCartListServlet">장바구니목록</a>
 <a href="BoardListServlet">고객센터</a>
<%
	}//end if
%>

