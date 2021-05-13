<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list"><button>홈으로</button></a>
	<form action="/board/write" method="post">
		<input type="text" name="title" placeholder="제목">
		<textarea name="ctnt"></textarea>
		<input type="submit" value="작성">
	</form>
</body>
</html>