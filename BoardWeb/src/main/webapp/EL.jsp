<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardService"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL.jsp</title>
</head>
<body>
<%
	request.setAttribute("msg", "Hello"); // 응답후 사라지는 휘발성 request객체의 attribute
	session.setAttribute("errorMsg", "ID,PW 확인요망.");// session이 alive인 동안은 계손 잔존
	application.setAttribute("projectName", "BoardWeb");// session보다 생존 주기가 길다
	
	BoardService svc = new BoardServiceImpl();
	SearchDTO search = new SearchDTO();
	search.setPage(1);
	List<BoardVO> list = svc.boardList(search);
	request.setAttribute("blist", list);
%>
<!-- "${'Practice, world'}+${errorMsg }"-->
<!-- version 이 높아져서 그런지 <!-- 으로해도 된다 -->
<p>${'Hello, world' }</p>
<p>${10 eq 5 }</p>
<p>${(!empty msg) ? "NULL" : msg }</p>
<p><!-- ${(!empty msg) ? "NULL" : msg } --></p>
<p>${errorMsg }</p>

<c:set var="name" value="Hongkildong" />
<c:out value="${name }" />
<c:set var = "age" value="20" />
<c:if test="${age >= 20 }">
<p>Adult</p>
</c:if>

<c:if test="${!empty logId }">
<p>Login Active</p>
</c:if>


<c:choose>
<c:when test="${!empty logId }">
<p>Login Active</p>
</c:when>
<c:otherwise>
<p>Login inActive</p>
</c:otherwise>
</c:choose>

<!-- 반복문1 -->
<c:forEach var="i" begin="1" end="5">
<span>I의 값은 ${i} 입니다</span><br>

</c:forEach>
<table border="1">
<!-- 반복문2 -->
<c:forEach var="board" items="${blist }" >
	<tr>
	  <td>${board.boardNo }</td> <!-- == board.getBoardNo() -->
	  <td>${board.title }</td><!-- == board.getTitle() -->
	  <td><c:out value="${board.writer }" /></td> <!--  == board.getWriter() -->
	  <td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>

</table>

</body>
</html>