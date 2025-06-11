package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 * 서블릿 경로는 어떻게 정의하느냐에 따라 경로가 달라짐(사용자 정의마다 달라짐)
 * ex > /boardList.serv > html/boardList.serv 로 바뀌면 엄연히 다른 경로
 * 약간 뭔가 alias 느낌
 */
@WebServlet("/servlet/boardList.serv")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		// 출력스트림 
		PrintWriter out = response.getWriter();
		
		out.print("hello~");
		out.print("My name is LeeWoongJae~");
		SqlSession sqlSession = DataSource.getInstance().openSession();
		
//		// interface - mapper
//		BoardMapper bMapper = sqlSession.getMapper(BoardMapper.class);
//		// 
//		List<BoardVO> list = bMapper.selectBoardList();
		
		// Processing unit
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		
		System.out.println(list.toString());
		out.print("<table border = '1'>");
		out.print("<thead><tr><th>글번호</th><th>글제목</th><th>작성자</th></tr>");
		out.print("</thead>");
		out.print("<tbody>");
		for(int i = 0; i<list.size();i++) {
			
			out.print("<tr>");
			out.print("<td align='center'>"+list.get(i).getBoardNo()+"</td>");
			out.print("<td><a href='board.serv?boardNo="+list.get(i).getBoardNo()+"'>"+list.get(i).getTitle()+"</a></td>");
			out.print("<td>"+list.get(i).getWriter()+"</td>");
			//out.print("<td>"+list.get(i).getContent()+"</td>");
			out.print("</tr>");
			
		}
		out.print("</tbody></table>");
		out.print("<a href='../html/addForm.html'>등록페이지</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
