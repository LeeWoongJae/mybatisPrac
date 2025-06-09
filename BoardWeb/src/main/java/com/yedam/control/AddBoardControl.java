package com.yedam.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  한글 깨짐 처리
		req.setCharacterEncoding("utf-8");
		
		// GET 방식 요청일 경우
		if(req.getMethod().equals("GET")){
			// RequestDispatcher -> 요청 페이지를 재지정
			// 모든 요청들을 frontcontrol에서 처리하기 위헤서 get 매소드에 dispatcher로 받아온다
			req.getRequestDispatcher("WEB-INF/jsp/addBoard.jsp").forward(req, resp);
			
		}else if (req.getMethod().equals("POST")) {
		// POST 방식 요청일 경우
		// addBoard.serv?title=제목&content=내용&writer=user89
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String writer = req.getParameter("writer");
				
				//매게값 정의
				BoardVO board = new BoardVO();
				board.setTitle(title);
				board.setContent(content);
				board.setWriter(writer);
				
				// 업무 서비스
				BoardService svc = new BoardServiceImpl();
				if(svc.registBoard(board)) {
					System.out.println("등록 완료!");
					// 목록이동(새로운 페이지 요청으로 인해서 명명한 웹서블릿 페이지로 이동)
					resp.sendRedirect("boardList.do");
				}else {
					System.out.println("등록 실패!");
				}
			}
		}
}
