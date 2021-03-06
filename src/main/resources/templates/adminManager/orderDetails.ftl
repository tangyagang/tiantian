<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="../js/safe/aywmq_qt.js" ></script>
    <script type="text/javascript" src="../js/safe/da_opt.js" ></script>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="../css/safe/css.css" />
    <link rel="stylesheet" href="../css/safe/common.min.css" />
    <link rel="stylesheet" href="../css/yz_orderDetails.css" />
    <link rel="stylesheet" href="../css/safe/ms-style.min.css" />
    <link rel="stylesheet" href="../css/safe/personal_member.min.css" />
    <link rel="stylesheet" href="../css/safe/Snaddress.min.css" />
    <link rel="stylesheet" href="../css/zpwd/sui.css" />
    <script type="text/javascript" src="../js/sui.js" ></script>
</head>
<style>
    a{
        color: #000000;
    }
    .sui-table th, .sui-table td {
        padding: 6px 8px;
        line-height: 18px;
        text-align: left;
        vertical-align: middle;
        border-top: 1px solid #e6e6e6;
        font-size: 14px;
        color: #333333;
    }
</style>
<body class="ms-body">
<div id="" class="ng-top-banner"></div>
<div class="ng-toolbar">
    <div class="ng-toolbar-con wrapper">
        <div class="ng-toolbar-left">
            <a href="${request.contextPath}/index" class="ng-bar-node ng-bar-node-backhome" id="ng-bar-node-backhome" style="display: block;">
                <span><img src="../img/Home.png" style="margin-right: 10px;"/>返回首页</span>
            </a>
            <div class="ng-bar-node-box ng-site-nav-box">

                <div class="ng-sn-site-nav ng-d-box site-nav-child" style="display:none;">
                    <dl class="sn-site-list lnb">
                        <dt>
                            特色购物
                        </dt>
                        <dd>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            主题频道
                        </dt>
                        <dd>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            生活助手
                        </dt>
                        <dd>
                            <p><a target="_blank">###<i class="hot"></i></a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            会员服务
                        </dt>
                        <dd>
                            <p><a target="_blank">###<i class="hot"></i></a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list rnb">
                        <dt>
                            更多热点
                        </dt>
                        <dd>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a target="_blank">###<i class="hot"></i></a></p>
                        </dd>
                    </dl>
                    <a href="" class="ng-close"><em class="ng-iconfont"></em></a>
                </div>
            </div>

        </div>
        <div class="ng-toolbar-right">
            <a href="" class="ng-bar-node username-bar-node username-bar-node-showside" id="" rel="nofollow" style="display:none;">
                <span id="">天天商城</span>
                <em class="hasmsg ng-iconfont"></em>
            </a>
            <div class="ng-bar-node-box username-handle" id="" style="display: block;">
                <a href="" rel="nofollow" class="ng-bar-node username-bar-node username-bar-node-noside">
                    <span id=""><a href="#"前往注册</span>

                </a>
                <div class="ng-d-box ng-down-box ng-username-slide" style="display:none;">
                    <a href="" class="ng-vip-union" target="_blank" rel="nofollow">账号管理</a>
                    <a href="" rel="nofollow">退出登录</a>
                </div>
            </div>
            <div class="ng-bar-node reg-bar-node" id="reg-bar-node" style="display: none;">
                <a href="" rel="nofollow" class="login">登录</a>
                <a href="" target="_blank" class="login reg-bbb" rel="nofollow">注册</a>
            </div>

            <div class="ng-bar-node-box myorder-handle">
                <a class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>我的天天</span><em class="ng-iconfont down"></em></a>
                <div class="ng-down-box ng-d-box myorder-child" style="display:none;">
                    <a>待支付<em id="waitPayCounts"></em></a>
                    <a>待收货<em id="waitDeliveryCounts"></em></a>
                    <a>待评价<em id="waitEvaluation"></em></a>
                    <a>修改订单</a>
                </div>
            </div>
            <a class="ng-bar-node ng-bar-node-mini-cart" rel="nofollow" href="${request.contextPath}/userManager/shopping">
                <span style="display: inline-block;width: 72px;"><img src="../img/购物车.png" />&nbsp;购物车</span>
                <span class="total-num-bg-box">
						<em></em>
						<i></i>
					</span>
                </span>
            </a>
            <div class="ng-bar-node-box mysuning-handle">
                <a href="${request.contextPath}/userManager/myCollection" rel="nofollow" name="" class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>收藏夹</span><em class="ng-iconfont down"></em></a>
                <div class="ng-down-box ng-d-box mysuning-child" style="display:none;">
                    <a href="" rel="nofollow" target="_blank">我的二手</a>
                    <a href="" rel="nofollow" target="_blank">我的金融</a>
                    <a href="" rel="nofollow">我的收藏</a>
                    <a href="" rel="nofollow">我的任性付</a>
                    <a href="" rel="nofollow">我的优惠券</a>
                    <a href="" rel="nofollow">打卡赚云钻</a>
                    <a href="" class="ng-vip-union" target="_blank" rel="nofollow">会员联盟<em class="ng-iconfont"></em></a>
                </div>
            </div>

            <div class="ng-bar-node-box app-down-box">
                <a href="" target="_blank" rel="nofollow" class="ng-bar-node mb-suning touch-href">
                    <span>关注天天</span>
                </a>
                <div class="ng-mb-box ng-d-box mb-down-child" style="display:none;">
                    <div class="ng-code-box">
                        <p class="ng-tip">
                            <a href="" rel="nofollow" target="_blank"></a>
                        </p>
                        <a target="_blank">
                            <img src="" height="80" width="80">
                        </a>
                    </div>
                    <div class="ng-app-box">
                        <div class="ng-app-list">
                            <a href="" target="_blank" rel="nofollow" class="ng-app">
                                <img src="" title="###"></a>
                            <a href="" target="_blank" rel="nofollow" class="ng-app">
                                <img src="" title="###"></a>
                            <a class="ng-app">
                                <img src="" title="###"></a>
                            <a href="" target="_blank" rel="nofollow" class="ng-app">
                                <img src="" title="###"></a>
                        </div>
                    </div>
                    <a href="" target="_blank" rel="nofollow">
                        <img src="" height="35" width="242">
                    </a>
                    <a href="" class="ng-close" rel="nofollow"><em class="ng-iconfont"></em></a>
                </div>
            </div>

            <a href="${request.contextPath}/myInfo" class="ng-bar-node ng-bar-node-pr5"><span>联系我们</span><em class="ng-iconfont down"></em></a>
            <div class="ng-bar-node-box service-handle">
                <a href="${request.contextPath}/exit" class="ng-bar-node ng-bar-node-service ng-bar-node-fix touch-href ng-bar-node-pr5" rel="nofollow">退出登陆
                </a>
                <div class="ng-down-box ng-d-box service-center-child ng-ser-list" style="display:none;">
                    <a>帮助中心</a>
                    <a>查找门店</a>
                    <a>退换货</a>
                    <a>帮客预约</a>
                    <a>建议反馈</a>
                    <a>在线咨询</a>
                </div>
            </div>
        </div>
        <div id="ng-minicart-slide-box"></div>
    </div>
