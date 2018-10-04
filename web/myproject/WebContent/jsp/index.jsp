<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.User"%>


<%@page errorPage="jsp/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
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
 <!-- start price_bar  -->	
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
<style type="text/css">


body {
	background-image: url(img/frame-06.jpg);
	background-size: cover;
	background-attachment: fixed;
}


</style>
<meta charset="gb2312">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<body>
<div class="container">
<div class="main">
	
	<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			<div class="grid3_of_1" style="height:370px;">
		<a href="/myproject/jsp/activity.jsp">
		  <img src="/myproject/jsp/image/login.jpg" class="img-circle" style="width:250px;height:250px;"/></a>
				<h2 style="color:#000; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;活动模块</h2>
				<p style="font-weight: bold">&nbsp;&nbsp;&nbsp;                                           &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			</div>
		
			<div class="grid1_of_list1">	
			</div>
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
		<div class="grid3_of_1" style="height:370px;">
          <div class="signin_form">
         <a href="/myproject/showCoachVenueServlet?sportid=1">
          <img src="/myproject/jsp/image/02.jpg" alt="" class="img-circle" style="width:250px;height:250px;"/></a>
					<h2 style="color:#000; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;场馆教练</h2>
                    <p style="font-weight: bold" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
		  </div>     	
		</div><!-- end switch_main ---->
		
			
	  </div>
	 
	</div><!-- end span1_of_2 -->	
	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
		<div class="grid2_of_1">
          <div class="signin_form">
          <div  >
          <p align="center">
          	 <a href="/myproject/jsp/main.jsp"><img src="/myproject/jsp/images/user.png" alt="" class="img-responsive" /></a></p>
				<h2 align="center">${sessionScope.person.nickname}</h2>
				<h5 align="center">积分：${sessionScope.user.integ} +等级：${sessionScope.user.rank} </h5>
                <p></p>
                <!-- 显示她的运动标签 -->
                <p align="center">运动标签：
               <% 
                User user=(User)session.getAttribute("user");
                int uid=user.getUserid();
                IUserBiz userBiz=new UserBizImpl();
				List<String> lstSport=userBiz.showMylabel(uid);
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
                <p></p>
                <p align="center">运动宣言：${sessionScope.user.spordec}</p>
              <h3 align="center"><a align="center" class="btn btn-lg btn-default btn-inline" href="/myproject/logoutServlet">退出</a></h3>
             
                </div>
          </div>
			
                
                
      
        
		</div><!-- end switch_main ---->
		<div class="clearfix"></div>
	</div>
	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
 
        
        	
	<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
    <div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
    <div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
<div class="grid3_of_1" style="height:370px;">
				<div class="signin_form">
				 <a href="/myproject/jsp/main.jsp">
                <img src="/myproject/jsp/image/29.jpg" alt="" class="img-circle" style="width:250px; height:250px;" />
                </a> 
					<h2 align="center" style="color: #000; font-weight: bold;">我的主页</h2>

                    
				</div>
			</div>
			
			
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			
		  <div class="grid3_of_1" style="height:370px;">
          <div class="signin_form">
          <a href="/myproject/jsp/treasure.jsp">
          <img src="/myproject/jsp/image/7.jpg" alt="" class="img-circle" style="width:250px; height:250px;" />
		  </a>
		<h2 style="color: #000; font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 运动宝典</h2>
                
                    
				</div>
			
                
                
      
        
		</div><!-- end switch_main ---->
			
	</div><!-- end span1_of_2 -->	
	
      
                
               
        
		</div><!-- end switch_main ---->
        
	<div class="copy">
		<p class="link"><span></a></span></p>
	
</div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
</head>
<body>

</body>
</html>