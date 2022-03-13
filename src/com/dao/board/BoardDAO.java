package com.dao.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.board.BoardDTO;

public class BoardDAO {
	
	// DB 연동
	
	//목록 보기
	public List<BoardDTO> selectAll(SqlSession session){
		return session.selectList("com.config.BoardMapper.selectAll");
	}
}
