<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<a href="/user/logout"><button>로그아웃</button></a>
	<h1>리스트</h1>
	
	<form action="list" method="get">
		<div>
			<input type="search" name="search" value="${param.search }">
			<input type="submit" value="검색">			
		</div>
	</form>
	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일시</td>
			
		</tr>	
		<c:forEach var="item" items="${requestScope.list }">
		<tr class="record" onclick="location.href='detail?iboard=${item.iboard}'">
			<td>${item.iboard }</td>
			<td>${item.unm }</td>
			<td>${item.title }</td>
			<td>${item.regdt }</td>
			
		</tr>	
		</c:forEach>
	</table>
	<div>
		<c:forEach var="cnt" begin="1" end="${requestScope.totalPage }">
			<a href="list?page=${cnt }&search=${param.search}"><span>${cnt }</span></a>
		</c:forEach>
	</div>
	<a href="write">글작성하기</a>
