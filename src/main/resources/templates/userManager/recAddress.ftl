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
		<link rel="stylesheet" href="../css/zpwd/sui.css" />
        <link rel="stylesheet" href="../css/admin_index.css">
        <link rel="stylesheet" href="../css/收货地址.css"/>
		<script type="text/javascript" src="../js/sui.js" ></script>
        <script type="text/javascript">
            $(function () {
                $("#provinceId").change(function () {
                    var provinceCode = $("#provinceId").val();
                    $.get("${request.contextPath}/getCity?provinceCode="+provinceCode,function (data) {
                        $("#cityId option").remove();
                        $("#areaId option").remove();
                        $("#cityId").append('<option value="">请选择市</option>');
                        for (var i=0;i<data.length;i++){
                            $("#cityId").append("<option value='"+data[i].cityCode+"'>"+data[i].city+"</option>");
                        }
                        $("#areaId").append('<option value="">请选择区</option>');
                        /* for (var j=0;j<data[0].areases.length;j++){
                            $("#areaId").append("<option value='"+data[0].areases[j].areaCode+"'>"+data[0].areases[j].area+"</option>");
                        }*/
                    })
                })
                $("#cityId").change(function () {
                    var cityCode = $("#cityId").val();
                    $.get("${request.contextPath}/getAreas?cityCode="+cityCode,function (data) {
                        $("#areaId option").remove();
                        $("#areaId").append('<option value="">请选择区</option>');
                        for (var i=0;i<data.length;i++){
                            $("#areaId").append("<option value='"+data[i].areaId+"'>"+data[i].area+"</option>");
                        }
                    })
                })
                //提交表单。添加
                $("#addRecAddress").click(function () {
                    var recAddress_tr = $(".recAddress_tr");
                    if (recAddress_tr.length<15){
                        $("#message1").hide();
                        var recAddressAdd = $("input:text,select,textarea").serialize();
                        var areaId = $("#areaId").val();
                        var flag = $("input:checkbox").is(":checked");
                        var isDefault = "";
                        if (flag) {
                            isDefault = 1;
                        }else {
                            isDefault = 0;
                        }
                        $.get("${request.contextPath}/userManager/doAddressAdd?recAddressAdd="+recAddressAdd+"&areaId="+areaId,"isDefault="+isDefault,function (data) {
                            if(data){
                                $("#message").hide();
                                window.location.href = "${request.contextPath}/userManager/recAddress";
                            }else {
                                $("#message").show();
                            }
                        });
					}else {
                        $("#message1").show();
					}

                })
            });
            //删除地址
			function delRecAddress(recAddressId) {
				if (confirm("删除后无法恢复，确定是否删除！")){
				    $.post("${request.contextPath}/userManager/delRecAddress","recAddressId="+recAddressId,function (data) {
                        if(data){
                            $("#message").hide();
                            window.location.href = "${request.contextPath}/userManager/recAddress";
                        }else {
                            $("#message").show();
                        }
                    });
				}
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
					<div class="side-neck">
						<i></i>
					</div>
					<div class="ms-side">
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
					<div class="main-wrap mt15">
						<h3>
	                        <strong style=" font-size: 14px;">收货地址</strong>
	                    </h3>
                        <div class="user-profile clearfix" style="margin-left: 0px;width: 100%;border: 0px;">
                            <div class="user-profile-wrap">
                                <p>
                                    <span>新增收货地址</span>
                                    <span>*号为必填项</span>
                                </p>
                                <div class="sui-form">
                                    <div class="address">
                                        <span>*&nbsp;</span><span class="titles">所在地区:</span>
                                        <!--<select style="padding:5px;margin-left: 14px;">
                                            <option selected="">中国大陆</option>
                                        </select>-->
                                        <span>中国大陆</span>
                                        <select id="provinceId">
                                            <option value="">请选择省</option>
											<#list addressList as pro>
												<option value="${pro.provinceCode}">
													${pro.province}
                                                </option>
											</#list>
                                        </select>
                                        <select id="cityId">
                                            <option value="">请选择市</option>
                                        </select>
                                        <select id="areaId" name="areaId">
                                            <option value="">请选择区</option>
                                        </select>
                                    </div>
                                    <div style="margin-left: 70px;margin-top: 50px;">
                                        <span style="color: #F2873B;">*&nbsp;</span><span>详细地址:</span>
                                    </div>
                                    <div style="margin-left: 150px;margin-top:-40px;">
                                        <textarea style="width:500px;height: 90px;padding: 5px;" id="recAddress" name="recAddress" placeholder="建议您如实填写详细收货地址，例如街道 名称，门牌号码，楼层和房间号等信息"></textarea>
                                    </div>

                                    <div style="margin-left: 80px;margin-top: 20px;">
                                        <span class="titles">邮政编号:</span>
                                        <input type="text" name="addressCode" placeholder="如您不清楚地区邮递号，请填写000000" style="padding: 5px;width: 300px;margin-left: 14px;" />
                                    </div>

                                    <div style="margin-left: 55px;margin-top: 30px;">
                                        <span style="color: #F2873B;">*</span>
                                        <span class="titles">收货人姓名:</span>
                                        <input type="text" name="recName" placeholder="长度不超过25个字符" style="padding: 5px;width: 300px;margin-left: 14px;" />
                                    </div>
                                    <div style="margin-left: 67px;margin-top: 30px;">
                                        <span style="color: #F2873B;">*</span>
                                        <span class="titles">手机号码:</span>
                                        <select style="padding: 5px;margin-left: 14px;">
                                            <option>中国大陆+86</option>
                                        </select>
                                        <input type="text" name="phone" placeholder="电话号码必须为11位数字"  style="padding: 5px;width: 200px;"/>
                                    </div>

                                    <div style="margin-left: 150px;margin-top: 10px;">
                                        <div class="am-u-sm-7 am-u-sm-offset-3" style="padding-right: 0rem;">
                                            <label class="checkbox-pretty inline ">
                                                <input style="color: #33302b" type="checkbox" name="isDefault">
                                                <span style="font-size: 12px;color: #878787;">
                                                    <font style="font-size: 12px;color: #333333;">设为默认地址</font>
                                                </span> </label> </div>
                                    </div>
                                    <button id="addRecAddress" style="margin-left:150px;margin-top:10px;background-color:#F37B1D ;color: #fff;width: 100px;height: 30px;border: 0px;border-radius: 5px;">确定</button><br>
                                    <span id="message" style="color: red;font-size: 12px;line-height: 25px;margin-left: 150px;display: none;">收货地址新增失败，请检查输入内容是否有误！</span><br>
                                    <span id="message1" style="color: red;font-size: 12px;line-height: 25px;margin-left: 150px;display: none;">收货地址已达到最大限制，请删除多余地址再进行添加！</span>
                                </div>
                            </div>


                        </div>
					</div>
				</div>

							<div style="margin-top: 30px;width: 1068px; margin: 15px 0 30px 170px;">
								<dl style="color: #F88600;font-size: 16px;margin-top: 69px;">您已添加${count}个地址，你还可以添加${15-count}个地址</dl><br>
                                <span id="message" style="color: red;font-size: 12px;line-height: 25px;display: none;">收货地址删除失败！</span>
                                <table class="sui-table table-bordered-simple">
								  <thead>
								    <tr>
								      <th>收货人</th>
								      <th>所在地区</th>
								      <th>收货地址</th>
								      <th>邮编</th>
								      <th>电话/手机</th>
								      <th>操作</th>
								      <th></th>
								    </tr>
								  </thead>
								  <tbody>
								  <#list recAddresses as recAddress>
								  		<tr class="recAddress_tr">
                                            <td>${recAddress.recName}</td>
                                            <td>${recAddress.areas.cities.provinces.province} ${recAddress.areas.cities.city} ${recAddress.areas.area}</td>
                                            <td>${recAddress.recAddress}</td>
                                            <td><#if recAddress.addressCode??>${recAddress.addressCode}</#if></td>
                                            <td>${recAddress.phone}</td>
                                            <td>
												<a href="${request.contextPath}/userManager/recAddressModify?recAddressId=${recAddress.recAddressId}">修改</a>&nbsp;|&nbsp;
												<a onclick="delRecAddress(${recAddress.recAddressId})" href="javascript:void(0)">删除</a>
											</td>
											<#if recAddress.isDefault == 0><td ><span style="padding: 5px;">
												<a href="${request.contextPath}/userManager/modifyIsDefault?recAddressId=${recAddress.recAddressId}">设为默认</a>
											</span></td></#if>
											<#if recAddress.isDefault == 1><td ><span style="padding: 2px;font-size: 10px;color: #EC5937;border-radius:5px;background-color: #fad5d0;border: 1px #C85E0B solid;">默认地址</span></td></#if>
                                        </tr>
								  </#list>
								  </tbody>
								</table>
								
							</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="ng-footer">
			<textarea class="footer-dom" id="footer-dom-02">
			</textarea>
			<div class="ng-fix-bar"></div>
		</div>
		<script type="text/javascript" src="js/safe/ms_common.min.js" ></script>
	</body>

</html>