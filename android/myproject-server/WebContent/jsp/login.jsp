<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css"
	href="/myproject/jsp/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="/myproject/jsp/css/login.css">
<link rel="stylesheet" type="text/css"
	href="/myproject/jsp/css/index.css">
<style type="text/css">
body {
	background-image: url(/myproject/jsp/image/90.jpg);
}
</style>
</head>
<body>
<c:if test="${!empty requestScope.msgcode }">
	<%
		int msgcode = Integer.parseInt(request.getAttribute("msgcode").toString());
		switch(msgcode){
		case 101:
			out.print("<script>alert('账号或密码错误，登录失败！');</script>");
			break;
		case 103:
			out.print("<script>alert('当前账号已经登录！');</script>");
			break;
		default:
			break;
		}
	%>
</c:if>
	<!-- 上方菜单 -->
	<!-- header begin -->
	
	<!-- header end -->
	<!-- 上方菜单结束 -->

	<div class="flash">
		</br> </br> </br>
		<div class="bed">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
				codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
				width="680" height="500" title="flash">
				<param name="movie" value="flash.swf" />
				<param name="quality" value="high" />
				<embed src="/myproject/jsp/image/flash.swf" quality="high"
					pluginspage="http://www.macromedia.com/go/getflashplayer"
					type="application/x-shockwave-flash" width="680" height="500"
					loop="false"></embed>
			</object>
		</div>
		<div class="login-form">
			<form class="form-signin" role="form" name="form1" method="post"
				action="/myproject-server/loginServlet">
				<h2 class="form-signin-heading">请登陆</h2>
				</br>
				<c:if test="${empty requestScope.account }">
					<input type="text" name="account" class="form-control" id="account" placeholder="账号" required>
				</c:if>
				<c:if test="${!empty requestScope.account }">
					<input type="text" name="account" class="form-control" id="account" placeholder="账号"
						value="${requestScope.account }">
				</c:if>
				</br> 
				<input type="password" name="password" class="form-control" placeholder="密码"
					required></br>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-info btn-inline" type="submit">登陆</button>
				<a class="btn btn-lg btn-info btn-inline" type="button"
					href="/myproject/jsp/RegisterTest.jsp">注册
					</button>
			</form>
		</div>
	</div>
</body>
</html>