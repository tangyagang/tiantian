<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/product-details.css" type="text/css" rel="stylesheet"/>
<title>product-details.class</title>

</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/product-details.js"></script>
<script type="text/javascript">
    $(function(){
        $("#buyCar").click(function () {
            var num = $(".number2").val();
            var proId = $(".proId").val();
            window.location.href = "${request.contextPath}/userManager/doShopping?proId=${product.proId}&num="+num;
        })
    })
</script>
<body>
<!--网页头部-->
<header>
<div class="main1">
<div class="test2">
<div class="A1"> <a href="#">登录&nbsp;&nbsp;</a> <a href="#">免费注册</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">我的订单&nbsp;&nbsp;</a>| </div>
<div class="A2">
<ul class="B1">
|
<li class="c1"><a href="#">&nbsp;&nbsp;&nbsp;收藏夹&nbsp;&nbsp;</a></li>
<li class="c1"><a href="#">&nbsp;<img src="img/head_cart.png" />&nbsp;购物车&nbsp;&nbsp;&nbsp; </a> </li >
<li class="c1"><a href="#">关于我们&nbsp;</a></li>
</div>
</div>
</div>
<div class="top">
  <div class="logo"> <a href="#"> <img src="img/log.png"/> </a> </div>
  <div class="search">
    <form>
      <input type="search" value="" placeholder="请输入关键字" class="s_ipt"/>
      <input type="submit" value="搜索" class="s_btn"/>
    </form>
  </div>
</div>
<div class="head_nav_main">
  <div class="head_nav_main1"> <a href="#" class="head_index_on" style="color:#FFF"> 首页 </a> <a href="#"> 天天精选 </a> <a href="#"> 9块9包邮 </a> <a href="#"> 排行榜 </a> <a href="#"> 品牌团 </a> <a href="#">积分商城</a> <span class="n"></span> </div>
</div>
</header>


<section id="section">
	<div class="section-header">
    	<span class="span1"><a href="#">${product.productCategory.productCategory.productCategory.pcName?split("/")[0]} </a>></span>
        <span class="span1"><a href="#"> ${product.productCategory.productCategory.pcName} </a>></span>
        <span class="span2"> ${product.productCategory.pcName}</span>
     </div>
    <div>
    	<div class="img"><img src="${product.proUrl}" width="420px" height="420pxs"></div>
        <div class="section-left">
        	<span>${product.proName}</span>
        </div>
        <div class="section-section">
        	<div class="section-section-a">
            	<span class="section-a">￥${product.proPrice}</span>
                <#if product.isPrice == 1>
                    <span class="b">￥${product.newPrice}</span>
                </#if>
               <span class="c">去客户端签到可领红包</span>
            </div>
            <div class="span3">
            	<span>积分最多返72积分积分可抵订单金额</span>
            </div>
            <div class="span4">
            	<span>优惠指定商品满99减20,满199减50</span>  
            </div>
      </div>
      <div class="number">
      		<span class="number-n1">请选择数量</span>
            <input type="button" value="-" class="number1"/>
            <input type="text" value="1" class="number2"/>
            <input type="button" value="+" class="number3"/>
            <span class="number-n2">库存<span class="number-n2-no">${product.stock}</span>件</span>
      </div>
      <div class="section-bottom">
      	<a href="#"><div class="section-bottom-left">立即购买</div></a>
        <input type="hidden" value="${product.proId}" name="proId" class="proId"/>
        <a href="javascript:void(0)" id="buyCar"><div class="section-bottom-right">加入购物车</div></a>
      </div>
    </div>
    <div class="section-right">
    	<div class="section-right-header"><img src="${product.shop.user.userUrl}" width="330px" height="170px"></div>
        <div class="section-right-section">
        	${product.shop.shopName}
        </div>
        <div class="pingfen">描述综合评分<span class="pingfen1">10</span></div>
        <div class="pingfen">服务综合评分<span class="pingfen1">10</span></div>
        <div class="pingfen">发货综合评分<span class="pingfen1">10</span></div>
        <div class="section-right-bottom"><a href="#"><span class="product">店铺收藏</span></a></div>
    </div>
