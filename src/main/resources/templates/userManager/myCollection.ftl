<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="../js/safe/aywmq_qt.js"></script>
    <script type="text/javascript" src="../js/safe/da_opt.js"></script>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="../css/safe/css.css"/>
    <link rel="stylesheet" href="../css/safe/common.min.css"/>
    <link rel="stylesheet" href="../css/safe/ms-style.min.css"/>
    <link rel="stylesheet" href="../css/safe/personal_member.min.css"/>
    <link rel="stylesheet" href="../css/safe/Snaddress.min.css"/>
    <link rel="stylesheet" href="../css/admin_index.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.js" ></script>
    <script type="text/javascript">
        $(function () {
            //批量删除
            $(".all_delete").click(function () {
                var ck = $(".productCollect:checked[name='productCollect']");
                if(ck.length == 0){
                    alert("请选择,然后进行删除");
                    return;
                }
                var allDel=confirm("确认删除!!");
                if(!allDel){
                    return;
                }
                /*  $(".li_input").each(function (index,element) {
                      if (element.checked){
                          $(element).parents("li").remove();
                      }
                  });*/
                del();
            });
            //宝贝搜索
            $("#searchProduct").blur(function () {
                var proName = $(this).val();
                window.location.href="${request.contextPath}/userManager/myCollection?proName="+proName;
            })
        })
        //全部选中
        function checkboxAllOnclick(checkbox){
            if ( checkbox.checked == true){
                $("input:checkbox").attr("checked",true);
            }else{
                $("input:checkbox").attr("checked",false);
            }
        }
        //删除
        function del() {
            var productCollectIds = new Array();//需要删除的ID
            var cks = $(".productCollect:checked[name='productCollect']").length;
            for (var i=0;i<cks;i++){
                if ($(".productCollect:checked[name='productCollect']:eq("+i+")").is(':checked')) {
                    var id = $(".productCollect:checked[name='productCollect']:eq("+i+")").next().val();
                    productCollectIds.push(id);
                }
            }
            if (productCollectIds.length>0){
                window.location.href = "${request.contextPath}/userManager/deleteProductCollect?productCollectIds="+productCollectIds;
            }
        }

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
            <div class="ms-side" style="margin-top: 20px; float:left">
                <article class="side-menu side-menu-off">
                    <dl class="side-menu-tree" style="padding-left: 50px; ">
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
                    <a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
                </article>
            </div>
        </div>
        <div class="cont-main" style="width: 1000px; margin-left:200px">
            <div style="margin-top: 20px;width: 940px;">
                <font style="font-size: 16px;color: #F88600;font-weight: bold; margin-left:30px;">全部宝贝${productCollectList?size}</font>
                <font style="font-size: 16px;color: #333333; font-weight:bold;margin-left:61px;">降价${isPrice}</font>
                <font style="font-size: 16px;color: #333333; font-weight:bold;margin-left:40px;">失效${isDelete}</font>
                <div style="display:inline-block;line-height:30px;position: relative;left: 190px;top: 32px;">
                    <input onclick="checkboxAllOnclick(this)" type="checkbox" style="display:inline-block;vertical-align: middle;margin-right: 5px;"><span>全选</span>
                    <img src="../img/垃圾桶图标.png" class="all_delete" style="margin-left: 20px;margin-right: 5px;display:inline-block;vertical-align: middle;"><span class="all_delete">删除</span>
                </div>
                <input type="button" value="批量管理"
                       style=" color:#333333;height:34px;width:80px;background:#ffffff;border-color:#EDEDED;border-style:solid;margin-left:630px;"></input>
                <div style="float: right; display: block;">
                    <input id="searchProduct" type="text" name="proName" value="<#if proName??>${proName}</#if>" placeholder="宝贝搜索"
                           style=" float: right;color:#333333;height:auto;margin-left: 10px;float: left;padding: 5px;">
                </div>
            </div>

            <div style="margin-top: 10px; overflow:hidden;height: auto;width: 1000px; border:1px solid #EDEDED">
                <#list productCollectList as productCollect>
                    <div style="float: left;padding: 10px;margin-left: 10px;">
                        <input class="productCollect" type="checkbox" name="productCollect">
                        <input type="hidden" value="${productCollect.productCollectId}">
                        <img src="${request.contextPath}/${productCollect.product.proUrl}" style="height:150px;width: 150px;"/>
                        <br/>
                        <span style="color: #686868;">${productCollect.product.proName}</span>
                        <br/>
                        <#if productCollect.product.isDelete == 1>
                            <span style="color: #686868;margin-top: 23px;display:block;">
							<img src="../img/tennis-ball.png"
                                 style="margin-bottom: -2px; height:12px;width:12px;margin-left:30px ;"/>
							<font style="font-size: 12px;color: #505050;font-weight: bold; margin-left: 5px;">宝贝失效了</font>
							</span>
                        <#else >
                            <#if productCollect.product.isPrice == 1>
                                <span style="color: #686868;margin-top: 23px;display:block;">
							<img src="../img/组-42.png"
                                 style="margin-bottom: -2px; height:15px;width:15px;margin-left:30px ;"/>
							<font style="font-size:14px;color:#fb3201; font-weight: bold;">￥${productCollect.product.newPrice}</font>
							<font style="font-size:14px;color:#686868;TEXT-DECORATION: line-through;margin-left: 2px; ">￥${productCollect.product.proPrice}</font></span>
                            <#else >
                            <span style="color: #686868;margin-top: 23px;display:block;margin-left: 50px;">
								<font style="font-size:14px;color:#fb3201; font-weight: bold;">￥${productCollect.product.proPrice}</font></span>
                            </#if>
                        </#if>
                    </div>
                </#list>
            </div>
            <hr style=" border-style:solid;width: 1000px;border-color:#D3D3D3;"></hr>
            <div style="margin-top: 20px;width: 1000px;">
                <font style="font-size: 16px;color: #565656; margin-left:30px;">热卖单品</font>
                <hr style=" border-style:solid;width:1000px;border-color:#D3D3D3;margin-top: 20px;"></hr>
                <#list pageInfo.list as product>
                    <div style="float: left;margin-top: 20px;margin-left:10px;text-align: center; ">
                        <img src="${request.contextPath}/${product.proUrl}" style="width: 223px;height: 223"/>
                        <br/>

                        <span><font style="color: #F2873B;font-size: 16px; font-weight: bold;">￥
                        <#if product.isPrice == 1>
                            ${product.newPrice}
                        <#else >
                            ${product.proPrice}
                        </#if></font></span>
                        <span style="background-color: #F37B1D;margin-left: 100px;padding-left: 2px;padding-right: 2px;"><font
                                style="color: #F0F0F0;font-size: 12px; font-weight: bold;">包邮</font></span>
                        <br/>
                        <span style="color: #565656;">${product.proName}</span>
                        <br/>
                        <#--<span style="display:inline;margin-top: 5px;"><font
                                style="color: #686868;font-size: 12px; ">销量:996</font></span>-->
                        <span style="display:inline ;background-color: #00DB00;margin-left: 100px;padding-left: 2px;padding-right: 2px;"><font
                                style="color: #F0F0F0;font-size: 12px; font-weight: bold;">新品上市</font></span>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</div>
</div>
<div class="clear "></div>
<div class="ng-footer ">

			<textarea class="footer-dom " id="footer-dom-02 ">
			</textarea>
    <div class="ng-fix-bar "></div>
</div>
<style type="text/css ">
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
<script type="text/javascript " src="js/safe/ms_common.min.js "></script>
</body>

</html>