package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class AddBoard
 */
@WebServlet("/addBoard.serv")
public class AddBoard extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// addBoard.serv?title=제목&content=내용&writer=user89
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.registBoard(board)) {
			System.out.println("등록 완료!");
			// 목록이동(새로운 페이지 요청으로 인해서 명명한 웹서블릿 페이지로 이동)
			resp.sendRedirect("boardList.serv");
		}else {
			System.out.println("등록 실패!");
		}
		
		
	}
       
    

}
