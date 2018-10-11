<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>PointOpreating</title>
<style type="text/css">
form{
	display: none;
}
#bigDiv{
	text-align: center;
}
#bigDiv span{
	font-size: 15px;
} 
#line{
	background-color: orange;
	display: inline-block;
	width: 1900px;
	height: 10px;
	margin: 0px;
} 
h1:first-child{
	margin: 5px;
}
</style>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all">
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	 $(".beginDate").datetimepicker({
         locale: "zh-cn",
         format: "MM/DD/YYYY",
         dayViewHeaderFormat: "YYYY年 MMMM"
     });
     $(".endDate").datetimepicker({
     	 locale: "zh-cn",
         format: "MM/DD/YYYY",
         dayViewHeaderFormat: "YYYY年 MMMM"
     });
	$('h2').bind("selectstart", function () { return false; });
	$("#h1").click(function () {
		if($("#form1").css("display")=="none"){
			$("#h1").css({"background-color":"gray","color": "white"});
			$("#form1").css("display","inline");
		}else{
			$("#h1").css({"background-color":"white","color": "black"});
			$("#form1").css("display","none");
		}
	})
	$("#h2").click(function () {
		if($("#form2").css("display")=="none"){
			$("#h2").css({"background-color":"gray","color": "white"});
			$("#form2").css("display","block");
		}else{
			$("#h2").css({"background-color":"white","color": "black"});
			$("#form2").css("display","none");
		}
	})
	$("#h3").click(function () {
		if($("#form3").css("display")=="none"){
			$("#h3").css({"background-color":"gray","color": "white"});
			$("#form3").css("display","block");
		}else{
			$("#h3").css({"background-color":"white","color": "black"});
			$("#form3").css("display","none");
		}
	})
	$("#h4").click(function () {
		if($("#form4").css("display")=="none"){
			$("#h4").css({"background-color":"gray","color": "white"});
			$("#form4").css("display","block");
		}else{
			$("#h4").css({"background-color":"white","color": "black"});
			$("#form4").css("display","none");
		}
	})
	$("#h5").click(function () {
		if($("#form5").css("display")=="none"){
			$("#h5").css({"background-color":"gray","color": "white"});
			$("#form5").css("display","block");
		}else{
			$("#h5").css({"background-color":"white","color": "black"});
			$("#form5").css("display","none");
		}
	})
	$("#h6").click(function () {
		if($("#form6").css("display")=="none"){
			$("#h6").css({"background-color":"gray","color": "white"});
			$("#form6").css("display","block");
		}else{
			$("#h6").css({"background-color":"white","color": "black"});
			$("#form6").css("display","none");
		}
	})
	$("#h7").click(function () {
		if($("#form7").css("display")=="none"){
			$("#h7").css({"background-color":"gray","color": "white"});
			$("#form7").css("display","block");
		}else{
			$("#h7").css({"background-color":"white","color": "black"});
			$("#form7").css("display","none");
		}
	})
	
})
</script>
</head>
<body>
<div id="bigDiv">
	<div>
		<h1>Symbio_Points Operating</h1>
		<h1 id="line"></h1>
	</div>
	<div> 
		<h2 id="h1">pointsDeposit</h2>
		<form action="${pageContext.request.contextPath }/pointsDeposit" method="get" id="form1" >
			<span>pointsNum:</span><input type="text" id="pointsNum" name="pointsNum">
			<span>memershipId:</span><input type="text" id="memershipId" name="memershipId">
			<input type="submit" value="Deposit">
		</form>
	</div>
	<div> 
		<h2 id="h2">pointSpend</h2>
		<form action="${pageContext.request.contextPath }/pointSpend" method="get" id="form2">
			<span>pointsNum:</span><input type="text" id="pointsNum" name="pointsNum">
			<span>memershipId:</span><input type="text" id="memershipId" name="memershipId">
			<input type="submit" value="Spend">
		</form>
	</div>
	<div> 
		<h2 id="h3">transferPoints</h2>
		<form action="${pageContext.request.contextPath }/transferPoints" method="get" id="form3">
			<span>pointsNum:</span><input type="text" id="pointsNum" name="pointsNum">
			<span>memershipId1:</span><input type="text" id="memershipId1" name="memershipId1">
			<span>memershipId2:</span><input type="text" id="memershipId2" name="memershipId2">
			<input type="submit" value="transfer">
		</form>
	</div>
	<div> 
		<h2 id="h4">cancelDeposit</h2>
		<form action="${pageContext.request.contextPath}/cancelDeposit" method="get" id="form4">
			<span>memershipId:</span><input type="text" id="memershipId" name="memershipId">
			<input type="submit" value="cancelDeposit">
		</form>
	</div>
	<div> 
		<h2 id="h5">cacelSpend</h2>
		<form action="${pageContext.request.contextPath }/cacelSpend" method="get" id="form5">
			<span>memershipId:</span><input type="text" id="memershipId" name="memershipId">
			<input type="submit" value="cacelSpend">
		</form>
	</div>
	<div> 
		<h2 id="h6">cleanPoints</h2>
		<form action="${pageContext.request.contextPath }/cleanPoints" method="get" id="form6">
			<span>beginDate:</span><input type="text" class="beginDate" name="beginDate">
			<span>endDate:</span><input type="text" class="endDate" name="endDate">
			<input type="submit" value="cleanPoints">
		</form>
	</div>
	<div> 
		<h2 id="h7">getPointsDetailByDate</h2>
		<form action="${pageContext.request.contextPath }/getPointsDetailByDate" method="post" id="form7">
			<span>beginDate:</span><input type="text" class="beginDate" name="beginDate">
			<span>endDate:</span><input type="text" class="endDate" name="endDate">
			<input type="submit" value="getPointsDetailByDate">
		</form>
	</div>
			<a href="${pageContext.request.contextPath }/views/Login.jsp">返回主页</a>
</div>
</body>
</html>