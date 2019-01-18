<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="js/safe/aywmq_qt.js" ></script>
    <script type="text/javascript" src="js/safe/da_opt.js" ></script>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="css/safe/css.css" />
    <link rel="stylesheet" href="css/safe/common.min.css" />
    <link rel="stylesheet" href="css/yz.css" />
    <link rel="stylesheet" href="css/safe/ms-style.min.css" />
    <link rel="stylesheet" href="css/safe/personal_member.min.css" />
    <link rel="stylesheet" href="css/safe/Snaddress.min.css" />
    <link rel="stylesheet" href="css/zpwd/sui.css" />
    <script type="text/javascript" src="js/sui.js" ></script>
    <script type="text/livescript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/livescript" src="js/OrderList.js"></script>
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
            <a  class="ng-bar-node ng-bar-node-backhome" id="ng-bar-node-backhome" style="display: block;">
                <span><img src="${request.contextPath}/img/Home.png" style="margin-right: 10px;"/>返回买啦首页</span>
            </a>
            <div class="ng-bar-node-box ng-site-nav-box">
                <a href="" class="ng-bar-node ng-bar-node-site" >
                    <span><img src="${request.contextPath}/img/daohang.png" style="margin-right: 5px;" />网站导航</span><em class="ng-iconfont down"></em>
                </a>
                <div class="ng-sn-site-nav ng-d-box site-nav-child" style="display:none;">
                    <dl class="sn-site-list lnb">
                        <dt>
                            特色购物
                        </dt>
                        <dd>
                            <p><a  target="_blank">###</a></p>
                            <p><a target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            主题频道
                        </dt>
                        <dd>
                            <p><a  target="_blank">###</a></p>
                            <p><a   target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            生活助手
                        </dt>
                        <dd>
                            <p><a  target="_blank">###<i class="hot"></i></a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <dl class="sn-site-list">
                        <dt>
                            会员服务
                        </dt>
                        <dd>
                            <p><a  target="_blank">###<i class="hot"></i></a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                            <p><a  target="_blank">###</a></p>
                        </dd>
                    </dl>
                    <a href="" class="ng-close" ><em class="ng-iconfont"></em></a>
                </div>
            </div>

        </div>
        <div class="ng-toolbar-right">
            <a href="" class="ng-bar-node username-bar-node username-bar-node-showside" id="" rel="nofollow" style="display:none;">
                <span id="">吉米小子</span>
                <em class="hasmsg ng-iconfont"></em>
            </a>
            <div class="ng-bar-node-box username-handle" id="" style="display: block;">
                <a href="" rel="nofollow" class="ng-bar-node username-bar-node username-bar-node-noside">
                    <span id="">吉米小子</span>
                    <em class="hasmsg ng-iconfont"></em>
                    <em class="ng-iconfont down"></em>
                </a>
                <div class="ng-d-box ng-down-box ng-username-slide" style="display:none;">
                    <a href="" class="ng-vip-union" target="_blank" rel="nofollow">账号管理</a>
                    <a href="" rel="nofollow">退出登录</a>
                </div>
            </div>
            <div class="ng-bar-node reg-bar-node" id="reg-bar-node" style="display: none;">
                <a href=""  rel="nofollow" class="login">登录</a>
                <a href="" target="_blank" class="login reg-bbb" rel="nofollow" >注册</a>
            </div>

            <div class="ng-bar-node-box myorder-handle">
                <a class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>我的买啦</span><em class="ng-iconfont down"></em></a>
                <div class="ng-down-box ng-d-box myorder-child" style="display:none;">
                    <a >待支付<em id="waitPayCounts"></em></a>
                    <a >待收货<em id="waitDeliveryCounts"></em></a>
                    <a >待评价<em id="waitEvaluation"></em></a>
                    <a >修改订单</a>
                </div>
            </div>
            <a class="ng-bar-node ng-bar-node-mini-cart"  rel="nofollow" href="">
                <span><img src="${request.contextPath}/img/购物车.png" />&nbsp;购物车</span>
                <span class="total-num-bg-box">
						<em></em>
						<i></i>
					</span>
                </span>
            </a>
            <div class="ng-bar-node-box mysuning-handle">
                <a href="http://my.suning.com" rel="nofollow" name="" class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>收藏夹</span><em class="ng-iconfont down"></em></a>
                <div class="ng-down-box ng-d-box mysuning-child" style="display:none;">
                    <a href=""  rel="nofollow" target="_blank">###</a>
                    <a href="" rel="nofollow"  target="_blank">###</a>
                    <a href="" rel="nofollow" >###</a>
                    <a href="" rel="nofollow">###</a>
                    <a href="" rel="nofollow" >###</a>
                    <a href="" rel="nofollow" >###</a>
                    <a href="" class="ng-vip-union" target="_blank" rel="nofollow" >###<em class="ng-iconfont"></em></a>
                </div>
            </div>
            <div class="ng-bar-node-box app-down-box">
                <a href="" target="_blank"  rel="nofollow" class="ng-bar-node mb-suning touch-href">
                    <span>关注买啦</span>
                </a>
                <div class="ng-mb-box ng-d-box mb-down-child" style="display:none;">
                    <div class="ng-code-box">
                        <p class="ng-tip">
                            <a href="" rel="nofollow"  target="_blank"></a>
                        </p>
                        <a  target="_blank">
                            <img src=""  height="80" width="80">
                        </a>
                    </div>
                    <div class="ng-app-box">
                        <div class="ng-app-list">
                            <a href="" target="_blank" rel="nofollow" class="ng-app">
                                <img src="" title="###"></a>
                            <a href="" target="_blank" rel="nofollow"  class="ng-app">
                                <img src="" title="###"></a>
                            <a  class="ng-app">
                                <img src="" title="###"></a>
                            <a href="" target="_blank" rel="nofollow"  class="ng-app">
                                <img src="" title="###"></a>
                        </div>
                    </div>
                    <a href="" target="_blank" rel="nofollow" >
                        <img src="" height="35" width="242">
                    </a>
                    <a href=""  class="ng-close" rel="nofollow"><em class="ng-iconfont"></em></a>
                </div>
            </div>
            <a href="" class="ng-bar-node ng-bar-node-pr5"  target="_blank"><span>卖家中心</span><em class="ng-iconfont down"></em></a>
            <div class="ng-bar-node-box service-handle">
                <a href="" class="ng-bar-node ng-bar-node-service ng-bar-node-fix touch-href ng-bar-node-pr5" rel="nofollow" ><span>联系我们</span><em class="ng-iconfont down"></em>
                </a>
                <div class="ng-down-box ng-d-box service-center-child ng-ser-list" style="display:none;">
                    <a >帮助中心</a>
                    <a >查找门店</a>
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
            .titles{
                font-size: 12px;
                color: #333333;
                /*font-weight: bold;*/
            }
            h3 {
                margin: 0px 0;
                font-weight: bold;
                font-size: 14px;
                line-height: 18px;
                color: inherit;
                text-rendering: optimizelegibility;
            }
        </style>
        <div class="header-menu">
            <div class="ms-logo">
                <a class="ms-head-logo"  name="Myyigou_index_none_daohangLogo"><span style="font-size: 30px;color: #fff;font-weight: bold;    line-height: 28px;;">我的买啦</span></a>

            </div>
            <nav class="ms-nav">
                <ul>
                    <li class=""><a href="" data-url="" >首页</a><i class="nav-arrow"></i></li>
                    <li class="nav-manage selected">
                        <a href="" data-url="" >账户管理<em></em></a><i class="nav-arrow"></i>
                        <div class="list-nav-manage " hidden="">
                            <p class="nav-mge-hover">账户管理<em></em></p>
                            <p><a >个人资料</a></p>
                            <p><a >安全设置</a></p>
                            <p><a >账号绑定</a></p>
                            <p><a >地址管理</a></p>
                        </div>
                    </li>
                    <li class="ms-nav-msg"><a >消息</a><i class="nav-arrow"></i></li>
                </ul>
                <div class="ms-search">
                    <form >
                        <input id="" type="text" value="">
                        <a id="" href=""></a>
                    </form>
                </div>
            </nav>
        </div>

    </article>

    <article class="ms-useinfo">
        <div class="header-useinfo" id="">
            <div class="ms-avatar">
                <div class="useinfo-avatar">
                    <img src="${request.contextPath}/img/头像.png">
                    <div class="edit-avatar"></div>
                    <a class="text-edit-avatar" >修改</a>
                </div>
                <a >sunshine</a>
            </div>

            <div class="ms-name-info">
                <div class="link-myinfo">
                    <a >我的编号:99653</a>
                </div>
                <div class="info-member">
							<span class="name-member member-1">
        				 <i></i><a target="_blank" >注册会员</a></span>
                    <span style="margin-left: 20px;">
        				 <a target="_blank" >我的资料</a></span>
                </div>
                <div class="info-safety">
							<span class="safety-lv lv-3">
        				<a >安全等级：<span>中</span></a>
							</span>
                    <a class="bind-phone" >
                        <i style="background-image: url(${request.contextPath}/img/修改手机.png);"></i>修改手机</a>
                    <a class="bind-email" >
                        <i style="background-image: url(${request.contextPath}/img/绑定邮箱.png);"></i>修改邮箱</a>
                    <a  class="manage-addr" ><i style="background-image: url(../img/地址管理.png);"></i>地址管理</a>
                </div>
            </div>
        </div>

    </article>
