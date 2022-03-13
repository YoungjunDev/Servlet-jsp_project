package com.dao.goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.goods.GoodsDTO;

public class GoodsDAO {
	
	// select id 값과 메서드 값을 일치시키자
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory)throws Exception{
		return session.selectList("com.config.GoodsMapper.goodsList", gCategory);
	}
	// 상품 자세히 보기
	public GoodsDTO goodsRetrieve(SqlSession session, String gCode)throws Exception{
		return session.selectOne("com.config.GoodsMapper.goodRetrieve", gCode);
	}
}
