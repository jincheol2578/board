<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list">리스트</a>
	<form action="/board/mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard }" readOnly >
		<div>
			<input type="text" name="title" value="${data.title }">
		</div>
		<div>
			<textarea name="ctnt">${data.ctnt }</textarea>
		</div>
		<div>
			<input type="submit" value="수정"> 
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>