</header>
<div id="yz-center" class="personal-member">
    <div class="cont">
        <div class="cont-side">
            <div class="yz-side-neck">
                <i></i>
            </div>
            <div class="ms-side">
                <article class="side-menu side-menu-off">
                    <dl class="side-menu-tree">
                        <dt><img src="${request.contextPath}/img/yz/user1.png" >账户管理</dt>
                        <dd><a ><span ></span>我的资料</a></dd>
                        <dd><a ><span></span>安全设置</a></dd>
                        <dd><a ><span></span>资金管理</a></dd>
                        <dd><a ><span ></span>地址管理</a></dd>
                        <dt><img src="${request.contextPath}/img/yz/shop.png" >店铺管理</dt>
                        <dd><a href="ProdoctAdd.html"><span ></span>发布商品</a></dd>
                        <dd><a href="ProdoctList.html"><span ></span>出售中的商品</a></dd>
                        <dd><a href="ProdoctStock.html"><span ></span>仓库中的商品</a></dd>
                        <dt><img src="${request.contextPath}/img/yz/projoct.png" >订单管理</dt>
                        <dd><a href="OrderList.html" style="color:#f70"><span class="active"></span>已卖出的商品</a>
                        <dd><a ><span ></span>发货</a></dd>
                        <dd><a ><span ></span>退款管理</a></dd></dd>
                    </dl>
                    <a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
                </article>
            </div>
        </div>

        <div class="yz-div-box">
            <dl >订单列表</dl>
            <div  style="margin-top: 5px">
                <from >
                    <div >
                        <div class="yz-input1">商品名称：<input type="text" name="proName"/></div>
                        <div class="yz-input2">下单时间：
                            <input type="date" name="createTime1">---<input type="date" name="createTime2">
                        </div>
                    </div>
                    <div >
                        <div class="yz-input1">买家名称：<input type="text" name="nickName"/></div>
                        <div class="yz-input2">订单编号：<input type="text" name="orderId"></div>
                    </div>
                    <div class="yz-bt"><input class="yz-input3" type="submit" value="搜索订单" ></div>
                </from>
            </div>

            <div class="yz-title" >
                <div class="yz-tab3" ><span class="yz-span1" style="color: #f88600;border-bottom:1px #f88600 solid"><a href="#">近三个月订单</a></span><span class="yz-span2"></span></div>
                <div class="yz-tab2"><span class="yz-span1"><a href="#">等待付款</a></span><span class="yz-span2"></span></div>
                <div class="yz-tab2"><span class="yz-span1"><a href="#">等待发货</a></span><span class="yz-span2"></span></div>
                <div class="yz-tab1" ><span class="yz-span1"><a href="#">已发货</a></span><span class="yz-span2"></span></div>
                <div class="yz-tab2"><span class="yz-span1"><a href="#">成功的订单</a></span><span class="yz-span2"></span></div>
                <div class="yz-tab4"><span class="yz-span1"><a href="#">三个月以前的订单</a></span></div>
            </div>

            <table class="yz-table-box">
                <thead>
                <table class="yz-table">
                    <tbody >
                    <tr class="list-table-tr1">
                        <td class="list-table-td1">商品名称</td>
                        <td  class="list-table-td2">单价</td>
                        <td class="list-table-td2">数量</td>
                        <td class="list-table-td2"></td>
                        <td class="list-table-td4">买家</td>
                        <td class="list-table-td5">交易状态</td>
                        <td class="list-table-td5">实收款</td>
                        <td class="list-table-td6">评价</td>
                    </tr>
                    </tbody>
                </table>
                </thead>
                <tbody>
                <td>
                    <div class="yz-table-td-div2">
                        <div class="yz-table-td-div">
                            <!--订单号 订单生成时间 -->订单号：1235734285743 创建时间：2019-01-01
                        </div>
                        <table >
                            <tbody class="list-table">
                            <td class="list-table-body-td1" style="text-align: left"><img src="${request.contextPath}/img/yz/user1.png"><a href="">商品名称</a></td>
                            <td ><input type="text" value="1500" class="list-table-body-td2" style="border:1px #FFFFFF;"></td>
                            <td><input type="text" value="1" class="list-table-body-td23" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td2"></td>
                            <td class="list-table-body-td3">mf</td>
                            <td class="list-table-body-td4" style="color: #f88600"><p></p>待发货<p>
                                <a href="" style="font-size: 10px">前往发货页面</a></td>
                            <td><input type="text" value="1200" class="list-table-body-td4" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td5">评价</td>
                            </tbody>
                        </table>
                    </div>
                </td>
                <td>
                    <div class="yz-table-td-div2">
                        <div class="yz-table-td-div">
                            订单号：1235734285743 创建时间：2019-01-01
                        </div>
                        <table >
                            <tbody class="list-table">
                            <td class="list-table-body-td1" style="text-align: left"><img src="${request.contextPath}/img/yz/user1.png"><a href="">商品名称</a></td>
                            <td><input type="text" value="1500" class="list-table-body-td2" style="border:1px #FFFFFF;"></td>
                            <td><input type="text" value="1" class="list-table-body-td23" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td2"></td>
                            <td class="list-table-body-td3">mf</td>
                            <td class="list-table-body-td4" style="color: #f88600"><p></p>待发货<p>
                                <a href="" style="font-size: 10px">前往发货页面</a></td>
                            <td><input type="text" value="1200" class="list-table-body-td4" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td5">评价</td>
                            </tbody>
                        </table>
                    </div>
                </td>
                <td>
                    <div class="yz-table-td-div2">
                        <div class="yz-table-td-div">
                            订单号：1235734285743 创建时间：2019-01-01
                        </div>
                        <table >
                            <tbody class="list-table">
                            <td class="list-table-body-td1" style="text-align: left"><img src="${request.contextPath}/img/yz/user1.png"><a href="">商品名称</a></td>
                            <td><input type="text" value="1500" class="list-table-body-td2" style="border:1px #FFFFFF;"></td>
                            <td><input type="text" value="1"  class="list-table-body-td23" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td2"></td>
                            <td class="list-table-body-td3">mf</td>
                            <td class="list-table-body-td4" style="color: #f88600"><p></p>待发货<p>
                                <a href="" style="font-size: 10px">前往发货页面</a></td>
                            <td><input type="text" value="1"  class="list-table-body-td4" style="border:1px #FFFFFF;"></td>
                            <td class="list-table-body-td5">评价</td>
                            </tbody>
                        </table>
                    </div>
                </td>
                </tbody>
            </table>

            <div id="page">
                <div class="yz-page">
                    <span class=""><a href="#">首页</a></span>
                    <span class=""><a href="#">当前页</a></span>
                    <span class=""><a href="#">上页</a></span>
                    <span class=""><a href="#">1</a></span>
                    <span class=""><a href="#">2</a></span>
                    <span class=""><a href="#">3</a></span>
                    <span class=""><a href="#">4</a></span>
                    <!--<span class="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.....</span>-->
                    <span class=""><a href="#">总页数</a></span>
                    <span class=""><a href="#">下页</a></span>
                    <span class=""><a href="#">末页</a></span>
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
        .sui-table td
        {
            font-size: 14px;
        }
        .sui-table td
        {
            font-size: 12px;
        }
        .ng-footer {
            height: 130px;
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
    <script type="text/javascript" src="js/safe/ms_common.min.js" ></script>
</body>

</html>