<%@page import="com.chinasofti.myproject.dao.IPersonDao"%>
<%@page import="com.chinasofti.myproject.dao.impl.PersonDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.impl.FriendrelationDaoImpl"%>
<%@page import="com.chinasofti.myproject.dao.IFriendrelationDao"%>
<%@page import="com.chinasofti.myproject.po.Friendrelation"%>
<%@page import="com.chinasofti.myproject.po.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myspace_main</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Blog Template for Bootstrap</title>
  <script type="text/javascript" src="js/jquery-1.4.min.js"></script>
  <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
  <script type="text/javascript" src="js/jquery.galleryview-1.1.js"></script>
  <script type="text/javascript" src="js/jquery.timers-1.1.2.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="blog.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"><style type="text/css">
<!--
body {
	background-color: #FFF;
	background-image: url(../image/muban.jpg);
	background-attachment:fixed;
}
-->
</style>
</head>
<body>
<c:if test="${empty sessionScope.person }">
	<script>
		alert("您还未登陆，点击登陆");
		location="/myproject/jsp/login.jsp";
	</script>
</c:if>
 <!-- 这是固定不动的菜单 -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation"  style="background-color:#ffeedd;">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">ISport</a>
        </div>
        <div class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
					<li><a href="/myproject/jsp/index.jsp">首页</a></li>
					<li><a href="#">约友</a></li>
					<li><a href="/myproject/jsp/activity.jsp">活动</a></li>
					<li><a href="/myproject/jsp/treasure.jsp">运动宝典</a></li>
					<li><a href="/myproject/showCoachVenueServlet?sportid=1">场馆&教练</a></li>
					<li><a href="/myproject/jsp/myspace/main.jsp">我</a></li>
					<li><a href="#">${sessionScope.person.nickname}</a></li>
					<li><a href="/myproject/logoutServlet">退出</a></li>
				</ul>
         <div class="navbar-collapse collapse">
          
        </div><!--/.navbar-collapse -->
        </div><!--/.nav-collapse -->
      </div>
  </div>
    <!-- 固定不动的菜单结束 -->
<!-- 菜单 -->

    <div class="container">
    <p><p></p>
    </p>
  
       <div class="container">
      <div class="blog-header">
      <p>
      </p>
      <p>
      </p>
      <p>
      </p>
        <div align="justify">
          <p>&nbsp;</p>
          <p>&nbsp;</p>
           <p><strong><a class="btn btn-inverse" href="/myproject/jsp/otherspace/othermain.jsp">SKY&nbsp; </a></strong>
          <span class="label label-info">&nbsp;等级36</span></p>
</div>
        <p class="lead blog-description">I Sport 空间，喵喵~</p>
        
        <img src="image/1.jpg" width="150" class="img-rounded">&nbsp;
        <span class="blog-description">&nbsp;&nbsp;&nbsp; 
        ${sessionScope.person.nickname}</span>
         &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
       
<a class="btn btn-success" href="/myproject/jsp/otherspace/otherinfo.jsp"
					role="button">个人档</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
				<a class="btn btn-success"
					href="/myproject/jsp/otherspace/otherphoto.jsp" role="button">相册</a>
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a class="btn btn-success"
					href="/myproject/jsp/otherspace/otherdiary.jsp" role="button">日志</a> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp; <a class="btn btn-success" href="/myproject/jsp/otherspace/othershuoshuo.jsp"
					role="button">说说</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
				<button class="btn btn-success" type="submit">收藏</button>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
      <a href="#"><button type="button" class="btn btn-large btn-danger">+ 添加好友</button></a></h4>
            <button type="button" class="btn btn-large btn-danger">@ 发送私信</button></h4>
         </div>
        
        
  </div>
       
     

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="blog-post">
            <!-- 发状态 -->
  &nbsp;&nbsp;
  <div style="margin-top:-16px;margin-left:-39px;color:#002233;">
    <img src="image/newthing.jpg">   <a class="btn btn-success"  role="button">运动标签：</a>
    <span class="label label-success">篮球</span> &nbsp;&nbsp;&nbsp;
 <span class="label label-success">足球</span>&nbsp;&nbsp;&nbsp;
 <span class="label label-success">游泳</span> &nbsp;&nbsp;&nbsp;
      
    
  </div>

  <!--发状态结束 -->
  <hr>
   <div class="sidebar-module sidebar-module-inset">
           <a class="bar-info" href="./dairy.html"><h11 class="blog-post-title">我的I Sport 开始</h11></a> 
               <div class="span4">
       
         
            <p class="blog-post-meta">2014-08-02，天津，南开 by <a href="#">考拉</a></p></div>

            <p>这是第一天参加I Sport 网站的活动。认识了了很多同样喜欢篮球的好朋友！</p>
 
          
         
            <h11 class="blog-post-title">新朋友</h11></a>
           
            <h3>南开园的新朋友</h3>
            <p></p>
            <h3>球场上的偶遇</h3>
           
            
           
          </div><!-- /.blog-post -->
            <div class="sidebar-module sidebar-module-inset">
          <div class="blog-post">
             <a class="bar-info"><h11 class="blog-post-title">新的未来-篮球部落</h11></a> 
            <p class="blog-post-meta">2014-08-01 <a href="#">考拉</a></p>

            <p></p>
            <blockquote>
              <p></p>
            </blockquote>
            <p></p>
            <p></p>
          </div><!-- /.blog-post -->

          <div class="blog-post">
            <a class="bar-info"><h11 class="blog-post-title">世界杯日记</h11></a> 
            <p class="blog-post-meta">2014-07-02 by <a href="#">考拉</a></p>

        
            </div>
          </div><!-- /.blog-post -->
   
     </div>
        </div><!-- /.blog-main -->
           <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
        <div align="left"><form class="navbar-search pull-left"> <input type="text" class="search-query" placeholder="请输入搜索关键字">
          &nbsp; 
          &nbsp; &nbsp;
        </form>
          <button type="submit" class="btn-danger">提交
        </button>
         <p>&nbsp;</p>
        </div>
        </div>

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4><img src="image/zan.jpg">运动宣言：</h4>
每周参加足球和篮球运动、相遇球场、拥抱阳关，与好朋友相约在I Sport,一同享受积极向上的生活！</p> <div align="right">
</div>
          </div>
          <hr>
           <div class="sidebar-module sidebar-module-inset">
            <h4><img src="image/gongkai.jpg">最近联系</h4>
            <ol class="list-unstyled">
              <li><a href="#"><img src="image/2.jpg" width="38" height="32" class="img-rounded">  </a><a href="#">朱敏杰&nbsp; 羽毛球</a></li>
              <p></p><li><a href="#"><img src="image/3.jpg" width="38" height="32" class="img-rounded">  </a><a href="#">张筱倩&nbsp; 篮球</a></li>
            <p></p><li><a href="#"><img src="image/4.jpg" width="38" height="32" class="img-rounded">  </a><a href="#">杨川&nbsp;足球</a></li>
         <p></p><li><a href="#"><img src="image/5.jpg" width="38" height="32" class="img-rounded">  </a><a href="#">张三&nbsp; 乒乓球</a></li>
              <p></p><li><a href="#"><img src="image/6.jpg" width="38" height="32" class="img-rounded">  </a><a href="#">Alice&nbsp; 瑜伽</a></li>
             
 
      </ol>
      </div>
          <hr>
            
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <div class="blog-footer">
      <p>个人主页 for I Sport by <a href="https://twitter.com/mdo">@小黄蜂</a>.</p>
      <p>
      <p></p>
        <a href="#">Back to top</a>
      </p>
    </div>
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>