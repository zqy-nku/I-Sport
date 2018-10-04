<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">


 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
     <link type="text/css" rel="stylesheet" href="css/galleryview.css" />

    <title>相册p</title>
  <script type="text/javascript" src="js/jquery-1.4.min.js"></script>
  <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
  <script type="text/javascript" src="js/jquery.galleryview-1.1.js"></script>
  <script type="text/javascript" src="js/jquery.timers-1.1.2.js"></script>
  <script type="text/javascript">
	$(document).ready(function(){
		$('#photos').galleryView({
			panel_width: 700,
			panel_height: 300,
			frame_width: 100,
			frame_height: 100
		});
	});
</script>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <link href="css/bootstrap.css" rel="stylesheet">
    

    <!-- Custom styles for this template -->
    <link href="blog.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    


    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"><style type="text/css">
<!--
body {
	background-color: #FFF;
	background-image: url(../image/muban.jpg);
	background-attachment: fixed;
}
-->
</style></head>

  <body>

    <!-- 这是固定不动的菜单 -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation"
		style="background-color: #ffeedd;">
		<div class="container">
			<div class="navbar-header" style="background-color: #ffeedd;">
				<a class="navbar-brand" href="#">ISport</a>
			</div>
			<div class="navbar-collapse collapse"
				style="background-color: #ffeedd;">
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
				<div class="navbar-collapse collapse"
					style="background-color: #ffeedd;"></div>
				<!--/.navbar-collapse -->
			</div>
			<!--/.nav-collapse -->
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
          <span class="label label-danger">&nbsp;等级36</span></p>
</div>
        <p class="lead blog-description">空间，暂时对外开放</p>
        
         <img src="image/1.jpg" width="150" class="img-rounded">&nbsp;<span class="blog-description">&nbsp;&nbsp;&nbsp; 考拉</span>
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
   <img src="image/newthing.jpg"> 
  <a class="btn btn-success"
							role="button">运动标签：</a> <span
							class="label label-success">篮球</span> &nbsp;&nbsp;&nbsp; <span
							class="label label-success">足球</span>&nbsp;&nbsp;&nbsp; <span
							class="label label-success">游泳</span> &nbsp;&nbsp;&nbsp;
 <hr>
 <!--相册--->
 <div id="photos" class="galleryview">
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/01.jpg" /> 
    <div class="panel-overlay">
      <h2>Effet du soleil sur le paysage</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/02.jpg" /> 
    <div class="panel-overlay">
      <h2>Eden</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/03.jpg" /> 
    <div class="panel-overlay">
      <h2>Snail on the Corn</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/04.jpg" /> 
    <div class="panel-overlay">
      <h2>Flowers</h2>
    </div>
  </div>
  <div class="panel">
     <img src="image/06.jpg" /> 
    <div class="panel-overlay">
      <h2>Alone Beach 2B</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/05.jpg" /> 
    <div class="panel-overlay">
      <h2>Sunrise Trees</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/07.jpg" /> 
    <div class="panel-overlay">
      <h2>Waterfall</h2>
    </div>
  </div>
  <div class="panel">
     <img src="/myproject/jsp/myspace/image/08.jpg" /> 
    <div class="panel-overlay">
      <h2>Death Valley</h2>
    </div>
  </div>
  <ul class="filmstrip">
    <li><img src="/myproject/jsp/myspace/image/frame-01.jpg" alt="Effet du soleil" title="Effet du soleil" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-02.jpg" alt="Eden" title="Eden" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-03.jpg" alt="Snail on the Corn" title="Snail on the Corn" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-04.jpg" alt="Flowers" title="Flowers" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-06.jpg" alt="Alone Beach" title="Alone Beach" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-05.jpg" alt="Sunrise Trees" title="Sunrise Trees" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-07.jpg" alt="Waterfall" title="Waterfall" /></li>
    <li><img src="/myproject/jsp/myspace/image/frame-08.jpg" alt="Death Valley" title="Death Valley" /></li>
  </ul>
</div>
<h3>&nbsp;</h3>
 </div>   
 </div>
 
          <!-- /.blog-post -->        

        </div><!-- /.blog-main -->
              <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
        <div align="left"><form class="navbar-search pull-left"> <input type="text" class="search-query" placeholder="请输入搜索关键字">
          &nbsp; 
          &nbsp; &nbsp;
          <button type="submit" class="btn-danger">提交
        </button>
       
        <p>&nbsp; &nbsp;</p>
        </div>
        </div>
         </form>

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4><font="幼圆"><img src="image/zan.jpg">运动宣言：</font></h4>
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
        <a href="#">Back to top</a>
      </p>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
