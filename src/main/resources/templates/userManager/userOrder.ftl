<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" href="css/safe/css.css" />
		<link rel="stylesheet" href="css/safe/common.min.css" />
		<link rel="stylesheet" href="css/safe/ms-style.min.css" />
		<link rel="stylesheet" href="css/safe/personal_member.min.css" />
		<link rel="stylesheet" href="css/safe/Snaddress.min.css" />
		<link rel="stylesheet" href="css/sui.css" />
		<link rel="stylesheet" href="css/admin_index.css">
		<link rel="stylesheet" href="css/我的订单标注.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="js/sui.js" ></script>
		<script type="text/javascript">
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
            });

		</script>
	</head>

	<body class="ms-body">
		<div id="" class="ng-top-banner"></div>
		<div class="ng-toolbar">
			<div class="ng-toolbar-con wrapper">
				<div class="ng-toolbar-left">
					<a class="ng-bar-node ng-bar-node-backhome" id="ng-bar-node-backhome" >
						<span><img src="img/Home.png"/>返回买啦首页</span>
					</a>
					<div class="ng-bar-node-box ng-site-nav-box">
						<a href="" class="ng-bar-node ng-bar-node-site">
							<span><img src="img/daohang.png"/>网站导航</span><em class="ng-iconfont down"></em>
						</a>
						<div class="ng-sn-site-nav ng-d-box site-nav-child">
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
						<span id="">吉米小子</span>
						<em class="hasmsg ng-iconfont"></em>
					</a>
					<div class="ng-bar-node-box username-handle" id="">
						<a href="" rel="nofollow" class="ng-bar-node username-bar-node username-bar-node-noside">
							<span id="">吉米小子</span>
							<em class="hasmsg ng-iconfont"></em>
							<em class="ng-iconfont down"></em>
						</a>
						<div class="ng-d-box ng-down-box ng-username-slide">
							<a href="" class="ng-vip-union" target="_blank" rel="nofollow">账号管理</a>
							<a href="" rel="nofollow">退出登录</a>
						</div>
					</div>
					<div class="ng-bar-node reg-bar-node" id="reg-bar-node">
						<a href="" rel="nofollow" class="login">登录</a>
						<a href="" target="_blank" class="login reg-bbb" rel="nofollow">注册</a>
					</div>

					<div class="ng-bar-node-box myorder-handle">
						<a class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>我的买啦</span><em class="ng-iconfont down"></em></a>
						<div class="ng-down-box ng-d-box myorder-child" style="display:none;">
							<a>待支付<em id="waitPayCounts"></em></a>
							<a>待收货<em id="waitDeliveryCounts"></em></a>
							<a>待评价<em id="waitEvaluation"></em></a>
							<a>修改订单</a>
						</div>
					</div>
					<a class="ng-bar-node ng-bar-node-mini-cart" rel="nofollow" href="">
						<span><img src="img/购物车.png" />&nbsp;购物车</span>
						<span class="total-num-bg-box">
						<em></em>
						<i></i>
					</span>
						</span>
					</a>
					<div class="ng-bar-node-box mysuning-handle">
						<a href="" rel="nofollow" name="" class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>收藏夹</span><em class="ng-iconfont down"></em></a>
						<div class="ng-down-box ng-d-box mysuning-child" >
							<a href="" rel="nofollow" target="_blank">我的二手</a>
							<a href="" rel="nofollow">我的收藏</a>
						</div>
					</div>

					<div class="ng-bar-node-box app-down-box">
						<a href="" target="_blank" rel="nofollow" class="ng-bar-node mb-suning touch-href">
							<span>关注买啦</span>
						</a>
						<div class="ng-mb-box ng-d-box mb-down-child">
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

					<a href="" class="ng-bar-node ng-bar-node-pr5" target="_blank"><span>卖家中心</span><em class="ng-iconfont down"></em></a>
					<div class="ng-bar-node-box service-handle">
						<a href="" class="ng-bar-node ng-bar-node-service ng-bar-node-fix touch-href ng-bar-node-pr5" rel="nofollow"><span>联系我们</span><em class="ng-iconfont down"></em>
				    </a>
						<div class="ng-down-box ng-d-box service-center-child ng-ser-list">
							<a>帮助中心</a>
							<a>查找门店</a>
							<a>退换货</a>
							<a>帮客预约</a>
							<a>建议反馈</a>
						</div>
					</div>
				</div>
				<div id="ng-minicart-slide-box"></div>
			</div>
		</div>
		<header class="ms-header ms-header-inner ms-head-position">
			<article class="ms-header-menu">
				<div class="header-menu">
					<div class="ms-logo">
						<a class="ms-head-logo" name="Myyigou_index_none_daohangLogo">
							<span>我的买啦</span>
						</a>

					</div>
					<nav class="ms-nav">
						<ul>
							<li class=""><a href="" data-url="">首页</a><i class="nav-arrow"></i></li>
							<li class="nav-manage selected">
								<a href="" data-url="">账户管理<em></em></a><i class="nav-arrow"></i>
								<div class="list-nav-manage " hidden="">
									<p class="nav-mge-hover">账户管理<em></em></p>

								</div>
							</li>
							<li class="ms-nav-msg"><a>消息</a><i class="nav-arrow"></i></li>
						</ul>
						<div class="ms-search">
							<form>
								<input id="" type="text" value="">
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
							<a class="text-edit-avatar">修改</a>
						</div>
						<a>sunshine</a>
					</div>

					<div class="ms-name-info">
						<div class="link-myinfo">
							<a>我的编号:99653</a>
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
							<a class="bind-phone">
								<i style="background-image: url(img/修改手机.png);"></i>修改手机</a>
							<a class="bind-email">
								<i style="background-image: url(img/绑定邮箱.png);"></i>修改邮箱</a>
							<a class="manage-addr"><i style="background-image: url(img/地址管理.png);"></i>地址管理</a>
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
								<dt><img src="img/左侧/我的购物车.png"  style="margin-right: 10px;margin-left: -20px;"/>我的购物车</dt>
								<dt><img src="img/左侧/file.png"  style="margin-right: 10px;margin-left: -20px;"/>订单管理</dt>
								<dd>
									<a href="我的订单.html">我的订单</a>
								</dd>
								<dd>
									<a href="我的收藏.html">我的收藏</a>
								</dd>
								<dd>
									<a href="商品评价.html">商品评价</a>
								</dd>
								<dd>
									<a href="已买宝贝.html">已买宝贝</a>
								</dd>
								<dd>
									<a href="浏览足迹.html">浏览足迹</a>
								</dd>
								<dd>
									<a href="购买过的店铺.html">购买过的店铺</a>
								</dd>
								<dt><img src="img/左侧/我的买啦.png"  style="margin-right: 10px;margin-left: -20px;"/>个人信息</dt>
								<dd>
									<a href="基本资料.html">基本资料</a>
								</dd>
								<dd>
									<a href="收货地址.html">收货地址</a>
								</dd>
							</dl>
							<a ison="on" class="switch-side-menu icon-up-side"><i></i></a>
						</article>
					</div>
				</div>
				<div class="cont-main">
					<div class="main-wrap mt15" >
						      <ul class="sui-nav nav-tabs">
								  <li   style="margin-left: -5px;"><a href="#profile" data-toggle="tab">所有订单<span>|</span></a></li>
								  <li class="active"><a href="#profile" data-toggle="tab">待付款<span>|</span></a></li>
								   <li class="active"><a href="#profile" data-toggle="tab">待发货<span>|</span></a></li>
								    <li class="active"><a href="#profile" data-toggle="tab">待发货1<span>|</span></a></li>
								    <li class="active"><a href="#profile" data-toggle="tab">待评价<span>|</span></a></li>
								</ul>
							<div class="profile-info">
								<div class="control-group clearfix " >
									<div>
                                        <div>
									    	<img src="img/trash-拷贝.png" />
											<span>订单回收站</span>
                                        </div> 
									 </div>
									
								</div>
							</div>
						<form method="post" action="#">
							<div id="search">
								<input  type="text"  placeholder="输入商品标题或者订单号进行搜索 " />
								<button type="submit">订单搜索</button>
							    <span>更多搜索条件</span>
							</div>
							<div id="condition" class="con" style="margin-left: 30px;">
								<div class="condition1">
									<div>
										<span>交易状态</span>
										<select>
											<option value="">全部</option>
											<option value="1">等待买家付款</option>
											<option value="2">买家已付款</option>
											<option value="3">卖家已发货</option>
											<option value="4">交易成功</option>
											<option value="5">交易关闭</option>
											<option value="6">退款中的订单</option>
										</select>
									</div>
									<div>
										<span>成交时间</span>
										<input id="date-search" type="date" placeholder="请选择时间范围开始">-<input type="date" placeholder="请选择时间范围结束">
									</div>
								</div>
								<div class="condition1">
									<div>
										<span>评价状态</span>
										<select>
											<option value="">全部</option>
											<option value="1">需我评价</option>
											<option value="2">我已评价</option>
											<option value="3">对方已评</option>
											<option value="4">双方已评</option>
										</select>
									</div>
									<div>
										<span>卖家昵称</span>
										<input type="text">
									</div>
								</div>
							</div>
						</form>

							<div class="tab-content">
								  <div id="index" class="tab-pane " >
								  </div>
								 <div id="profile" class="tab-pane active">
									 <div>
										<span style="color: #858585;margin-left: 160px;">宝贝</span>
										<span style="color: #858585;margin-left: 190px;">单价(元)</span>
										<span style="color: #858585;margin-left: 29px;">数量</span>
										<span style="color: #858585;margin-left: 45px;">商品操作</span>
										<span style="color: #858585;margin-left: 100px;">实付款(元)</span>
										<span style="color: #858585;margin-left: 45px;">交易状态</span>
										<span style="color: #858585;margin-left: 45px;">交易操作</span>
									 </div>
									 <div style="width: 100%;height: 0px;padding: 10px;">
										<input class="index_all" type="checkbox">
										<span style="line-height: 20px;">全选</span>
										<input type="button" value="批量确认收货"  style="padding: 2px;border: 1px #ccc solid;background-color: #fff;color: #666;margin-left: 20px;"/>
										<div style="float: right;margin-right: 5px;">
											<button class="button-left">上一页</button>
											<button class="button-left">下一页</button>
										</div>
									 </div>

									 <#list pageInfo.list as order>
										<div style="margin-top: 30px;width: 100%;height: 150px;border: 1px #ccc solid;">
											<div style="width: 100%;height: 50px;background-color: #eaf9ff;vertical-align: middle;font-size: 12px;">
												<input type="checkbox" style="line-height: 50px;margin-left: 20px;"/>
												<span style="line-height: 50px;">${order.createTime?string("yyyy-MM-dd")}</span>
												<span style="line-height: 50px;margin-left: 20px;">订单号：${order.orderNum}</span>
												<span style="line-height: 50px;margin-left: 100px;">如熙旗舰店</span>
											</div>
											<div style="float: left;width: 65%;height: 12px;">
												<div style="width: 100%;">
													<img src="img/tb1yczdhpxxxxxzxxxxxxxxxxxx_!!2-item_pic.png"
														 style="height: 100px;float: left;"/>
													<dl style="width: 220px;float: left;margin-left: 20px;margin-top: 20px;">
														如熙2016春季新款韩版春季新款韩版春季新款韩版春季新款韩版春季新款韩版春季新款韩版春季新款韩版春季新款韩版
													</dl>
													<del style="display: inline-block;margin-left: -38px;margin-top: 20px;color: #858585;">
														199.00
													</del>
													<dl style="float: left;margin-left: 50px;margin-top: 40px;">129.00</dl>
													<span style="margin-left: 40px;">1</span>
													<dl style="float: right;margin-right: 50px;margin-top: 20px;">退款/退货
														<br/>投诉卖家
														<br>
														退运保险
													</dl>
												</div>
											</div>

											<div style="float: left;border-left: 1px #ccc solid;width: 11%;height:100px;text-align: center;">
												<span style="font-weight: bold;margin-top: 30px;display: block;">129</span>
												<dl>(含运费:00)</dl>
											</div>
											<div style="float: left;border-left: 1px #ccc solid;width: 11%;height:100px;text-align: center ;">
												<dl style="margin-top: 30px;">卖家已发货</dl>
												<dl>订单详情</dl>
												<dl>查看物流</dl>
											</div>
											<div style="float: left;border-left: 1px #ccc solid;width: 11%;height:100px;text-align: center ;">
												<dl style="margin-top: 30px;">还有9天10时4分</dl>
												<button style="color:#fff;background-color: #65b5ff;border: 0px;padding: 4px;margin-top: 5px;margin-top: 5px;">
													确认收货
												</button>
											</div>
										</div>
									 </#list>

								 <div style="width: 100%;height: 0px;padding: 10px;">
									<input class="index_all" type="checkbox">
								 	<span style="line-height: 20px;">全选</span>
								 	<input type="button" value="批量确认收货"  style="padding: 2px;border: 1px #ccc solid;background-color: #fff;color: #333;margin-left: 20px;"/>
								 		
								 </div>		<p style="text-align:right;margin-top: 10px;width: 100%;">
							    	<span class="fenye"><</span><span class="fenye" style="margin-left: 10px;">1</span><span class="fenye">2</span><span class="fenye">3</span>.....<span class="fenye">></span>共1页，到<input type="text" value="1" style="width: 20px;margin-left: 10px;margin-right: 10px;" />页<button  style="background-color: #f95555;padding: 3px;border: 0px;color: #fff;margin-left: 10px;width: 50px;border-radius:4px;">确认</button>
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