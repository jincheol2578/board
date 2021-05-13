<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/user/login" method="post">
		<input type="text" name="uid" placeholder="id">
		<input type="text" name="upw" placeholder="pw">
		<input type="submit" value="로그인">
	</form>
	<input type="button" value="회원가입" onclick="location.href='join'">
	<div>${errMsg}</div>
</body>

</html>