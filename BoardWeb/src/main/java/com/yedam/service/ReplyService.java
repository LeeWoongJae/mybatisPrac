package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;


public interface ReplyService {
	public boolean addReply(ReplyVO rvo);
	public List<ReplyVO> replyList(int boardNo , int page);// 댓글 리스트 조회
	public ReplyVO getReply(int replyNo);
	public boolean removeReply(int replyNo); // 댓글 삭제
	public int replyTotal(int boardNo); // 원글기준 댓글수
}
