<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="../css/safe/css.css"/>
    <link rel="stylesheet" href="../css/safe/common.min.css"/>
    <link rel="stylesheet" href="../css/safe/ms-style.min.css"/>
    <link rel="stylesheet" href="../css/safe/personal_member.min.css"/>
    <link rel="stylesheet" href="../css/safe/Snaddress.min.css"/>
    <link rel="stylesheet" href="../css/sui.css"/>
    <link rel="stylesheet" href="../css/admin_index.css">
    <link rel="stylesheet" href="../css/我的订单标注.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../js/sui.js"></script>
    <script type="text/javascript">
        var shopName = "";
        var userName = "";
        var pageNo = "";
        var totalPage = "";
        $(function () {
            $("#search>span").toggle(
                    function () {
                        $("#condition").removeClass("con");
                        $(this).html("精简搜索条件");
                    },
                    function () {
                        $("#condition").addClass("con");
                        $(this).html("更多搜索条件");
                    }
            );
            //条件筛选
            $(".yz-input3").click(function () {
                var searchOrder = $("input:text,select,.date-search").serialize();
                pageNo = $("input:hidden[name=pageNo]").val();
                window.location.href=
                        "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder;
            });
            //分页
            $("#first_page").click(function(){
                //首页
                var searchOrder = $("input:text,select,.date-search").serialize();
                pageNo = parseInt($("#current").val());
                if(pageNo > 1){
                    pageNo = 1;
                    $("#current").val(pageNo);
                    window.location.href=
                            "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
                }
            })
            $("#pre_page").click(function(){
                //上一页
                var searchOrder = $("input:text,select,.date-search").serialize();
                pageNo = parseInt($("#current").val());
                if(pageNo > 1){
                    pageNo = pageNo-1;
                    $("#current").val(pageNo);
                    window.location.href=
                            "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
                }
            });
            $("#next_page").click(function(){
                //下一页
                var searchOrder = $("input:text,select,.date-search").serialize();
                pageNo = parseInt($("#current").val());
                totalPage = parseInt($("#totalPage").val());
                if(pageNo < totalPage){
                    pageNo = pageNo + 1;
                    $("#current").val(pageNo);
                    window.location.href=
                            "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
                }
            });
            $("#end_page").click(function(){
                //末页
                var searchOrder = $("input:text,select,.date-search").serialize();
                pageNo = parseInt($("#current").val());
                totalPage = parseInt($("#totalPage").val());
                if(totalPage > pageNo){
                    pageNo = totalPage;
                    $("#current").val(pageNo);
                    window.location.href=
                            "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
                }
            });
            //页码
            $(".fenye_test").click(function () {
                pageNo = $(this).children("a").html();
                var searchOrder = $("input:text,select,.date-search").serialize();
                window.location.href=
                        "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
            });
            //跳转
            $("#skip").click(function () {
                pageNo = $("#skip_num").val();
                var searchOrder = $("input:text,select,.date-search").serialize();
                window.location.href=
                        "${request.contextPath}/userManager/userOrder?searchOrder="+searchOrder+"&pageNo="+pageNo;
            })

        });

        function checkboxAllOnclick(checkbox) {
            if (checkbox.checked == true) {
                $("input:checkbox").attr("checked", true);
            } else {
                $("input:checkbox").attr("checked", false);
            }
        };
        //确认收货，单选
        function takeGoods(shopId) {
            doTakeGoods(shopId);
        }
        //批量收货
        function allTakeGoods() {
            var orderIds = new Array();//需要修改的订单ID
            var count = $(".center_main_test").length;
            for (var i=0;i<count;i++){
                if ($(".li_input:eq("+i+")").is(':checked')) {
                    var orderId = $(".li_input:eq("+i+")").next().val();
                    orderIds.push(orderId);
                }
            }
            if (orderIds.length>0){
                doTakeGoods(orderIds);
            }
        }
        //收货，改变状态
        function doTakeGoods(orderIds) {
            window.location.href = "${request.contextPath}/userManager/doTakeGoods?orderIds="+orderIds;
        }
    </script>
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
            <div class="side-neck"><i></i></div>
            <div class="ms-side">
                <article class="side-menu side-menu-off">
                    <dl class="side-menu-tree" style="padding-left: 50px;">
                        <dt><img src="../img/左侧/我的购物车.png" style="margin-right: 10px;margin-left: -20px;"/>我的购物车</dt>
                        <dt><img src="../img/左侧/file.png" style="margin-right: 10px;margin-left: -20px;"/>订单管理</dt>
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
                    <a ison="on" class="switch-side-menu icon-up-side"><i></i></a></article>
            </div>
        </div>
        <div class="cont-main">
            <div class="main-wrap mt15">
                <ul class="sui-nav nav-tabs">
                    <li style="margin-left: -5px;"><a style="width: auto;" href="#profile"
                                                      data-toggle="tab">所有订单${pageInfo.total}<span>|</span></a></li>
                    <li class="active"><a style="width: auto;" href="#profile" data-toggle="tab">待付款0<span>|</span></a></li>

                    <li class="active"><a style="width: auto;" href="#profile" data-toggle="tab">待发货${num1}
                        <span>|</span></a></li>
                    <li class="active"><a style="width: auto;" href="#profile" data-toggle="tab">待收货${num2}
                        <span>|</span></a></li>
                    <li class="active"><a style="width: auto;" href="#profile" data-toggle="tab">待评价${num3}
                        <span>|</span></a></li>
                </ul>
                <div class="profile-info">
                    <div class="control-group clearfix ">
                        <div>
                            <div><img src="../img/trash-拷贝.png"/> <span>订单回收站</span></div>
                        </div>
                    </div>
                </div>
                <form method="post" action="javascript:void(0)">
                    <div id="search">
                        <input type="text" name="like" placeholder="输入商品标题或者订单号进行搜索 "/>
                        <button class="yz-input3" type="button">订单搜索</button>
                        <span>更多搜索条件</span></div>
                    <div id="condition" class="con" style="margin-left: 30px;">
                        <div class="condition1">
                            <div><span>交易状态</span>
                                <select name="status">
                                    <option value="0">全部</option>
                                    <option value="1">待发货</option>
                                    <option value="2">已发货</option>
                                    <option value="3">已收货</option>
                                    <option value="4">交易成功</option>
                                    <option value="5">交易关闭</option>
                                </select>
                            </div>
                            <div><span>成交时间</span>
                                <input class="date-search" name="startDate" type="date" placeholder="请选择时间范围开始">
                                <input class="date-search" type="date" name="endDate" placeholder="请选择时间范围结束">
                            </div>
                        </div>
                        <div class="condition1">
                            <div><span>评价状态</span>
                                <select name="scoreStatus">
                                    <option value="0">全部</option>
                                    <option value="1">需我评价</option>
                                    <option value="2">我已评价</option>
                                    <option value="3">对方已评</option>
                                    <option value="4">双方已评</option>
                                </select>
                            </div>
                            <div><span>商店名称</span>
                                <input name="shopName" type="text" value="">
                            </div>
                        </div>
                    </div>
                </form>
                <div class="tab-content">
                    <div id="index" class="tab-pane "></div>
                    <div id="profile" class="tab-pane active">
                        <div><span style="color: #858585;margin-left: 160px;">宝贝</span> <span
                                style="color: #858585;margin-left: 190px;">单价(元)</span> <span
                                style="color: #858585;margin-left: 29px;">数量</span> <span
                                style="color: #858585;margin-left: 45px;">商品操作</span> <span
                                style="color: #858585;margin-left: 100px;">实付款(元)</span> <span
                                style="color: #858585;margin-left: 45px;">交易状态</span> <span
                                style="color: #858585;margin-left: 45px;">交易操作</span></div>
                        <div style="width: 100%;height: auto;padding: 10px;
                                       overflow:hidden;">
                            <input class="index_all" type="checkbox" onclick="checkboxAllOnclick(this)">
                            <span style="line-height: 20px;">全选</span>
                            <input type="button" onclick="allTakeGoods()" value="批量确认收货"
                                   style="padding: 2px;border: 1px #ccc solid;background-color: #fff;color: #666;margin-left: 20px;"/>
                            <div style="float: right;margin-right: 5px;">
                                <#if pageInfo.pageNum == 1>
                                    <span class="button-left fenye_changIn">上一页</span>
                                <#else >
                                    <span id="pre_page" class="button-left fenye_changIn">上一页</span>
                                </#if>
                                <#if pageInfo.pageNum == pageInfo.pages>
                                    <span class="button-left fenye_changIn">下一页</span>
                                <#else >
                                    <span id="next_page" class="button-left fenye_changIn">下一页</span>
                                </#if>
                            </div>
                        </div>
                    </div>

                    <div class="center_main">
						<#list pageInfo.list>
                            <ul>
								<#items as order>
                                    <li class="center_main_test" style="border:1px solid #ccc; margin-top:20px;">
                                        <div class="center_two">

                                            <ul style=" overflow:hidden">
                                                <div style="margin-top: 20px;width: 100%;height: 150px;">
                                                    <div style="width: 100%;height: 50px;background-color: #eaf9ff;vertical-align: middle;font-size: 12px;">
                                                        <input type="checkbox" <#if order.status==1>disabled="disabled"</#if> class="li_input" style="line-height: 50px;margin-left: 20px;"/>
                                                        <input type="hidden" value="${order.orderId}" name="orderId">
                                                        <span style="line-height: 50px;">订单日期：${order.createTime?string("yyyy-MM-dd")}</span>
                                                        <span style="line-height: 50px;margin-left: 20px;">订单号：${order.orderNum}</span>
                                                        <span style="margin-left: 80px;">${order.orderDetails[0].shop.shopName}</span>
                                                    </div>
                                                    <div style="width: 100%;line-height: 30px;background-color: #eaf9ff;vertical-align: middle;font-size: 12px;border: 1px #ccc solid">
                                                        <span style="display:inline-block;line-height: 30px;text-align:center;width: 36%;">宝贝</span>
                                                        <span style="display:inline-block;text-align:center;width: 8%;">单价</span>
                                                        <span style="display:inline-block;text-align:center;width: 5%;">数量</span>
                                                        <span style="display:inline-block;text-align:center;width: 15%;">商品操作</span>
                                                        <span style="display:inline-block;text-align:center;width: 8%;">实付款</span>
                                                        <span style="display:inline-block;text-align:center;width: 12%;">交易状态</span>
                                                        <span style="display:inline-block;text-align:center;width: 13%;">交易操作</span>
                                                    </div>
                                                    <div class="test" style="width: 34%; float:right;">
                                                        <div style="float: left;width: 20%;height:auto;text-align: center;">
                                                            <span style="font-weight: bold;margin-top: 30px;display: block;">${order.cost}</span>
                                                            <dl>
                                                                (含运费:00)
                                                            </dl>
                                                        </div>
                                                        <div style="float: left;width: 40%;height:auto;text-align: center ;">
                                                            <dl style="margin-top: 30px;">
																<#if order.status == 1>待发货</#if>
                                                                <#if order.status == 2>已发货</#if>
                                                                <#if order.status == 3>已收货</#if>
                                                                <#if order.status == 4>已完成</#if>
                                                                <#if order.status == 5>订单已关闭</#if>
                                                            </dl>
                                                            <dl>
                                                                订单详情
                                                            </dl>
                                                            <dl>
                                                                查看物流
                                                            </dl>
                                                        </div>
                                                        <div style="float: left;width:39%;height:auto;text-align: center ;">
                                                            <#if order.status==1>
																<span style="color:#333;line-height: 100px;">
																	待发货
																</span>
                                                            </#if>
															<#if order.status==2>
                                                            <dl style="margin-top: 30px;">
                                                                还有9天10时4分
                                                            </dl>
                                                            <button onclick="takeGoods(${order.orderId})" style="color:#fff;background-color: #65b5ff;border: 0px;padding: 4px;margin-top: 5px;margin-top: 5px;">
                                                                确认收货
                                                            </button>
                                                            </#if>
															<#if order.status &gt;=3>
																<span style="color:#333;line-height: 100px;overflow: hidden;">
																	<a href="${request.contextPath}/userManager/reviews?orderId=${order.orderId}"
                                                                       style="display: inline-block;width: 60px;height: 30px;color: #0a628f;clear: both;">评价</a>
																</span>
                                                            </#if>
                                                        </div>
                                                    </div>
													<#list order.orderDetails as orderDetail>
														<li class="center_test"
                                                            style=" float: left;width: 65%;height:auto; overflow:hidden; float:left; border-bottom:1px solid #ccc; border-right:#ccc solid 1px;">
                                                            <div style="float: left;width:100%;">
                                                                <div style="width: 100%;">
                                                                    <img src="${request.contextPath}/${orderDetail.product.proUrl}"
                                                                         style="height: 100px;float: left;"/>
                                                                    <dl style="width: 220px;float: left;margin-left: 20px;margin-top: 20px;">${orderDetail.product.proName}</dl>
                                                                    <#if orderDetail.product.isPrice==1>
                                                                    	<del style="display: inline-block;margin-left: -30px;margin-top: 20px;color: #858585;">${orderDetail.product.proPrice}</del>
																		<dl style="float: left;margin-left: 50px;margin-top: 42px;">${orderDetail.product.newPrice}</dl>
                                                                    </#if>
																	<#if orderDetail.product.isPrice==0>
																		<dl style="float: left;margin-left: 50px;margin-top: 42px;">${orderDetail.product.proPrice}</dl>
                                                                    </#if>
                                                                    <span style="display: inline-block;margin-top: 25px;margin-left: 40px;">${orderDetail.count}</span>
                                                                    <dl style="float: right;margin-right: 50px;margin-top: 20px;">
                                                                        退款/退货
                                                                        <br/>投诉卖家
                                                                        <br>
                                                                        退运保险
                                                                    </dl>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </#list>
                                            </ul>
                                        </div>
                                    </li>
                                </#items>
                            </ul>
                        </#list>
                    </div>

                    <div style="width: 100%;height: 0px;padding: 10px;overflow:hidden; height:auto; margin:auto">
                        <input class="index_all" type="checkbox" onclick="checkboxAllOnclick(this)">
                        <span style="line-height: 20px;">全选</span>
                        <input type="button" onclick="allTakeGoods()" value="批量确认收货"
                               style="padding: 2px;border: 1px #ccc solid;background-color: #fff;color: #333;margin-left: 20px;"/>
                    </div>
                    <p style="text-align:right;margin-top: 10px;width: 100%;">
                    <#--保存当前页-->
                        <input type="hidden" name="pageNo" value="${pageInfo.pageNum}" id="current"/>
                        <input type="hidden" value="${pageInfo.pages}" id="totalPage"/>
                        <#if pageInfo.pageNum == 1>
                            <span class="fenye_changIn"><</span>
                        <#else >
                            <span id="first_page" class="fenye_changIn"><a href="javascript:void(0)"><</a></span>
                        </#if>
                        <#list numbs>
                            <#items as numb>
                                 <span class="fenye_test"><a href="javascript:void(0)">${numb}</a></span>
                            </#items>
                        </#list>
                         <#if pageInfo.pageNum == pageInfo.pages>
                            <span class="fenye_changOut">></span>
                         <#else >
                            <span id="end_page" class="fenye_changOut"><a href="javascript:void(0)">></a></span>
                         </#if>
                         共${pageInfo.pages}页，到
                         <input type="text" id="skip_num" value="${pageInfo.pageNum}" style="width: 20px;margin-left: 10px;margin-right: 10px;"/>
                         页
                        <button id="skip" style="background-color: #f95555;padding: 3px;border: 0px;color: #fff;margin-left: 10px;width: 50px;border-radius:4px;">
                            确认
                        </button>
                    </p>
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
<script type="text/javascript" src="js/safe/ms_common.min.js"></script>
</body>
</html>