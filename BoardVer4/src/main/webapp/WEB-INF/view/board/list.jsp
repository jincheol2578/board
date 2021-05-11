<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>로그인 성공 </div>
	<div>${loginUser.unm }님 (${loginUser.uid }) 환영합니다 <a href="/user/logout">Logout</a></div>
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>이름</td>
				<td>날짜</td>
			</tr>
			<c:forEach var="list" items="${data }">
			<tr>
				<td>${list.iboard}</td>
				<td>${list.title }</td>
				<td>${list.unm }</td>
				<td>${list.regdt }</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>