package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO id , pw => login success
		String id = req.getParameter("memId"); // input value memId
		String pw = req.getParameter("password"); // input value password
		String respon = req.getParameter("respon");
		// 로그인 시도
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login(id, pw);
		
		// 로그인 성공 여부
		if(member != null) {
			// 로그인할 정보가 데이터로 남아있을 경우
			
			HttpSession session = req.getSession();// 웹 브라우저 쿠키를 저장
			session.setAttribute("logId", member.getMemberId()); // session에 로그인된 id 저장
			
			if(member.getResponsibility().equals("User")) {
				// 글 등록 화면으로 
				resp.sendRedirect("addBoard.do");
			}else if(member.getResponsibility().equals("Admin")){
				resp.sendRedirect("memberList.do");
			}
			
		}else {
			// 로그인할 정보가 데이터에 존재하지 않을 경우
			// 메헤지를 셋팅하고 로그인화면으로 이동
			req.setAttribute("msg", "ID와 Password를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
		
	}

}
