<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/user/join" method="post" onsubmit="return pwcheck()">
		<div>
			<input type="text" name="uid" id="uid" placeholder="id">
			<input type="button" value="중복체크" onclick="idcheck()">
		</div>
		
		<input type="password" name="upw" id="pw1" placeholder="pw">
		<input type="password" id="pw2" placeholder="pwcheck">
		<input type="text" name="unm" placeholder="이름">
		<label>남<input type="radio" name="gender" value="1" checked></label>
		<label>여<input type="radio" name="gender" value="0" ></label>
		<input type="submit" value="가입하기">
	</form>
	<div>
		<input type="button" value="취소" onclick="location.href='login'">
	</div>
</body>
<script type="text/javascript">
	function pwcheck() {
		var pw = document.getElementById("pw1");
		var pw2 = document.getElementById("pw2");
		
		if (pw.value === pw2.value){
			return true;
		} else{
			alert('비밀번호확인');
			return false;
		}
	}
	function idcheck() {
		var uid = document.getElementById("uid").value;
		var option = "width=300, height=300, menubar=no, status=no, toolbar=no";
		window.open("/user/idcheck?uid="+uid,"중복체크", option);
				
	}
</script>
</html>