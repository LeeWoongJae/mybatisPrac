package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=UTF-8");
		ReplyService svc = new ReplyServiceImpl();
		
		String boardNo = req.getParameter("boardNo"); // 게시글번호
		String reply = req.getParameter("reply"); // 댓글
		String replyer = req.getParameter("replyer"); // 댓글 작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(boardNo));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		// json 문자열 생성 함수
		Map<String , Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		
		
		if(svc.addReply(rvo)) {
			map.put("retVal", rvo);
			map.put("retCode", "Success");
			// {"retCode":"Success"}
			// escape : "\"
			// resp.getWriter().print("{\"retCode\":\"Success\"}");
		}else {
			map.put("retCode", "Fail");
			// {"retCode":"Fail"}
			// resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
		String json = gson.toJson(map);
		System.out.println(json);
		resp.getWriter().print(json);
		
		
		
	}

}
