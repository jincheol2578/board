<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/res/css/userMypage.css">
	<c:choose>
		<c:when test="${empty requestScope.loginUser.profileImg }">
			<c:set var="img" value="/res/img/noprofile.jpg"/>
		</c:when>
		<c:otherwise>
			<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg }"/>		
		</c:otherwise>
	</c:choose>
	
<div>
	<form action="" method="post" enctype="multipart/form-data">
		이미지변경 : <input type="file" name="profileImg" accept="image/*">
		<input type="submit" value="이미지 업로드">
	</form>

</div>
	
<div>
	<div><img src="${img }"></div>
	<div>pk : ${sessionScope.loginUser.iuser }</div>
	<div>ID : ${sessionScope.loginUser.uid}</div>
	<div>Name : ${sessionScope.loginUser.unm }</div>
</div>
