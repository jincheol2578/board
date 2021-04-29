<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.koreait.board.*"%>
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
	<h1>detail</h1>
	<div><%=no%></div>
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="<%=no%>"> <input
				type="submit" value="삭제">

		</form>
		<a href="/mod?no=<%=no%>"><button>수정</button></a>
	</div>


	<div>
		제목 :
		<%=vo.getTitle()%></div>
	<div><%=vo.getCtnt()%></div>
</body>
</html>