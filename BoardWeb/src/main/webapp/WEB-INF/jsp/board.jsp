<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

<!-- 댓글 관련 페이지 -->
<style>
div.reply ul{
  list-style-type: none;
}
div.reply span{
 display: inline-block;
}


</style>
<div class="container reply">
	<div class="header">
	<input type="text" class="col-sm-8" id="reply" >
	<button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
		
	</div>
	<div class="content">
		<ul>
		<li>
			<span class="col-sm-1">글번호</span>
			<span class="col-sm-4">글내용</span>
			<span class="col-sm-2">작성자</span>
			<span class="col-sm-3">작성일</span>
			<span class="col-sm-1">삭제</span>
			
		</li>
		</ul>
		<ul id="target">
		</ul>
	</div>
	<div class="footer">
		<nav aria-label="...">
			<ul class="pagination pagination-sm">
				<li class="page-item disabled"><a class="page-link">Previous</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item active" aria-current="page">
					<span>2</span></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
</div>
<!-- 댓글 관련 페이지 -->
<script>
let logId = "${logId}";
let bno = "${board.boardNo}";
document.querySelector('button.btn-danger').addEventListener('click', function(){
	location.href='removeBoard.do?boardNo='+bno;
	
});
</script>
<script src="js/service.js"></script>
<script src="js/reply.js"></script>

<!--
const button = document.querySelector('button.btn-danger');

const removeDataFnc = () =>{
  location.href='removeBoard.do?boardNo='+bNo;
};
 
button.addEventListener('click',removeDataFnc);
-->

