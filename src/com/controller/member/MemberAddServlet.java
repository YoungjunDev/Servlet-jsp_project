package com.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

//화면만 보는 기능
//따라서 화면만 위임하면 된다.

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDTO dto = new MemberDTO(userid, passwd,
				username, post, addr1, addr2,
				phone1, phone2, phone3, email1, email2);
		
		MemberService service = new MemberServiceImpl();
		String next = "";
		try {
			int num = service.memberAdd(dto);
			next="member/memberAddSuccess.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			next = "error/error.jsp";
		}
		
		response.sendRedirect(next);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//나중에 Filter로 변경하기
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
