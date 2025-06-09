package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	// 게시글 건수 기준으로 페이지를 계산 
	private int start, end, currentPage; // 1~10 , 11~20 까지 페이지수를 보여주는 변수
	private boolean prev , next;
	
	public PageDTO(int page , int totalCnt) {
		this.currentPage = page;
		this.end = (int) (Math.ceil(1.0 * page / 10) * 10);
		this.start = this.end - 9;
		
		int realEnd = (int)Math.ceil(1.0 * totalCnt / 5);
		// 계산 건수를 기준으로 실제 마지막 페이지 (위에껀 무조건 10페이지 단위로 하단바를 생성)
		this.end = this.end > realEnd ? realEnd : this.end;
		
		
		// 이전 , 이후 페이지 존재 체크
		this.prev = this.start > 1;
		// 1페이지보다 크면 이전페이지가 존재 11 21 31...
		this.next = this.end < realEnd; 
		
	}
}
