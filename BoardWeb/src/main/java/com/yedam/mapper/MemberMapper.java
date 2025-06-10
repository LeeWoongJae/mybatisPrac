package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	// 회원관리 매퍼
	// select member
	// @Param() << 선언하면 mapper.xml에서 인자값이 각각 매칭되서 2가지 이상 되는 쿼리분들을 각각 대입해서 처리가능
	// (parameter_name) << 안에 있는 파라메타 명은 쿼리문에 쓰일 이름이어야한다
	public MemberVO selectMember(@Param("id") String memberId, @Param("pw") String password); 
}
