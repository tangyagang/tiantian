<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="../css/safe/css.css" />
    <link rel="stylesheet" href="../css/safe/common.min.css" />
    <link rel="stylesheet" href="../css/safe/ms-style.min.css" />
    <link rel="stylesheet" href="../css/safe/personal_member.min.css" />
    <link rel="stylesheet" href="../css/safe/Snaddress.min.css" />
    <link rel="stylesheet" href="../css/sui.css" />
    <link rel="stylesheet" href="../css/admin_index.css">
    <link rel="stylesheet" href="../css/购买过的店铺.css"/>
    <script type="text/javascript" src="../js/jquery-1.8.3.js" ></script>
    <script type="text/javascript" src="../js/sui.js" ></script>
    <script type="text/javascript">
        $(function () {
            //宝贝搜索
            $("#searchShop").blur(function () {
                var shopName = $(this).val();
                window.location.href="${request.contextPath}/userManager/buyStore?shopName="+shopName;
            })
        })
    </script>
    <style>
        progress {
            width: 300px;
            border: 1px solid #ffffff;
            background-color: #e6e6e6;
            color: #0064B4;
            /*IE10*/
        }

        progress::-moz-progress-bar {
            background: #FFFFFF;
        }

        progress::-webkit-progress-bar {
            background: #ccc;
        }

        progress::-webkit-progress-value {
            background: #FF7700;
        }
        a{
            color: #000000;
        }
        .sui-table th, .sui-table td {
            padding: 16px 8px;
            line-height: 18px;
            text-align: center;
            vertical-align: middle;
            border-top: 1px solid #e6e6e6;

        }
        .sui-nav.nav-tabs > .active > a {
            font-weight: bold;
            border:1px #fff solid;
            background-color: #fff;
            border-bottom-color: transparent;
            cursor: default;
            font-weight: bold;
            color: #F2873B;
        }
        .sui-nav.nav-tabs > li > a {
            color: #333333;
            line-height: 18px;
            -webkit-border-radius: 3px 3px 0 0;
            -moz-border-radius: 3px 3px 0 0;
            border-radius: 3px 3px 0 0;
            border: 1px #fff solid;
            border-bottom: 1px #fff solid;
            height: 30px;
            width: 110px;
            text-align: center;
            padding-top: 10px;
            font-size: 14px;
        }
        .sui-nav.nav-tabs {
            border-bottom: 1px solid #CECECE;
            padding-left: 5px;
        }
        .sui-nav.nav-tabs > .active > a:hover {
            font-weight: bold;
            cursor: default;
            font-weight: bold;
            color: #F37B1D;
        }
        .sui-nav.nav-tabs > li {
            margin-bottom: -1px;
            background-color: #fff;
            border-bottom: 1px #ccc solid;
        }
        .sui-nav.nav-tabs > .active {
            border-bottom: 0;
        }
        .sui-nav.nav-tabs > li + li {
            margin-left: -3px;
        }
    </style>
</head>

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
<div id="ms-center" class="personal-member">
    <div class="cont">
        <div class="cont-side">
            <div class="side-neck" style="margin-top: 20px;">
                <i></i>
            </div>
            <div class="ms-side" style="margin-top: 20px;" >
                <article class="side-menu side-menu-off">
                    <dl class="side-menu-tree" style="padding-left: 50px;">
                        <dt><img src="../img/左侧/我的购物车.png"  style="margin-right: 10px;margin-left: -20px;"/>我的购物车</dt>
                        <dt><img src="../img/左侧/file.png"  style="margin-right: 10px;margin-left: -20px;"/>订单管理</dt>
                        <dd>
                            <a href="${request.contextPath}/userManager/userOrder">我的订单</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/myCollection">我的收藏</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/proScore">商品评价</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/buyProduct">已买宝贝</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/myHistory">浏览足迹</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/buyStore">购买过的店铺</a>
                        </dd>
                        <dt><img src="../img/左侧/我的买啦.png"  style="margin-right: 10px;margin-left: -20px;"/>个人信息</dt>
                        <dd>
                            <a href="${request.contextPath}/userManager/userInfo">基本资料</a>
                        </dd>
                        <dd>
                            <a href="${request.contextPath}/userManager/recAddress">收货地址</a>
                        </dd>
                    </dl>

                    <a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
                </article>
            </div>
        </div>
        <div class="cont-main">
            <div class="main-wrap mt15" style="border: 0px;">
                <h3 style="background-color:#fff ;margin-left: 20px;width: 980px;">
                    <strong style="font-size: 14px;color: #666;">全部店铺</strong>
                    <span style="color: #b94a48;font-size: 14px;position: relative;right: 500px;" >显示最近十条信息</span>
                </h3>
                <div class="profile-info">
                    <div class="control-group clearfix " style="margin-top: 21px;width: 1010px;">
                        <div style="margin-top: -40px;border-bottom: 1px #ccc solid;height: 30px;margin-right: -120px;";>
                            <div style="float:right;display: inline;margin-left:60px;border: 1px #ccc solid;display: inline-block;background-color: #fff;height: 25px;margin-right: 100px;">
                                <input id="searchShop"  name="shopName" value="<#if shopName??>${shopName}</#if>"  type="text" placeholder="店铺名称"  style="width:130px;border: 0px;background-color: #fff;line-height: 25px;border-right: 0px #ccc solid;" />
                                <img src="../img/搜索.png"  style="height: 10px;width: 10px;" />
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-content" style="width: 1000px;margin-top: 0px;border:1px #fff solid; border-top:transparent;margin-left: 30px;">
                    <div id="profile" class="tab-pane active" style="padding: 00px 00px;">
                        <#list shopList as shop>
                            <#assign x=0>
                            <div class="profile_info">
                                <ul>
                                    <li><img src="${request.contextPath}/${shop.user.userUrl}"></li>
                                    <li>
                                        <p>${shop.shopName}</p>
                                    </li>
                                    <#list shop.orderDetails>
                                    <ul>
                                        <#items  as orderdetail>
                                            <li><img src="${request.contextPath}/${orderdetail.product.proUrl}"></li>
                                        </#items>
                                    </ul>
                                    </#list>
                                </ul>
                            </div>
                             <#assign x=x+1/>
                            <#if x == 10>
                                <#break>
                            </#if>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div class="clear"></div>
<div class="ng-footer">

			<textarea class="footer-dom" id="footer-dom-02">
			</textarea>
    <div class="ng-fix-bar"></div>
</div>
<style type="text/css">
    .yuan{
        height: 30px;
        width: 30px;
        border-radius: 50%;
        background-color: #64bdc5;
        display: block;
        text-align: center;
        vertical-align: middle;
        line-height: 30px;
        color: #fff;
        font-size: 18px;
        margin-top: 50px;

    }

    .ng-footer {
        height:514px;
        margin-top: 0;
    }

    .ng-s-footer {
        height: 130px;
        background: none;
        text-align: center;
    }

    .ng-s-footer p.ng-url-list {
        height: 25px;
        line-height: 25px;
    }

    .ng-s-footer p.ng-url-list a {
        color: #666666;
    }

    .ng-s-footer p.ng-url-list a:hover {
        color: #f60;
    }

    .ng-s-footer .ng-authentication {
        float: none;
        margin: 0 auto;
        height: 25px;
        width: 990px;
        margin-top: 5px;
    }

    .ng-s-footer p.ng-copyright {
        float: none;
        width: 100%;
    }

    .root1200 .ng-s-footer p.ng-copyright {
        width: 100%;
    }
</style>
<script type="text/javascript" src="js/safe/ms_common.min.js"></script>
</body>

</html>