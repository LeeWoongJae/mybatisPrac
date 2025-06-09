<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<h3>게시글화면(BoardList.jsp)</h3>

	<% 
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("blist");
	PageDTO paging = (PageDTO)request.getAttribute("pageInfo");
  	%>
  	<p><%=paging %></p>
<h3>게시글 목록</h3>
<table class="table">
    <thead>
        <tr>
            <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
        </tr>

    </thead>
    <tbody>
    	<% for(BoardVO vo : list){ %>
        <tr>
            <td><a href="board.do?boardNo=<%= vo.getBoardNo() %>"><%= vo.getBoardNo() %></a></td>
            <td><%= vo.getTitle() %></td>
            <td><%= vo.getWriter() %></td>
            <td><%= vo.getWriteDate() %></td>
            <td><%= vo.getReadCont() %></td>
        </tr>
		<% } %>    	
    </tbody>

</table>
<!-- paging start -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  <!-- 이전페이지 존재 확인 -->
  <%if(!paging.isPrev()) {%>
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    
    <% } else { %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getStart()-1 %>">Previous</a>
    </li>
    <% }%>
    
    <!-- paging 정보를 활용 -->
    <% for(int p = paging.getStart();p<=paging.getEnd();p++){%>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
    
    
    <% } %>
    
    <%if(!paging.isNext()) {%>
    <li class="page-item disabled">
      <a class="page-link">Next</a>
    </li>
    
    <% } else { %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1 %>">Next</a>
    </li>
    <% }%>
    
    
    
  </ul>
</nav>

<!-- paging end -->

<jsp:include page="../include/footer.jsp" />
