<%@page import="com.chinasofti.myproject.dao.impl.SportDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.ISportDao"%>
<%@page import="com.chinasofti.myproject.po.Sporttreasure"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML>
<html>
<head>
<title>浏览收藏</title>
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
		<!--script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.2.js"></script-->		
		
		<!--[if gt IE 8]> --&gt;
		<script src="js/vendor/highlight.min.js"></script>		
		<script>
			hljs.tabReplace = '&nbsp;&nbsp;&nbsp;';
			hljs.initHighlightingOnLoad();
		</script>
		<!-- <![endif]-->
				
		<!-- jpage -->
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
 <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
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
				height: 230px;
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
	padding:0;
	margin:0;
	background-image: url(/myproject/jsp/image/1.jpg);
	background-size:cover;
	background-attachment:fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
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
		<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
	  <nav>
		<ul class="menu list-unstyled">
			<li class="color1"><a href="/myproject/jsp/index.jsp">首页</a></li>
			<li class="color2"><a href="/myproject/jsp/activity.jsp">活动</a></li>
			<li class="color3"><a href="/myproject/jsp/coach-venue.jsp">场馆和教练</a></li>
            <li class="color1"><a href="/myproject/jsp/treasure.jsp">运动宝典</a></li>
             <li class="color2"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
            <li><img src="/myproject/jsp/images/newactivity.jpg"></li>
            	<li><span class="name">
				<a href="#">${sessionScope.person.nickname}</a>
				<a href="/myproject/logoutServlet">退出</a>
			</span></li>
		</ul>
	  </nav>
	  <script src="/myproject/jsp/js/menu.js" type="text/javascript"></script>
		</div>
		<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			<div class="grid1_of_1" style="height:600px; width:300px;">
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
                <h3>收藏列表</h3>
            <div id="contains">

			<div class="scroll-pane">
			<%
					List<Sporttreasure> lstSporttreasures=userBiz.showMyCollect(uid);
					if(lstSporttreasures!=null){
					for(Sporttreasure st:lstSporttreasures){
				%>
                         <!-- 显示所有收藏 -->
							<blockquote>
								<h3>
									<div align="left"><%=st.getTreasname() %></div>
								</h3>
								<div class="span4">

									<p ><%=st.getTreaspubtime() %>By<%=st.getTreaauthname() %><a href="/myproject/viewTreasureServlet?treasid=<%=st.getTreasid()%>">点击查看</a>
									</p>
								</div>
								<p></p>
							</blockquote>
                          <!-- 显示结束 -->
                        <% }} %>
                    
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
							  <%
							  Sporttreasure sporttreasure=(Sporttreasure)request.getAttribute("sporttreasure");
							  int sportid=sporttreasure.getSportid();
							  ISportDao sportDao=new SportDaoImpl();
							  String sportname=sportDao.selectById(sportid);
							  %>
									<p class="date">发帖时间${requestScope.sporttreasure.treaspubtime} </p>
								<p class="title"></p>
								<p class="desc">
							    </p>
							    <p class="like">&nbsp;  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题：xxxxx</p>
							    <table width="99%" height="302" border="0">
								    <tr>
								      <th width="6%" height="22" scope="row">&nbsp;</th>
								      <th width="6%" scope="row">&nbsp;</th>
								      <th width="7%" scope="row">&nbsp;</th>
								      <th width="44%" scope="row">文章标签：<%=sportname %></th>
								      <td width="15%">&nbsp;</td>
								      <td width="22%">&nbsp;</td>
							        </tr>
								    <tr>
								      <th height="80" colspan="6" scope="row">文章图片：</th>
							      </tr>
								    <tr>
								      <th height="192" colspan="6" scope="row"><p>文章内容：<%=sporttreasure.getTreascont() %></p></th>
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