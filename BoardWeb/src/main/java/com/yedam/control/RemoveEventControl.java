package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService svc = new BoardServiceImpl();
		
		String title = req.getParameter("title");
		String start= req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVO vo = new EventVO();
		vo.setTitle(title);
		vo.setStart(start);
		vo.setEnd(end);
		if(svc.removeEvent(vo)==1) {
			System.out.println("삭제완료!");
			//{"retCode":"Success"}
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		}else {
			System.out.println("삭제실패!");
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}
