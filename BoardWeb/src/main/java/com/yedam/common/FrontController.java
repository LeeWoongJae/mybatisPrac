package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AllControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartPageControl;
import com.yedam.control.CheckControl;
import com.yedam.control.EventListControl;
import com.yedam.control.GetReplyControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.replyCountControl;
import com.yedam.control.replyInfoControl;

public class FrontController extends HttpServlet{
// url pattern을 key , value 로 관리
	
	Map<String, Control> map;
	public FrontController() {
		map = new HashMap<String, Control>();
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 글 목록 출력 > BoardList.do
		map.put("/boardList.do", new BoardListControl()); // 글리스트
		map.put("/board.do", new BoardControl()); // 글 상세화면
		map.put("/addBoard.do", new AddBoardControl()); // 글 추가
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 글 수정
		map.put("/removeBoard.do", new RemoveBoardControl()); // 글 삭제
		
		// chart
		map.put("/chart.do", new ChartControl());// chart
		map.put("/chartPage.do", new ChartPageControl());
		
		// member
		map.put("/loginForm.do", new LoginFormControl()); // 화면
		map.put("/login.do", new LoginControl()); // 실제 로그인 처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃
		
		map.put("/memberList.do", new MemberListControl());// 회원 목록
		map.put("/signup.do", new SignUpControl());
		map.put("/checkId.do", new CheckControl());
		
		// product
		map.put("/allProduct.do", new AllControl());
		
		// reply
		map.put("/replyList.do", new ReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReply.do", new GetReplyControl());
		map.put("/replyCount.do", new replyCountControl());
		map.put("/replyInfo.do", new replyInfoControl());
		
		
		//event
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 각 url 마다 매핑된 페이지를 호출(https://localhost:8080/BoardWep/boardList.do)-> Control 반환
		String uri = req.getRequestURI(); // /BoardWep/boardList.do 반환
		String context = req.getContextPath();
		String page = uri.substring(context.length());// /boardList.do 반환
		//System.out.println(page+context.length()); // => /user/loginForm.do 반환 ?? 이게 맞아?
		Control sub = map.get(page);
		sub.exec(req , resp);
	}
}
