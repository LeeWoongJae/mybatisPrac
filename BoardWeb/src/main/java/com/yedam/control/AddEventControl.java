package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AddEventControl implements Control {
	
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		
		if(svc.addEvent(map)==1) {
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
		
		

	}

}
