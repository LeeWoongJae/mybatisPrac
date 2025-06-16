package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class replyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardNo = req.getParameter("boardNo");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.replyTotal(Integer.parseInt(boardNo));
		
		resp.getWriter().print("{\"totalCnt\":"+totalCnt+"}");

	}

}
