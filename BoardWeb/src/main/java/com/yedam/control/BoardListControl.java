package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("글 목록 출력");
		// TODO forward => 페이지 이동 메소드
		
			//req.setAttribute("myName", "Hongkildong");
			// 글목록을 가져와서 넘기고
			String page = req.getParameter("page");
			page = page == null ? "1" : page;
			
			
			BoardService svc = new BoardServiceImpl();
			//List<BoardVO> list = svc.boardList();
			List<BoardVO> list = svc.boardList(Integer.parseInt(page));
			
			int totalCnt = 112;
			PageDTO paging = new PageDTO(Integer.parseInt(page) , totalCnt);
			
			
			req.setAttribute("blist", list); // 요청정보(request 객체에 담아서 전달)
			req.setAttribute("pageInfo", paging);
			// 요청 페이지 재지정
			req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
			
		
		
		
	}
	

}
