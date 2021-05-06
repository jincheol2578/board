<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${list.title }</h1>
	<div>${list.iboard }</div>
	<div>${list.userName }</div>
	<div>${list.viewCnt }</div>
	<div>${list.regdt }</div>
	<div>${list.content }</div>
	<input type="button" value="수정" onclick="location.href='/mod?iboard=${param.iboard}'">
	<input type="button" value="삭제" onclick="location.href='/del?iboard=${param.iboard}'">
	<input type="button" value="목록" onclick="location.href='/list'">
	
	
	<div>댓글창</div>
	<form action="/comment" method="post">
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="text" name="username" placeholder="ID">
		<input type="text" name="comment" placeholder="내용">
		<input type="submit" value="작성">
	</form>
	<table>
		<tr>
			<td>번호</td>
			<td>id</td>
			<td>내용</td>
			<td>시간</td>
		</tr>
		
		<c:forEach var="item" items="${clist }" varStatus="stat">
		<tr>
			<td>${item.icmt }</td>
			<td>${item.userName }</td>
			<td>${item.comment }</td>
			<td>${item.regdt }</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>