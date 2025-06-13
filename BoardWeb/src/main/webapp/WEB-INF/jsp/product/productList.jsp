<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>product/productList.jsp</h3>
<div id="show">
<table class="table">
		<tr><th>글번호</th><td><input id="boardNo" type="text" class="form-control" required name="title"></td></tr>
		<tr><th>글내용</th><td><input id="reply" type="text" class="form-control" required name="content"></td></tr>
		<tr>
		<td colspan=2 align='center'>
		<button id="addReply" type="button" class="btn btn-primary">등록</button>
		</td>
		</tr>
	</table>
	<table class="table">
	<thead>
	<tr>
        <th>글번호</th><th>내 용</th><th>작성자</th><th>삭 제</th>
    </tr>
	</thead>
	<tbody>
	
	</tbody>
    
	</table>
<p>${logId}</p>
</div>
<script>
 const logId = "${logId}";
 
</script>
<script src="js/service.js"></script>
<script src="js/ajax2.js"></script>