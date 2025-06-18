package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// GET 요청 : 화면출력
		// POST 요청 : 회원등록
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);
		}
		else if (req.getMethod().equals("POST")) {
			// db insert
			// images 폴더에 업로드
			// 1. 요청정보 2. 경로 3. 최대크기 4. 언어에대한 인코딩 5.리네임정책(같은이름의 파일이 존재하면 재정의)
			String svPath = req.getServletContext().getRealPath("images");
			MultipartRequest mr = new MultipartRequest(
					                  req // 요청정보
					                  , svPath // 업로드 경로
					                  , 1024 * 1024 * 5 // 최대 크기(5MB)
					                  , "UTF-8"
					                  , new DefaultFileRenamePolicy() // 리네임 정책
					                  );
			
			String id = mr.getParameter("userId");
			String pw = mr.getParameter("userPw");
			String name = mr.getParameter("userName");
			String img = mr.getParameter("userImg");
			
			System.out.println("id : "+id+"pw : "+pw+"name : "+name+"img : "+img);
			
			
			MemberVO vo = new MemberVO();
			vo.setMemberId(id);
			vo.setPassword(pw);
			vo.setMemberName(name);
			vo.setImg(img);
			
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(vo)) {
				resp.sendRedirect("boardList.do");
			}
			
			
			
			
			
			
			
		}
		
		
	}

}
