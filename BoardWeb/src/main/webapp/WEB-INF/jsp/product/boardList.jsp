
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>게시글화면(BoardList.jsp)</h3>

<!-- <p>${pageInfo}</p> -->
<h3>게시글 목록</h3>
<!-- blist 검색결과리스트 / pageInfo 페이지 정보 / search 검색결과 -->
<!-- 검색조건 추가 -->
<form action="boardList.do">
	<div class="row">
    <div class="col-sm-4">
      <select name="searchCondition" class="form-control">
        <option value="">선택하세요</option>
        <option value="T" ${((!empty search.searchCondition) && (search.searchCondition eq 'T')) ? "selected" : ""}>제목</option>
        <option value="W" ${((!empty search.searchCondition) && (search.searchCondition eq 'W')) ? "selected" : ""}>작성자</option>
        <option value="TW" ${((!empty search.searchCondition) && (search.searchCondition eq 'TW')) ? "selected" : ""}>제목&작성자</option>
      </select>
    </div>

    <div class="col-sm-6">
      <input type="text" class="form-control" name="keyword" value="${(!empty search.keyword) ? '' : search.keyword}"></input>
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
    	<c:forEach var="vo" items="${blist}">
    	 <tr>
            <td><a href="board.do?boardNo=${vo.boardNo }&page=${pageInfo.currentPage }&searchCondition=${search.searchCondition }&keyword=${search.keyword}">${vo.boardNo}</a></td>
            <td>${vo.title }</td>
            <td>${vo.writer }</td>
            <td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd" /></td>
            <td><fmt:formatNumber value="${vo.readCont }" pattern="#,###" /></td>
        </tr>
    	
    	</c:forEach>
 	    	
    </tbody>

</table>
<!-- paging start -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  <!-- 이전페이지 존재 확인 -->
  <c:choose>
  <c:when test="${!pageInfo.prev }">
   <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
  </c:when>
  <c:otherwise>
   <li class="page-item">
      <a class="page-link" href="boardList.do?page=${pageInfo.start - 1 } ">Previous</a>
    </li>
  </c:otherwise>
  
  </c:choose>

    
    <!-- paging 정보를 활용 -->
    <c:forEach var="p" begin="${pageInfo.start }" end="${pageInfo.end }">
    <c:choose>
    
    <c:when test="${p ne pageInfo.currentPage }">
    <li class="page-item"><a class="page-link" href="boardList.do?searchCondition=${search.searchCondition }&keyword=${search.keyword}&page=${p }">${p }</a></li>
    </c:when>
    
    <c:otherwise>
     <li class="page-item active">
  		<span class="page-link">${p }</span>
	</li>
    </c:otherwise>
    
    </c:choose>
    
    </c:forEach>
 
	<c:choose>
	<c:when test="${!pageInfo.next }">
	<li class="page-item disabled">
      <a class="page-link">Next</a>
    </li>
	
	</c:when>
	<c:otherwise>
	<li class="page-item">
      <a class="page-link" href="boardList.do?page=${pageInfo.end +1 }">Next</a>
    </li>
	</c:otherwise>
	
	</c:choose>
  </ul>
</nav>

<!-- paging end -->
