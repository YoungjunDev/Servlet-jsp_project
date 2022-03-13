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

//장바구니 과정 2번. com/controller/GoodsCartAddServlet
@WebServlet("/GoodsCartAddServlet")
public class GoodsCartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//gImage=bottom1&gCode=B1&gName=제나+레이스+스커트&gPrice=9800&goods_size=사이즈선택&goods_color=색상선택&goods_amount=1
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String next ="";
		if(dto != null) {
			
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice");
			String goods_size = request.getParameter("goods_size");
			String goods_color = request.getParameter("goods_color");
			String goods_amount = request.getParameter("goods_amount");
			CartDTO cartDTO = new CartDTO();
			cartDTO.setgImage(gImage);
			cartDTO.setgCode(gCode);
			cartDTO.setgName(gName);
			cartDTO.setgPrice(Integer.parseInt(gPrice));
			cartDTO.setgSize(goods_size);
			cartDTO.setgColor(goods_color);
			cartDTO.setgAmount(Integer.parseInt(goods_amount));
			cartDTO.setUserid(dto.getUserid());
			
			//service
			//장바구니 과정 7번. cartServiceImpl 가져오기
			CartService service = new CartServiceImpl();
			// throws Exception 처리
			
			try {
				// num 변수에 서비스의 cartAdd를 불러서
				int num = service.cartAdd(cartDTO);
				// 다음으로 간다.	
				next = "cart/cartAddSuccess.jsp";
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
