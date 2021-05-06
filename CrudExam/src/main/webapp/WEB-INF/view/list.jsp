<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
	.list{
	cursor: pointer;
	}
</style>
</head>
<body>
	<h1>게시판</h1>
	<table>
		<tr>
			<td>id</td>
			<td>제목</td>
			<td>시간</td>
			<td>조회수</td>
			<td>번호</td>
		</tr>
		
		<c:forEach var="item" items="${list }" varStatus="stat">
		<tr class="list" onclick="moveToDetail(${item.iboard})">
			<td>${item.userName }</td>
			<td>${item.title }</td>
			<td>${item.regdt }</td>
			<td>${item.viewCnt}</td>
			<td>${item.iboard }</td>
		</tr>
		</c:forEach>
		
	</table>
	<input type="button" value="작성" onclick="location.href='/write'">
</body>
<script>
	function moveToDetail(i) { 
		location.href="/detail?iboard="+i;
		
	}
	
	
</script>
</html>