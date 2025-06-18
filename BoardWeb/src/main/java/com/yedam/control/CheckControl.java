package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class CheckControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// fetch로 넘겨받은 파라메터 ?id= 한것을 가져와서 user로 지정
		String user = req.getParameter("id");
		
		resp.setContentType("text/json; charset=UTF-8");
		MemberService svc = new MemberServiceImpl();
		if(svc.getMemberInfo(user)) {
			//{"retCode":"Exist"}
			resp.getWriter().print("{\"retCode\":\"Exist\"}");
		}else {
			resp.getWriter().print("{\"retCode\":\"NotExist\"}");
		}
		
		

	}

}
