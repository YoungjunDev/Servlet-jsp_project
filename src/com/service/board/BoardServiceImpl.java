package com.service.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.board.BoardDAO;
import com.dto.board.BoardDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.selectAll(session);
		} finally {
			session.close();
		}
		return list;
	}

}
