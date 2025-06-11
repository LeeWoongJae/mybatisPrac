package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String memberId , String password);
	public List<MemberVO> memberList(String order);
}
