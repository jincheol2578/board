<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<form action="/user/login" method="post">
				<div><input type="text" name="uid" placeholder="아이디"></div>
				<div><input type="password" name="upw" placeholder="비밀번호"></div>
				<div>
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a>
		</div>
	</div>
</body>
</html>