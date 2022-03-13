package com.service.member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public interface MemberService {

	public MemberDTO idDuplicateCheck(String userid)throws Exception;
	public int memberAdd(MemberDTO dto)throws Exception;
	public MemberDTO login(HashMap<String, String> map)throws Exception;
	public MemberDTO mypage(String userid)throws Exception;
	public int memberUpdate(MemberDTO dto)throws Exception;
}
