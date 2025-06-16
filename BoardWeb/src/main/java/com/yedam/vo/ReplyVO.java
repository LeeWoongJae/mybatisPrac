package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int replyNo, boardNo;
	private String reply, replyer;
	private Date replyDate;
	
}
