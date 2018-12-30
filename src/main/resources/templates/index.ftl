<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/public.css" type="text/css" rel="stylesheet"/>
    <title>public.class</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/public.js">

    </script>


</head>


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
                    <li class="c1"><a href="#">&nbsp;<img src="images/head_cart.png" />&nbsp;购物车&nbsp;&nbsp;&nbsp; </a> </li >
                    <li class="c1"><a href="#">关于我们&nbsp;</a></li>
            </div>
        </div>
    </div>
    <div class="top">
        <div class="logo"> <a href="#"> <img src="images/log.png"/> </a> </div>
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

<!--网页主题部分-->
<section class="center_clear" >
    <!--商品列表、焦点图-->
    <div class="clear">
        <div class="menu_bg">
            <div class="menu">
                <!--Begin 商品分类详情 Begin-->
                <nav class="nav">
                    <div class="leftNav">
                        <!--左边购物列表导航-->
                          <#list productCategorys>
                          <ul>
                              <#items as productCategory>
                              <li>
                                  <div class="fj">
                                      <span class="fl">${productCategory.pcName}</span>
                                  </div>
                                  <!--目前不显示，鼠标移入显示-->
                                  <div class="zj">
                                      <div class="zj_l">
                                          <#list productCategory.productCategorys>
                                              <#items as type2>
                                                  <div class="zj_l_c">
                                                      <h2>${type2.pcName}</h2>
                                                      <#list type2.productCategorys>
                                                          <#items as type3>
                                                              <a href="#">${type3.pcName}</a>|
                                                          </#items>
                                                      </#list>
                                                  </div>
                                              </#items>
                                          </#list>
                                      </div>
                                      <div class="zj_r">
                                          <a href="#"><img src="images/log5.jpg" width="236" height="200"/></a>
                                          <a href="#"><img src="images/log6.jpg" width="236" height="200"/></a>
                                      </div>
                                  </div>
                              </li>
                              </#items>
                          </ul>
                          </#list>
                    </div>
                </nav>
            </div>
        </div>



        <!--焦点图-->
        <div class="banner">
            <div class="top_slide_wrap">
                <ul class="slide_box ">
                    <li><img src="images/login4.jpg"/></li>
                    <li><img src="images/login1.jpg" /></li>
                    <li><img src="images/login3.jpg" /></li>
                </ul>
                <ul class="num">
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                </ul>
                <div class="op_btns">
                    <a href="#" class="op_btn op_prev"></a>
                    <a href="#" class="op_btn op_next"></a>
                </div>
            </div>
        </div>



        <!--新闻列表-->
        <div class="inews">
            <div class="news_t">
                <h3 class="fl">公告</h3>

            </div>
             <#list newsList>
             <ul>
                 <#items as news>
                 <li><span>${news.title}</span><a href="#">${news.content}</a></li>
                 </#items>
                 <hr/>
             </ul>
             </#list>
        </div>
    </div>




    <!--中间  中间热销部分-->
    <div class="hotSaleIndex_bg" >
        <div class="area hot_sale" >
            <div class="hot_infor">
                <span><img src="images/hostProduct.png" width="130px" height="30"/></span>
                &nbsp;&nbsp;|<a href="#"  target="_blank">&nbsp;&nbsp;即将下架</a>

                &nbsp;&nbsp;|<a href="#"  target="_blank">&nbsp;&nbsp;人气爆款</a>

                &nbsp;&nbsp;|<a href="#"  target="_blank">&nbsp;&nbsp;每日更新</a>
            </div>
        </div>

        <div class="class1">
            <div class="test3">
                <ul >
                    <li class="but_m1"><a><img src="images/secend5.jpg"/></a></li>
                    <li class="but_m1"><a><img src="images/secend4.jpg" /></a></li>
                    <li class="but_m1"><a><img src="images/secend3.jpg" /></a></li>
                    <li class="but_m1"><a><img src="images/secend2.jpg" /></a></li>
                    <li class="but_m1"><a><img src="images/secend1.png"/></a></li>

                </ul>
            </div>

        </div>

    </div>
    <!--中间  中间今日更新部分-->

    <div class="changs_bg" >
        <div class="area changs_sale"  style="border-bottom:#F00 2px solid; height:78px; ">
            <div class="changs_infor">
                <span><img src="images/newProduct.png" width="230px" height="35"/></span>
            </div>

            <div class="changs_next1">
                <ul>
                    <li><a>女装&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>男装&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>美妆&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>家纺&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>母婴&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>内衣&nbsp;&nbsp;</a>|&nbsp;&nbsp;</li>
                    <li><a>鞋包&nbsp;&nbsp;</a>&nbsp;&nbsp;</li>
                    <li class="changs_next1_li"><span>全部分类</span></li>
                </ul>
            </div>
        </div>

        <div class="class2">
            <div class="test4">
                <ul >
                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center1.jpg" style="width:270px; height:250px;" /></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>
                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center2.jpg"  style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center3.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>

                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center4.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥</strong><span style="font-size:16px;">699</span></div>

                    </li>
                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center4.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥</strong><span style="font-size:16px;">699</span></div>

                    </li>
                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center1.jpg" style="width:270px; height:250px;" /></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>
                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center2.jpg"  style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center3.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>

                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>
                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center1.jpg" style="width:270px; height:250px;" /></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>
                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center2.jpg"  style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>
                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>

                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center3.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>

                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>
                    <li class="but_m2">

                        <div class="but_img"><a><img src="images/center3.jpg" style="width:270px; height:250px;"/></a></div>
                        <div class="name"><a><h2>精品毛衣</h2><span>品牌时尚，特价选购,天天优选！</span></a></div>

                        <div class="price"><strong>￥<span>699</span></strong></div>

                    </li>
                    <li style="clear:both"></li>

                </ul>
            </div>

        </div>

    </div>
    <!--分页 -->
    <div id="fenye">
        <div class="fenye_main">
            <span class="fenye_changIn"><a href="#">首页</a></span>
            <span class="fenye_changIn"><a href="#">上页</a></span>
            <span class="fenye_test1"><a href="#">1</a></span>
            <span class="fenye_test2"><a href="#">2</a></span>
            <span class="fenye_test3"><a href="#">3</a></span>
            <span class="fenye_test4"><a href="#">4</a></span>
            <span class="fenye_te">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.....</span>
            <span class="fenye_test"><a href="#">1000</a></span>
            <span class="fenye_changIn"><a href="#">下页</a></span>
            <span class="fenye_changOut"><a href="#">末页</a></span>
        </div>
    </div>








