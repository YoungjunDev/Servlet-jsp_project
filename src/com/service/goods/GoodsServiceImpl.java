package com.service.goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.goods.GoodsDAO;
import com.dto.goods.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List<GoodsDTO> goodsList(String gCategory) throws Exception {
		List<GoodsDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			GoodsDAO dao = new GoodsDAO();
			list = dao.goodsList(session, gCategory);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public GoodsDTO goodsRetrieve(String gCode) throws Exception {
		GoodsDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			GoodsDAO dao = new GoodsDAO();
			dto = dao.goodsRetrieve(session, gCode);
		} finally {
			session.close();
		}
		return dto;
	}

}
