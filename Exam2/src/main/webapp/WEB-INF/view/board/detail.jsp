<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="list"><button>홈으로</button></a>
	<div>${param.iboard}</div>
	<div>${data.unm }</div>
	<div>${data.title }</div>
	<div>${data.ctnt }</div>
	<div>${data.regdt }</div>
	<c:if test="${loginUser.iuser == data.iuser }">
	<div>
		<a href="del?iboard=${param.iboard }"><button>삭제</button></a>
		<a href="mod?iboard=${param.iboard }"><button>수정</button></a>
	</div>
	</c:if>

</body>
</html>