</div>
<header class="ms-header ms-header-inner ms-head-position">
    <article class="ms-header-menu">
        <style type="text/css">
            .nav-manage .list-nav-manage {
                position: absolute;
                padding: 15px 4px 10px 15px;
                left: 0;
                top: -15px;
                width: 90px;
                background: #FFF;
                box-shadow: 1px 1px 2px #e3e3e3, -1px 1px 2px #e3e3e3;
                z-index: 10;
            }

            .ms-nav li {
                float: left;
                position: relative;
                padding: 0 20px;
                height: 44px;
                font: 14px/26px "Microsoft YaHei";
                color: #FFF;
                cursor: pointer;
                z-index: 10;
            }
            .personal-member .main-wrap {
                width: 1068px;
                margin: 15px 0 30px 180px;
                padding: 0 0 39px 0;
                border: 1px solid #ddd;
                background: none;
            }
        </style>
        <div class="header-menu">
            <div class="ms-logo">
                <a class="ms-head-logo" name="Myyigou_index_none_daohangLogo"><span style="font-size: 30px;color: #fff;font-weight: bold;    line-height: 28px;;">天天购物</span></a>

            </div>
            <nav class="ms-nav">
                <ul>
                    <li class=""><i class="nav-arrow"></i></li>
                    <li class="nav-manage selected"><i ></i>
                        <div class="list-nav-manage " hidden="">
                            <p class="nav-mge-hover">账户管理<em></em></p>
                        </div>
                    </li>
                    <li class="ms-nav-msg"><i ></i></li>
                </ul>

            </nav>
        </div>

    </article>

    <article class="ms-useinfo">
        <div class="header-useinfo" id="">
            <div class="ms-avatar">
                <div class="useinfo-avatar">
                    <img style="margin-left: 0px;width: 60px;height: 60px;"  src="<#if user.userUrl??>${request.contextPath}/${user.userUrl}</#if>">
                    <div class="edit-avatar"></div>
                    <a class="text-edit-avatar">修改</a>
                </div>
                <a>&nbsp;<#if user.nickName??>${user.nickName}</#if></a>
            </div>

            <div class="ms-name-info">
                <div class="link-myinfo">
                    <a>我的编号:99653</a>
                </div>
                <div class="info-member">
							<span class="name-member member-1">
        				 <i></i><a target="_blank" >注册会员</a></span>
                    <span style="margin-left: 20px;">
        				 <a href="${request.contextPath}/userManager/userInfo" >我的资料</a></span>
                </div>
                <div class="info-safety">
							<span class="safety-lv lv-3">
        				<a >安全等级：<span>中</span></a>
							</span>
                    <a class="bind-phone">
                        <i style="background-image: url(../img/修改手机.png);"></i>修改手机</a>
                    <a class="bind-email">
                        <i style="background-image: url(../img/绑定邮箱.png);"></i>修改邮箱</a>
                    <a href="${request.contextPath}/userManager/recAddress" class="manage-addr"><i style="background-image: url(../img/地址管理.png);"></i>地址管理</a>
                </div>
            </div>
        </div>

    </article>
