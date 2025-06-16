package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public boolean addReply(ReplyVO vo) {
		ReplyVO repl = new ReplyVO();
		repl.setBoardNo(vo.getBoardNo());
		repl.setReply(vo.getReply());
		repl.setReplyer(vo.getReplyer());
		int r = mapper.registRepl(repl);
		if(r==1) {
			System.out.println("Success!");
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<ReplyVO> replyList(int boardNo , int page) {
		return mapper.replList(boardNo , page);
	}

	@Override
	public ReplyVO getReply(int boardNo) {
		return mapper.getRepl(boardNo);
	}

	@Override
	public boolean removeReply(int replyNo) {
		int r = mapper.removeRepl(replyNo);
		if(r==1) {
			System.out.println("성공적으로 삭제.");
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int replyTotal(int boardNo) {

		return mapper.selectTotal(boardNo);
	}

}
