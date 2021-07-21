<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="basePath" value="${pageContext.request.contextPath}" />
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 乾坤科技学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link href="../css/footTxt.css" rel="Stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<header id="top" class="fixed_nav">
   <%@include file="header.jsp" %>
</header>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.html" class="acti">首页</a></li>
        <li><a href="index.html#computer" >电脑办公</a></li>
        <li><a href="index.html#stationery" >办公文具</a></li>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt >我的订单
                <img src="../images/myOrder/myOrder2.png">
            </dt>
            <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
            <dd>
                <a href="#">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt >我的优惠卷<img src="../images/myOrder/myOrder1.png"></dt>
        </dl>
        <dl class="address">
                <dt>收货地址<img src="../images/myOrder/myOrder1.png"></dt>
				<dd><a href="${basePath}/address/toAddressHTML.do">地址管理</a></dd>
            </dl>
            <dl class="count_managment">
                <dt >帐号管理<img src="../images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="${basePath}/address/toMyinforHTML.do">我的信息</a></dd>
                <dd><a href="${basePath}/address/toUpdateHTML.do">安全管理</a></dd>
            </dl>
    </div>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="${basePath}/address/toMyinforHTML.do">我的信息</a></span>
            <span class="rs_header_active"><a href="${basePath}/address/toUpdateHTML.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word" >输入旧密码：</span><input type="password" id="oldpwd" onblur="oldPwd()"/><span class="change_hint" id="oldpwdSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input type="password" id="newpwd" onblur="newPwd()"/><span class="change_hint" id="newpwdSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input type="password" id="confirmnewpwd" onblur="confirmNewPwd()"/><span class="confirm_hint" id="confirmnewpwdSpan"></span>
            </div>
            <div class="save_password">
                <input type="button" value="保存更改" style="font-size: 30px" onclick="update()"/>
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf" id="if">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2  footTxt">高端品牌,值得信赖</p>
             <img id="img" class="hide" alt=""  src="../images/footTxt/1.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/2.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/3.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/4.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/5.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/6.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/7.png">
             <img id="img" class="hide" alt=""  src="../images/footTxt/8.png">
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于乾坤科技</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2020 乾坤科技 版权所有 西安ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
<script type="text/javascript">
	//校验用户旧密码
	function oldPwd(){
		//获取用户数据
		var oldpwd=$("#oldpwd").val();
		//正则
  		var regPwd=/^\w{6,9}$/;
  		if(!regPwd.test(oldpwd)){
  			$("#oldpwdSpan").html("旧密码长度在6到9位之间").attr("style","color:red");
  			return false;
  		}
  		
  		//ajax异步请求
  		var url="${basePath}/address/tofindoldPwd.do";
  		var params={"oldpwd":oldpwd};
  		$.post(url,params,function(result){
  			if(result.state==1){
  				$("#oldpwdSpan").html(result.message).attr("style","color:green");
  			}else{
  				$("#oldpwdSpan").html(result.message).attr("style","color:red");
  			}
  		});
  		return true;
	}
	
	//用户输入的新密码
	function newPwd(){
		//获取用户新密码
		var newpwd=$("#newpwd").val();
		//正则
		var regPwd=/^\w{6,9}$/;
		if(!regPwd.test(newpwd)){
			$("#newpwdSpan").html("新密码长度在6到9位之间").attr("style","color:red");
			return false;
		}
		$("#newpwdSpan").html("ok").attr("style","color:green");
  		return true;
	}
	
	
	//校验用户输入的新密码
	function confirmNewPwd(){
		//获取用户新密码
		var newpwd=$("#newpwd").val();
		//获取校验的密码
		var confirmnewpwd=$("#confirmnewpwd").val();
		if(newpwd!=confirmnewpwd){
			$("#confirmnewpwdSpan").html("密码不一致").attr("style","color:red");
			return false;
		}
		$("#confirmnewpwdSpan").html("ok").attr("style","color:green");
  		return true;
	}
	
	//提交
	function update(){
		var n=oldPwd()+newPwd()+confirmNewPwd();
		if(n==3){
			var newpwd=$("#newpwd").val();
			var data={"newpwd":newpwd};
			var url="${basePath}/address/toUpdatePwd.do"
			$.post(url,data,function(result){
				if(result.state==1){
					//跳转到登录页面
					location.href="${basePath}/user/tologinHtmL.do"
				}else{
					alert(result.message);
				}
			});
		}else{
			alert("请仔细查看填写内容");
		}
		
	}
	
</script>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script src="../js/footTxt.js"></script>
</html>