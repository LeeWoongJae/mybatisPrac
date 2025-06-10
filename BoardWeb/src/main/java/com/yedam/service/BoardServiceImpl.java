package com.yedam.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	
	@Override
	public List<BoardVO> boardList() {
		
		return mapper.selectBoardList();
	}
	
	@Override
	public List<BoardVO> boardList(SearchDTO searh) {
		return mapper.selectListWithPaging(searh);
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO board = mapper.selectBoard(boardNo);
		if (board != null) {
			mapper.updateReadCont(boardNo);
			sqlSession.commit();
		}
		return board;
	}

	@Override
	public boolean registBoard(BoardVO board) {
		
		int r = mapper.insertBoard(board);
		if(r==1) {
			sqlSession.commit();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		int r = mapper.updateBoard(board);
		if(r==1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		int r = mapper.deleteBoard(boardNo);
		if(r==1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int getTotalCount(SearchDTO search) { // 페이지를 만들 전체 데이터수 계산
		return mapper.selectCount(search);
	}



	

	

}// end of class
