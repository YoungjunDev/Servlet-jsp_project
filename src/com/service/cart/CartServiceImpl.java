package com.service.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.goods.CartDAO;
import com.dto.goods.CartDTO;
import com.dto.goods.OrderDTO;

public class CartServiceImpl implements CartService {

	@Override
	public int cartAdd(CartDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public List<CartDTO> cartList(String userid) throws Exception {
		List<CartDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			list = dao.cartList(session, userid);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int cartDel(int delnum) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartDel(session, delnum);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int cartUpdate(HashMap<String, Integer> map) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartUpdate(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public int cartDelAll(List<String> list) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			num = dao.cartDelAll(session, list);
			session.commit();
		}finally {
			session.close();
		}
		return num;
	}

	@Override
	public CartDTO cartByNum(int num) throws Exception {
		CartDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			dto = dao.cartByNum(session, num);
		}finally {
			session.close();
		}
		return dto;
		}

	@Override
	public int orderDone(OrderDTO dto, String cartNum) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			// 트랜잭션 처리
			//1. OrderInfo 테이블에 insert
			CartDAO dao = new CartDAO();
			num = dao.orderDone(session, dto);
			
			//2. Cart 테이블 delete
			num = dao.cartDel(session, Integer.parseInt(cartNum));
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally {
			session.close();
		}
		return num;
	}
	
	@Override
	public List<CartDTO> orderAllConfirm(List<String> cartNumlist) throws Exception {
		List<CartDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			CartDAO dao = new CartDAO();
			list = dao.orderAllConfirm(session, cartNumlist);
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public int orderAllDone(List<OrderDTO> oList, List<String> cList) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//트랜잭션 처리
			//1. OrderInfo테이블 insert
			CartDAO dao = new CartDAO();
			num = dao.orderAllDone(session, oList);
			
			//2. Cart테이블 delete
			num = dao.cartDelAll(session, cList);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
			
		}finally {
			session.close();
		}
		return num;
	}
}


//장바구니 과정 6번. 
//CartDTO.interface를 받는 Impl 생성 및 Override하여 작성
// 이걸 쓰는건 GoodsAddServlet

//장바구니 목록 6번