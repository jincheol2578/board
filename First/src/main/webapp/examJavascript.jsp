<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<input type="text" id="num1" value=""><br>
		<input type="text" id="num2" value="">
		<button onclick="sum();">더하기</button>
		<button onclick="minus();">빼기</button>
	</div>
	<div>
		<input type="text" id="result">
	</div>
	
	<script>
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2');
		var resultElem = document.querySelector('#result');
		
		
		function sum() {
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			
			resultElem.value = Number(num1)+Number(num2);
			
		}
		function minus(){
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			
			resultElem.value = Number(num1)-Number(num2);
			
		}
	</script>
</body>
</html>