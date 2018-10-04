<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>运动宝典</title>
  <!-- styles specific to demo site -->
		<link type="text/css" href="/myproject/jsp/style/demo.css" rel="stylesheet" media="all" />
		<!-- styles needed by jScrollPane - include in your own sites -->
		<link type="text/css" href="/myproject/jsp/style/jquery.jscrollpane.css" rel="stylesheet" media="all" />
		<!-- the styles for the lozenge theme -->
		<link type="text/css" href="/myproject/jsp/style/jquery.jscrollpane.lozenge.css" rel="stylesheet" media="all" />

		<!-- latest jQuery direct from google's CDN -->
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<!-- the mousewheel plugin -->
		<script type="text/javascript" src="/myproject/jsp/js/jquery.mousewheel.js"></script>
		<!-- the jScrollPane script -->
		<script type="text/javascript" src="/myproject/jsp/js/jquery.jscrollpane.min.js"></script>
	
	
			
		<link rel="stylesheet" href="/myproject/jsp/css/styles.css" />
      
		
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
		
		<link href="/myproject/jsp/css/jpage.css" rel="stylesheet" type="text/css" />		
		
	<script src="/myproject/jsp/js/jpage.min.js"></script>
		
			
			<script>
			$('document').ready(function(){
				$('#jpage').jpage({
					effect: 'random' //'', 'crossfade', 'bricks', 'slideLeft', 'slideRight', 'random'
				});
			});
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
			/* Styles specific to this particular page */
			.scroll-pane, .scroll-pane-arrows {
				width: 100%;
				height: 270px;
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
	margin: -10px ;
	-moz-border-radius: 50px;
	-webkit-border-radius: 50px;
	border-radius: 50px;
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<%
		Person person = (Person) session.getAttribute("person");
		IUserBiz userBiz = new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		//
		String colltreas = user.getColletreasid();
		request.setAttribute("colltreas", colltreas);
	%>
<script type="text/javascript">

window.onload = function(){
	loadtip();
	//loadcollecount();
};

function loadtip(){
	document.getElementById("tips").innerHTML = "${requestScope.dailytips.tipcontext}";
};

var xmlHttp;
function createXMLHttp(){
	   if(window.XMLHttpRequest){
		   xmlHttp = new XMLHttpRequest();
	   } else {
		   xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	   }
};

function changetips(){
	  
	   //var tips = document.getElementById("email").value;
	   createXMLHttp();
	   xmlHttp.open("post","/myproject/ChangeTipsServlet",true);
	   xmlHttp.onreadystatechange = changetipsCallback;
	  
	   xmlHttp.send(null);
};

function changetipsCallback(){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   document.getElementById("tips").innerHTML=xmlHttp.responseText;
			//还没写异常处理
		   }
	   }
};

function searchtreasure(){
	var keyword = document.getElementById("search").value;
	window.location = "/myproject/SearchtreasServlet?keyword="+keyword;
};
var coll;
function check(id){
	var button = document.getElementById(id); 
  	var coll = '${requestScope.colltreas}' ; 
	if(coll.indexOf(id)>0){
	button.value = "取消收藏";
		
	} else{
		button.value="收藏";
	} 
}; 
function docolle(id){
	var iscolle = document.getElementById(id).value;
	if(iscolle =="收藏"){
		addcolle(id);
	}else if(iscolle == "取消收藏"){
		delcolle(id);
	}
};
function addcolle(colleid){
	  
	   //var tips = document.getElementById("email").value;
	   createXMLHttp();
	   xmlHttp.open("post","/myproject/AddColleServlet?colleid="+colleid,true);
	   xmlHttp.onreadystatechange = function(){addcolleCallback(colleid);};	  
	   xmlHttp.send(null);
};
function delcolle(colleid){
	  
	   //var tips = document.getElementById("email").value;
	   createXMLHttp();
	   xmlHttp.open("post","/myproject/DelColleServlet?colleid="+colleid,true);
	   xmlHttp.onreadystatechange = function(){delcolleCallback(colleid);};	  
	   xmlHttp.send(null);
};
function addcolleCallback(btnid){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   document.getElementById(btnid).value="取消收藏";
				document.getElementById("count"+btnid).innerHTML = xmlHttp.responseText;
			
		   }
	   }
};
function delcolleCallback(btnid){
	   if(xmlHttp.readyState==4){
		   if(xmlHttp.status==200){
			   document.getElementById(btnid).value="收藏";
				document.getElementById("count"+btnid).innerHTML = xmlHttp.responseText;
			
		   }
	   }
};
function test(){
	alert('执行了');
}
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
}</style>
</head>
<body>
	<!-- header begin -->
	<c:if test="${empty requestScope.lstSport }">
		<script>
window.location="/myproject/ShowTreasureServlet"
</script>
	</c:if>
	<!-- header end -->
	<!-- container -->
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
		<script src="/myproject/jsp/js/menu.js" type="text/javascript"></script> 
        
	<!-- start span1_of_2 -->
    
    <div class="col-md-8 span_of_2" style="margin-left:-29px; margin-top:-15px; width:730px;">
    
  	<br>
      <!-- main content -->
    
    <div id="main-content" class="box">
      
      <!----模糊搜索开始----->  
     <a href="#">
     <form method="post" action="/myproject/SearchtreasServlet">
