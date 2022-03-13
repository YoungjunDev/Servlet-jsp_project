package com.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.cart.CartService;
import com.service.cart.CartServiceImpl;


@WebServlet("/GoodsCartDelServlet")
public class GoodsCartDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
			CartService service = new  CartServiceImpl();
			try {
				int n = service.cartDel(Integer.parseInt(num));
				next = "GoodsCartListServlet";
			} catch (Exception e) {
				e.printStackTrace();
				next = "error/error.jsp";
			}
		}else {
			next = "member/sessionInvalidate.jsp";
		}
		// forward 하면 url이 변경안됨.GoodsCartAddServlet로 남아있기
		//때문에 새로고침시 cart에 다시 추가할려고 하기 때문에
		response.sendRedirect(next); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
