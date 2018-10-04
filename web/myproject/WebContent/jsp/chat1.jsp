<%@page import="com.chinasofti.myproject.po.Peruser"%>
<%@page import="com.chinasofti.myproject.dao.impl.MessageDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IMessageDao"%>
<%@page import="com.chinasofti.myproject.biz.impl.MessageBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IMessageBiz"%>
<%@page import="com.chinasofti.myproject.dao.impl.PeruserDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IPeruserDao"%>
<%@page import="com.chinasofti.myproject.biz.impl.PersonBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IPersonBiz"%>
<%@page import="com.chinasofti.myproject.po.Person"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天页面</title>
<!-- Bootstrap -->
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!----font-Awesome----->
<link rel="stylesheet"
	href="/myproject/jsp/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700'
	rel='stylesheet' type='text/css'>
<link href="/myproject/jsp/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>
<!----Calender -------->
<link rel="stylesheet" href="/myproject/jsp/css/clndr.css"
	type="text/css" />
<script src="/myproject/jsp/js/underscore-min.js"></script>
<script src="/myproject/jsp/js/moment-2.2.1.js"></script>
<script src="/myproject/jsp/js/clndr.js"></script>
<script src="/myproject/jsp/js/site.js"></script>
<!--- start circle --->
<script src="/myproject/jsp/js/jquery.circliful.min.js"></script>
<script>
	$(document).ready(function() {
		$('#myStat2').circliful();
	});
</script>
<!-- start price_bar  -->
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
<!-- start price_bar  -->
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css" id="page-css">
			/* Styles specific to this particular page */
			.scroll-pane, .scroll-pane-arrows {
				width: 100%;
				height: 450px;
				overflow: auto;
			}
			.horizontal-only {
				height: auto;
				max-height: 200px;
			}
			#contains {
	width: 800px;
	background: #FFF;
	padding: 20px;
	margin: -20px ;
	-moz-border-radius: 50px;
	-webkit-border-radius: 50px;
	border-radius: 50px;
	
}
		</style>
<style type="text/css">

h1 {
	font-size: 100px;
	line-height: 100px;
	font-weight: normal;
	margin-bottom: 100px;
}

a,a:hover {
	border: none;
	text-decoration: none;
}

img,a img {
	border: none;
}

pre {
	overflow-x: scroll;
	background: #ffffff;
	border: 1px solid #cecece;
	padding: 10px;
}

.clear {
	clear: both;
}

.zoomed>.container {
	-webkit-filter: blur(3px);
	filter: blur(3px);
}

.contain {
	width: 505px;
	margin: 0 auto;
}

.gallery {
	list-style-type: none;
	float: left;
	background: #ffffff;
	padding: 20px 20px 10px 20px;
	margin: 0;
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.25);
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.25);
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.25);
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border-radius: 2px;
}

.gallery li {
	float: left;
	padding: 0 10px 10px 0;
}

.gallery li:nth-child(6n) {
	padding-right: 0;
}

.gallery li a,.gallery li img {
	float: left;
}
body{
	overflow-y:scroll;
	font-family:"HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, sans-serif;
	padding:0;
	margin:0;
	background-image: url(/myproject/jsp/image/1.jpg);
	background-size:cover;
	background-attachment:fixed;
}
</style>




<!--图片弹出层样式 必要样式-->
<link rel="stylesheet" href="/myproject/jsp/css/zoom.css" media="all" />
<style type="text/css">
body{
	overflow-y:scroll;
	font-family:"HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, sans-serif;
	padding:0;
	margin:0;
	background-image: url(/myproject/jsp/image/1.jpg);
	background-size:cover;
	background-attachment:fixed;
}
</style>

<script type="text/javascript">
window.onload=function(){
	// refresh();
	/* loadbox(); */
	
};
function refresh(){
	setTimeout("window.location.href='/myproject/ShowMessageServlet?fid='+${requestScope.fid}",5000);	
}; 
function checktext(){
	var text = document.getElementById("text").value;
	if(text ==null || text.length==0){
		alert('发送内容不能为空哦');
		return false;	
	}else {
		return true;
	}
};


var xmlHttp;
function createXMLHttp(){
	   if(window.XMLHttpRequest){
		   xmlHttp = new XMLHttpRequest();
	   } else {
		   xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	   }
};

function loadboxwews(){
	  
	   //var tips = document.getElementById("email").value;
	   createXMLHttp();
	   xmlHttp.open("post","/myproject/LoadMessageboxServlet",true);
	   xmlHttp.onreadystatechange = changetipsCallback;
	  
	   xmlHttp.send(null);
};

