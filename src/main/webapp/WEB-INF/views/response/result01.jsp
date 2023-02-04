<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String data = (String)request.getAttribute("data");
    	
    	Date serverTime  = (Date)request.getAttribute("serverTime");
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 ${data } <!-- request.get이 자동으로 됨 -->
	 ${serverTime }
</body>
</html>