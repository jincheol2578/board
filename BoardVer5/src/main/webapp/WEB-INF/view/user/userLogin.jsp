<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${errMsg }</div>
	<form action="login" method="post">
		<div>아이디 : <input type="text" name="uid" placeholder="아이디"></div>
		<div>비밀번호 : <input type="password" name="upw" placeholder="패스워드"></div>
		<div><input type="submit" value="로그인"></div>
	</form>
	
	<div>
		<a href="join">join</a>
	</div>
</body>
</html>