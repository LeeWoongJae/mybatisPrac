package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
 public int registRepl(ReplyVO vo);
 public List<ReplyVO> replList(@Param("boardNo")int boardNo  , @Param("page")int page);
 public ReplyVO getRepl(int replyNo);
 public int removeRepl(int boardNo);
 public int selectTotal(int boardNo);
}
