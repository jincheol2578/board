<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>리스트</h1>

<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>글쓴이</td>
		<td>작성일시</td>
	</tr>
	<c:forEach items="${requestScope.list }" var="item">
		<tr>
			<td>${item.iboard }</td>
			<td>${item.title }</td>
			<td>${item.writerNm }</td>
			<td>${item.regdt }</td>
		</tr>
	
</c:forEach>
</table>