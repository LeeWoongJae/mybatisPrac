package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardNo = req.getParameter("boardNo");
		BoardService svc = new BoardServiceImpl();
		
		
		if(req.getMethod().equals("GET")) {
			//BoardVO vo = svc.getBoard(Integer.parseInt(boardNo));
			svc.removeBoard(Integer.parseInt(boardNo));
			// 개발자가 만든 페이지만 매핑 가능하고 인자값을 가지고 forwarding할 수 있다는 이점
			//req.getRequestDispatcher("WEB-INF/jsp/removeBoard.jsp").forward(req, resp);
			resp.sendRedirect("boardList.do");
		}
		else if(req.getMethod().equals("POST")) {
			
			//resp.sendRedirect("boardList.do");
		}
		
		

	}

}
