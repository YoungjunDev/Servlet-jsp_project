package com.service.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.board.BoardDTO;

public interface BoardService {
	// DAO에서  세션뺴고 복사
	public List<BoardDTO> selectAll();
}
