package com.yedam.control;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청방식에 따라서 분류 >> GET 방식이면 화면 open
		// 					  POST 방식이면 데이터 수정
		req.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String boardNo = req.getParameter("boardNo");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//추가 파라메터 => board.jsp에 전달하여 데이터 보존
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		kw = URLEncoder.encode(kw); // 한글을 16진수로 변환하여 GET방식으로 처리해야 페이지에서 데이터가 맵핑
		
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			// 요청 페이지 재지정 modifyBaord.do?boardNo=??
			BoardVO vo = svc.getBoard(Integer.parseInt(boardNo));
			
			req.setAttribute("board", vo);
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			
			// 개발자가 만든 페이지만 매핑 가능하고 인자값을 가지고 forwarding할 수 있다는 이점
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			
		}
		else if(req.getMethod().equals("POST")) {
			BoardVO vo = new BoardVO();
			vo.setBoardNo(Integer.parseInt(boardNo));
			vo.setTitle(title);
			vo.setContent(content);
			svc.modifyBoard(vo);
			
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}
		
		
	}

}
