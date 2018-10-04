<%@page import="com.chinasofti.myproject.po.Sporttreasure"%>
<%@page import="com.chinasofti.myproject.dao.impl.SportDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.ISportDao"%>
<%@page import="com.chinasofti.myproject.po.Peruser"%>
<%@page import="com.chinasofti.myproject.dao.impl.UserDaoImpl"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@page import="com.chinasofti.myproject.dao.IUserDao"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.Mydiary"%>
<%@page import="com.chinasofti.myproject.po.Person"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.dao.impl.MydiaryDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IMydiaryDao"%>
<%@page import="com.chinasofti.myproject.po.Publishstatus"%>
<%@page import="com.chinasofti.myproject.dao.impl.PublishstatusDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IPublishstatusDao"%>
<%@page import="com.chinasofti.myproject.po.Resource"%>
<%@page import="com.chinasofti.myproject.dao.impl.ResourceDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IResourceDao"%>
<%@page import="com.chinasofti.myproject.dao.IPersonDao"%>
<%@page import="com.chinasofti.myproject.dao.impl.PersonDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.impl.FriendrelationDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IFriendrelationDao"%>
<%@page import="com.chinasofti.myproject.po.Friendrelation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人主页</title>
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
 <!-- start price_bar  -->	
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
 <!-- start price_bar  -->	
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
body{overflow-y:scroll;font-family:"HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, sans-serif;background:#f4f4f4;padding:0;margin:0;}
h1{font-size:100px;line-height:100px;font-weight:normal;margin-bottom:100px;}
a,a:hover{border:none;text-decoration:none;}
img,a img{border:none;}
pre{overflow-x:scroll;background:#ffffff;border:1px solid #cecece;padding:10px;}
.clear{clear:both;}
.zoomed > .container{-webkit-filter:blur(3px);filter:blur(3px);}
.contain{width:505px;margin:0 auto;}
.gallery{list-style-type:none;float:left;background:#ffffff;padding:20px 20px 10px 20px;margin:0;-webkit-box-shadow:0 1px 3px rgba(0,0,0,0.25);-moz-box-shadow:0 1px 3px rgba(0,0,0,0.25);box-shadow:0 1px 3px rgba(0,0,0,0.25);-webkit-border-radius:2px;-moz-border-radius:2px;border-radius:2px;}
.gallery li{float:left;padding:0 10px 10px 0;}
.gallery li:nth-child(6n){padding-right:0;}
.gallery li a,.gallery li img{float:left;}
</style>



<!--图片弹出层样式 必要样式-->
<link rel="stylesheet"  href="/myproject/jsp/css/zoom.css" media="all" />
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
			/* Styles specific to this particular page */
			.scroll-pane, .scroll-pane-arrows {
				width: 100%;
				height: 330px;
				overflow: auto;
			}
			.horizontal-only {
				height: auto;
				max-height: 200px;
			}
			#contains {
	width: 320px;
	background: #FFF;
	padding: 20px;
	margin: -10px ;
	-moz-border-radius: 50px;
	-webkit-border-radius: 50px;
	border-radius: 50px;
	
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
<!-- 判断表单预加载信息是否完整 -->
<c:if test="${empty requestScope.Havedone}">
	<script>
	window.location="/myproject/showFriendServlet";
	</script>
</c:if>

<!-- header -->
<!-- header结束 -->

<div class="container">
<div class="main">
		<div class="h_menu">
		<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
		<nav>
		<ul class="menu list-unstyled">
		    <li class="color1"><a href="/myproject/jsp/index.jsp">首页</a>
			<li class="color3"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
			<li class="color2"><a href="/myproject/jsp/photo.jsp">相册</a></li>
            <li class="color3"><a href="/myproject/jsp/changeinfo.jsp">个人管理</a></li>
             <li class="color2"><a href="/myproject/jsp/chat1.jsp">消息</a></li>
            	
				<li><a href="#">${sessionScope.person.nickname}</a></li>
				<li><a href="/myproject/logoutServlet">退出</a></li>
		</ul>
		</nav>
		<script src="/myproject/jsp/js/menu.js" type="text/javascript"></script>
		</div>

	<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			<div class="grid1_of_1" style="height:450px; margin-left:3px; width:330px;">
				<img src="/myproject/jsp/images/user.png" alt="" class="img-responsive" />
				<h2>${sessionScope.person.nickname}</h2>
				<p>空间介绍：${sessionScope.user.mark}</p>
                <p></p>
                <!-- 显示她的运动标签 -->
                <p>运动标签：
               <% 
                User user=(User)session.getAttribute("user");
                int uid=user.getUserid();
                IUserBiz userBiz=new UserBizImpl();
				List<String> lstSport=userBiz.showMylabel(uid);
				for(String label:lstSport){
				 %> <%=label%>   <%} %></p>
                <p></p>
                <p>运动宣言：${sessionScope.user.spordec}</p>
                <p>居住地：${sessionScope.person.regaddr}</p>
               
			</div>
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:450px; ">
				<div class="signin_form">
					<h4>好友列表</h4>
					 
					<form name="form1" method="post" action="">
			    
                  
			        <table width="89%" border="0" align="center">
			         <tr>
                      <td width="30%" height="53" align="center" valign="middle">头像</td>
                      <td width="23%" align="center">昵称</td>
                      <td width="19%" align="center">性别</td>
                      <td width="28%" align="center">取消好友</td>
                    </tr>
                    <!--显示所有好友 -->
                 
				
                    <% 
                    List<Peruser> lstmyfri=(List<Peruser>)request.getAttribute("lstmyfri");
                    if(lstmyfri!=null){
                    for(Peruser ur:lstmyfri){
                    	
			        %>
			         <tr>
			         <td height="67" align="center" bgcolor="#FFFFFF"><a href="/myproject/inOtherSpaceServlet?uid=<%=ur.getUserid()  %>">
			         <img style="height: 30px; width:30px;" src=" /myproject/jsp/image/<%=ur.getUserpho()  %>"></a></td>
                     <td align="center" bgcolor="#FFFFFF"><%=ur.getNickname() %></td>
                      <td align="center" bgcolor="#FFFFFF"><%=ur.getGender() %></td>
                         <td align="center"><a href="/myproject/DelFriendServlet?fid=<%=ur.getUserid()%>" >取消好友</td>
		            <%} }%>
		           
		            </tr>
		            
		            </table>
		            
			      </form>                    
				</div>
			</div>
			
			
		</div>
	</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
		<div class="grid2_of_1" style="height:450px; margin-left:-13px; width:330px;">
          <div class="signin_form">
					<h4>好友推荐</h4>
					<!-- 所有的好友推荐 -->
					<%-- <a href="/myproject/fenyeServlet?page=${sessionScope.page}&action=before">上一页</a>
					<a href="/myproject/fenyeServlet?page=${sessionScope.page}&action=after">下一页</a>
					 --%><form action="" method="get">
                    <table width="89%" border="0" align="center">
  <tr>
    <td width="30%" height="53" align="center">头像</td>
    <td width="23%" align="center">昵称</td>
    <td width="19%" align="center">性别</td>
    <td width="28%" align="center">加为好友</td>
  </tr>
   
  <%
  List<Peruser> lstrecomfri=(List<Peruser>)request.getAttribute("lstrecomfri");
  if(lstrecomfri!=null){
  for(Peruser recomfri:lstrecomfri){
	  /* String label = recomfri.getSportlabel();
	  String[] labels = label.split("/");
	  ISportDao sportDao=new SportDaoImpl();
	  String sportname=sportDao.selectById(sid); */
  
  %>
  <tr>
    <td  height="67" align="center"><a href="/myproject/inOtherSpaceServlet?uid=<%=recomfri.getUserid()  %>">
    <img style="height: 30px; width:30px;"src=" /myproject/jsp/image/<%=recomfri.getUserpho() %>"></a></td>
    <td align="center"><%=recomfri.getNickname() %></td>
<%--     <td align="center"><%=sportname %></td> --%>
    <td align="center"><%=recomfri.getGender() %></td>
    <td align="center"><a href="/myproject/addFriendServlet?fid=<%=recomfri.getUserid()%>" >添加好友</td>
  </tr>
  <%}} %>
</table>

                  </form><!-- 所有的好友推荐结束 -->
				</div>
</div><!-- end switch_main ---->
		<div class="clearfix"></div>
	</div>
	
    <div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
    <div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:450px; margin-left:3px;">
				<div class="signin_form"  >
					<h3>最新日志</h3>
					  <div id="contains">

			<div class="scroll-pane">
				
                    <%
					   IMydiaryDao mydiaryDao=new MydiaryDaoImpl();
					   List<Mydiary> lstMydiary=mydiaryDao.selectByUserid(uid);
					   for (Mydiary mydiary : lstMydiary) {%>
						
							<!-- 显示所有日志 -->
							<blockquote>
								<h3>
									<div align="left"><%=mydiary.getMdiaryname() %></div>
								</h3>
								<div class="span4">

									<p><%=mydiary.getMdiarytime() %><a href="/myproject/viewDiaryServlet?mdiaryid=<%=mydiary.getMdiaryid()%>">点击查看</a>
									</p>
								</div>
								<p></p>
							</blockquote>
                          <!-- 显示日志结束 -->
                         <% } %>
                         </div>
                         </div>
				</div>
			</div>
			
			
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1">
				<div class="signin_form" style="height:380px;">
					<h3>最新说说</h3>
					 <div id="contains">

			<div class="scroll-pane">
				
                <%
                     	IPublishstatusDao publishstatusDao=new PublishstatusDaoImpl();
					   List<Publishstatus> lstPublishstatus=publishstatusDao.selectByUserid(uid);
					   for (Publishstatus publishstatus : lstPublishstatus) {%>
						
							<blockquote>
								<h3>
									<div align="left"><%=publishstatus.getStacontext() %></div>
								</h3>
								<div class="span4">

									<p >
										<%=publishstatus.getStapubtime() %>
									</p>
								</div>
								<p></p>
							</blockquote>
                          <!-- 显示说说结束 -->
                         <%}%>					    
				</div>
			</div>
			</div>
		</div>
			
		</div>
	</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
		<div class="grid2_of_1" style="height:450px; margin-left:-13px; width:330px;">
          <div class="signin_form">
          <h3>最新收藏</h3>
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
									<div align="left"><%=st.getTreasname()%></div>
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
                
                
      
        
		</div><!-- end switch_main ---->
        
        
	<div class="copy">
		<p class="link"><span></a></span></p>
	</div>
</div>
</div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>