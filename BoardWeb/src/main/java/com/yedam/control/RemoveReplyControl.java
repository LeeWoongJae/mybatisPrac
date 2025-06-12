package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReplyService svc = new ReplyServiceImpl();
		// reply_no 기준 삭제
		String replyNo = req.getParameter("replyNo");
		
		if(svc.removeReply(Integer.parseInt(replyNo))) {
			System.out.println("삭제 완료");
		}
		
		

	}

}
