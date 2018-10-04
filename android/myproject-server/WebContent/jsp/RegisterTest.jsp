<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="/myproject/jsp/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/myproject/jsp/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/myproject/jsp/css/my.css">
<style type="text/css">
body,td,th {
	font-family: allan;
	font-style: normal;
	font-weight: 700;
	color: #6F3;
}

body {
	background-image: url(/myproject/jsp/image/90.jpg);
}
</style>
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
<script>
	var __adobewebfontsappname__ = "dreamweaver"
</script>
<!-- <script
	src="http://use.edgefonts.net/allan:n7:default;cooper-black-std:n4:default.js"
	type="text/javascript"></script> -->

<script type="text/javascript">
var accountOk,nicknameOk,passwordOk,repswOk;
function nicknameForm(){
	var Nickname = document.getElementById("nickname").value;
	if(Nickname.length<1 || Nickname ==null || Nickname.length>20){
		document.getElementById("labnickname").innerHTML = "昵称不规范哦！";
		//nickname.focus();
		nicknameOk = 0;
	} else{
		checkNickname();
	}
}
function passwordForm(){
	var Password = document.getElementById("password").value;
	if(Password.length<6 || Password ==null || Password.length>16){
		document.getElementById("labpassword").innerHTML = "密码不规范哦！";
		passwordOk = 0;
	} else{
		document.getElementById("labpassword").innerHTML = "ok";
		passwordOk = 1;
	}
}
function repswForm(){
	var Repsw = document.getElementById("repassword").value;
	var Password = document.getElementById("password").value; 
	if(Repsw != Password){
		document.getElementById("labrepsw").innerHTML = "两次密码不一致！";
		repswOk = 0;
	} else{
		document.getElementById("labrepsw").innerHTML = "ok";
		repswOk = 1;
	}
}
//ajax部分
var xmlHttp;

function createXMLHttp(){
	   if(window.XMLHttpRequest){
		   xmlHttp = new XMLHttpRequest();
	   } else if(window.ActiveXObject) {
		   var activexName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
		   for(var i=0;i<activaxName.length;i++){
			   try{
				   xmlHttp = new ActiveXObject(activexName[i]);
				   break;
			   }catch(e){
				   return null;
			   }
		   }
		   
	   }
}
function selectcity(){
	  var province = document.getElementById("province").value;
	  var city = document.getElementById("city");

	  if(province != null){
	
		  switch(province){
		  
		  case '北京':city.options.length = 0;
			city.options.add(new Option('朝阳区','朝阳区'));
			break;
		  				
		  case '天津':city.options.length = 0;
		    city.options.add(new Option('南开区','南开区'));
			break;
		  case '上海':city.options.length = 0;
		  city.options.add(new Option('浦东区','浦东区'));
			break;
						
		  case '广东':city.options.length = 0;
		  city.options.add(new Option('深圳','深圳'));
			break;
						
		  default:city.options.length = 0;
		  alert('没选则');
		  					break;
		  }
	  }
	
}

function checkUsername(){
	  
	   var email = document.getElementById("email").value;
	   if( email.length>1){
		   createXMLHttp();
		   xmlHttp.open("post","/myproject/CheckaccountServlet?email="+email,true);
		   xmlHttp.onreadystatechange = checkUsernameCallback;
		  
		   xmlHttp.send(null);
	   }else {
		  document.getElementById("labemail").innerHTML="邮箱不对哦0=0";
	   }
	
	 //  document.getElementById("labemail").innerHTML="正在验证。。。。";
	  
}
function checkNickname(){
	  
	   var nickname = document.getElementById("nickname").value;
	   if(nickname != null){
		   createXMLHttp();
		   xmlHttp.open("post","/myproject/CheckNicknameServlet?nickname="+nickname,true);
		   xmlHttp.onreadystatechange = checkNicknameCallback;
		  
		   xmlHttp.send(null);
		   //document.getElementById("labnickname").innerHTML="正在验证。。。。";
	   } else{
		   return ;
	   }
	 
	  
}

