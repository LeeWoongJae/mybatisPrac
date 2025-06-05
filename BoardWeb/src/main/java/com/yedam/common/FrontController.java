package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

public class FrontController extends HttpServlet{
// url pattern을 key , value 로 관리
	
	Map<String, Control> map;
	public FrontController() {
		map = new HashMap<String, Control>();
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 글 목록 출력 > BoardList.do
		map.put("/boardList.do", new BoardListControl());
		map.put("/boardControl.do", new BoardControl());
		map.put("/addBoard.do", new AddBoardControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 각 url 마다 매핑된 페이지를 호출(https://localhost:8080/BoardWep/boardList.do)-> Control 반환
		String uri = req.getRequestURI(); // /BoardWep/boardList.do 반환
		String page = uri.substring(9);// /boardList.do 반환
		Control sub = map.get(page);
		sub.exec(req , resp);
	}
}
