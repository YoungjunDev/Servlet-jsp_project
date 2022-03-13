package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

//화면만 보는 기능
//따라서 화면만 위임하면 된다.

@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 게속 중복되는 건 class를 만들어서 중복 제거를 해줘야 한다.
		// 세션을 가져와서
		HttpSession session = request.getSession();
		
		// dto에서 세션정보중 로그인 정보를 가져와서
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		//다음에 뭘 줄건지 변수 선언을 해주고
		String next="";
		// 로그인이 널이 아니면 mypage를 보여주고  널이면 로그인서블릿으로 보낸다.
		if(dto != null) {
		String userid = request.getParameter("userid");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDTO updateDTO = new MemberDTO();
		updateDTO.setUserid(userid);
		updateDTO.setPost(post);
		updateDTO.setAddr1(addr1);
		updateDTO.setAddr2(addr2);
		updateDTO.setPhone1(phone1);
		updateDTO.setPhone2(phone2);
		updateDTO.setPhone3(phone3);
		updateDTO.setEmail1(email1);
		updateDTO.setEmail2(email2);
		
		MemberService service = new MemberServiceImpl();
		try {
			int num = service.memberUpdate(updateDTO);
			next = "MyPageServlet";
		} catch (Exception e) {
			e.printStackTrace();
			next = "error/error.jsp";
		}
		
		}else {
			next="member/sessionInvalidate.jsp";
		}
		request.getRequestDispatcher(next).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//나중에 Filter로 변경하기
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
