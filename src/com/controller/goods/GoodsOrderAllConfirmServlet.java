package com.controller.goods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.dto.goods.CartDTO;
import com.dto.goods.GoodsDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;
import com.service.goods.GoodsService;
import com.service.goods.GoodsServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsOrderAllConfirmServlet")
public class GoodsOrderAllConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String [] check = request.getParameterValues("check");
		List<String> list = Arrays.asList(check);
	
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
			
			try {
				
				//cartlist에서 선택한 목록
				CartService service = new CartServiceImpl();
				List<CartDTO> cartDTOList = service.orderAllConfirm(list); //체크된 상품목록이 저장됨.
				
				//고객정보
				MemberService mService = new MemberServiceImpl();
				MemberDTO mDTO = mService.mypage(dto.getUserid());
				
				request.setAttribute("cList", cartDTOList);
				request.setAttribute("mDTO", mDTO);
				
				next = "orderAllConfirm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp";
			}
		}else {
			next = "member/sessionInvalidate.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
