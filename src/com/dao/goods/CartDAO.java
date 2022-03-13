package com.dao.goods;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.goods.CartDTO;
import com.dto.goods.GoodsDTO;
import com.dto.goods.OrderDTO;

public class CartDAO {
	
	public int cartAdd(SqlSession session, CartDTO dto)throws Exception{
		return session.insert("com.config.CartMapper.cartAdd",dto);
	}
	
	// 장바구니 목록 4번
		public List<CartDTO> cartList(SqlSession session, String userid)throws Exception{
			return session.selectList("com.config.CartMapper.cartList", userid);
		}
		
		// 장바구니 삭제
		public int cartDel(SqlSession session, int num)throws Exception{
			return session.delete("com.config.CartMapper.cartDel",num);
		}
		
		//장바구니 수정
		public int cartUpdate(SqlSession session, HashMap<String, Integer> map)throws Exception{
			return session.update("com.config.CartMapper.cartUpdate", map);
		}
		
		// 장바구니 전체 삭제
		public int cartDelAll(SqlSession session, List<String> list)throws Exception {
			return session.delete("com.config.CartMapper.cartDelAll", list);
		}
		
		// 결제전 상품 정보 보여주기
		public CartDTO cartByNum(SqlSession session, int num)throws Exception{
			return session.selectOne("com.config.CartMapper.cartByNum", num);
		}
		
		// orderDone
		public int orderDone(SqlSession session, OrderDTO dto)throws Exception{
			return session.insert("com.config.CartMapper.orderDone",dto);
		}
		
		public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list)throws Exception {
			return session.selectList("com.config.CartMapper.orderAllConfirm", list);
		}

		public int orderAllDone(SqlSession session, List<OrderDTO> oList) throws Exception{
			
			return session.insert("com.config.CartMapper.orderAllDone", oList);
		}
}



//장바구니 과정 4번. com/dao/goods/CartDTO 생성
//mapper 생성 및 configation 수정후 mapper 이용할 dao 작성