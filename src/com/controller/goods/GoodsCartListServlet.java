package com.controller.goods;

import java.io.IOException;
import java.util.List;

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
// 장바구니 목록 2번
@WebServlet("/GoodsCartListServlet")
public class GoodsCartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그인인지 알 필요가 있는 과정에서는 거의 필수로 쓰이는 코드
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
			// 내가 담은 목록만 가져와야 한다. userid 활용
			String userid = dto.getUserid();
			// 장바구니 목록 2-1 CartMapper로 이동
			
			//장바구니 목록 8번  service
			CartService service = new CartServiceImpl();
			try {
				List<CartDTO> cartList = service.cartList(userid);
				// requestScope로 set헀기때문에
				request.setAttribute("cartList", cartList);
				next = "cartList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp";
			}
	
			
		}else {
			next = "member/sessionInvalidate.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
		// requestScope로는 response.sendRedirect(next); 못함
		// sendRedirect의 경우 request를 제외한 session과 application만 가능하다.
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
