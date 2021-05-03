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
	<h1>TODO List</h1>
	<form action="/write" method="post">
		<div>
		제목 : <input type="text" name="title">
		</div>
		<div>
		내용 : <input type="text" name="content">
		</div>
		<input type="submit" value="작성">
	</form>
	<table>
		<tr>
			<td>할일</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="item" items="${data}" varStatus="status">
		<tr>
			<td>
			<input type="text" name="mtitle" value="${item.title }" onclick=mod(this.name); readonly>
			</td>
			<td>
			<input type="text" name="mcontent" value="${item.content }" readonly>
			</td>
			<td>
			<input type="text" value="${item.regdt }" readonly>
			</td>
			<td><a href="/del?itodo=${item.iTodo}"><button>삭제</button></a></td>
		</tr>
		</c:forEach>
	</table>
</body>
<script>
	function mod(name) {
		var upt = document.getByName(name);
		upt.readOnly = false;
	}
</script>
</html>