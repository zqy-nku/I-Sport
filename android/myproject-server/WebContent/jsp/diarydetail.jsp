<%@page import="com.chinasofti.myproject.po.Peruser"%>
<%@page import="com.chinasofti.myproject.dao.impl.PeruserDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IPeruserDao"%>
<%@page import="com.chinasofti.myproject.dao.impl.PersonDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.impl.MydiaryDaoImpl"%>
<%@page import="com.chinasofti.myproject.po.Mydiary"%>
<%@page import="com.chinasofti.myproject.biz.impl.MydiaryBizImpl"%>
<%@page import="com.chinasofti.myproject.dao.IMydiaryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>浏览日志</title>
	<!-- font awesome -->
		<link href="/myproject/jsp/css/font-awesome.css" rel="stylesheet" />
		
		<!-- css -->
		<link rel="stylesheet" href="/myproject/jsp/css/styles.css" />
        <link href="/myproject/jsp/img/common/favicon.png" rel="shortcut icon" />
		<!--[if lt IE 8]>
		<link rel="stylesheet" href="css/styles.ie7.css" />
		<![endif]-->
		
		<link rel="stylesheet" href="/myproject/jsp/css/vendor/github.min.css" />
		<link href="/myproject/jsp/css/jpage.css" rel="stylesheet" type="text/css" />		
		
		<!-- js -->		
        <script src="/myproject/jsp/js/vendor/jquery-1.10.0.min.js"></script>			
		<script src="/myproject/jsp/js/jpage.min.js"></script>
		
			
			<script>
			$('document').ready(function(){
				$('#jpage').jpage({
					effect: 'random' //'', 'crossfade', 'bricks', 'slideLeft', 'slideRight', 'random'
				});
			});
			</script>
<!-- Bootstrap -->
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!----font-Awesome----->
   	<link rel="stylesheet" href="/myproject/jsp/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700' rel='stylesheet' type='text/css'>
<link href="/myproject/jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>
<!----Calender -------->
<link rel="stylesheet" href="/myproject/jsp/css/clndr.css" type="text/css" />
<script src="/myproject/jsp/js/underscore-min.js"></script>
<script src= "/myproject/jsp/js/moment-2.2.1.js"></script>
<script src="/myproject/jsp/js/clndr.js"></script>
<script src="/myproject/jsp/js/site.js"></script>
<!--- start circle --->
<script src="/myproject/jsp/js/jquery.circliful.min.js"></script>
<script>
$( document ).ready(function() {
		$('#myStat2').circliful();
    });
</script>

		<link rel="stylesheet" href="/myproject/jsp/css/styles.css" />
	<link href="/myproject/jsp/css/jpage.css" rel="stylesheet" type="text/css" />		
		
 <!-- start price_bar  -->	
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
	<!-- styles specific to demo site -->
		<link type="text/css" href="/myproject/jsp/style/demo.css" rel="stylesheet" media="all" />
		<!-- styles needed by jScrollPane - include in your own sites -->
		<link type="text/css" href="/myproject/jsp/style/jquery.jscrollpane.css" rel="stylesheet" media="all" />
		<!-- the styles for the lozenge theme -->
		<link type="text/css" href="/myproject/jsp/style/jquery.jscrollpane.lozenge.css" rel="stylesheet" media="all" />

		<style type="text/css" id="page-css">
			/* Styles specific to this particular page */
			.scroll-pane, .scroll-pane-arrows {
				width: 100%;
				height: 330px;
				overflow: auto;
			}
				.scroll-pana, .scroll-pane-arrows {
				width: 100%;
				height: 260px;
				overflow: auto;
			}
			.horizontal-only {
				height: auto;
				max-height: 200px;
			}
			#contains {
	width: 300px;
	background: #FFF;
	padding: 20px;
	margin: -20px ;
	-moz-border-radius: 50px;
	-webkit-border-radius: 50px;
	border-radius: 50px;
	
}
#containe {
	width: 800px;
	background: #FFF;
	padding: 20px;
	margin: -20px ;
	-moz-border-radius: 50px;
	-webkit-border-radius: 50px;
	border-radius: 50px;
	
}
		</style>

		<!-- latest jQuery direct from google's CDN -->
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<!-- the mousewheel plugin -->
		<script type="text/javascript" src="/myproject/jsp/js/jquery.mousewheel.js"></script>
		<!-- the jScrollPane script -->
		<script type="text/javascript" src="/myproject/jsp/js/jquery.jscrollpane.min.js"></script>

		<script type="text/javascript" id="sourcecode">
			$(function() {
			$('.scroll-pane').jScrollPane();
			$('.scroll-pane-arrows').jScrollPane({
			showArrows:true,horizontalGutter:10
			});
			});
		</script>
