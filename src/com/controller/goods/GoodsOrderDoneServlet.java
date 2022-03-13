package com.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.goods.CartDTO;
import com.dto.goods.OrderDTO;
import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;


@WebServlet("/GoodsOrderDoneServlet")
public class GoodsOrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*gCode=T2&gName=%EC%8A%AC%EB%A6%AC%EB%B8%8C+%EB%9F%AC%ED%94%8C+%EB%B8%94%EB%9D%BC%EC%9A%B0%EC%8A%A4&gPrice=12100&gSize=M&gColor=ivory&gAmount=3&gImage=top2&same=on&orderName=aaa&post1=06035&addr1=%EC%84%9C%EC%9A%B8+%EA%B0%95%EB%82%A8%EA%B5%AC+%EA%B0%80%EB%A1%9C%EC%88%98%EA%B8%B8+5+%28%EC%8B%A0%EC%82%AC%EB%8F%99%29&addr2=%EC%84%9C%EC%9A%B8+%EA%B0%95%EB%82%A8%EA%B5%AC+%EC%8B%A0%EC%82%AC%EB%8F%99+537-5&phone=011-1234-1234&payMethod=%EC%8B%A0%EC%9A%A9%EC%B9%B4%EB%93%9C
		 * 
		 * */
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String next ="";
		if(dto != null) {
			
			try {
				//주문자 정보(로그인 정보)
				String userid = dto.getUserid();
				
				//cart에서 삭제할 num
				String cartNum = request.getParameter("cartNum");
				
				//상품정보
				String gCode = request.getParameter("gCode");
				String gName = request.getParameter("gName");
				String gPrice = request.getParameter("gPrice");
				String gSize = request.getParameter("gSize");
				String gColor = request.getParameter("gColor");
				String gAmount = request.getParameter("gAmount");
				String gImage = request.getParameter("gImage");
				//배송정보
				String orderName = request.getParameter("orderName");
				String post1 = request.getParameter("post1");
				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");
				String phone = request.getParameter("phone");
				//결제정보
				String payMethod = request.getParameter("payMethod");
				//데이터를 Mapper를 통해 DTO로 DB로 전달
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setUserid(userid);
				orderDTO.setgCode(gCode);
				orderDTO.setgName(gName);
				orderDTO.setgPrice(Integer.parseInt(gPrice));
				orderDTO.setgSize(gSize);
				orderDTO.setgColor(gColor);
				orderDTO.setgAmount(Integer.parseInt(gAmount));
				orderDTO.setgImage(gImage);
				orderDTO.setOrderName(orderName);
				orderDTO.setPost(post1);
				orderDTO.setAddr1(addr1);
				orderDTO.setAddr2(addr2);
				orderDTO.setPhone(phone);
				orderDTO.setPayMethod(payMethod);

				CartService service = new CartServiceImpl();
				int n = service.orderDone(orderDTO, cartNum);
				
				request.setAttribute("orderDTO", orderDTO);
				
				next ="orderDone.jsp";
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