function changetipsCallback(){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   document.getElementById("messagebox").innerHTML=xmlHttp.responseHTML;
			//还没写异常处理
		   }
	   }
};

</script>
</head>

<body>

<c:if test="${empty sessionScope.person }">
		<script>
		alert("您还未登陆，点击登陆");
		location="/myproject/jsp/login.jsp";
	</script>
</c:if>
<script>refresh()</script>

		<div class="container">
			<div class="main">
				<div class="h_menu">
					<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
					<nav>
					 <ul class="menu list-unstyled">
             <li class="color1"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
			<li class="color3"><a href="/myproject/jsp/othermain.jsp">好友主页</a></li>   
			 <li class="color2"><a href="main.html">聊天</a></li>
			
            	<li>
				<a href="#">${sessionScope.person.nickname}</a></li>
				<li><a href="/myproject/logoutServlet">退出</a></li>
		
		
					</ul>
					</nav>
					<script src="js/menu.js" type="text/javascript"></script>
				</div>

				<div class="col-md-8 span_of_2">
					<!-- start span1_of_2 -->
					<div class="col-md-6 span1_of_1">
						<!-- start span1_of_3 style1 -->
						<div class="grid1_of_1" style="height: 600px; width: 800px">
							<h4>消息展示</h4>
							
							 <div id="contains">
			<div class="scroll-pane">
			<%List<Message> lstMessage = (List<Message>)request.getAttribute("lstMessage");
			if(lstMessage !=null){			
				IPeruserDao peruserDao = new PeruserDaoImpl();
				IMessageDao messageDao = new MessageDaoImpl();
				for(Message message:lstMessage){
					String nickname = peruserDao.selectById(message.getUserid()).getNickname();
			%>
							<table width="85%" border="0" align="center">
								<tr>
									<td width="23%" height="53"><%=nickname %> <%=message.getMsgtime() %></td>
									<td width="77%"><%=message.getMsgcontext() %></td>
									<hr>
								</tr>
							</table>
			<% 	message.setMsgstatus(1);
			messageDao.updateMessage(message);
			    }
			}
			%>			
							</div>
							</div>
						</div>


					</div>

				</div>
				<!-- end span1_of_2 -->
				<div class="col-md-4 span1_of_3">
					<!-- start span1_of_3 style3 -->



					<div class="grid2_of_1" style="width: 220px;margin-left:100px;height: 700px; ">
						<div class="signin_form" >
						 <% 
                IUserBiz userBiz=new UserBizImpl();
				int fid = Integer.parseInt(request.getParameter("fid"));
				IPeruserDao peruserDao = new PeruserDaoImpl();
				Peruser peruser = peruserDao.selectById(fid);
				%>
							<h4 align="center">好友</h4>
							<p align=""><img src="/myproject/jsp/images/user.png" alt="" class="img-responsive" /></p>
							<h2 align="center"><%=peruser.getNickname()    %></h2>
							 <p>运动标签：
              <% 
				List<String> lstSport=userBiz.showMylabel(fid);
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
						
                         <hr>
                         <h4 align="center">我</h4>
							<img src="/myproject/jsp/images/user.png" alt="" class="img-responsive" />
							<h2 align="center">${sessionScope.person.nickname}</h2>
							 <p>运动标签：
               <% 
                User user=(User)request.getSession().getAttribute("user");
				lstSport = userBiz.showMylabel(user.getUserid());
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
							
                         
						</div>





					</div>
					<!-- end switch_main ---->


					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
				<div class="col-md-8 span_of_2">
					<!-- start span1_of_2 -->
					<div class="col-md-6 span1_of_2">
						<!-- start span1_of_3 style2 -->
						<div class="grid2_of_1" style="height: 150px; width: 800px;margin-top:-150px;">
							<div>
								<form action="/myproject/SendMessageServlet?fid=${requestScope.fid }" method="post" onsubmit=" return checktext();">
									<table width="95%" height="31" border="0" align="center">
										<tr>
											<td width="80%" align="left"><label for="textarea"></label> <textarea
													name="text" id="text" cols="100" rows="5"></textarea></td>

											<td width="20%"><input type="submit"
												class="btn btn-info" align="center" name="send" id="send"
												value="发送"></td>
										</tr>
									</table>


								</form>


							</div>
						</div>


					</div>


				</div>
				<!-- end span1_of_2 -->
				<div class="col-md-4 span1_of_3">
					<!-- start span1_of_3 style3 -->

					<!-- end switch_main ---->

					<div class="copy">
						<p class="link">
							<span></a></span>
						</p>
					</div>
				</div>
			</div>
		
</body>
</html>