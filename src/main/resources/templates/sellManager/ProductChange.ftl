<html>
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#pcId1").change(function () {
            var id1=$(this).val();
            $("#pcId2").empty();
            var option1=' <option value="0">未选择</option>';
            $("#pcId2").append(option1);
            $("#pcId3").empty();
            var option1=' <option value="0">未选择</option>'
            $("#pcId3").append(option1)
            $.ajax({
                type:'post',
                url:"pcId",
                data:{ pdd:id1},
                dataType:false,
                success:function(pcId2){
                    $.each(pcId2,function (key, id) {
                        var option='<option value="'+id.pcId+'">'+id.pcName+'</option>'
                        $("#pcId2").append(option)
                    })
                }
            })
        })
        $("#pcId2").change(function () {
            var id2=$(this).val();
            $("#pcId3").empty();
            var option1=' <option value="0">未选择</option>'
            $("#pcId3").append(option1)
            $.ajax({
                type:'post',
                url:"pcId",
                data:{ pdd:id2},
                dataType:false,
                success:function(pcId3){
                    $.each(pcId3,function (key, id3) {
                        var option='<option value="'+id3.pcId+'">'+id3.pcName+'</option>'
                        $("#pcId3").append(option)
                    })
                }
            })
        })
    })

</script>
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
                <span><img src="img/Home.png" style="margin-right: 10px;"/>返回买啦首页</span>
            </a>
            <div class="ng-bar-node-box ng-site-nav-box">
                <a href="" class="ng-bar-node ng-bar-node-site" >
                    <span><img src="img/daohang.png" style="margin-right: 5px;" />网站导航</span><em class="ng-iconfont down"></em>
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
                <span><img src="img/购物车.png" />&nbsp;购物车</span>
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
                    <img src="img/头像.png">
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
                        <i style="background-image: url(img/修改手机.png);"></i>修改手机</a>
                    <a class="bind-email" >
                        <i style="background-image: url(img/绑定邮箱.png);"></i>修改邮箱</a>
                    <a  class="manage-addr" ><i style="background-image: url(img/地址管理.png);"></i>地址管理</a>
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
                        <dt><img src="../static/img/yz/user1.png" >账户管理</dt>
                        <dd><a ><span ></span>我的资料</a></dd>
                        <dd><a ><span></span>安全设置</a></dd>
                        <dd><a ><span></span>资金管理</a></dd>
                        <dd><a ><span ></span>地址管理</a></dd>
                        <dt><img src="../static/img/yz/shop.png" >店铺管理</dt>
                        <dd><a href="${request.contextPath}/sellManager/SellAdd"  style="color:#f70"><span ></span>发布商品</a></dd>
                        <dd><a href="${request.contextPath}/sellManager/SellProductController"><span ></span>出售中的商品</a></dd>
                        <dd><a href="ProdoctStock.html"><span ></span>仓库中的商品</a></dd>
                        <dt><img src="../static/img/yz/projoct.png" >订单管理</dt>
                        <dd><a href="${request.contextPath}/sellManager/SellOrder"><span class="active"></span>已卖出的商品</a>
                        <dd><a ><span ></span>发货</a></dd>
                        <dd><a ><span ></span>退款管理</a></dd></dd>
                    </dl>
                    <a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
                </article>
            </div>
        </div>

        <div style="margin-top: 30px;width: 1068px; margin: 15px 0 30px 170px;">
            <dl style="color: #F88600;font-size: 16px;margin-top: 69px;">修改商品</dl>
            <form  class="manage" method="post" action="${request.contextPath}/sellManager/ProChange">
                <table class="form">
                        <input style="display: none" type="text" class="text" name="proId" value="${Product.proId}"/>

                    <tr>
                        <td class="field">商品名称：</td>
                        <td><input type="text" class="text" name="proName" value="${Product.proName}"/></td>
                    </tr>
                    <#if Product.productCategory.typeId=1>
                    <tr>
                        <td class="field">所属大类：</td>
                        <td>
                            <select id="pcId1" name="pcId1">
                                    <#list CateList>
                                        <#items as cate>
                                        <option value=${cate.pcId}
                                            <#if cate.pcId=Product.productCategory.pcId>selected = "selected"</#if>
                                            >${cate.pcName}</option>
                                        </#items>
                                    </#list>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属二级分类：</td>
                        <td>
                            <select id="pcId2" name="pcId2">
                                <option value="0">未选择</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属三级分类：</td>
                        <td>
                            <select id="pcId3" name="pcId3">
                                <option value="0">未选择</option>
                            </select>
                        </td>
                    </tr>
                    </#if>

                    <#if Product.productCategory.typeId=2>
                    <tr>
                        <td class="field">所属大类：</td>
                        <td>
                            <select id="pcId1" name="pcId1">
                                    <#list CateList>
                                        <#items as cate>
                                        <option value=${cate.pcId}
                                            <#if cate.pcId=Product.productCategory.parentId>selected = "selected"</#if>
                                            >${cate.pcName}</option>
                                        </#items>
                                    </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属二级分类：</td>
                        <td>
                            <select id="pcId2" name="pcId2">
                                <option value="0">未选择</option>
                                 <#list CateList>
                                     <#items as cate>
                                        <#list cate.productCategorys>
                                            <#items  as cate2>
                                                <#if cate2.parentId=Product.productCategory.parentId>
                                        <option value=${cate2.pcId}
                                         <#if cate2.pcId=Product.productCategory.pcId>selected = "selected"</#if>
                                            >${cate2.pcName}</option>
                                                </#if>
                                            </#items>
                                        </#list>
                                     </#items>
                                 </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属三级分类：</td>
                        <td>
                            <select id="pcId3" name="pcId3">
                                <option value="0">未选择</option>
                            </select>
                        </td>
                    </tr>
                    </#if>

                    <#if Product.productCategory.typeId=3>
                    <tr>
                        <td class="field">所属大类：</td>
                        <td>
                            <select id="pcId1" name="pcId1">
                                    <#list CateList>
                                        <#items as cate>
                                        <option value=${cate.pcId}
                                            <#if cate.pcId=Category>selected = "selected"</#if>
                                            >${cate.pcName}</option>
                                        </#items>
                                    </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属二级分类：</td>
                        <td>
                            <select id="pcId2" name="pcId2">
                                <option value="0">未选择</option>
                                 <#list CateList>
                                     <#items as cate>
                                         <#list cate.productCategorys>
                                             <#items  as cate2>
                                                 <#if cate2.parentId=Category>
                                        <option value=${cate2.pcId}
                                                 <#if cate2.pcId=Product.productCategory.parentId>selected = "selected"</#if>
                                            >${cate2.pcName}</option>
                                                 </#if>
                                             </#items>
                                         </#list>
                                     </#items>
                                 </#list>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">所属三级分类：</td>
                        <td>
                            <select id="pcId3" name="pcId3">
                                <option value="0">未选择</option>
                                <#list CateList>
                                    <#items as cate>
                                        <#list cate.productCategorys>
                                            <#items  as cate2>
                                                <#list  cate2.productCategorys>
                                                    <#items  as cate3>
                                                        <#if cate3.parentId=Product.productCategory.parentId>
                                        <option value=${cate3.pcId}
                                                <#if cate3.pcId=Product.productCategory.parentId>selected = "selected"</#if>
                                            >${cate3.pcName}</option>
                                                        </#if>
                                                    </#items>
                                                </#list>
                                            </#items>
                                        </#list>
                                    </#items>
                                </#list>
                            </select>
                        </td>
                    </tr>
                    </#if>

                    <tr>
                        <td class="field">商品价格：</td>
                        <td style="font-size: 12px"><input type="text" class="text tiny" name="proPrice" value="${Product.proPrice}"/> 元</td>
                    </tr>
                    <tr>
                        <td class="field">优惠价：</td>
                        <td  style="font-size: 12px"><input type="text" class="text tiny" name="newPrice" value="${Product.newPrice}"/> 元</td>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">库存：</td>
                        <td><input type="text" class="text tiny" name="stock" value="${Product.stock}"/> 件</td>
                    </tr>
                    <tr>
                        <td class="field">描述：</td>
                        <td>
                           <textarea cols="50" rows="10" name="description" value="${Product.description}">
                           </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="submit" value="修改"/></label></td>
                    </tr>
                </table>
            </form>
            <form>
                <tr>
                    <td class="field">商品缩略图：</td>
                    <td style="font-size: 12px"><input type="file" class="text" name="file"/></td>
                </tr>
                <tr>
                    <td class="field">商品展示图：</td>
                    <td style="font-size: 12px"><input type="file" class="text" name="file1"/></td>
                </tr>
                <tr>
                    <td class="field">商品展示图：</td>
                    <td style="font-size: 12px"><input type="file" class="text" name="file1"/></td>
                </tr>
            </form>
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