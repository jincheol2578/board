<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="#" onclick="goBack();">뒤로가기</a>
<h1>${requestScope.data.title }</h1>
<div>글번호 : ${requestScope.data.iboard }</div>
<div>작성자 : ${requestScope.data.writerNm } | 작성일시 : ${requestScope.data.regdt }</div>
<div><c:out value="${requestScope.data.ctnt }"/></div>

<c:if test="${not empty sessionScope.loginUser }">
	<div>
		<form id="cmtFrm" onsubmit="return false;">
			<input type="text" id="cmt">
			<input type="button" value="댓글달기" onclick="regCmt();">
		</form>
		<div id="mod">
	
		</div>
	</div>
</c:if>
<!-- c:out 보안역할  -->


<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser }" data-iboard="${param.iboard }"></div>


<script src="/res/js/boardDetail.js"></script>