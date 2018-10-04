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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场馆信息</title>
<!-- Bootstrap -->
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!----font-Awesome----->
   	<link rel="stylesheet" href="/myproject/jsp/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700' rel='stylesheet' type='text/css'>
<link href="/myproject/jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>

<!--- start circle --->
<script src="/myproject/jsp/js/jquery.circliful.min.js"></script>
<script>
$( document ).ready(function() {
		$('#myStat2').circliful();
    });
</script>
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
				height: 450px;
				overflow: auto;
			}
			.horizontal-only {
				height: auto;
				max-height: 200px;
			}
			#contains {
	width: 220px;
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
	padding:0;
	margin:0;
	background-image: url(/myproject/jsp/image/1.jpg);
	background-size:cover;
	background-attachment:fixed;
}
</style>
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
			<li class="color1"><a href="/myproject/jsp/index.jsp">首页</a></li>
			<li class="color2"><a href="/myproject/jsp/activity.jsp">活动</a></li>
			<li class="color3"><a href="/myproject/jsp/coach-venue.jsp">场馆和教练</a></li>
            <li class="color1"><a href="/myproject/jsp/treasure.jsp">运动宝典</a></li>
             <li class="color2"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
            <li><img style="width:200px;" src="/myproject/jsp/images/newactivity.jpg"></li>
            	<li>
				<a href="#">${sessionScope.person.nickname}</a></li>
				<li><a href="/myproject/logoutServlet">退出</a>
			</li>
		</ul>
		</nav>
		<script src="js/menu.js" type="text/javascript"></script>
		</div>

	<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			<div class="grid1_of_1" style="height:900px; width:220px;">
             <p align="center"> <img align="center" src="images/user.png" alt="" class="img-responsive" /></p>
		  <h4 align="center">${sessionScope.person.nickname} </h4>
		  <p align="center">运动标签：
               <% 
                User user=(User)session.getAttribute("user");
                int uid=user.getUserid();
                IUserBiz userBiz=new UserBizImpl();
				List<String> lstSport=userBiz.showMylabel(uid);
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
		  <h3 align="center">积分：${sessionScope.user.integ} </h3>
           <h3 align="center">等级：${sessionScope.user.rank} </h3>
                <hr>
 <form name="search1" class="navbar-form navbar-right" method="post" action="/myproject/searchCoachServlet?sportid=${requestScope.sportid}">
 <div align="right"><input name="coachname1" type="text" class="form-control" style="width:121px;"
					placeholder="教练或场馆信息">
<button class="btn btn-sm btn-info" type="submit">GO!</button></div>
</form>
                <h3>运动分类</h3>
            <div id="contains">

			<div class="scroll-pane">
				<ul class="nav nav-sidebar" style="alignment-adjust:">
						
							<li><a href="/myproject/showCoachVenueServlet?sportid=1">足球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=2">羽毛球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=5">乒乓球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=6">网球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=3">篮球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=7">排球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=4">台球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=8">高尔夫球</a></li>
							<li><a href="/myproject/showCoachVenueServlet?sportid=9">保龄球</a></li>
					</ul>
					<ul class="nav nav-sidebar">
						
						<li><a href="/myproject/showCoachVenueServlet?sportid=10">健美操</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=12">瑜伽</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=11">街舞</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=13">田径</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=15">旱冰</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=17">攀岩</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=14">滑雪</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=16">溜冰</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=18">自行车</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=19">太极</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=27">游泳</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=20">广场舞 </a></li>
					</ul>
					<ul class="nav nav-sidebar">
						<li><a href="/myproject/showCoachVenueServlet?sportid=21">散打</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=23">跆拳道</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=24">空手道</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=25">击剑</a></li>
						<li><a href="/myproject/showCoachVenueServlet?sportid=26">拳击</a></li>
					</ul>
					<ul class="nav nav-sidebar">
						<li><a href="">其他</a></li>

					</ul>
		</div>
        </div>
				
    </div>
		
			<div class="grid1_of_list1">	
			</div>
		</div>
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
		
		
		
		
			<div class="grid2_of_1" style="height:900px; width:800px; margin-left:-120px;">
				<div class="signin_form" >
                <div class="head-one text-center team-head">
                
                <div>
			<p align="left">
				<a class="btn btn-sm btn-default" href="/myproject/showCoachVenueServlet?sportid=${requestScope.sportid}">返上一页面</a>

         
		</div>
                
                
								<h3>教练信息</h3>
                            <p>Thanks for your reading~~~</p>
							</div>	
                          
                			<!----team-members---->
                              <div id="containe">

			<div class="scroll-panes">
							<div class="team-members">
				<!-- 显示所有教练信息 -->
				
		<c:forEach items="${requestScope.lstCoach}" var="coach" >
				
				
								<div class="col-md-3">
									<div class="team-member text-center">
										<img class="t-pic" src="/myproject/jsp/images/t1.jpg" title="name" />
										<h3>姓名${coach.coaname}</h3>
										<p align="center">${coach.coacontext} </p>
										<p align="center">
									<a class="btn btn-info" href="/myproject/viewCoachDetailServlet?coachid=${coach.coachid}&sportid=${requestScope.sportid}" role="button">View
										details &raquo;</a>	</p>
										<ul class="t-social unstyled-list list-inline">
											<li><a class="in" href="#"><span> </span></a></li>
											<div class="clearfix"> </div>
										</ul>
									</div>
								</div>
								
	</c:forEach>							
							</div>
							<!----//team-members---->
				</div>
                </div>
				</div>
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
</body>
</html>