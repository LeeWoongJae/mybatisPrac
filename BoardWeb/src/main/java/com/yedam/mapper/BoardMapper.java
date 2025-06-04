package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;


// xml 매칭
// MarketPlace에서 mybatipse 설치해서 (모두 신용으로 진행) 인터페이스에 명명한 (아이디와 같아야 링크됨) 메소드와 링크
public interface BoardMapper {
	public List<BoardVO> selectBoardList();
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	
}
