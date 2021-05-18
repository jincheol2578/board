<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/res/js/boardDetail.js?ver=2">
</script>
<style>
	.hidden { display:none;}
	
</style>
</head>
<body>
	<a href="list"><button>뒤로가기</button></a>
	<div>${data.title }</div>
	<div>글번호 : ${data.iboard }</div>
	<div>작성자 : ${data.unm } | 작성일시 : ${data.regdt }</div>
	<div>내용 : ${data.ctnt }</div>
	<div></div>
	<div>
	<a href="mod?iboard=${data.iboard }">수정</a>
	<a href="del?iboard=${data.iboard }">삭제</a>
	</div>
	
	
	<div>
		<form id="insFrm" action="cmt" method="post">
		<input type="hidden" name="icmt" value="0"> 
		<input type="hidden" name="iboard" value="${requestScope.data.iboard }"> 
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">	
			</div>
		</form>
	</div>
	
	<div>
		<form id="updFrm" action="cmt" method="post" class="hidden">
		<input type="hidden" name="icmt" value="0"> 
		<input type="hidden" name="iboard" value="${requestScope.data.iboard }"> 
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">	
				<input type="button" value="수정취소" onclick="showInsFrm()">	
			</div>
		</form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="item" items="${requestScope.cmtList }">
			<tr>
				<td>${item.cmt }</td>
				<td>${item.unm }</td>
				<td>${item.regdate }</td>
				<td>
				<c:if test="${item.iuser == sessionScope.loginUser.iuser }">
					<button onclick="updCmt(${item.icmt},'${item.cmt }')" >수정</button>
					<button onclick="delCmt(${item.icmt},${requestScope.data.iboard })">삭제</button>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>