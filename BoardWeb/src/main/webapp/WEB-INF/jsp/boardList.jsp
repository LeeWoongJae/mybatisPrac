
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>
<h3>게시글화면(BoardList.jsp)</h3>

<!-- <p>${pageInfo}</p> -->
<h3>게시글 목록</h3>
<!-- blist 검색결과리스트 / pageInfo 페이지 정보 / search 검색결과 -->
<table id="example" class="display">
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
	<tfoot>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>장성일시</th>
			<th>조회수</th>
		</tr>
	</tfoot>
</table>
<script>
	let table = new DataTable('#example');
</script>