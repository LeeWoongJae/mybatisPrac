package com.yedam.service;


import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	@Override
	public MemberVO login(String memberId, String password) {
		// TODO Auto-generated method stub
		return mapper.selectMember(memberId, password);
	}

}
