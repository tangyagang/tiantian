<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物车</title>
<link href="../css/shopping.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../js/shopping.js" ></script>
</head>

<body>
<!--网页头部-->
<header  class="main">
	<div class="main1">
        <div class="test2">
            <div class="A1"> <a href="#">登录&nbsp;&nbsp;</a> <a href="#">免费注册</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">我的订单&nbsp;&nbsp;</a>| </div>
            <div class="A2">
            <ul class="B1">
            |
            <li class="c1"><a href="#">&nbsp;&nbsp;&nbsp;收藏夹&nbsp;&nbsp;</a></li>
            <li class="c1"><a href="#">&nbsp;<img src="../img/head_cart.png" />&nbsp;购物车&nbsp;&nbsp;&nbsp; </a> </li >
            <li class="c1"><a href="#">关于我们&nbsp;</a></li>
            </div>
            </div>
            </div>
            <div class="top">
              <div class="logo"> <a href="#"> <img src="../img/log.png"/> </a> </div>
              <div class="search">
                <form>
                  <input type="search" value="" placeholder="请输入关键字" class="s_ipt"/>
                  <input type="submit" value="搜索" class="s_btn"/>
                </form>
              </div>
            </div>
            
</header>



<!--主体部分-->
<section class="center_class" >
		<div id="ms-center" class="personal-member">
			<div class="cont">

				<div class="cont-main" style="width: 1210px;">
					<div style="margin-top: 20px;width: 1200px;">
						<font style="font-size: 16px;color: #F4401C;font-weight: bold; margin-left:20px;   padding-bottom: 14px;"><span">共<span class="J_totalCount">0</span>件商品</span></font>
						<font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">|</font>
						<font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">降价商品 0</font>
						<font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">|</font>
						<font style="font-size: 16px;color: #060606; font-weight:bold;margin-left:20px;">库存紧张  0</font>
						<font style="font-size: 12px;color: #949494; font-weight:bold;margin-left:670px;">已选商品(不含运费)</font>
                        	<input type="button" value="结算" style="float: right; color:#686868;background-color:#DEDEDE;height:20px;width:46px;border-style:solid;"></input>
                        <hr style=" border-style:solid;width: 1200px;border-color:#DEDEDE;margin-top: 12px;"/> 
                         <input name="商品" class="allSelect" onclick="checkboxAllOnclick(this)" type="checkbox" value="" style="margin-top:19px;" />
					
                        <font style="font-size: 12px;color: #212121;margin-left: 20px;font-weight: bold;margin-top: -15px;display: flex;">全选</font> 
                        <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">商品信息</font> 
                        <font style="font-size: 12px;color: #212121;margin-left: 400px;font-weight: bold;">单价(元)</font> 
                        <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">数量</font>
                        <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">金额(元)</font>
                        <font style="font-size: 12px;color: #212121;margin-left: 100px;font-weight: bold;">操作</font>			
            
            </div>
            </div>
          </div>
</div>
 
    
<div class="last">
      <div class="noshop">
         <img src="../img/icon_tips2.png" alt=""/>
         <h3>你的1号店购物车还是空的</h3>
      </div>

          <div class="shop">
          <#list pageInfo.list>
              <ul>
                  <#items as buyCar>
                      <li>
                          <input class="li_input" name="store" onclick="checkboxOnclick(this)" type="checkbox" value="" style="margin-top: 15px;margin-left: 20px;" />
                          <div class="shopImg">
                              <img src="${request.contextPath}/${buyCar.product.proUrl}" width="60px" height="70px" alt=""/>
                          </div>
                          <div class="shopText">
                              <div class="clear">
                                  <h5>${buyCar.product.proName} </h5>
                              </div>

                              <p class="price">￥
                                    <#if buyCar.product.isPrice == 1>
                                        ${buyCar.product.newPrice?replace(",","")}
                                    <#else >
                                        ${buyCar.product.proPrice?replace(",","")}
                                    </#if>
                              </p>
                              <div class="clear">
                                  <div class="plush">
                                      <span class="J_btnDelCount">-</span>
                                      <input class="J_inputCount" type="text" name="num" value="${buyCar.num}"/>
                                      <input type="hidden" name="buyCarId" value="${buyCar.buyCarId}"/>
                                      <span class="J_btnAddCount">+</span>
                                  </div>
                                  <strong class="J_smallTotalPrice">￥
                                        <#if buyCar.product.isPrice == 1>
                                            ${(buyCar.product.newPrice?replace(",","")?number*buyCar.num)?replace(",","")}
                                        <#else >
                                            ${(buyCar.product.proPrice?replace(",","")?number*buyCar.num)?replace(",","")}
                                        </#if>
                                  </strong>
                                  <a href="#" class="shoucang">加入收藏</a>
                                  <a href="#" class="close J_btnDelete">删除</a>
                              </div>
                          </div>
                      </li>
                  </#items>
              </ul>
          </#list>


          <div class="buy">
              <div class="buy_chose" style=" width:100px; float:left;">
                  <input name="商品" type="checkbox" class="allSelect" onclick="checkboxAllOnclick(this)" value="" style="margin-top:19px;" />
                  <font  style="font-size: 12px;color: #212121;margin-left: 20px;font-weight: bold;margin-top: -18px;display: flex;  width:60PX;">全选</font>
              </div>
              <a href="#" class="buy_delete">批量删除</a>

              <a href="#" class="buy_count">立即结算<span class="J_totalCount">(0)</span></a>
              <p>合计 <span class="J_totalPrice">￥0.0</span></p>
          </div>

  </div>
 </div>

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
</section>
<!--网页底部-->
<footer class="center">
  <div class="about" style="height:400px;">
    <ul class="area">
      <li class="lw"> <span class="aboutus show_icon"><img src="../img/foot1.png" /></span> <span>关于我们</span> <a href="#" target="_blank" >关于我们</a> <a rel="nofollow" href="#" target="_blank" >网站服务条款</a> <a href="#" target="_blank" >用户服务协议</a> <a href="#" target="_blank" >联系我们</a> <a href="#"target="_blank" >隐私政策</a> </li>
      <li class="lw"> <span class="shopguide show_icon"><img src="../img/foot2.png" /></span> <span>购物指南</span> <a href="#" target="_blank" >新手玩转折800</a> <a href="#" target="_blank" >订单查询</a> <a href="#" target="_blank" >会员介绍</a> <a href="#" target="_blank" >积分攻略</a> <a href="#" target="_blank" >帮助中心</a> </li>
      <li class="lw"> <span class="busscom show_icon"><img src="../img/foot3.png" /></span> <span>消费者保障</span> <a href="#" target="_blank" >商品抽检</a> <a href="#" target="_blank" >退货退款政策</a> <a href="#" target="_blank" >运费补贴卡</a> <a href="#" target="_blank" >无忧售后</a> <a href="#" target="_blank" >先行赔付</a> </li>
      <li class="lw"> <span class="usersafe show_icon"><img src="../img/foot4.png" /></span> <span>商务合作</span> <a href="#" target="_blank" >商家报名</a> <a href="#" target="_blank" >友情链接</a> <a href="#" target="_blank" >廉正举报</a> </li>
      <li class="w3"> <span class="nexttothere show_icon"><img src="../img/foot5.png" /></span> <span>下次怎么来?</span>
        <h3> 记住域名：<a  href="#"  target="_blank"> <em>天天购物.com</em> </a> </h3>
        
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
