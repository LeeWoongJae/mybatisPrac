<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%  
    	String str="Hello, world";
    	for(int i=0;i<10;i++){
    %>
    <h3>여기는 HTML 영역입니다.</h3>
    <%  }
    	BoardService svc = new BoardServiceImpl();
    	List<BoardVO> list = svc.boardList();
    	out.print("<ul>");
    	for(BoardVO vo : list){
    	%>
    		<li><%=vo.getBoardNo() %>, <%=vo.getTitle() %></li>	
    	<%
    	
    		
    	}
    	out.print("</ul>");
    	System.out.println(str);
    %>
</body>
</html>