<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="취소" onclick="location.href='/detail?iboard=${list.iboard}'">
	<form action="/mod" method="post">
		<input type="hidden" name="iboard" value="${list.iboard }">
		<input type="text" name="username" placeholder="이름" value="${list.userName }" readOnly>
		<input type="text" name="title" placeholder="제목" value="${list.title }">
		<input type="text" name="content" placeholder="내용" value="${list.content }">
		<input type="submit" value="수정">
	</form>
</body>
</html>