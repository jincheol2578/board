<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="test.*"%>
<%
	List<TVO> list = (List<TVO>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트</h1>
	<button onclick="location.href='/twrite'";>글쓰기</button>
	<% for(int i = 0; i<list.size(); i++) {
		TVO vo = list.get(i);  %> <%=i %> <%=vo.getTitle() %>
	<% } %>
	
</body>
</html>