</section>






<!--网页底部-->
<footer class="center">
    <div class="about" style="height:400px;">
        <ul class="area">
            <li class="lw"> <span class="aboutus show_icon"><img src="images/foot1.png" /></span> <span>关于我们</span> <a href="#" target="_blank" >关于我们</a> <a rel="nofollow" href="#" target="_blank" >网站服务条款</a> <a href="#" target="_blank" >用户服务协议</a> <a href="#" target="_blank" >联系我们</a> <a href="#"target="_blank" >隐私政策</a> </li>
            <li class="lw"> <span class="shopguide show_icon"><img src="images/foot2.png" /></span> <span>购物指南</span> <a href="#" target="_blank" >新手玩转折800</a> <a href="#" target="_blank" >订单查询</a> <a href="#" target="_blank" >会员介绍</a> <a href="#" target="_blank" >积分攻略</a> <a href="#" target="_blank" >帮助中心</a> </li>
            <li class="lw"> <span class="busscom show_icon"><img src="images/foot3.png" /></span> <span>消费者保障</span> <a href="#" target="_blank" >商品抽检</a> <a href="#" target="_blank" >退货退款政策</a> <a href="#" target="_blank" >运费补贴卡</a> <a href="#" target="_blank" >无忧售后</a> <a href="#" target="_blank" >先行赔付</a> </li>
            <li class="lw"> <span class="usersafe show_icon"><img src="images/foot4.png" /></span> <span>商务合作</span> <a href="#" target="_blank" >商家报名</a> <a href="#" target="_blank" >友情链接</a> <a href="#" target="_blank" >廉正举报</a> </li>
            <li class="w3"> <span class="nexttothere show_icon"><img src="images/foot5.png" /></span> <span>下次怎么来?</span>
                <h3> 记住域名：<a  href="#"  target="_blank"> <em>天天购物.com</em> </a> </h3>
                <h4> 百度搜索：<a rel="nofollow"  href="#" target="_blank">天天购物</a> </h4>
                <h5> 收藏本站：<a id="clt"  href="#"> <u>加入收藏</u> </a> </h5>
            </li>
        </ul>
    </div>
    <div class="btmbg">
        <div class="btm"> 京ICP证120075号  京ICP备10051110号-5  京公网安备11010502025623  统一社会信用代码 91110105571298269B  食品流通许可证			SP1101051510352397 </br>
            出版物经营许可证 新出发京零字第朝160018号  Copyright©2011-2015 版权所有 ZHE800.COM </br>
            天天购物有限公司、地址：湖南长沙北大青鸟、电话：400-0611-800 <br/>
            <img src="images/b_1.gif"/> <img src="images/b_2.gif"/> <img src="images/b_3.gif"/> <img src="images/b_4.gif"/> <img src="images/b_5.gif"/> <img src="images/b_6.gif"/> </div>
    </div>
</footer>
</body>
</html>