<table width="1%" border="0" style="margin-left:13px;">
				    <tr>
				      <th scope="row"><input name="search" id="search" type="search" placeholder="搜索活动项目"></th>
				      <td><input type="submit" name="submit" id="submit" value="搜索" ></td>
				      <td><button class="btn btn-default" href="/myproject/jsp/treasure.jsp">返回上一页</button></td>
		      </table>
</table>
</form>
  
</a>
          <!----模糊搜索结束-------->   
  <br>
		<!-- main content -->
		<div id="main-content" class="box">
			<div class="center">
				<div id="page-content" class="box">
				<!-- jPage DEMO -->
				<div id="jpage" class="jpage box">
					
					<!-- pagination panel -->
					<div class="box jpage-panel" data-type="panel"></div>
					
					<div class="list box text-shadow" data-type="content">						
						<c:if test="${!empty requestScope.lstSporttreasure }">
				<c:forEach items="${requestScope.lstSporttreasure }"
					var="Sporttreasure">
							
							<!-- item 1 -->
							<div class="list-item box">					
								<!-- img -->
								<div class="img left">
									<img src="/myproject/jsp/images/harry_teaser.jpeg" alt="宝典图片" title="I Sport"/>
								</div>
								
								<!-- data -->
								<div class="block right">
									<p class="date">发布时间：${Sporttreasure.treaspubtime }</p>
									<p class="title">宝典标题：${Sporttreasure.treasname }</p>
									<p class="desc">宝典内容：${Sporttreasure.treascont }</p>
                                     <div align="right"> 
                                <label aligen="left"><input type="button" class="btn btn-sm btn-default" id="${Sporttreasure .treasid }" value="" onclick="javascript:docolle('${Sporttreasure .treasid }')"></div>
                                	<%-- <span id="count${lstsearchtreasure.treasid }"></span>
										<script> document.getElementById('count${lstsearchtreasure.treasid }').innerHTML="${lstsearchtreasure.treascollecount }"</script> --%>
							<script> check('${Sporttreasure.treasid }');
											</script></label>
											
								</div>
							</div>
							</c:forEach>
				</c:if>
						<!-- //搜索的部分 -->
				<c:if test="${!empty requestScope.lstSearchtreasure }">
				<c:forEach items="${requestScope.lstSearchtreasure }"
					var="lstsearchtreasure">
							
							<!-- item 1 -->
							<div class="list-item box">					
								<!-- img -->
								<div class="img left">
									<img src="/mypoject/jsp/img/thumbs/arch-2.jpg" alt="宝典图片" title="I Sport"/>
								</div>
								<!-- data -->
								<div class="block right">
									<p class="date">发布时间：${lstsearchtreasure.treaspubtime }</p>
									<p class="title">宝典标题：${lstsearchtreasure.treasname }</p>
									<p class="desc">宝典内容：${lstsearchtreasure.treascont }</p>
                                     <div align="right"> 
                               <label><input type="button" class="btn btn-large btn-default" id="${lstsearchtreasure .treasid }" value=""  
									onclick="javascript:docolle('${lstsearchtreasure .treasid }')">
									<%-- <span id="count${lstsearchtreasure.treasid }"></span>
										<script> document.getElementById('count${lstsearchtreasure.treasid }').innerHTML="${lstsearchtreasure.treascollecount }"</script>
										 --%>
											<script> check('${lstsearchtreasure.treasid }');
											</script></label>
											
								</div>
							</div>
							</div>
								</c:forEach>
				</c:if>
		</div>
				</div>
				<!-- end of jPage DEMO -->
				</div>
			</div>
		</div>	
		
        
	</div>            
  </div>
  </div>
</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
 
<div class="grid2_of_1" style="width:330px; margin-left:-20px; margin-top:-63px; height:850px;">
	<div class="signin_form" >	  	
		<p align="center"><img src="/myproject/jsp/images/user.png" alt="" class="img-responsive" /></p>
			 <h4 align="center">${sessionScope.person.nickname} </h4>
		  <p align="center">运动标签：
               <% 
                User user8=(User)session.getAttribute("user");
                int uid8=user8.getUserid();
                IUserBiz userBiz8=new UserBizImpl();
				List<String> lstSport8=userBiz8.showMylabel(uid8);
				for(String label:lstSport8){
				 %> <%=label%>   <%} %></p>
		  <h3 align="center">积分：${sessionScope.user.integ} +等级：${sessionScope.user.rank} </h3>	
  
 
    <!-- end switch_main ---->
    
 
 
  <div class="clearfix"></div>
  
  	<hr>	
    <h5>Tips:<a href="javascript:changetips();"><h5>换一换</h5></a></h5>
     <marquee width="-200px;" height="25px;"direction="left" scrollamount="4" onMouseOver="stop()"
 onMouseOut="start()" id="tips" ><span style="font-family: '微软雅黑', '幼圆'">朱敏杰是猪猪猪猪猪，汪汪汪汪汪，竟然嫌弃太小了~！！！！！哇，好大吖吖</span></marquee>
      <hr>
      <h5>运动分类：</h5>
          <div id="contains">

			<div class="scroll-pane">
				 <table width="40%" border="0">
				    <tr>
				      <th scope="row"><c:forEach items="${requestScope.lstSport }" var="sport">
        <a href="/myproject/SelectTreasureServlet?sportid=${sport.sportid }"><h4>${sport.sportname }</h4></a>
			</c:forEach></th>
			        </tr>
		      </table>
				
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