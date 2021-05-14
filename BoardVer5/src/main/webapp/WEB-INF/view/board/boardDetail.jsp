<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list"><button>뒤로가기</button></a>
	<div>글번호 : ${data.iboard }</div>
	<div>작성자 : ${data.unm }</div>
	<div>제목 : ${data.title }</div>
	<div>내용 : ${data.ctnt }</div>
	<div>작성일시 : ${data.regdt }</div>
	<div>
	<a href="mod?iboard=${param.iboard }">수정</a>
	<a href="del?iboard=${param.iboard }">삭제</a>
	</div>
	
</body>
</html>