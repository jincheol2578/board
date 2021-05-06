<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
</head>
<body>
	<h1>ToDo List</h1>
	<form action="/write" method="post">
		<div>
		제목 : <input type="text" name="title">
		</div>
		<div>
		내용 : <input type="text" name="content">
		</div>
		<input type="submit" value="작성">
	</form>
	<table>
		<tr>
			<td>할일</td>
			<td>내용</td>
			<td>날짜</td>
		</tr>
	</table>
		
	<c:forEach var="item" items="${data}" varStatus="status" >
	<form action="/mod" method="post" onsubmit="return mod(${item.iTodo});">
					<input type="hidden" name="itodo" value="${item.iTodo }">
		<table>
			<tr>
				<td>
					<input type="text" name="mtitle" id="mtitle${item.iTodo}" value="${item.title }" readonly>
				</td>
				<td>
					<input type="text" name="mcontent" id="mcontent${item.iTodo}" value="${item.content }" readonly>
				</td>
				<td>
					<input type="text" value="${item.regdt }" readonly>
				</td>
				<td><input type="button" value="삭제" onclick="del(${item.iTodo})"></td>
				<td><input type="submit" value="수정" id="btnMod${item.iTodo}"></td>
			</tr>
		</table>
	</form>
	</c:forEach>
</body>
<script>
	function mod(i) {
		var btn = document.getElementById('btnMod'+i);
		var tRead = document.getElementById('mtitle'+i);
		var cRead = document.getElementById('mcontent'+i);
		
		if (btn.value === "수정"){
			btn.value = "완료";
			tRead.readOnly = false;
			cRead.readOnly = false;
			return false;
			
		}else{
			btn.value = "수정";
			tRead.readOnly = true;
			cRead.readOnly = true;
			return true;
		}
		
	}
	function del(i) {
		location.href= '/del?itodo='+i;
	}
	/* function formsubmit(f){
    	var name = f.name;
        f.submit();
        console.log("11");
    } */
</script>
</html>