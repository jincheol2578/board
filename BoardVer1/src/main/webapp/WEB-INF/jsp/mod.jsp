<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.koreait.exam.*"%>
<%
	String no = request.getParameter("no");
	BoardVO vo = (BoardVO) request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/list"><button>홈으로</button></a>
	<h1>mod</h1>
	<form action="/mod" method="post">
		<!--action : 이동할 주소  method : get방식-->
		<input type="hidden" name="no" value="<%=no %>">
		<div>
			제목 : <input type="text" name="title" value="<%=vo.getTitle() %>">
		</div>
		<div>
			내용 :
			<textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기">
			<!-- 누르면 실행 -->
		</div>
	</form>
</body>
</html>