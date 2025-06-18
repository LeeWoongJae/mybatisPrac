package com.yedam.service;


import java.util.List;

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
	@Override
	public List<MemberVO> memberList(String order) {
		// TODO Auto-generated method stub
		
		// Mapper.xml && Mapper.java에 있는 id값과 동일
		return mapper.selectList(order);
	}
	@Override
	public boolean addMember(MemberVO vo) {
		int r = mapper.insertMember(vo);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	@Override
	public boolean getMemberInfo(String id) {
		MemberVO vo = mapper.selectMemberInfo(id);
		System.out.println(vo);
		if(vo != null) {
			return true;
		}
		return false;
		
	}

}
