package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class EventVO {
	private int eventNO;
	private String eventContent , eventUser;
	private Date eventDateStart ,eventDateEnd; 
}
