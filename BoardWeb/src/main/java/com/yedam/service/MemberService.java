package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String memberId , String password);
	public List<MemberVO> memberList(String order);
	
	// 회원등록
	public boolean addMember(MemberVO vo);
	
	public boolean getMemberInfo(String userId);
	
}
