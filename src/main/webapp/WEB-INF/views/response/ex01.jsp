<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ex01 res
	<a href="result01">model객체 사용</a>
	<a href="result02">modelAndView객체 사용</a>
	<a href="result03?num=10">modelAttribute 단일값</a>
	<form action="result04" method="post">
		<input type="text" name="name">
		<input type="text" name="age">
		<input type="submit" value="sum">
	</form>
</body>
</html>