package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String memberId , String password);
}
