<%@page import="com.chinasofti.myproject.po.Person"%>
<%@page import="com.chinasofti.myproject.biz.impl.UserBizImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.myproject.biz.IUserBiz"%>
<%@page import="com.chinasofti.myproject.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人管理</title>
<!-- Bootstrap -->
<link href="/myproject/jsp/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="/myproject/jsp/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!----font-Awesome----->
 	<link rel="stylesheet" href="/myproject/jsp/fonts/css/font-awesome.min.css">
<link href="/myproject/jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="/myproject/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.js"></script>
<script type="text/javascript" src="/myproject/jsp/js/bootstrap.min.js"></script>
<!--- start circle --->
<script src="js/jquery.circliful.min.js"></script>

<% Person person = (Person)session.getAttribute("person");
	String oldpsw = person.getPassword();
	request.setAttribute("oldpsw", oldpsw);
	out.print(oldpsw);
%>

 <!-- start price_bar  -->	
<link href="css/jquery.nouislider.css" rel="stylesheet">
<script src="js/jquery.nouislider.js"></script>
<script type="text/javascript">
 var oldpswOk, newpswOk,repswOk;
function checkoldpsw(){
	 var oldpsw= ${requestScope.oldpsw}; 
	var inputoldpsw =document.getElementById("oldpassword").value;
	alert(inputoldpsw);
	 if(oldpsw == inputoldpsw){
		document.getElementById("laboldpsw").innerHTML = "ok";
		oldpswOk=true;
	}else {
		document.getElementById("laboldpsw").innerHTML = "密码不正确哦0=0";
		oldpswOk=false;
	} 
}; 
 function checknewpsw(){
	var inputnewpsw =document.getElementById("newpassword").value;
	if(inputnewpsw.length<6 || inputnewpsw.length>12 ||inputnewpsw==null){
		document.getElementById("labnewpsw").innerHTML = "密码不规范0=0";
		alert('notok');
		newpswOk=false;
	}else {
		document.getElementById("labnewpsw").innerHTML = "ok";
		newpswOk=true;
	}
}
function checkrepsw(){
	var inputrepsw =document.getElementById("newrepsw").value;
	var inputnewpsw =document.getElementById("newpassword").value;
	if(inputnewpsw !=inputrepsw ){
		document.getElementById("labrepsw").innerHTML = "两次密码不一致0=0";
		repswOk=false;
	}else {
		document.getElementById("labrepsw").innerHTML = "ok";
		repswOk=true;
	}
}
function submitPsw(){
	if(repswOk==true&& newpswOk==true&& oldpswOk==true){
		return true;
	} else{
		return false;
	}
	
}; 

/*  function IsOk(){
	var flag = ${requestScope.flag};
	if(flag ==1){
		document.getElementById("isok").innerHTML = "修改成功";
	} else if(flag == -1){
		document.getElementById("isok").innerHTML = "修改失败";
} */
function test(){
	alert('hhhhh');
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
}
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
<script type="text/javascript">
function selectAll(checkboxname){
	var lstlabel = document.getElementsByName(checkboxname);
	for(var i=0; i<lstlabel.length;i++){
		lstlabel[i].checked = true;
	}
}
function selectCancle(checkboxname){
	var lstlabel = document.getElementsByName(checkboxname);
	for(var i=0; i<lstlabel.length;i++){
		lstlabel[i].checked = fale;
	}
}
function selectReverse(checkboxname){
	var lstlabel = document.getElementsByName(checkboxname);
	for(var i=0; i<lstlabel.length;i++){
		lstlabel[i].checked = !lstlabel[i].checked;
	}
}
function selectOk(checkboxname){
	var lstlabel = document.getElementsByName(checkboxname);
	 var data = "";
	 var flag = 0;
	 for(var i=0; i<lstlabel.length; i++){
		 if(lstlabel[i].checked == true)
			 flag = 1;
		 break;
	 };
	 if(flag){
		 for(var i=0; i<lstlabel.length; i++){
			 // 判断循环到的当前节点是否被选中
			 if(lstlabel[i].checked == true){
				 // 获取该复选框的value属性值
				 var val = lstlabel[i].value;
				 // 将获取到的值累加到data中
				 data = data+ val+"/"  ;
			 }
		 }
		 // 步骤3：规范数据，删除多余的,号
		 data = data.substr(0, data.length-1);
		 // 步骤4：将数据向服务器上传
	    window.location="/myproject/ChangeLabelServlet?data="+data;
	 }else{
		 alert('至少选一个');
	 }

}
		
