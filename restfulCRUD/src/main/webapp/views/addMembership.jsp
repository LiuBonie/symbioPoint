<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	SimpleDateFormat aa = new SimpleDateFormat("MM/dd/YYYY HH:mm aa",Locale.ENGLISH);
	String time = aa.format(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"> 
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    // date time picker
 
        $("#initialDttm").datetimepicker({
            locale: "zh-cn",
            format: "MM/DD/YYYY",
            dayViewHeaderFormat: "YYYY年 MMMM"
        });
        $("#lastUpdateDttm").datetimepicker({
        	locale: "zh-cn",
            format: "MM/DD/YYYY",
            dayViewHeaderFormat: "YYYY年 MMMM"
        });$("#createdDttm").datetimepicker({
        	locale: "zh-cn",
            format: "MM/DD/YYYY",
            dayViewHeaderFormat: "YYYY年 MMMM"
        }); 
        
        let re = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;

        //绑定文本输入时触发的事件
        email.oninput = function () {

        let textBox = this.value;

        //判断检测这个值是否正确，
        if(re.test(textBox)){//如果验证正确执行以下代码
        notice.innerHTML = '邮箱验证成功';
        notice.style.color = 'green';
        }else {//验证不成功，执行以下代码
        notice.innerHTML = '邮箱验证不成功，请重新输入';
        notice.style.color = 'red';
        }
        }
})
</script>
</head>
<body>

	<div class="info">
		<form action="<%=basePath%>/memadd" method="post">
		
		<div class="lastName">
			<span>lastName:</span>
			<input type="text" name="lastName" id="lastName" placeholder="lastName"/>
		</div>
		<div class="firstName">
			<span>firstName:</span>
			<input type="text" name="firstName" id="firstName" placeholder="firstName"/> 
		</div>
		<div>
			<span>email:</span>
			<input type="text" name="email" id="email" placeholder="email" /> 
			<p id="notice" style="display: inline;"></p>
		</div>
		<div>
			<span>address:</span>
			<input type="text" name="address" id="address" placeholder="address" />
		</div>
		<div>
			<span>cellPhone:</span>	
			<input type="text" name="cellPhone" id="cellPhone"  placeholder="cellPhone"/>
		</div>
		<div>
			<span>initialDttm:</span>
			<input type="text" name="initialDttm" id="initialDttm" placeholder="initialDttm"/>
		</div>
		<div>
			<span>membershipNum:</span>
			<input type="text" name="membershipNum" id="membershipNum" placeholder="membershipNum"/>
		</div>
		<div>
			<span>statusId:</span>
			<input type="text" name="statusId" id="statusId" placeholder="statusId"/>
		</div>
		<div>
			<span>lastUpdateById:</span>
			<input type="text" name="lastUpdateById" id="lastUpdateById" placeholder="lastUpdateById">
		</div>
		<div>
			<span>lastUpdateDttm:</span>
			<input type="text" name="lastUpdateDttm" id="lastUpdateDttm" placeholder="lastUpdateDttm">
		</div>
		<div>
			<span>createdbyId:</span>
			<input type="text" name="createdbyId" id="createdbyId" placeholder="createdbyId">
		</div>
		<div>
			<span>createdDttm:</span>
			<input type="text" name="createdDttm" id="createdDttm" placeholder="createdDttm">
		</div>
		<div>
			<span>enterpriseCd:</span>
			<input type="text" name="enterpriseCd" id="enterpriseCd" placeholder="enterpriseCd">
		</div>
		<div>
			<span>productLineId:</span>
			<input type="text" name="productLineId" id="productLineId" placeholder="productLineId">
		</div>
		<div>
			<span>externalMembershipId:</span>
			<input type="text" name="externalMembershipId" id="externalMembershipId" placeholder="externalMembershipId">
		</div>
		<div>
			<span>memberTypeId:</span>
			<input type="text" name="memberTypeId" id="memberTypeId" placeholder="memberTypeId">
		</div>
		<div>
			<span>sourceCompanyId:</span>
			<input type="text" name="sourceCompanyId" id="sourceCompanyId" placeholder="sourceCompanyId">
		</div>
		<div>
			<p>${Msg }</p>
			<input type="submit" id="sub" value="提交" >
		</div>
		</form>
		<a href="${pageContext.request.contextPath }/views/Login.jsp">返回主页</a>
	</div>	
</body>
</html>