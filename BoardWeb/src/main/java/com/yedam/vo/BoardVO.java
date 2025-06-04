package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Data
public class BoardVO {
	// 생성자 , 필드 , 메소드 (getter , setter)
	// lombok 라이브러리설치로 간편하게 관리
	// annotation을 통해서 간편하게 관리
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCont;
	
}
