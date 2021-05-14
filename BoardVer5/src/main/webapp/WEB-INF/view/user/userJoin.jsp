<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="post">
		<div>id : <input type="text" name="uid"></div>
		<div>name : <input type="text" name="unm"></div>
		<div>password : <input type="password" name="upw"></div>
		<div>성별
			<label>남<input type="radio" value="1" checked></label>
			<label>여<input type="radio" value="0" ></label>
		</div>
		<div>
		<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>