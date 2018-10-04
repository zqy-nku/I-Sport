<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>好友相册</title>
<!-- Bootstrap -->
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 
<!----font-Awesome----->
   	<link rel="stylesheet" href="fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700' rel='stylesheet' type='text/css'>
<link href="/myproject/jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>
<script src="/myproject/jsp/js/jquery.circliful.min.js"></script>
<script>
$( document ).ready(function() {
		$('#myStat2').circliful();
    });
</script>
 <!-- start price_bar  -->	
<link href="/myproject/jsp/css/jquery.nouislider.css" rel="stylesheet">
<script src="/myproject/jsp/js/jquery.nouislider.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
body{overflow-y:scroll;font-family:"HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, sans-serif;background:#f4f4f4;padding:0;margin:0;}
h1{font-size:31px;line-height:100px;font-weight:normal;margin-bottom:100px;}
a,a:hover{border:none;text-decoration:none;}
img,a img{border:none;}
pre{overflow-x:scroll;background:#ffffff;border:1px solid #cecece;padding:10px;}
.clear{clear:both;}
.zoomed > .container{-webkit-filter:blur(300px);filter:blur(300px);}
.contain{width:1030px;margin:0 auto;}
.gallery{list-style-type:none;float:left;background:#ffffff;padding:20px 20px 10px 20px;margin:0;-webkit-box-shadow:0 1px 3px rgba(10,0,0,0.50);-moz-box-shadow:0 1px 3px rgba(10,0,0,0.50);box-shadow:0 1px 3px rgba(10,0,0,0.50);-webkit-border-radius:2px;-moz-border-radius:2px;border-radius:2px;}
.gallery li{float:left;padding:0 20px 20px 0;}
.gallery li:nth-child(11n){padding-right:0;}
.gallery li a,.gallery li img{float:left;}
</style>
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


<!--图片弹出层样式 必要样式-->
<link rel="stylesheet"  href="/myproject/jsp/css/zoom.css" media="all" />
</head>
<body>
<div class="container">
<div class="main">
		<div class="h_menu">
		
		<nav>
		<ul class="menu list-unstyled">
		    <li class="color1"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
			<li class="color3"><a href="/myproject/jsp/othermain.jsp">好友主页</a></li>
			<li class="color2"><a href="/myproject/jsp/otherphoto.jsp">好友相册</a></li>   
				<li>
				<a href="#">${sessionScope.person.nickname}</a></li>
				<li><a href="/myproject/logoutServlet">退出</a></li>
		</ul>
		</nav>
		<script src="/myproject/jsp/js/menu.js" type="text/javascript"></script>
		

        <div class="contain">

	<ul class="gallery">
		<li><a href="img/gallery/DSC_0008-660x441.jpg"><img src="img/gallery/DSC_0008-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0014-660x441.jpg"><img src="img/gallery/DSC_0014-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0019-660x441.jpg"><img src="img/gallery/DSC_0019-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0061-660x441.jpg"><img src="img/gallery/DSC_0061-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0063-441x660.jpg"><img src="img/gallery/DSC_0063-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0008-660x441.jpg"><img src="img/gallery/DSC_0008-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0014-660x441.jpg"><img src="img/gallery/DSC_0014-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0019-660x441.jpg"><img src="img/gallery/DSC_0019-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0061-660x441.jpg"><img src="img/gallery/DSC_0061-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0063-441x660.jpg"><img src="img/gallery/DSC_0063-69x69.jpg" /></a></li>
        <li><a href="img/gallery/DSC_0008-660x441.jpg"><img src="img/gallery/DSC_0008-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0014-660x441.jpg"><img src="img/gallery/DSC_0014-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0019-660x441.jpg"><img src="img/gallery/DSC_0019-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0061-660x441.jpg"><img src="img/gallery/DSC_0061-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0063-441x660.jpg"><img src="img/gallery/DSC_0063-69x69.jpg" /></a></li>
        <li><a href="img/gallery/DSC_0008-660x441.jpg"><img src="img/gallery/DSC_0008-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0014-660x441.jpg"><img src="img/gallery/DSC_0014-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0019-660x441.jpg"><img src="img/gallery/DSC_0019-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0061-660x441.jpg"><img src="img/gallery/DSC_0061-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0063-441x660.jpg"><img src="img/gallery/DSC_0063-69x69.jpg" /></a></li>
        <li><a href="img/gallery/DSC_0008-660x441.jpg"><img src="img/gallery/DSC_0008-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0014-660x441.jpg"><img src="img/gallery/DSC_0014-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0019-660x441.jpg"><img src="img/gallery/DSC_0019-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0061-660x441.jpg"><img src="img/gallery/DSC_0061-69x69.jpg" /></a></li>
		<li><a href="img/gallery/DSC_0063-441x660.jpg"><img src="img/gallery/DSC_0063-69x69.jpg" /></a></li>
	</ul>
	

<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/zoom.min.js"></script>
<div style="text-align:left;clear:both">

</div>

	<div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
		<div class="col-md-6 span1_of_1"><!-- start span1_of_3 style1 -->
			
		
			<div class="grid1_of_list1">	
				
              
                    
					
                  
				
				<ul class="list_img list-unstyled">
					<li></li>
					<li></li>
				</ul>			
			</div>
		</div>
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			
			
			
		</div>
	</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
	
          <div class="signin_form">
					
					
                
                    
                    
				</div>
			
                
                
      
        
		</div><!-- end switch_main ---->
        
        	
	<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
    <div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
    <div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			
			
			
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			
			
			
		</div>
	</div><!-- end span1_of_2 -->	
    <div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
	
          <div class="signin_form">
					
					
                  
                    
				</div>
			
                
                
      
        
		</div><!-- end switch_main ---->
        
	
       
					
				
                    
				
			
                
                
      
        
		<!-- end switch_main ---->
	<div class="copy">
		<p class="link"><span></a></span></p>
	</div>



<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>