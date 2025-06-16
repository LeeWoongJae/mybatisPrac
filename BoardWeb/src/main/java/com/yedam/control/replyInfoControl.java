package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class replyInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyService svc = new ReplyServiceImpl();
		String rno = req.getParameter("replyNo");
		ReplyVO rvo = svc.getReply(Integer.parseInt(rno));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(rvo);
		resp.getWriter().print(json);
		
	}

}
