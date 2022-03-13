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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", userid);
		map.put("pw", passwd);
		
		MemberService service = new MemberServiceImpl();
		String next = "";
		try {
			MemberDTO dto = service.login(map);
			if(dto != null) {
				next="main";  //8090/ShopMiniMall/main
				
				// 세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("login", dto);
				// session.getAttribute("login")했는데 null이면 로그인 안함. 아니면 로그인함
				// 로그인 했는지 안했는지 체크
			}else {
				next="member/loginFail.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			next="error/error.jsp";
		}
		
		response.sendRedirect(next);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
