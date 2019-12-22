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
		<link rel="stylesheet" href="../css/safe/ms-style.min.css" />
		<link rel="stylesheet" href="../css/safe/personal_member.min.css" />
		<link rel="stylesheet" href="../css/safe/Snaddress.min.css" />
		<script type="text/javascript" src="../js/sui.js" ></script>
		<script type="text/javascript">
			$(function () {
				$("#provinceId").change(function () {
					var provinceCode = $("#provinceId").val();
					$.get("${request.contextPath}/getCity?provinceCode="+provinceCode,function (data) {
						$("#cityId option").remove();
						$("#areaId option").remove();
						for (var i=0;i<data.length;i++){
						    $("#cityId").append("<option value='"+data[i].cityCode+"'>"+data[i].city+"</option>");
						}
                        for (var j=0;j<data[0].areases.length;j++){
                            $("#areaId").append("<option value='"+data[0].areases[j].areaCode+"'>"+data[0].areases[j].area+"</option>");
                        }
                    })
                })
                $("#cityId").change(function () {
                    var cityCode = $("#cityId").val();
                    $.get("${request.contextPath}/getAreas?cityCode="+cityCode,function (data) {
                        $("#areaId option").remove();
                        for (var i=0;i<data.length;i++){
                            $("#areaId").append("<option value='"+data[i].areaCode+"'>"+data[i].area+"</option>");
                        }
                    })
                })
            });
            //获取验证码
            function getVerify(obj){
                $("#veryCode").attr("src",httpurl + "${request.contextPath}/getVerify?"+Math.random());
                /*obj.src = httpurl + "/tiantian/getVerify?"+Math.random();*/
            }
		</script>
	</head>
	<body class="ms-body">
	<#import "../public.ftl" as public>
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
        				 <a href="${request.contextPath}/adminManager/userInfo" >我的资料</a></span>
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
					<div class="side-neck">
						<i></i>
					</div>
					<div class="ms-side">
                        <article class="side-menu side-menu-off">
                            <dl class="side-menu-tree">
                                <dt><img src="${request.contextPath}/img/yz/user1.png" >账户管理</dt>
                                <dd><a href="${request.contextPath}/adminManager/userInfo" style="color:#f70"><span ></span>我的资料</a></dd>
                                <dd><a ><span></span>安全设置</a></dd>
                                <dd><a ><span></span>资金管理</a></dd>
                                <dd><a ><span ></span>地址管理</a></dd>
                                <dt><img src="${request.contextPath}/img/yz/shop.png" >店铺管理</dt>
                                <dd><a href="${request.contextPath}/adminManager/productAdd"><span ></span>发布商品</a></dd>
                                <dd><a href="${request.contextPath}/adminManager/productStock"><span ></span>出售中的商品</a></dd>
                                <dd><a href="${request.contextPath}/adminManager/productList"><span ></span>仓库中的商品</a></dd>
                                <dt><img src="${request.contextPath}/img/yz/projoct.png" >订单管理</dt>
                                <dd><a href="${request.contextPath}/adminManager/orderList" ><span></span>已卖出的商品</a>
                                <dd><a ><span ></span>发货</a></dd>
                                <dd><a ><span ></span>退款管理</a></dd></dd>
                            </dl>
                            <a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
                        </article>
					</div>
				</div>
				<div class="cont-main">
					<div class="main-wrap mt15">

						<div class="main-wrap-main">
							<h3>
								<strong>个人信息</strong>
							</h3>
							<form method="post" name="user" action="${request.contextPath}/userManager/userModify" enctype="multipart/form-data">
								<!--<div class="main-wrap-info"><a href="#"> <span>基本资料</span></a><a href="#"><span>头像照片</span></a></div>-->
								<div class="user-profile clearfix">
									<div class="user-profile-wrap">
										<p>当前头像：</p>
										<div class="profile-avatar">
										<img src="<#if user.userUrl??>${request.contextPath}/${user.userUrl}</#if>" height="120" width="120">
										<a href="${request.contextPath}/adminManager/userInfoImg" name="">编辑头像</a>
										<div class="edit_bg"></div>
									</div>
									</div>
									<#--<div class="modify-file">
										<p>仅支持JPG、GIF、PNG图片文件，且文件小于5M</p>
										<input type="file" name="filename" />
									</div>-->
								</div>

								<div class="form-list tab-switch personal-wrap-show">
									<div class="control-group clearfix">
										<label class="control-label"><em>*&nbsp;</em>用户名：</label>
										<div class="controls">
											<input type="hidden" value="${user.userId}" name="userId">
											<input  type="text" class="text" maxlength="12" name="userName" value="${user.userName}">
										</div>
									</div>
									<div class="control-group clearfix">
										<label class="control-label"><em>*&nbsp;</em>真实姓名：</label>
										<div class="controls">
											<input  type="text" class="text" maxlength="12" name="realName" value="${user.realName}">
										</div>
									</div>
									<div class="control-group clearfix">
										<label class="control-label"><em>*&nbsp;</em>性别：</label>
										<div id="gender" class="controls">
											<label class="sex-label">
												<input type="radio" value="1" name="sex" <#if user.sex==1>checked="checked"</#if>>
												<span>男</span>
											</label>
											<label class="sex-label">
												<input type="radio" value="2" name="sex" <#if user.sex==2>checked="checked"</#if>>
												<span>女</span>
											</label>
										</div>
									</div>
									<div class="control-group clearfix">
										<label class="control-label">手机：</label>
										<div class="controls lh26">
											<#--<span>${public.transPhone(user.phone)}</span>
											<a >修改</a>-->
											<input  type="text" class="text" maxlength="11" name="phone" value="${user.phone}">
										</div>
									</div>
									<div class="control-group clearfix">
										<label class="control-label">邮箱：</label>
										<div class="controls lh26">
											<#--<span>31***9@qq.com</span>
											<a >修改</a>-->
											<input  type="text" class="text" name="email" value="<#if user.email??>${user.email }</#if>">
										</div>
									</div>
									<div class="control-group clearfix">
										<label class="control-label">出生日期：</label>
										<div class="controls">
											<span id="" class="dateSelector">
											<input  value="<#if user.birthday??>${user.birthday?string("yyyy-MM-dd")}</#if>" type="date" class="text date-color" name="birthday" >
											<i class="date-icons"></i>
											</span>
										</div>
									</div>
									<div class="control-group clearfix priority-high">
										<label class="control-label"><em>*&nbsp;</em>居住地址：</label>
										<div class="controls">
											<div id="zhen" datas-id="" class="citySelect cityboxbtn">
												<select id="provinceId">
													<#list addressList as pro>
														<option value="${pro.provinceCode}" <#if areas?? && pro.provinceId == areas.cities.provinces.provinceId> selected = "selected"</#if>>
															${pro.province}
														</option>
													</#list>
												</select>
												<select id="cityId">
													<#list addressList as pro>
														<#if  areas?? && pro.provinceId == areas.cities.provinces.provinceId>
															<#list pro.citieses as cities>
																<option value="${cities.cityCode}" <#if cities.cityId == areas.cities.cityId> selected = "selected"</#if>>
																	${cities.city}
																</option>
															</#list>
														</#if>
													</#list>
												</select>
												<select id="areaId" name="areaId">
													<#list addressList as pro>
														<#if  areas?? && pro.provinceId == areas.cities.provinces.provinceId>
															<#list pro.citieses as cities>
																<#if cities.cityId == areas.cities.cityId>
																	<#list cities.areases as area>
																		<option value="${area.areaId}" <#if area.areaId == areas.areaId> selected = "selected"</#if>>
																			${area.area}
																		</option>
																	</#list>
																</#if>
															</#list>
														</#if>
													</#list>
												</select>
											<div id="" class="error-place ml0">
											</div>
										</div>
									</div>

									<div id="code" class="control-group clearfix" >
										<#--<input id="" type="hidden" autocomplete="off" >
										<label class="control-label"><em>*&nbsp;&nbsp;&nbsp;</em>验证码：</label>
										<div class="controls">
											<input id="" type="text" class="text" maxlength="4" autocomplete="off" name="" style="width:150px" value="">
											<span class="tips-words"></span>
											<img id="veryCode" src="${request.contextPath}/getVerify" width="62" height="24" class="authCode">
											<span class="changeAuthCode" style="margin-bottom: 15px;"><a href="" style="margin-bottom: -10px;position: absolute;" onclick="getVerify(this);">换一张</a></span>
										</div>
										<div id="" class="error-place">
										</div>-->
									</div>
									<div class="control-group clearfix priority-low">
										<label class="control-label">&nbsp;</label>
										<div style="float:left;">
											<input class="ms-stand-btn1" type="submit" value="保 存">
										</div>
										<div id="" class="error-place"></div>
										<div class="error-place mt29"></div>
									</div>
								</div>
                            </form>
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