package com.controller.goods;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.MainServlet;
import com.dto.goods.GoodsDTO;
import com.service.goods.GoodsService;
import com.service.goods.GoodsServiceImpl;

//left.jsp div에서 누르면 GoodsListServlet로 온다.

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {

	static Logger logger= LoggerFactory.getLogger(GoodsListServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("요청시간:{}", new Date().toString());
		
		// 상품 데이터를 DB에서 가져와서 request scope에 저장.
		String gCategory = request.getParameter("gCategory");
		if(gCategory==null) {
			gCategory = "top";
		}
		
		String next="";
		GoodsService service = new GoodsServiceImpl();
		try {
			List<GoodsDTO> list = service.goodsList(gCategory);
			request.setAttribute("goodsList", list);
			next = "goods.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Main 요청시 예외 발생");
			next = "error/error.jsp";
		}
				//goods.jsp 위임 (forward)
		
		request.getRequestDispatcher("goods.jsp").forward(request, response);
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
