<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="detail?iboard=${param.iboard }"><button>뒤로가기</button></a>
	<form action="mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard }">
		<div>제목 : <input type="text" name="title" value="${data.title }"></div>
		<div>내용 : <textarea name="ctnt">${data.ctnt }</textarea></div>
		<div><input type="submit" value="작성"></div>
	</form>
</body>
</html>