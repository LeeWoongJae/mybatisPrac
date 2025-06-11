package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String order = req.getParameter("order");
		order = order==null ? "member_id" : order; 
		System.out.println("order value : "+order);
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		req.getRequestDispatcher("WEB-INF/jsp/member/memberList.jsp").forward(req, resp);

	}

}
