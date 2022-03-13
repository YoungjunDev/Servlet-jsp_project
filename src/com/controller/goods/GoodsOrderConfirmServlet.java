package com.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.goods.CartDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;


@WebServlet("/GoodsOrderConfirmServlet")
public class GoodsOrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cart table의 num값
		String num = request.getParameter("num");
		// num 값을 가지고 상품 정보를 가져올 수 있다.
		// 가져와서 주문 확인 화면의 해당 num값에 해당되는 상품 정보를 가져온다.
	
		// 세션에 저장된 값을 사용해서 member 테이블의 정보를 가져온다.
		HttpSession session = request.getSession();
		
		
		
		// 로그인 정보를 가져와서 로그인 유효성 체크를 진행하는 것
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
		
			try {
				// 상품정보
				CartService cartService = new CartServiceImpl();
				CartDTO cartDTO = cartService.cartByNum(Integer.parseInt(num));
				
				
				// 고객정보
				String userid = dto.getUserid();
				MemberService memberService = new MemberServiceImpl();
				MemberDTO memberDTO = memberService.mypage(userid);
				
				request.setAttribute("cDTO", cartDTO);
				request.setAttribute("mDTO", memberDTO);
				
				next = "orderConfirm.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				next = "error/error.jsp";
			}
		
		}else {
			next = "member/sessionInvalidate.jsp";
		}
		//request는 redirect로 못가져옴
		request.getRequestDispatcher(next).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
