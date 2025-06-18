package com.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.mapper.BoardMapper;

public class ListAppTest {
 // 연습용 클래스
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<Map<String, Object>> list = mapper.selectUserByCount();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		System.out.println(json);
	}
}