</header>

<div id="yz-center" class="personal-member">

    <div style="margin-top: 10px;margin-left:50px;width: 1000px;height: 163px;border: #F58B0F 1px solid;background: #FFF7EB">

        <#--<div class="yz-detail-table-div" <#if Order.status==0>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >当前订单状态：已拍下商品</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>商品已被拍下，请等待买家付款</span></li>
                    <li ><span>如果商品无法出售，您可以 <a href="/CloseOrder?${Order.orderId}">关闭订单</a></span></li>
                </ol>
            </div>
        </div>-->

        <div  class="yz-detail-table-div" <#if Order.status==1>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >当前订单状态：已付款等待卖家发货</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>款项已经到达商城，请及时发货</span></li>
                    <li ><span>如果无法发货，您可以<a href="#">关闭订单 </a></span></li>
                </ol>
            </div>
        </div>

        <div class="yz-detail-table-div" <#if Order.status==2>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >当前订单状态：卖家已经发货，等待买家确认</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>已经发货，请等待买家确认收货</span></li>
                </ol>
            </div>
        </div>

        <div class="yz-detail-table-div" <#if Order.status==3>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >当前订单状态：买家已确认收货</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>商品已收货，请等待买家评价</span></li>
                    <li ><span>如果商品无法出售，您可以 <a href="/CloseOrder?${Order.orderId}">关闭订单</a></span></li>
                </ol>
            </div>
        </div>

        <div class="yz-detail-table-div" <#if Order.status==4>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >当前订单状态：交易已成功</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>交易成功，请给买家评价</span></li>
                </ol>
            </div>
        </div>

        <div class="yz-detail-table-div" <#if Order.status==5>style="display: block"</#if>>
            <div class="yz-detail-table-div-1">
                <p >交易已关闭</p>
            </div>
            <div class="yz-detail-table-div-2">
                <ol>
                    <li ><span>交易已关闭</span></li>
                </ol>
            </div>
        </div>


    </div>

    <h3 style="margin-left: 60px;margin-top: 30px"> 订单信息</h3>
    <div class="yz-detail-table-div2">
        <div class="yz-detail-table-div2-1">
            <div>
                <p style="font-weight: bold;font-size: 16px">收货地址： </p>
                <p style="font-size: 14px">收货人姓名：${Order.recAddress.recName}，
                    电话：${Order.recAddress.phone}，地址：${Order.recAddress.areas.cities.provinces.province}
                ${Order.recAddress.areas.cities.city} ${Order.recAddress.areas.area}
                ${Order.recAddress.recAddress}，
                    邮编：${Order.recAddress.areas.areaCode}</p>
            </div>
        </div>
        <div class="yz-detail-table-div2-1">
            <div>
                <p style="font-weight: bold;font-size: 16px">订单信息： </p>
                <p style="font-size: 14px">订单编号:${Order.orderNum} &nbsp;&nbsp;&nbsp;下单时间:${Order.createTime}</p>
            </div>
        </div>

        <div  class="yz-detail-box">
            <p style="font-weight: bold;font-size: 16px">商品详情： </p>
            <table>
                <thead>
                <table class="yz-detail">
                    <tbody>
                    <tr class="yz-detail-table-tr1">
                        <td class="list-table-td1">商品名称</td>
                        <td class="yz-super-list-table-td2">数量</td>
                        <td class="yz-super-list-table-td2">单价</td>
                        <td class="yz-super-list-table-td2">小计金额</td>
                        <td class="yz-super-list-table-td4">买家名称</td>
                        <td class="yz-super-list-table-td4">交易状态</td>
                        <td class="list-table-td6">商品评价</td>
                    </tr>
                    </tbody>
                </table>
                </thead>
                <tbody>
                <td>
                    <div class="yz-detail-td-div2">
                        <div class="yz-detail-table-td-div1" >
                            <#if Order.status ==1 || Order.status==2><div style="text-align: right;margin-top: 2px;margin-right: 35px">
                                <a  href="${request.contextPath}/adminManager/closeOrder?orderId=${Order.orderId}">关闭订单</a>
                            </div>
                            </#if>
                        </div>
                        <table>
                            <#list Order.orderDetails>
                                <#items as ord>
                            <tr>
                                <div class="yz-super-list-table">
                                    <td class="yz-super-list-table-body-td1" style="text-align: left"><img style="width: 46;height: 40px;"
                                            src="${request.contextPath}/${ord.product.proUrl}">${ord.product.proName}</td>
                                    <td class="yz-super-list-table-body-td2">${ord.count}</td>
                                    <td class="yz-super-list-table-body-td2">${ord.product.proPrice}</td>
                                    <td class="yz-super-list-table-body-td2">${ord.cost}</td>
                                </div>
                                <!--下面这个DIV只在第一次循环中列数据-->
                                <div class="yz-detail-list-table2">
                                    <td class="yz-detail-list-table-body-td4"><#if ord_index==0>${Order.user.userName}</#if></td>
                                    <td class="yz-super-list-table-body-td4" style="color: #f88600"><p></p>
                                         <#if ord_index ==0>
                                             <#if Order.status==1>
                                            <p style="color: #d90000"> 待发货</p>
                                             <#elseif Order.status==2>
                                            已发货
                                             <#elseif Order.status==3>
                                            等待确认
                                             <#elseif Order.status==4>
                                            交易成功
                                             <#elseif Order.status==5>
                                            交易关闭
                                             </#if></#if></td>
                                    <td class="yz-super-list-table-body-td5"><a href="#" style="color: #0e90d2">评价</a></td>
                                </div>
                            </tr>
                                </#items>
                            </#list>
                        </table>
                    </div>
                </td>
                </tbody>
            </table>
        </div>
        <div style="width:900px;margin-left:50px;margin-top:20px;text-align: right;border-bottom: silver 1px solid;">
            <div style="padding-bottom: 10px;margin-right: 20px"> <b style="font-size: 14px;">订单金额：<b style="font-size: 16px;color: #e82f09"> ${Order.cost}</b>元</b></div>
        </div>
            <#if Order.status==1>
            <!--已付款未发货时显示-->
            <div style="margin-top: 14px;margin-left:50px;width: 900px;">
                <div style="margin-bottom: 20px">
                    <p style="font-weight: bold;font-size: 16px">发货信息： </p><#if message??><span style="font-size: 12px;color: red;display: inline-block;width: 900px;text-align: center;margin-bottom: 10px;">${message}</span></#if>
                    <form action="${request.contextPath}/adminManager/delivery?orderId=${Order.orderId}">
                        <input style="display: none" name="orderId" value="${Order.orderId}">
                        <div style="float: left;font-size: 15px;margin-left: 10px">
                            <td style="">快递公司：<input type="text"  /></td>
                        </div>
                        <div style="font-size: 15px;margin-left: 520px">
                            <td >快递单号：<input type="text"  /></td>
                        </div>
                        <br/>
                        <div style="margin-left: 720px">
                            <a style="width: 75px;height: 24px;background: #05b7fc;border: #05b7fc;font-size: 14px;display: inline-block;margin-right: 10px;" href="${request.contextPath}/adminManager/orderList">
                                <input style="width: 75px;height: 24px;background: #05b7fc;border: #05b7fc;font-size: 14px;margin-right: 10px;" type="button" value="返回">
                            </a>
                            <input style="width: 75px;height: 24px;background: #05b7fc;border: #05b7fc;font-size: 14px" type="submit" value="发货"></div>
                    </form>
                </div>
            </div>
            </#if>
        <div style="padding-bottom: 30px;"/>
    </div>

</div>

</html>