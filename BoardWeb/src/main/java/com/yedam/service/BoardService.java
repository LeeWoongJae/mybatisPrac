package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public interface BoardService {
	// processing unit
	
	public List<BoardVO> boardList(); // 목록조회
	public BoardVO getBoard(int boardNo);// 단건조회
	public List<BoardVO> boardList(SearchDTO search);// 페이징 처리 조회
	public boolean registBoard(BoardVO board); //등록기능
	public boolean modifyBoard(BoardVO board); // 글 수정
	public boolean removeBoard(int boardNo); // 글 삭제
	
	// 전체카운트 계산
	public int getTotalCount(SearchDTO search); // selectCount()
	public List<Map<String, Object>> chartCount();
	
	// Event
	public List<Map<String, Object>> eventList(); // list
	public int addEvent(Map<String, String> map); // add
	public int removeEvent(int eventNo); // del
	
	
	
}
