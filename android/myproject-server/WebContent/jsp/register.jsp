<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>register</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/my.css">
<link href="css/blog.css" rel="stylesheet">
<style type="text/css">
body,td,th {
	font-family: allan;
	font-style: normal;
	font-weight: 700;
	color: #6F3;
}

body {
	background-image: url(../image/4.jpg);
}

.my_regbody .my_reg .sidebar-module.sidebar-module-inset .form-signin h2 div
	{
	color: #000;
}
</style>
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>
var __adobewebfontsappname__="dreamweaver"
function MM_popupMsg(msg) { //v1.0
  alert(msg);
}
</script>
</head>
<body class="my_regbody">
	<div class="navbar navbar-default" role="navigation"
		style="background-color: #CCCCCC;">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="header">
					<p>
						<a href="" style="font-size: 23px;">ISport</a> <a
							href="./index.html">首页</a> <a href="">约友</a> <a
							href="./activity.html">活动</a> <a href="">运动宝典</a> <a
							href="./项目场馆教练表.html">场馆&教练</a> <a href="./isport/个人档浏览.html">我</a>
						<span class="name"> <a href="#">张三</a> <a href="#">退出</a>
						</span>
					</p>

				</div>
			</div>
		</div>
	</div>
	<!--填写注册信息-->
	<label for="textfield">:</label>
	<div class="my_reg">
		<div class="sidebar-module sidebar-module-inset">
			<form class="form-signin" role="form">
				<h2 style="color: #FFF">
					<div align="center">注册信息</div>
				</h2>
				<input type="email" class="form-control line" placeholder="邮箱"
					required> <input type="text" class="form-control line"
					placeholder="昵称" required> <input type="password"
					class="form-control line" placeholder="密码 6~20位英文或数字" required>
				<input type="password" required class="form-control line"
					placeholder="确认密码">
				<p>
				<div align="center">
					<label> <span class="label label-primary">男生</span>
					</label> <input type="radio" name="RadioGroup1" value="单选"
						id="RadioGroup1_0"> &nbsp; &nbsp; <span
						class="label label-danger">女生</span> <input type="radio"
						name="RadioGroup1" value="单选" id="RadioGroup1_1">
				</div>
				</p>
				<div align="center">
					&nbsp; <label for="select"><span
						class="label label-primary">省份</span></label> <select name="select"
						id="select"></select>&nbsp;&nbsp;&nbsp; <label for="select2"><span
						class="label label-danger">城市</span></label> <select name="select2"
						id="select2"></select>
					<fieldset></fieldset>
				</div>

				<h5>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div align="center">
						<button type="submit" class="btn btn-lg btn-primary btn-block">提交注册</button>
				</h5>

			</form>
		</div>
	</div>
	</div>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>