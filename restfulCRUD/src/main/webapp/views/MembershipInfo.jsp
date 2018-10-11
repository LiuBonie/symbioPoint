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


	<form action="${pageContext.request.contextPath }/getAllMembership"
		method="post">
		<table align="center" border="1">
			<tr>

				<td colspan="23" align="center">人员出差信息列表：</td>
			</tr>
			<tr>
				<td><a title=" membershipId">ID</a></td>
				<td><a title=" lastName">姓</td>
				<td><a title=" firstName">名</td>
				<td><a title=" email">邮箱</td>
				<td><a title=" address">地址</td>
				<td><a title=" cellPhone">手机号</td>
				<td><a title=" initialDttm">IDDTM</td>
				<td><a title=" membershipNum">MNum</td>
				<td><a title=" statusId">SId</td>
				<td><a title=" lastUpdateById">LUId</td>
				<td><a title=" lastUpdateDttm">LUDttm</td>
				<td><a title=" createdbyId">CId</td>
				<td><a title=" createdDttm">CDttm</td>
				<td><a title=" enterpriseCd">ECd</td>
				<td><a title=" productLineId">PId</td>
				<td><a title=" externalMembershipId">EMId</td>
				<td><a title=" memberTypeId">MTId</td>
				<td><a title=" sourceCompanyId">SCId</td>
				<td colspan="5" align="center"><a title=" operating">operating</td>
			</tr>
			<c:forEach items="${memberships }" var="membership" varStatus="s">
				<tr>
					<td>${membership.membershipId }</td>
					<td>${membership.lastName}</td>
					<td>${membership.firstName}</td>
					<td>${membership.email }</td>
					<td>${membership.address }</td>
					<td>${membership.cellPhone }</td>
					<td>${membership.initialDttm }</td>
					<td>${membership.membershipNum }</td>
					<td>${membership.statusId }</td>
					<td>${membership.lastUpdateById }</td>
					<td>${membership.lastUpdateDttm }</td>
					<td>${membership.createdbyId }</td>
					<td>${membership.createdDttm }</td>
					<td>${membership.enterpriseCd }</td>
					<td>${membership.productLineId }</td>
					<td>${membership.externalMembershipId }</td>
					<td>${membership.memberTypeId }</td>
					<td>${membership.sourceCompanyId }</td>
					<td><a
						href="${pageContext.request.contextPath }/delMembership/${membership.membershipId}"
						onclick="alert(${membership.membershipId}+'号删除成功')">删除</a></td>
					<td><a
						href="${pageContext.request.contextPath }/views/putMembership.jsp?id=${membership.membershipId}">更新</a></td>
					<td><a class = "getPointTotal" date="${membership.membershipId}"
						href="javascript:void(0);" >积分数</a></td>
					<td><a
						href="${pageContext.request.contextPath }/getTransactionDetail?id=${membership.membershipId}">消费账单</a></td>
					<td><a class = "getMemberType" date="${membership.membershipId}"
						href="javascript:void(0);" ">会员类型</a></td>
				</tr>
			</c:forEach>

		</table>
	</form>
	<a href="${pageContext.request.contextPath }/views/Login.jsp">返回主页</a>
</body>
</html>