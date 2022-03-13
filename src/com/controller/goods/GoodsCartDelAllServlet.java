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

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsCartDelAllServlet")
public class GoodsCartDelAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String [] check = request.getParameterValues("check");
		List<String> list = Arrays.asList(check);
	
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
			CartService service = new CartServiceImpl();
			try {
				int n  = service.cartDelAll(list);
				next = "GoodsCartListServlet";
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp";
			}
		}else {
			next = "member/sessionInvalidate.jsp";
		}
		response.sendRedirect(next); 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
