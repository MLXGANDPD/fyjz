<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head lang="cn">
    <meta charset="UTF-8">
    <title>学子商城首页</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/index.css" rel="stylesheet"/>
    <link href="../css/slide.css" rel="stylesheet"/>
    <link href="../css/footTxt.css" rel="Stylesheet"/>
    
    </head>
<body>
<!-- 页面顶部-->
	<%@include file="header.jsp" %>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.html" class="acti">首页</a></li>
        <li><a href="index.html#computer" >电脑办公</a></li>
        <li><a href="index.html#stationery" >办公文具</a></li>
    </ul>
</nav>
<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="product_details.html"><img src="../images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="product_details.html"><img src="../images/itemCat/itemCat_banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="product_details.html"><img src="../images/itemCat/itemCat_banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="product_details.html"><img src="../images/itemCat/itemCat_banner4.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="product_details.html"><img src="../images/itemCat/itemCat_banner1.png" alt=""></a>
        </li>
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
            </ul>
        </div>
    </div>
</div>

<!--/*楼梯1f*/-->
<h2 id="computer" class="stair"><span><img src="../images/itemCat/computer_icon.png" alt=".stair"/></span>办公电脑 /1F</h2>

<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf">
            <div class="left_pro lf">
                <p class="top_ys1">灵越 燃7000系列</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥4999.00</p>

                <p class="top_ys4 color_2"><a href="product_details.html">查看详情</a></p>
            </div>
            <span><img src="../images/itemCat/study_computer_img1.png" alt=""/></span>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf">
            <div class="right_pro lf">
                <p class="top_ys1">颜值 框不住</p>

                <p class="top_ys2">
                    酷睿双核i5处理器|256GB SSD| 8GB内存
                    </br>
                    英特尔HD显卡620含共享显卡内存
                </p>

                <p class="top_ys3">￥6888.00</p>

                <p class="top_ys4 color_2"><a href="product_details.html">查看详情</a></p>
            </div>
            <span><img src="../images/itemCat/study_computer_img2.png" alt=""/></span>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_2">
                <span>
                    <img src="../images/itemCat/computer_icon1.png" alt=""/>
                    电脑,办公/1F
                </span>
            </div>
            <div class="item_cat_all">
            	
                <c:forEach items="${map.list2}" var="m" varStatus="s"> 
                	<!--二级商品-->
                	<p>${m.name}</p>
                	<ul>
                		<c:forEach items="${map.list3[s.index]}" var="m2">
                		<!--三级商品-->               			
                			<li><a href="${basePath}/good/searchHTML.do?id=${m2.id}">${m2.name}</a></li>
                		</c:forEach>
                	</ul>
                </c:forEach>
            </div>
        </div>
        <c:forEach items="${map.goods}" var="g">
	         <div class="item_msg lf">
	            <img src="${basePath}${g.image}" alt="图片无法显示" title="${g.title}"/>
	
	            <p class="bottom_ys2" style="height:30px;overflow:hideeen">${g.title}</p>
	
	            <p class="bottom_ys3">￥${g.price}.00</p>
	
	            <p class="bottom_ys4 color_2"><a href="product_details.html">查看详情</a></p>
	        </div>
        </c:forEach>
 
        
    </div>
</div>
<!--楼梯2f-->
<h2 id="stationery" class="stair"><span><img src="../images/itemCat/stationery_icon.png" alt=".stair"/></span>办公文具 /2F</h2>

<div class="lf1">
    <div class="lf1_top">
        <!-- 上面部分左侧区域-->
        <div class="left lf">
            <div class="left_ys1 lf"><img src="../images/itemCat/study_stationery_img1.png" alt=""/></div>
            <div class="left_pro lf">
                <p class="top_ys1">雅致布面年历本</p>

                <p class="top_ys2">
                    有色更有范！变色PU皮，撞色搭配，绚丽色彩，张扬个性，点亮生活新时尚！
                </p>

                <p class="top_ys3 price_ys3">仅售 ￥49.00</p>

                <p class="top_ys4 color_1"><a href="product_details.html">查看详情</a></p>
            </div>
        </div>
        <!-- 上面部分右侧区域-->
        <div class="right lf">
            <div class="left_ys2 lf"><img src="../images/itemCat/study_stationery_img2.png" alt=""/></div>
            <div class="right_ys rt">
                <p class="top_ys1">透视网格拉链袋</p>
                <p class="top_ys2">
                    韩国创意卡通 丛林物语网格文件袋
                </p>
                <p class="top_ys3 price_ys3">仅售 ￥28.00</p>

                <p class="top_ys4 color_1"><a href="product_details.html">查看详情</a></p>
            </div>
        </div>
    </div>
    <div class="lf1_bottom">
        <div class="item_cat lf">
            <div class="cat_header color_1">
                <span>
                    <img src="../images/itemCat/stationery_icon1.png" alt=""/>
                    办公文具/2F
                </span>
            </div>
            <div class="item_cat_all item_color">
            
                 <c:forEach items="${map2.list2}" var="m" varStatus="s"> 
                	<!--二级商品-->
                	<p>${m.name}</p>
                	<ul>
                		<c:forEach items="${map2.list3[s.index]}" var="m2">
                		<!--三级商品-->               			
                			<li><a href="${basePath}/good/searchHTML.do?id="${m2.id}>${m2.name}</a>
                		</c:forEach>
                	</ul>
                </c:forEach>
                
            </div>
        </div>
      
        <c:forEach items="${map2.goods2}" var="g">
	        <div class="item_msg lf">
	             <img src="${basePath}${g.image}" alt="图片无法显示" title="${g.title}"/>
	
	            <p class="bottom_ys2" style="height:30px;overflow:hideeen">${g.title}</p>
	
	            <p class="bottom_ys3 price_ys3">￥${g.price}.00</p>
	
	            <p class="bottom_ys4 color_1"><a href="product_details.html">查看详情</a></p>
	        </div>
        </c:forEach>
        

        <div class="item_msg lf">
            <a href="product_details.html">
            <img src="../images/itemCat/study_stationery_img5.png" alt=""/>
            <p class="bottom_ys2">齐心皮面日程本子2017.1-2018.6计划记事本效率手册</p>
            <p class="bottom_ys3 price_ys3">￥23.00</p>
            <p class="bottom_ys4 color_1"><a href="product_details.html" id="iii">查看详情</a></p>
            </a>
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
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/slide.js"></script>
<script>
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
</script>
<script>
    $("#iii").click(function(){
        location.href="product_details.html";
    })
</script>

<script src="../js/footTxt.js"></script>
</body>
</html>