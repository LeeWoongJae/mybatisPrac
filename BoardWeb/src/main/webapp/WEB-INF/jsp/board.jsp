<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	BoardVO board = (BoardVO)request.getAttribute("board");
	String pg = (String)request.getAttribute("page");
	String sc = (String)request.getAttribute("searchCondition");
	String kw = (String)request.getAttribute("keyword");
%>
<form action="modifyBoard.do">
<input type="hidden" name="boardNo" value="${board.boardNo }">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="searchCondition" value="${searchCondition }">
<input type="hidden" name="keyword" value="${keyword }">

    <h3>상세화면</h3>
    <table class="table">
    
        <tr>
            <th>글번호</th><td>${board.boardNo}</td>
            <th>조회수</th><td>${board.readCont}</td>
        </tr>
        <tr>
            <th>제목</th><td colspan="3">${board.title }</td>
        </tr>
        <tr>
            <th>내용</th><td colspan="3"><textarea cols="30" rows="4" name="content" class="form-control" readonly>${board.content}</textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td colspan="3">${board.writer}</td>
        </tr>
        <tr>
            <th>작성일시</th><td colspan="3"><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
let bNo = "${board.boardNo }";
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
