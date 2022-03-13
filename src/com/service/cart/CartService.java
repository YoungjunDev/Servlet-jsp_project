package com.service.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.goods.CartDTO;
import com.dto.goods.OrderDTO;

public interface CartService {

	//장바구니 과정 5번. com/service/cart 만들고
		// CartDTO.interface 생성
		public int cartAdd(CartDTO dto)throws Exception;
		
		// 장바구니 목록 5번
		public List<CartDTO> cartList(String userid)throws Exception;
		
		//장바구니 삭제
		public int cartDel(int num)throws Exception;
		
		//장바구니 수정
		public int cartUpdate(HashMap<String, Integer> map) throws Exception;
		
		//장바구니 전체 삭제
		public int cartDelAll(List<String> list)throws Exception;

		// 결제전 상품정보 보여주기
		public CartDTO cartByNum(int num)throws Exception;

		// orderDone
		public int orderDone(OrderDTO dto, String cartNum)throws Exception;

		// orderAllConfirm
		public List<CartDTO> orderAllConfirm(List<String> list)throws Exception;
		
		//orderAllDone
		public int orderAllDone(List<OrderDTO> oList, List<String> cList)throws Exception;
}