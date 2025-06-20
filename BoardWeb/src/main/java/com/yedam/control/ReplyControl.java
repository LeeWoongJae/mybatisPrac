package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

public class ReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		//replyList.do => json returned
		ReplyService svc = new ReplyServiceImpl();
		
		
		String boardNo = req.getParameter("boardNo");
		String page = req.getParameter("page");
		page = "1";
		List<ReplyVO> list = svc.replyList(Integer.parseInt(boardNo),Integer.parseInt(page));
		
		//DataTable용
		Map<String , Object> map = new HashMap<>();
		map.put("data", list);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//String json = gson.toJson(list);
		String json = gson.toJson(map);
		System.out.println(json);
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		
		
	}

}
