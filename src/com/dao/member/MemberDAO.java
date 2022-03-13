package com.dao.member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public class MemberDAO {

	public MemberDTO idDuplicateCheck(SqlSession session,
				String userid)throws Exception{
		return session.selectOne("com.config.MemberMapper.idDuplicateCheck", userid);
	}
	
	public int memberAdd(SqlSession session,
					MemberDTO dto)throws Exception{
		return session.insert("com.config.MemberMapper.memberAdd",dto);
	}
	
	public MemberDTO login(SqlSession session, 
			HashMap<String, String> map)throws Exception{
		return session.selectOne("com.config.MemberMapper.login", map);
	}
	
	public MemberDTO mypage(SqlSession session,
			String userid)throws Exception{
	return session.selectOne("com.config.MemberMapper.mypage", userid);
	}
	
	public int memberUpdate(SqlSession session, MemberDTO dto)throws Exception{
		return session.update("com.config.MemberMapper.memberUpdate", dto);
	}
}
