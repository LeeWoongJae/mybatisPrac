<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<%
	BoardVO board = (BoardVO)request.getAttribute("board");
	String pg = (String)request.getAttribute("page");
	String sc = (String)request.getAttribute("searchCondition");
	String kw = (String)request.getAttribute("keyword");
	String writeDate = (String)request.getAttribute("writeDate");
%>
<form action="modifyBoard.do">
<input type="hidden" name="boardNo" value="<%=board.getBoardNo() %>">
<input type="hidden" name="page" value="<%=pg%>">
<input type="hidden" name="searchCondition" value="<%=sc%>">
<input type="hidden" name="keyword" value="<%=kw%>">

    <h3>상세화면</h3>
    <table class="table">
    
        <tr>
            <th>글번호</th><td><%=board.getBoardNo() %></td>
            <th>조회수</th><td><%=board.getReadCont()%></td>
        </tr>
        <tr>
            <th>제목</th><td colspan="3"><%=board.getTitle() %></td>
        </tr>
        <tr>
            <th>내용</th><td colspan="3"><textarea cols="30" rows="4" name="content" class="form-control" readonly><%=board.getContent() %></textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
        </tr>
        <tr>
            <th>작성일시</th><td colspan="3"><%=board.getWriteDate() %></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="submit" value="수정" class="btn btn-warning">
                <button class="btn btn-danger" type="button">삭제</button>
            </td>
        </tr>
    </table>
</form>
<script>
let bNo = "<%=board.getBoardNo() %>";
console.log(bNo);
document.querySelector('button.btn-danger').addEventListener('click', function(){
	location.href='removeBoard.do?boardNo='+bNo;
	
});
<!--
const button = document.querySelector('button.btn-danger');

const removeDataFnc = () =>{
  location.href='removeBoard.do?boardNo='+bNo;
};
 
button.addEventListener('click',removeDataFnc);
-->
</script>
<jsp:include page="../include/footer.jsp" />