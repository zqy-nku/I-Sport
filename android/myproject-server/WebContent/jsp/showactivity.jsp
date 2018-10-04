<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.po.Actihuo"%>
<%@page import="com.chinasofti.myproject.biz.impl.ActivityBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IActivityBiz"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.chinasofti.myproject.dao.impl.SportDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.ISportDao"%>
<%@page import="com.chinasofti.myproject.dao.impl.PersonDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IPersonDao"%>
<%@page import="com.chinasofti.myproject.dao.impl.UserDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IUserDao"%>
<%@page import="com.chinasofti.myproject.po.Activityinvitation"%>
<%@page import="com.chinasofti.myproject.po.Person"%>
<%@page import="com.chinasofti.myproject.po.Sport"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IActivityinvitationDao"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>活动搜索</title>

    <style type="text/css">
.header{
	position: fixed;
	width: 100%;
	height: 50px;
	background-color: #ffeedd;
	margin-top: -70px;
}

.header p{
	margin-top: 14px;
	font-size: 115%;
	margin-left: 14%;
}
.header p a{
	margin-left: 8px;
	margin-right: 8px;
	color: #223344;
	text-decoration: none;
}
.header p .name{
	float: right;
	margin-right: 10%;
}
</style>
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
				height: 200px;
				overflow: auto;
			}
			.horizontal-only {
				height: auto;
				max-height: 200px;
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
		
	
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
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
            <script language="javascript">
function showReply(id){
	// 将需要显示的回复表单行对象进行显示
	document.getElementById(id).style.display = "block";
}
function hiddenReply(id){
	document.getElementById(id).style.display = "none";
}
function yiZan(){
	document.form1.zan.value="已赞";
}
</script>
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!----font-Awesome----->
   	<link rel="stylesheet" href="/myproject/jsp/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700' rel='stylesheet' type='text/css'>
<link href="/myproject/jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
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
<!-- start span1_of_2 -->
    
    <div class="col-md-8 span_of_2">
    
    
    <br>		
      <!-- main content -->
    
    <div id="main-content" class="box">
      
      <!----返回上一页----->
     <a class="btn btn-default" href="/myproject/jsp/activity.jsp">返回上一页</a>
     <br>
          <!-----搜索活动名称---------------------->
 <p></p>
      <!---翻页必用------->
  <div id="page-content" class="box">   
    <!-- jPage DEMO -->
	<div id="jpage" class="jpage box">  
<!-- pagination panel -->
<div class="box jpage-panel" data-type="panel"></div>	  
<div class="list box text-shadow" data-type="content">	

<c:forEach items="${requestScope.lstacti}" var="acti" >	
	 
<!----显示所有活动-------->					
<!-- item 1 -->
<div class="list-item box">					
<!-- img -->
<div class="img left">
<p><img src="/myproject/upload/images/photo/"> </p>
<p>
<h5> 发帖人昵称：<div class="username">${acti.nickname}</div></h5>
</p>
</div>
<!-- data -->
<div class="block right">
<p class="date">发帖时间：${acti.actisettime}</p>
<p></p>
<p class="title">运动类别：[${acti.sportname}]</p>
<p class="title">活动名称：[${acti.actiname}]</p>
 <p></p>
<p class="desc">活动内容：${acti.acticont}</p>
                                    <p></p>
                                     <p class="date">活动开始时间：${acti.actibegtime}    |   活动结束时间：${acti.actiendtime}</p>
 <p></p>
 <p class="like">活动地点：${acti.actiplace}</p>
                                  <p></p>

<div align="right"> 
<p class="desc">已有${acti.actiusercount}人参加|赞(${acti.actidianzan})
<a class="btn btn-default" href="/myproject/dianZanActiServlet?userid=${sessionScope.person.regid}&actiid=${acti.actiid}" role="button">点赞 </a>|
 <a class="btn btn-default" href="/myproject/agreejoinActiServlet?userid=${sessionScope.person.regid}&actiid=${acti.actiid}" role="button">同意参加 </a>|
  <a class="btn btn-default " href="/myproject/canceljoinActiServlet?userid=${sessionScope.person.regid}&actiid=${acti.actiid}" role="button" role="button">取消参加 </a></div>
								</div>
							</div>
                            <!-------显示活动结束---------->
                          </c:forEach>

						
                           
                           
                         
                           </div>
	</div>            
  </div>
  </div>
</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
 
<div class="grid2_of_1" >
	<div class="signin_form" >	  	
		 <p align="center"> <img align="center" src="/myproject/jsp/images/user.png" alt="" class="img-responsive" /></p>
				 <h4 align="center">${sessionScope.person.nickname} </h4>
		  <p align="center">运动标签：
               <%
		  	User user8=(User)session.getAttribute("user");
		                  int uid8=user8.getUserid();
		                  IUserBiz userBiz8=new UserBizImpl();
		  		List<String> lstSport8=userBiz8.showMylabel(uid8);
		  		for(String label:lstSport8){
		  %> <%=label%>   <%
   	}
   %></p>
		  <h3 align="center">积分：${sessionScope.user.integ} +等级：${sessionScope.user.rank} </h3>
      <!------发起活动-------->
<form id="post" name="post" method="post" action="/myproject/publishActivityServlet">
   	<p><h4>&nbsp;<img src="/myproject//jsp/images/weather1.png" alt="" width="25" height="27"> 发起活动：</h4>
   	  <p>
      <input type="hidden" id="userid" name="userid" value="${sessionScope.person.regid}"/>
   	    <label align="left ">活动项目</label> 
   	    <select name="sportid" id="sportid">
   	      <option value="2">羽毛球</option>
   	      <option value="3">篮球</option>
   	      <option value="1">足球</option>
   	      <option value="5">乒乓球</option>
   	      <option value="6">网球</option>
   	      <option value="7">排球</option>
   	      <option value="4">台球</option>
   	      <option value="8">高尔夫球</option>
   	      <option value="9">保龄球</option>
   	      <option value="10">健美操</option>
   	      <option value="11">街舞</option>
   	      <option value="12">瑜伽</option>
   	      <option value="13">田径</option>
   	      <option value="14">滑雪</option>
   	      <option value="15">旱冰</option>
   	      <option value="16">溜冰</option>
   	      <option value="17">攀岩</option>
   	      <option value="18">自行车</option>
   	      <option value="19">太极</option>
   	      <option value="20">广场舞</option>
   	      <option value="21">散打</option>
   	      <option value="22">拳击</option>
   	      <option value="23">跆拳道</option>
   	      <option value="24">空手道</option>
   	      <option value="25">击剑</option>
   	      <option value="26">钓鱼</option>
   	      <option value="27">游泳</option>
        </select>
      </p>
   	    </div>
   	    <label align="left ">开始时间</label> 
   	    <input name="begtime" id="begtime" type="datetime" class="form-control" style="width:200px;height:30px;" placeholder="xxx-xx-xx xx:xx">
   	    <label align="center">结束时间</label>
   	    <input name="actiendtime" id="actiendtime" type="datetime" class="form-control" style="width:200px;height:30px;"
					placeholder="xxx-xx-xx xx:xx">
   	    
   	    <label align="right "> 活动名称</label>
   	    <input name="actiname" id="actiname" type="textarea" class="form-control" style="width:200px;height:30px;" placeholder="给活动取个好名字吧">
   	    <label align="left ">活动地点</label>
   	    <input name="actiplace" id="actiplace" type="textarea" class="form-control" style="width:200px;height:30px;"
					placeholder="请输入活动地点">
   	    <label align="left ">活动内容
        </label>
   	    <input name="acticont" id="acticont" type="textarea" class="form-control" style="width:280px;height:60px;"
					placeholder="请输入活动内容">
   	  </p>
   	    <label>
        <button class="btn-info"  name="publish" id="publish" type="submit" >提交</button>
<br>
<br>
        </label>
      
   	  </p>
    </form>
                  
  </p>
  
   
  
  <p>
    <!-- end switch_main ---->
    
 
 
  <div class="clearfix"></div>
		<div>
			<a class="btn btn-info"
				href="javascript:showReply('joinedacti');" role="button">我参加的活动
			</a></div>
				<div id="joinedacti" name="joinedacti" style="display: none;">
					<table width="93%" border="0" align="center">
						<tr>
							<td height="35" align="center" >发起人</td>
							<td align="center" >项目</td>
							<td align="center">名称</td>
						</tr>
						<!-- 显示所有参加活动-->
						<%
							IActivityBiz activityBiz=new ActivityBizImpl();
										Person person1=(Person)session.getAttribute("person");
										int uid=person1.getRegid();
										System.out.println(uid);
						%>
						<%
							List<Actihuo> lstActi=activityBiz.showAJacti(uid);
										for(Actihuo acti:lstActi){
						%>
						<tr>
							<td height="35" align="center" bgcolor="#999"><%=acti.getNickname()%></td>
							<td align="center" bgcolor="#999"><%=acti.getSportname()%></td>
							<td align="center" bgcolor="#999"><%=acti.getActiname()%></td>
						</tr>
					<%
						}
					%>
						<!-- 显示所有参加活动结束-->
					</table>

					<a class="btn btn-info"
						href="javascript:hiddenReply('joinedacti');" role="button">关闭此栏</a>
				</div>
				
				
				
				<hr>
				<div>
		  <div>
			<a class="btn btn-info"
				href="javascript:showReply('tuiacti');" role="button">活动推荐
			</a>
		 </div>
				<div id="tuiacti" name="tuiacti" style="display: none;"> 		
	     <table width="93%" border="0" align="center">
			      <tr>
			        <td height="45" colspan="3" align="center" bgcolor="#999"><strong>活动推荐</strong></td>
		          </tr>
			      <tr>
			        <td width="32%" height="35" align="center" >发起人</td>
			        <td width="30%" align="center">项目</td>
			        <td width="38%" align="center">名称</td>
		          </tr>
		          <%
		          	IActivityBiz activityBiz2=new ActivityBizImpl();
		          		          List<Actihuo> lstacti2=activityBiz2.TuiActivity(uid);
		          		          if(lstacti2!=null){
		          		        for(Actihuo activity:lstacti2){
		          %>
			      <tr>
			        <td height="89" align="center" bgcolor="#999"><%=activity.getNickname()%></td>
			        <td align="center" bgcolor="#999"><%=activity.getSportname()%></td>
			        <td align="center" bgcolor="#999"><%=activity.getActiname()%></td>
		          </tr>
			     <%
			     	}}
			     %>
		        </table>
		  
		  
		      <a class="btn btn-info"
						href="javascript:hiddenReply('tuiacti');" role="button">关闭此栏</a>
				</div>
				 
			</div>
            <hr>
				 <div>
		  <div>
			<a class="btn btn-info"
				href="javascript:showReply('hotacti');" role="button">热门活动
			</a>
		 </div>
				<div id="hotacti" name="hotacti" style="display: none;"> 		
	     
	     
	     <p>&nbsp;</p>
                <table width="93%" border="0" align="center">
                  <tr>
                    <td height="42" colspan="4" align="center" bgcolor="#999"><strong>热门活动</strong></td>
                  </tr>
                 
                  <tr>
                    <td width="27%" height="39" align="center" >发起人</td>
                    <td width="28%" align="center" >项目</td>
                    <td width="22%" align="center" >名称</td>
                    <td width="23%" align="center" >已参与人数</td>
                  </tr>
                   <%
                   	List<Actihuo> lstacti3=activityBiz2.HotActivity();
                                      if(lstacti3!=null){
                                     for(int i=lstacti3.size()-1;i>0;i--){
                   %>
                  <tr>
                    <td height="78" align="center" bgcolor="#999"><%=lstacti3.get(i).getNickname() %></td>
                    <td align="center" bgcolor="#999"><%=lstacti3.get(i).getSportname()  %></td>
                    <td align="center" bgcolor="#999"><%=lstacti3.get(i).getActiname() %></td>
                    <td align="center" bgcolor="#999"><%=lstacti3.get(i).getActiusercount() %></td>
                  </tr>
                <%} }%>
                </table>
		  
		  
		      <a class="btn btn-info"
						href="javascript:hiddenReply('hotacti');" role="button">关闭此栏</a>
				</div>
				 
			</div>
    </div>
	<div class="clearfix"></div>
   
</div>
        
<!-- end switch_main ---->
<div class="copy">
		<p class="link"><span></a></span></p>
		<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>