package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	// processing unit
	
	public List<BoardVO> boardList(); // 목록조회
	public BoardVO getBoard(int boardNo);// 단건조회
	public boolean registBoard(BoardVO board); //등록기능
	
	
}
