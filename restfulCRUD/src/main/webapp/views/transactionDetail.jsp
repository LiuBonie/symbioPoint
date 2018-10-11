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

<body>


	<form action="${pageContext.request.contextPath }/getAllMembership"
		method="post">
		<table align="center" border="1">
			<tr>

				<td colspan="20" align="center">消費賬單：</td>
			</tr>
			<tr>
				<td><a title=" transactionId">ID</a></td>
				<td><a title=" transDetailDttm">TDDTTM</td>
				<td><a title=" transTypeId">transTypeId</td>
				<td><a title=" userId">userId</td>
				<td><a title=" batchHeaderId">batchHeaderId</td>
			 	<td><a title=" ReferenceTransDetailId">RTDID</td> 
				<td><a title=" currencyId">currencyId</td>
				<td><a title=" feeAmt">feeAmt</td>
				<td><a title=" discountAmt">discountAmt</td>
				<td><a title=" taxAmt">taxAmt</td>
				<td><a title=" netAmt">netAmt</td>
				<td><a title=" overrideAmt">OAmt</td>
				<td><a title=" overrideReasonCd">ORCd</td>
				<td><a title=" createdById">CBID</td>
				<td><a title=" createdDttm">CDTTM</td>
				<td><a title=" lastUpdateById">LUID</td>
				<td><a title=" lastUpdateDttm">LUDTTM</td>
				<td><a title=" proratedAmt">PAmt</td>
				<td><a title=" transCompanyid">TCId</td>
			</tr>
				<tr>
					<td>${TransactionDetail.transactionId }</td>
					<td>${TransactionDetail.transDetailDttm}</td>
					<td>${TransactionDetail.transTypeId }</td>
					<td>${TransactionDetail.userId }</td>
					<td>${TransactionDetail.batchHeaderId }</td>
				 	<td>${TransactionDetail.referenceTransDetailId }</td> 
					<td>${TransactionDetail.currencyId }</td>
					<td>${TransactionDetail.feeAmt }</td>
					<td>${TransactionDetail.discountAmt }</td>
					<td>${TransactionDetail.taxAmt }</td>
					<td>${TransactionDetail.netAmt }</td>
					<td>${TransactionDetail.overrideAmt }</td>
					<td>${TransactionDetail.overrideReasonCd }</td>
					<td>${TransactionDetail.createdById }</td>
					<td>${TransactionDetail.createdDttm }</td>
					<td>${TransactionDetail.lastUpdateById }</td>
					<td>${TransactionDetail.lastUpdateDttm }</td>
					<td>${TransactionDetail.proratedAmt }</td>
					<td>${TransactionDetail.transCompanyid }</td>
				</tr>
		</table>
	</form>
	<a href="${pageContext.request.contextPath }/views/Login.jsp">返回主页</a>
</body>
</html>