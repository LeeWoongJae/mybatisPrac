package com.yedam.vo;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo, boardNo;
	private String reply, replyer, replyDate;
	
}