<style type="text/css">
body{
	overflow-y:scroll;
	font-family:"HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, sans-serif;
	background:#f4f4f4;
	padding:0;
	margin:0;
	background-image: url(/myproject/jsp/image/1.jpg);
	background-size:cover;
	background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<c:if test="${empty sessionScope.person }">
	<script>
		alert("您还未登陆，点击登陆");
		location="/myproject/jsp/login.jsp";
	</script>
</c:if>
<div class="container">
<div class="main">
	<div class="h_menu">
	  <nav>
		<ul class="menu list-unstyled">
			 <li class="color1"><a href="/myproject/jsp/index.jsp">首页</a>
		    <li class="color2"><a href="/myproject/jsp/activity.jsp">活动</a>
		    <li class="color3"><a href="/myproject/jsp/treasure.jsp">运动宝典 </a>
			<li class="color1"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
			<li class="color2"><a href="/myproject/jsp/photo.jsp">相册</a></li>
            <li class="color3"><a href="/myproject/jsp/changeinfo.jsp">个人管理</a></li>
		</ul>
	  </nav>
	  <script src="js/menu.js" type="text/javascript"></script>
		</div>
		<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			<div class="grid1_of_1" style="height:600px; width:300px;">
            <img src="images/user.png" alt="" class="img-responsive" />
            <%
            Mydiary mydiary=(Mydiary)request.getAttribute("mydiary");
            int userid=mydiary.getUserid();
            IPeruserDao peruserDao=new PeruserDaoImpl();
            Peruser peruser=peruserDao.selectById(userid);
            %>
				<h3><%=peruser.getNickname() %></h3>
                 <p>运动标签：
               <% 
                IUserBiz userBiz=new UserBizImpl();
				List<String> lstSport=userBiz.showMylabel(userid);
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
                <hr>
                <h3>日志列表</h3>
            <div id="contains">

			<div class="scroll-pane">
			  <%
					   IMydiaryDao mydiaryDao=new MydiaryDaoImpl();
					   List<Mydiary> lstMydiary=mydiaryDao.selectByUserid(userid);
					   for (Mydiary mdiary : lstMydiary) {%>
					   <!-- 显示所有日志 -->
				<blockquote>
								<h3>
									<div align="left"><%=mdiary.getMdiaryname() %></div>
								</h3>
								<div class="span4">

									<p><%=mdiary.getMdiarytime() %><a href="/myproject/viewDiaryServlet?mdiaryid=<%=mdiary.getMdiaryid()%>">点击查看</a>
									</p>
								</div>
								<p></p>
							</blockquote>
                          <!-- 显示日志结束 -->
                         <% } %>
		</div>
        </div>
				
    </div>
		
			<div class="grid1_of_list1">	
			</div>
		</div>
        
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:600px; width:720px; margin-left:-35px;">
            <div class="list box text-shadow" data-type="content">		
				<div class="signin_form" >
                					
								<!-- img -->
                              
							<div class="list-item box" style="margin-left:0px; height:550px;">					
								<!-- img -->
								<div class="img left"  style="width:200px; height:0px;"></div>
								 <a class="btn btn-sm btn" href="/myproject/jsp/main.jsp">返回上一页</a>
								<!-- data -->
							  <div class="block right">
									<p class="date">发帖时间:${mydiary.mdiarytime}&nbsp;&nbsp; &nbsp;&nbsp;by<%=peruser.getNickname() %></p>
								<p class="title"></p>
								<p class="desc">
							    </p>
							    <p class="like">&nbsp;  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日志标题：${mydiary.mdiaryname}</p>
							    <table width="99%" height="302" border="0">
								    <tr>
								      <th width="6%" height="22" scope="row">&nbsp;</th>
								      <th width="6%" scope="row">&nbsp;</th>
								      <th width="7%" scope="row">&nbsp;</th>
								      <th width="44%" scope="row">&nbsp;&nbsp; &nbsp;&nbsp;</th>
								      <td width="15%">&nbsp;</td>
								      <td width="22%">&nbsp;</td>
							        </tr>
								    <tr>
								      <th height="80" colspan="6" scope="row">日志图片：<img  src="/myproject/upload/diary/${mydiary.mdiaryresid}"
										style="width: 140px; height: 140px;"></th>
							      </tr>
								    <tr>
								      <th height="192" colspan="6" scope="row"><p>日志内容：${mydiary.mdiarycont}</p></th>
							        </tr>
							    </table>
								  <p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
									<p class="like"></p>
							  </div>
							</div>
                            
								
								<!-- data -->
							
                           
							</div>
                            </p>
                            
                   
			</div>
			
			
		</div>
	</div><!-- end span1_of_2 -->	

        
        	
	<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
    <div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 --><!-- end switch_main ---->
        
  <div class="copy">
		<p class="link"><span></a></span></p>
	</div>
</div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>