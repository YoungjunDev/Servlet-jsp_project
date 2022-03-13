package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Git 저장 예제 용

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	static Logger logger= LoggerFactory.getLogger(MainServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("요청시간:{}", new Date().toString());
		
		
		// 상품 데이터를 DB에서 가져와서 request scope에 저장.
		
				//main.jsp 위임 (forward)
				
			request.getRequestDispatcher("main.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
