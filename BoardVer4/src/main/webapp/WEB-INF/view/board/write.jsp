<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<a href="list">리스트</a>
	<form action="/board/write" method="post">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><textarea name="ctnt"></textarea></div>
		<div>
			<input type="submit" value="글쓰기">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>