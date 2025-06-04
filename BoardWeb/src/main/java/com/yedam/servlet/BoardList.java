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
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList.serv")
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
		
		// interface - mapper
		BoardMapper bMapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVO> list = bMapper.selectBoardList();
		System.out.println(list.toString());
		out.print("<table border = '1'>");
		out.print("<thead><tr><th>글번호</th><th>글제목</th><th>작성자</th></tr>");
		out.print("</thead>");
		out.print("<tbody>");
		for(int i = 0; i<list.size();i++) {
			
			out.print("<tr>");
			out.print("<td align='center'>"+list.get(i).getBoardNo()+"</td>");
			out.print("<td>"+list.get(i).getTitle()+"</td>");
			out.print("<td>"+list.get(i).getWriter()+"</td>");
			//out.print("<td>"+list.get(i).getContent()+"</td>");
			out.print("</tr>");
			
		}
		out.print("</tbody></table>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
