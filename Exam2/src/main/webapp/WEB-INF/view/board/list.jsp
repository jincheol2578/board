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
	<h1>게시판</h1>
	<a href="/user/logout"><button>로그아웃</button></a>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
		</tr>
		
		<c:forEach var="item" items="${data }">
			<tr onclick="mtd(${item.iboard})">
				<td>${item.iboard }</td>
				<td>${item.unm }</td>
				<td>${item.title }</td>
				<td>${item.regdt }</td>
			</tr>
		</c:forEach>	
		
	</table>
	<a href="write"><button>글쓰기</button></a>
</body>
<script type="text/javascript">
	function mtd(i) {
		location.href="detail?iboard="+i;
	}
</script>
</html>