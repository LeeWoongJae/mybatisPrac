package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=UTF-8");
		ReplyService svc = new ReplyServiceImpl();
		
		String boardNo = req.getParameter("boardNo"); // 게시글번호
		String reply = req.getParameter("reply"); // 댓글
		String replyer = req.getParameter("replyer"); // 댓글 작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(boardNo));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		
		
		if(svc.addReply(rvo)) {
			// {"retCode":"Success"}
			// escape : "\"
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		}else {
			// {"retCode":"Fail"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
		
		
		
	}

}
