package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;


@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션을 가져와서
		HttpSession session = request.getSession();
		
		// dto에서 세션정보중 로그인 정보를 가져와서
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		//다음에 뭘 줄건지 변수 선언을 해주고
		String next="";
		// 로그인이 널이 아니면 mypage를 보여주고  널이면 로그인서블릿으로 보낸다.
		if(dto != null) {
			next="mypage.jsp";
			String userid = dto.getUserid();
			MemberService service = new MemberServiceImpl();
			try {
				MemberDTO mypage = service.mypage(userid);
				session.setAttribute("login", mypage);
			} catch (Exception e) {
				next = "error/error.jsp";
				e.printStackTrace();
			}
		}else {
			next="member/sessionInvalidate.jsp";
		}
		request.getRequestDispatcher(next).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