</section>


<div class="review-product">
	<div class="review-header">商品详情</div>
    <div class="review-section"><img src="img/de8.jpg"></div>
    <div class="review-section1"><img src="img/de7 (1).jpg"></div>
    <div  class="review-header">商品评价</div>
	<div class="review">
        <#list pageInfo.list as proScore>
            <div class="review-re">
                <div class="review1">${proScore.user.nickName}</div>
                <div class="review2">${proScore.details}</div>
                <div class="review3">${proScore.createTime}</div>
            </div>
        </#list>
	</div>
 </div>
 <!--分页-->
<!--分页 -->
<div id="fenye">
    <div class="fenye_main">
            <#if pageInfo.pageNum == 1>
                <span class="fenye_changIn">首页</span>
            <#else >
                <span class="fenye_changIn"><a href="#">首页</a></span>
            </#if>
            <#if pageInfo.pageNum == 1>
                <span class="fenye_changIn">上页</span>
            <#else >
                <span class="fenye_changIn"><a href="#">上页</a></span>
            </#if>
            <#list numbs>
                <#items as numb>
                     <span class="fenye_test"><a href="#">${numb}</a></span>
                </#items>
            </#list>
            <#if pageInfo.pageNum == pageInfo.pages>
                <span class="fenye_changIn">下页</span>
            <#else >
                <span class="fenye_changIn"><a href="#">下页</a></span>
            </#if>
             <#if pageInfo.pageNum == pageInfo.pages>
                <span class="fenye_changOut">末页</span>
             <#else >
                <span class="fenye_changOut"><a href="#">末页</a></span>
             </#if>
    </div>
</div>

<!--网页底部-->
<footer class="center">
  <div class="about" style="height:400px;">
    <ul class="area">
      <li class="lw"> <span class="aboutus show_icon"><img src="img/foot1.png" /></span> <span>关于我们</span> <a href="#"  >关于我们</a> <a rel="nofollow" href="#"  >网站服务条款</a> <a href="#"  >用户服务协议</a> <a href="#"  >联系我们</a> <a href="#" >隐私政策</a> </li>
      <li class="lw"> <span class="shopguide show_icon"><img src="img/foot2.png" /></span> <span>购物指南</span> <a href="#"  >新手玩转折800</a> <a href="#"  >订单查询</a> <a href="#"  >会员介绍</a> <a href="#"  >积分攻略</a> <a href="#"  >帮助中心</a> </li>
      <li class="lw"> <span class="busscom show_icon"><img src="img/foot3.png" /></span> <span>消费者保障</span> <a href="#"  >商品抽检</a> <a href="#"  >退货退款政策</a> <a href="#"  >运费补贴卡</a> <a href="#"  >无忧售后</a> <a href="#"  >先行赔付</a> </li>
      <li class="lw"> <span class="usersafe show_icon"><img src="img/foot4.png" /></span> <span>商务合作</span> <a href="#"  >商家报名</a> <a href="#"  >友情链接</a> <a href="#"  >廉正举报</a> </li>
      <li class="w3"> <span class="nexttothere show_icon"><img src="img/foot5.png" /></span> <span>下次怎么来?</span>
        <h3> 记住域名：<a  href="#"  > <em>天天购物.com</em> </a> </h3>
       
      </li>
    </ul>
  </div>
  <div class="btmbg">
    <div class="btm"> 京ICP证120075号  京ICP备10051110号-5  京公网安备11010502025623  统一社会信用代码 91110105571298269B  食品流通许可证			SP1101051510352397 </br>
      出版物经营许可证 新出发京零字第朝160018号  Copyright©2011-2015 版权所有 ZHE800.COM </br>
      天天购物有限公司、地址：湖南长沙北大青鸟、电话：400-0611-800 <br/>
      <img src="img/b_1.gif"/> <img src="img/b_2.gif"/> <img src="img/b_3.gif"/> <img src="img/b_4.gif"/> <img src="img/b_5.gif"/> <img src="img/b_6.gif"/> </div>
  </div>
</footer>
</body>
</html>
