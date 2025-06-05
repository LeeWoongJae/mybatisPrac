package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

// 클래스가 서블릿이 되는 순서
//  HttpServlet을 상속

@WebServlet("/board.serv")
public class BoardServlet extends HttpServlet {
	public BoardServlet(){
		System.out.println("BoardServlet 생성자 호출.");
	}
	
	// init 메소드 - 반드시 있어야 하는것은 아님
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	//service - 반드시 존재해야 함
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service 메소드 호출");
		// session connect
		resp.setContentType("text/html;charset=UTF-8");

		// 파라메터 요청 - 필드로 정의된 변수명
		String boardNo = req.getParameter("boardNo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		// 상세조회
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(boardNo));
		
		// 상세조회하고 조회수 증가(프로세스 생각)
		//bMapper.(Integer.parseInt(boardNo));
		
		
		String str = "<table border='1'>";
		str += "<tbody align='center'><tr><th>글번호</th><td>"+board.getBoardNo()+"</td><th>조회수</th><td>"+board.getReadCont()+"</td></tr>";
		str += "<tr><th>제목</th><td colspan='3'>"+board.getTitle()+"</td></tr>";
		str += "<tr><th>내용</th><td colspan='3'>"+board.getContent()+"</td></tr>";
		str += "<tr><th>작성자</th><td colspan='3'>"+board.getWriter()+"</td></tr>";
		str += "<tr><th>작성일시</th><td colspan='3'>"+sdf.format(board.getWriteDate())+"</td></tr>";
		str += "</tbody></table>";
		str += "<p><a href='boardList.serv'>목록으로</a></p>";
				
				
		PrintWriter out = resp.getWriter();
		out.print(str);
		
	}
	
}