function checkUsernameCallback(){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   var  AccountOk=xmlHttp.responseText;
			  // alert(AccountOk);
			   if(AccountOk == 1){
					  document.getElementById("labemail").innerHTML="邮箱已注册！";
					  accountOk = 0;
					 // alert('1');
				  }
			   else{
					  document.getElementById("labemail").innerHTML="ok";
					  accountOk = 1;
				  }
		   }
	   }
}
function checkNicknameCallback(){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   var  NicknameOk = xmlHttp.responseText;

			   if(NicknameOk == 1){
		
					  document.getElementById("labnickname").innerHTML="昵称已被使用！";
					  
					nicknameOk = 0;
				  }else {
					  document.getElementById("labnickname").innerHTML="ok";	  
				
					 nicknameOk = 1;
					 // return true;
				  }
		   }
	   }
}

function checkregister(){
	if(accountOk==1 && nicknameOk==1 && passwordOk==1 && repswOk==1  ){
		//alert('hhh');
		return true;
	}else{
		alert('信息没填好哦0=0');
	return false;
	}
	
}

function loadimage(){

document.getElementById("randImage").src = "identifycode.jsp?"+Math.random();

}

function identifycode(){
	var inputcode = document.getElementById("inputrand").value;
	var randcode = "<%=session.getAttribute("rand")%>";
/* 	var randcode = ${sessionScope.rand}; */

	if(randcode== inputcode){
		document.getElementById("inputcodeok").innerHTML="ok";
		} else{
			document.getElementById("inputcodeok").innerHTML="手抖了吗？不对";
		}
}
function test(){
	alert('gfggggg');
}
</script>

</head>
<body>
<body class="my_regbody">
	
	
	
	<!--填写注册信息-->
	<label id="info"> </label>
	<label for="textfield">:</label>
	<div class="my_reg">
		<form class="form-signin" role="form" action="/myproject/RegisterServlet" 
			method="post" onsubmit="return checkregister();">
			<h1 class="form-signin-heading" style="color: #000033;"></h1>
				请填写注册信息 
			<span>	<input type="email" id="email" name="email"
					class="form-control line" placeholder="邮箱" 
					 onblur="javascript:checkUsername()" required />
					 <label id="labemail"></label>
					 </span>
			
			<nobr><span><input type="text" name="nickname" id="nickname"
				class="form-control line" placeholder="昵称1~20位" required
				onblur="javascript:nicknameForm();" /> 
				<label id="labnickname"></label>
				</span> </nobr>
			<input type="password" name="password"
				id="password" class="form-control line"
				placeholder="密码 6 ~ 16位英文或数字" required
				onblur="javascript:passwordForm();" /> 
				<label id="labpassword"></label> 
			<nobr><input type="password" name="repassword" id="repassword"
				class="form-control line" placeholder="确认密码" required
				onblur="javascript:repswForm();" /> 
				<label id="labrepsw"></label>
			<p></nobr>
				<label> <span
					style="font-size: 16px; color: #0000FF; font-style: normal; font-weight: 400; font-family: cooper-black-std;">男生
				</span> <input type="radio" name="Radiogender" value="男生"
					id="RadioGroup1_0" required>
				</label> &nbsp; &nbsp; &nbsp; <input type="radio" name="Radiogender"
					value="女生" id="RadioGroup1_1" required> <label>女生</label> <br>
				<br>
			</p>
			<label for="select">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
				style="font-size: 16px; color: #000033;">省份:</span></label> <select
				name="select" id="province" required onchange="javascript:selectcity();">
					
					<option value="北京">北京</option>
					<option value="天津">天津</option>
					<option value="上海">上海</option>
					<option value="广东">广东</option>

			</select> &nbsp; 
			 <label for="select2"><span
				style="font-size: 16px; color: #000000;">&nbsp;&nbsp; 城市:</span></label> <select
				name="select2" id="city" >
				
			</select>
			

<table width="256" border="0" cellpadding="0" cellspacing="0">
<!--DWLayoutTable-->

				<tr>
			
					<td width="118" height="22" valign="middle" align="center"><input
						type="text" id="inputrand" size="15" onblur="javascript:identifycode();"></td>
					<td width="138" valign="middle" align="center"><img
						alt="code..." name="randImage" id="randImage"
						data-osrc="identifycode.jsp" width="60" height="20" border="1"
						align="absmiddle"></td>
					<td width="150" height="22" align="middle" valign="middle"><a
						href="javascript:loadimage();"><font class=pt95>看不清点我</font></a></td>
				</tr>
				<tr>

				</tr>
			</table>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit" id="register"  >提交注册</button>
		
		</form>

	</div>

	<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
	<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>
</body>
</body>
</html>