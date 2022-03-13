package com.service.goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.goods.GoodsDTO;

public interface GoodsService {

	// 메인 화면에 대한 목록 리스트 
	public List<GoodsDTO> goodsList(String gCategory)throws Exception;
	// 상품 자세히 보기
	public GoodsDTO goodsRetrieve(String gCode)throws Exception;
}
