<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询</title>
</head>
<style type="text/css">
table {
	font-family: verdana, arial, sans-serif;
	font-size: 15px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table tr {
	background-color: #d4e3e5;
}

tabletd {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/views/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.0/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){
		$(".getPointTotal").click(function (e) {
			 var id = $(this).attr("date");
			$.ajax({
				  async : false,
			      cache : false,
				  type: 'POST',
				  url: "${pageContext.request.contextPath }/getPointsTotalByMembershipId/"+id,
				  success: function(date){
					  alert(id+"号的积分数："+date);
				  },
				  erro: function(){
					  alert("no");
				  }
				});
		});
		
		$(".getMemberType").click(function (e) {
			 var id = $(this).attr("date");
			$.ajax({
				  async : false,
			      cache : false,
				  type: 'POST',
				  url: "${pageContext.request.contextPath }/getMemberType/"+id,
				  success: function(date){
					  alert(id+"号的会员类型："+date);
				  },
				  erro: function(){
					  alert("no");
				  }
				});
		});
	
		$("tr").mouseover(function(){
			this.style.backgroundColor='#ffff66';
		});
		$("tr").mouseout(function(){
			this.style.backgroundColor='#d4e3e5';
		})
	})
</script>
<body>


	<form 
		method="post">
		<table align="center" border="1">
			<tr>

				<td colspan="17" align="center">积分账户列表：</td>
			</tr>
			<tr>
				<td><a title=" pointsAccountID">ID</a></td>
				<td><a title=" progamId">progamId</td>
				<td><a title=" accountStartDttm">accountStartDttm</td>
				<td><a title=" createdById">createdById</td>
				<td><a title=" createDttm">createDttm</td>
				<td><a title=" statusId">SId</td>
				<td><a title=" lastUpdateById">LUId</td>
				<td><a title=" lastUpdateDttm">LUDttm</td>
				<td><a title=" partnerMembershipId">PMId</td>
				<td><a title=" partnerCompanyId">PCID</td>
				<td><a title=" pointsAccountTypeCd">PATCd</td>
				<td><a title=" addPointsNum">APNum</td>
				<td><a title=" dePointsNum">DPNum</td>
				<td><a title=" pointsTotal">pointsTotal</td>
			</tr>
			<c:forEach items="${pointsAccounts }" var="pointAccount" varStatus="s">
				<tr>
					<td>${pointAccount.pointsAccountID}</td>
					<td>${pointAccount.progamId}</td>
					<td>${pointAccount.accountStartDttm}</td>
					<td>${pointAccount.createdById }</td>
					<td>${pointAccount.createDttm }</td>
					<td>${pointAccount.statusId }</td>
					<td>${pointAccount.lastUpdateById }</td>
					<td>${pointAccount.lastUpdateDttm }</td>
					<td>${pointAccount.partnerMembershipId }</td>
					<td>${pointAccount.partnerCompanyId }</td>
					<td>${pointAccount.pointsAccountTypeCd }</td>
					<td>${pointAccount.addPointsNum }</td>
					<td>${pointAccount.dePointsNum }</td>
					<td>${pointAccount.pointsTotal }</td>					
				</tr>
			</c:forEach>

		</table>
	</form>
	<a href="${pageContext.request.contextPath }/views/Login.jsp">返回主页</a>
</body>
</html>