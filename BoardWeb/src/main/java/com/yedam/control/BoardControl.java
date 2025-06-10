package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("BoardControl 클래스 입니다");
		// http://localhost:8080/BoardWeb/board.do?boardNo=34
		String boardNo = req.getParameter("boardNo");
		//추가 파라메터 => board.jsp에 전달하여 데이터 보존
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String writeDate = req.getParameter("writeDate");
		
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(boardNo));
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("writeDate", writeDate);
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
		
	}
}
