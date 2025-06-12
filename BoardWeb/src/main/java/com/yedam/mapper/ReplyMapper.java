package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
 public int registRepl(ReplyVO vo);
 public List<ReplyVO> replList(int boardNo);
 public ReplyVO getRepl(int replyNo);
 public int removeRepl(int boardNo);
}
