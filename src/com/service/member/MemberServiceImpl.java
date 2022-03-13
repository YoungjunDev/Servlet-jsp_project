package com.service.member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberDTO idDuplicateCheck(String userid) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
		
			MemberDAO dao = new MemberDAO();
			dto = dao.idDuplicateCheck(session, userid);
			
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int memberAdd(MemberDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.memberAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	@Override
	public MemberDTO login(HashMap<String, String> map) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.login(session, map);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public MemberDTO mypage(String userid) throws Exception {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			dto = dao.mypage(session, userid);
		} finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int memberUpdate(MemberDTO dto) throws Exception {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.memberUpdate(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	

}
