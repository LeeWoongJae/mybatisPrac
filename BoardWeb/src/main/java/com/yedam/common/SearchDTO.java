package com.yedam.common;

import lombok.Data;

@Data // getter , setter 추가 lombok 사용
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
