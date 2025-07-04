package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;


// xml 매칭
// MarketPlace에서 mybatipse 설치해서 (모두 신용으로 진행) 인터페이스에 명명한 (아이디와 같아야 링크됨) 메소드와 링크
public interface BoardMapper {
	public List<BoardVO> selectBoardList(); // 목록전체조회 사용X
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO selectBoard(int BoardNo); // 목록단건조회
	public int updateReadCont(int BoardNo); // 글제목을 눌렀을때 조회수가 증가
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	
	// 전체 건수.
	public int selectCount(SearchDTO search);
	public List<Map<String , Object>> selectUserByCount();
	
	// Event
	public List<Map<String, Object>> selectEvent();
	public int insertEvent(Map<String , String> map);
	public int deleteEvent(EventVO vo);
	
	
}
