<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="detail?iboard=${param.iboard }"><button>취소</button></a>
	<form action="/board/mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard }">
		<input type="text" name="title" value=${data.title }>
		<textarea name="ctnt">${data.ctnt }</textarea>
		<input type="submit" value="작성">
	</form>
</body>
</html>