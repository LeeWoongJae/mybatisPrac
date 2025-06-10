<%@page import="com.yedam.common.SearchDTO"%>
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
	SearchDTO search = (SearchDTO)request.getAttribute("search");
  	%>
  	<p><%=paging %></p>
<h3>게시글 목록</h3>

<!-- 검색조건 추가 -->
<form action="boardList.do">
	<div class="row">
    <div class="col-sm-4">
      <select name="searchCondition" class="form-control">
        <option value="">선택하세요</option>
        <option value="T" <%= search.getSearchCondition()!= null && search.getSearchCondition().equals("T") ? "selected" : "" %>>제목</option>
        <option value="W" <%= search.getSearchCondition()!= null && search.getSearchCondition().equals("W") ? "selected" : "" %>>작성자</option>
        <option value="TW" <%= search.getSearchCondition()!= null && search.getSearchCondition().equals("TW") ? "selected" : "" %>>제목&작성자</option>
      </select>
    </div>

    <div class="col-sm-6">
      <input type="text" class="form-control" name="keyword" value="<%=search.getKeyword() == null ? "" : search.getKeyword()%>"></input>
    </div>

    <div class="col-sm-2">
      <input type="submit" value="검색" class="btn btn-primary">
    </div>
  </div>

</form>


<table class="table">
    <thead>
        <tr>
            <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
        </tr>

    </thead>
    <tbody>
    	<% for(BoardVO vo : list){ %>
        <tr>
            <td><a href="board.do?boardNo=<%= vo.getBoardNo() %>&page=<%=paging.getCurrentPage() %>&searchCondition=<%=search.getSearchCondition() %>&keyword=<%=search.getKeyword() %>"><%= vo.getBoardNo() %></a></td>
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
    <% if(p != paging.getCurrentPage()) {%>
    
    <li class="page-item"><a class="page-link" href="boardList.do?searchCondition=<%=search.getSearchCondition() %>&keyword=<%=search.getKeyword() %>&page=<%=p %>"><%=p %></a></li>
   
    <% } else { %>
    <li class="page-item active">
  		<span class="page-link"><%=p %></span>
	</li>
	<% } }%>
    
    <%if(!paging.isNext()) {%>
    <li class="page-item disabled">
      <a class="page-link">Next</a>
    </li>
    
    <% } else { %>
    
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1 %>">Next</a>
    </li>
	<% } %>
    
    
    
    
  </ul>
</nav>

<!-- paging end -->

<jsp:include page="../include/footer.jsp" />
