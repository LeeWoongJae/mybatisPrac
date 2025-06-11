package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO forward => 페이지 이동 메소드
			// http://localhost:8080/BoardWeb/boardList.do?searchCondition=W&keyword=user01
		    // searchCondition , keyword 2가지 값을 들고 온다
			//req.setAttribute("myName", "Hongkildong");
			// 글목록을 가져와서 넘기고
			String page = req.getParameter("page");
			String searchCondition = req.getParameter("searchCondition");
			String keyword = req.getParameter("keyword");
			
			page = page == null ? "1" : page;
			searchCondition = searchCondition == null ? "" : searchCondition;
			keyword = keyword == null ? "" : keyword;
			keyword = URLDecoder.decode(keyword);// 16진수를 한글로 복호화
			
			SearchDTO search = new SearchDTO();
			search.setPage(Integer.parseInt(page));
			search.setSearchCondition(searchCondition);
			search.setKeyword(keyword);

			BoardService svc = new BoardServiceImpl();
			
			List<BoardVO> list = svc.boardList(search);
			
			//int totalCnt = 112;
			int totalCnt = svc.getTotalCount(search);
			PageDTO paging = new PageDTO(Integer.parseInt(page) , totalCnt);
			
			
			req.setAttribute("blist", list); // 요청정보(request 객체에 담아서 전달)
			req.setAttribute("pageInfo", paging);
			req.setAttribute("search", search);
			// 요청 페이지 재지정
			req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);
			
	}
	

}
