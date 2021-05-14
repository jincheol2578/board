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
<a href="/user/logout"><button>로그아웃</button></a>
	<h1>리스트</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일시</td>
			
		</tr>	
		<c:forEach var="item" items="${list }">
		<tr onclick="moveToDetail(${item.iboard})">
			<td>${item.iboard }</td>
			<td>${item.unm }</td>
			<td>${item.title }</td>
			<td>${item.regdt }</td>
			
		</tr>	
		</c:forEach>
	
	</table>
	<a href="write">글작성하기</a>
</body>
<script type="text/javascript">
	function moveToDetail(i){
		location.href="detail?iboard="+i;
	}
</script>
</html>