</script>
</head>	
<body>
<c:if test="${!empty requestScope.flag }">
<script>var flag = ${requestScope.flag};
if(flag ==1){
	document.getElementById("isok").innerHTML = "修改成功";
} else if(flag == -1){
	document.getElementById("isok").innerHTML = "修改失败";</script>
</c:if>
<c:if test="${empty requestScope.lstSport }">
		<script>
			window.location = "/myproject/ShowLabelServlet";
		</script>
	</c:if>
<div class="container">
<div class="main">
		<div class="h_menu">
		  <nav>
		    <ul class="menu list-unstyled">
			<li class="color1"><a href="/myproject/jsp/index.jsp">首页</a></li>
             <li class="color3"><a href="/myproject/jsp/main.jsp">个人主页</a></li>
             <li class="color2"><a href="/myproject/jsp/photo.jsp">相册</a></li>
            <li class="color3"><a href="/myproject/jsp/changeinfo.jsp">个人管理</a></li>
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
		
			<div class="grid1_of_list1">	
			</div>
		</div>
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:450px;">
				<div class="signin_form" ><h4>修改密码
				  </h4>
</div>
		      <form action="/myproject/ModifyPswServlet" method="post"  name="form1" onsubmit="return submitPsw();">
		        <p>
		          <label>旧密 码：
		            <input type="password" name="旧密码" id="oldpassword" onblur="javascript:checkoldpsw();">
		             <label id="laboldpsw">0</label>
	              </label>
	            </p>
		        <p>
		          <label >新 密码：    
		            <input type="password" name="newpassword" id="newpassword"   onblur="javascript:checknewpsw();">
		            <label id="labnewpsw">1</label>
		           
	              </label>
		        </p>
		        <p>
		          <label>密码确认：
		            <input type="password" name="密码确认" id="newrepsw" onblur="javascript:checkrepsw();">
		            <label id="labrepsw">2</label>
	              </label>
		        </p>
		        <p>
		          <label>
		            <input name="提交新密码" type="submit" class="btn-info" id="提交新密码" value="提交">
	              </label>
	              <label id="isok">3</label>
	              <hr>
	              <h4>上传图片</h4>
	               
		  <form action="/myproject/sendresourceServlet?userid=${sessionScope.person.regid}" method="post" enctype="multipart/form-data" name="form5">
		    <p>
		      <label>图片介绍
		        ：
		        <textarea name="resdesc" id="resdesc" cols="35" rows="1"></textarea>
	          </label>
	        </p>
		    <p>
		      <label>上传资料
		        :<br>
		        <input type="file" name="reslocation" id="reslocation">
	          </label>
		    </p>
		    <p>
		      <label>
		        <input name="提交4" type="submit" class="btn-info" id="提交4" value="提交">
	          </label>
		    </p>
		  </form>
		        </p>
		      </form>
			</div>
        
		        <p></p>
		      </form>
		     
		</div>
	  </div>
	</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
		<div class="grid2_of_1" style="height:450px; margin-left:-13px; width:330px; margin-top:-46px;">
          <div class="signin_form">
					<h4>修改个人信息</h4>
                    
				</div>
			
                
                
      
        
		  <form action="/myproject/changeUserinfoServlet?id=${sessionScope.person.regid}" method="post" enctype="multipart/form-data" name="form2">
		    <p>
		      <label>昵称：
		        <input type="text" name="nickname" id="nickname" placeholder="${sessionScope.person.nickname}">
	          </label>
	        </p>
		    <p>
		      <label>性别：
		        <select name="reggender" size="1" id="reggender">
                <option value="female">女</option>
		         <option value="male">男</option>
	            </select>
	          </label>
		    </p>
		    <p>
		      <label>居住地：
		        <input type="text" name="regaddr" id="regaddr" placeholder="${sessionScope.person.regaddr}">
	          </label>
		    </p>
		    <p>
		      
		        <label>空间介绍：
		          <textarea name="mark" id="mark" cols="35" rows="1"></textarea>
	          </label>
            </p>
             <p>
		      
		        <label>运动宣言：
		          <textarea name="spordec" id="spordec" cols="35" rows="2"></textarea>
	          </label>
            </p>
             <p>
               <label>上传头像
                 ：
                    <input type="file" name="userpho" id="userpho">
               </label>
             </p>
             <p>
               <label>
                 <input name="提交" type="submit" class="btn-info" id="提交" value="提交">
               </label>
             </p>
		  </form>
		</div><!-- end switch_main ---->
        
        	
	<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
    <div class="col-md-8 span_of_2"><!-- start span1_of_2 -->
    <div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:380px; margin-left:26px;width:330px;margin-top:-25px;">
				<div class="signin_form">
					<h4>上传日志</h4>
					
                    
				</div>
		      <form action="/myproject/writeDiaryServlet?userid=${sessionScope.person.regid}" method="post" enctype="multipart/form-data" name="form3">
		        <p>
		          <label>标题：
		          <input type="text" name="mdiaryname" id="mdiaryname">
	              </label>
		        </p>
		        <p><label>内容：
		            <textarea name="mdiarycont" id="mdiarycont" cols=35" rows="7"></textarea>
	              </label>
		        </p>
		        <p>
		          <label>
		            <input type="file" name="mdiaryresid" id="mdiaryresid">
	              </label>
		        </p>
		        <p>
		          <label>
		            <input name="提交2" type="submit" class="btn-info" id="提交2" value="提交">
	              </label>
		        </p>
		      </form>
			</div>
			
			
		</div>
		
		<div class="col-md-6 span1_of_2"><!-- start span1_of_3 style2 -->
			<div class="grid2_of_1" style="height:380px;margin-left:8px;width:337px;margin-top:-25px;">
				<div class="signin_form">
					<h4>上传说说</h4>
					
                    
				</div>
		      <form action="/myproject/writeShuoshuoServlet?userid=${sessionScope.person.regid}" method="post" enctype="multipart/form-data" name="form4">
		        <p>
		          <label>内容：
		            <textarea name="stacontext" id="stacontext" cols="35" rows="8"></textarea>
	              </label>
	            </p>
		        <p>
		          <label>文件
		            ：
		              <input type="file" name="stareid" id="stareid">
	              </label>
		        </p>
		        <p>
		          <label>
		            <input name="提交3" type="submit" class="btn-info" id="提交3" value="提交">
	              </label>
		        </p>
		      </form>
			</div>
			
			
		</div>
	</div><!-- end span1_of_2 -->	
	<div class="col-md-4 span1_of_3"><!-- start span1_of_3 style3 -->
		
		
      
		<div class="grid2_of_1" style="height:380px;margin-left:-20px;width:330px;margin-top:-25px;">
          <div class="signin_form">
					<h4>修改运动标签</h4>
					 <div id="contains">

			<div class="scroll-pane">
			 <table width="%" border="0">
					<%int temp=5; %>
										<c:forEach items="${requestScope.lstSport}" var="lstSport">
											 <tr>
								      <th scope="row"><input  name="sportlabel" type="checkbox"
												value="${lstSport.sportid }"></th>
								      <td><span class="label label-defualt">${lstSport.sportname }
											</span>
										</td>
							        </tr>
											
											
									</c:forEach>
									
								
		      </table>
									  </div>
                </div>
                
								
				<!-- /.blog-post -->
				<div align="right">
				 
				<input class="btn btn-xs btn-info" type="button" id="btselectall"
						value="全选"		onclick="javascript:selectAll('sportlabel');">
							<button class="btn btn-xs btn-info" type="button"
								id="btselectreverse"
								onclick="javascript:selectReverse('sportlabel');">反选</button>
					<button class="btn btn-xs btn-info" type="button" id="btok"
						onclick="javascript:selectOk('sportlabel');">保存</button>
					<button class="btn btn-xs btn-info" type="button" id="btcancle"
						onclick="javascript:selectCancle('sportlabel');">取消</button>
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