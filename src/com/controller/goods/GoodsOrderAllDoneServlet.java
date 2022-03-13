package com.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
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
import com.dto.goods.OrderDTO;
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
@WebServlet("/GoodsOrderAllDoneServlet")
public class GoodsOrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 
		     ?cartNum=13&
		      cartNum=24&
		      same=on&
		      orderName=aaa&
		      post1=63043&post2=&
		      addr1=제주특별자치도+제주시+애월읍+애월남길+5&
		      addr2=제주특별자치도+제주시+애월읍+애월리+1486-1&
		      phone=011-1234-5678&
		      payMethod=신용카드
		 
		 */
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String next ="";
		if(dto != null) {
			try {
				//주문자 정보(로그인 정보)
				String userid = dto.getUserid();
	
				//배송정보
				String orderName = request.getParameter("orderName");
				String post = request.getParameter("post1");
				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");
				String phone = request.getParameter("phone");
				//결제정보
				String payMethod = request.getParameter("payMethod");
			
				//상품정보
			    String [] cartNums = request.getParameterValues("cartNum"); 
				List<String> cList = Arrays.asList(cartNums);  //[13,24]
				
				CartService cService = new CartServiceImpl();
				List<CartDTO> cartDTOList= cService.orderAllConfirm(cList);
				
				//최종 저장
				List<OrderDTO> oList = new ArrayList<OrderDTO>();
				for (CartDTO cDTO : cartDTOList) {
					OrderDTO oDTO = new OrderDTO();
//					oDTO.setNum(cDTO.getNum());  // orderinfo 저장시 시퀀스로 저장함.
					oDTO.setUserid(userid);
					oDTO.setgCode(cDTO.getgCode());
					oDTO.setgName(cDTO.getgName());
					oDTO.setgPrice(cDTO.getgPrice());
					oDTO.setgSize(cDTO.getgSize());
					oDTO.setgColor(cDTO.getgColor());
					oDTO.setgAmount(cDTO.getgAmount());
					oDTO.setgImage(cDTO.getgImage());
					oDTO.setOrderName(orderName);
					oDTO.setPost(post);
					oDTO.setAddr1(addr1);
					oDTO.setAddr2(addr2);
					oDTO.setPhone(phone);
					oDTO.setPayMethod(payMethod);
					oList.add(oDTO);
				}
				
				int n = cService.orderAllDone(oList, cList);
				
				
				request.setAttribute("oList", oList);
				next ="orderAllDone.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				next ="error/error.jsp";
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
