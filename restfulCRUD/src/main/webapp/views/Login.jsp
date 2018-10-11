<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Symbio_Points System</title>
<style type="text/css">
body{
	background-color: gray;
}
a{
	text-decoration: none;
	text-align: center;
	display:inline-block;
	width:1900px;
	color:white;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">Symbio_Points System</h1>
	
	<a href="${pageContext.request.contextPath }/views/addMembership.jsp">Enter member information</a>
	<br/><br/>
	<a href="${pageContext.request.contextPath }/getAllMembership">Query member information</a>
	<br/><br/>
	<a href="${pageContext.request.contextPath }/views/PointOperating.jsp">PointOperating</a>
</body>
</html>