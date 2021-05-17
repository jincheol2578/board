<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer src="/res/js/boardList.js?ver=1"></script>
<link rel="stylesheet" type="text/css" href="/res/css/boardList.css?ver=1">
</head>
<body>
<a href="/user/logout"><button>로그아웃</button></a>
	<h1>리스트</h1>
	<h1>${sessionScope.loginUser.unm}님 반갑습니다.</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일시</td>
			
		</tr>	
		<c:forEach var="item" items="${requestScope.list }">
		<tr class="record" onclick="moveToDetail(${item.iboard})">
			<td>${item.iboard }</td>
			<td>${item.unm }</td>
			<td>${item.title }</td>
			<td>${item.regdt }</td>
			
		</tr>	
		</c:forEach>
	
	</table>
	<a href="write">글작성하기</a>
</body>

</html>