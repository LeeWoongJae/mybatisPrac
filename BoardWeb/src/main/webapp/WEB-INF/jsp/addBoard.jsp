<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../include/header.jsp" />
<h3>글등록화면(addBoard.jsp)</h3>
<%
	String logId = (String)session.getAttribute("logId");
%>
<!-- 현재 경로 : BoardWeb/html/addForm.html -->
	<form action="addBoard.do" method="post">
	<input type="hidden" class="form-control" name="writer" value="<%=logId %>">
	<table class="table">
		<tr><th>글제목</th><td><input type="text" required name="title"></td></tr>
		<tr><th>글내용</th><td><input type="text" required name="content"></td></tr>
		<tr><th>작성자</th><td><span><%=logId %></span></td></tr>
		<tr>
		<td colspan=2 align='center'>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		</td>
		</tr>
	</table>

	</form>

<jsp:include page="../include/footer.jsp" />
