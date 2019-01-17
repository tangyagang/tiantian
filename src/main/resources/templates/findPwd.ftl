<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="js/amazeui.min.js"></script>
		<link rel="stylesheet" href="css/zpwd/sjsz.css" />
		<link rel="stylesheet" href="css/sui.css" />
		<script type="text/javascript" src="js/sui.js"></script>
		<link rel="stylesheet" href="css/jd.css" />
		<script type="text/javascript">
            $(function(){
				$("#send").click(function () {
                    if(checkMobile()){
                        //给指定手机号发送验证码
                        var $mobile=$("#phone").val();
                        $.get("${request.contextPath}/sendMessage?phone="+$mobile,function (data) {
							if (!data.success) {
							    alert(data.msg);
							}
                        });
					}
                });
                //验证手机验证码
                $(".am-btn").click(function (data) {
                    var $mobile=$("#phone").val();
                    var $code = $("#code").val();
                    if(checkMobile() && checkCode()){
                        $.get("${request.contextPath}/checkMessage?phone="+$mobile,"code="+$code,function (data) {
                            if (!data.success) {
                                alert(data.msg);
                            }else {
                                //判断手机号是否注册
                                $.get("${request.contextPath}/sendPassword?phone="+$mobile,function (data) {
                                    if (data.success){
                                        $("#mobile_prompt").html("");
                                        window.location.href = "${request.contextPath}/finish"
                                    } else {
                                        $("#mobile_prompt").html(data.msg);
                                    }
                                })
                            }
                        });
                    }
                })
            });
            //验证手机号；
            function checkMobile(){
                var $mobile=$("#phone");
                var $mobile_prompt=$("#mobile_prompt");
                $mobile_prompt.html("");
                var reg=/^1[345789]\d{9}$/;
                if($mobile.val()==""){
                    $mobile_prompt.html("手机号不能为空");
                    return false;
                }
                if(reg.test($mobile.val())==false){
                    $mobile_prompt.html("手机号必须是以1开头的11位数字");
                    return false;
                }
                return true;
            }
            //验证手机验证码
            function checkCode() {
                var $code = $("#code").val();
                if($code==""){
                    $("#send_prompt").html("验证码不能为空");
                    return false;
                }
                $("#send_prompt").html("");
                return true;
            }
		</script>
		<title></title>
		<style>
			/*.bottomLine {
				border-bottom: 1px solid #ccc;
				border-top: 1px solid #ccc;
				margin-bottom: 10px;
				/*padding: 10px;*/
			/*padding-top: 10px;
				padding-bottom: 10px;
				word-spacing: 0.05rem;
				text-align: center;
				margin-top: 82px;*/
			/*width:677px ;*/
			/*line-height: ;*/
			/*}*/
			
			.bottomLine {
				border-bottom: 1px solid #ccc;
				border-top: 1px solid #ccc;
				padding-top: 8px;
				/*padding-bottom:10px;*/
			}
			
			.bot {
				margin-bottom: 50px;
				/*text-align: center;*/
				color: #7b6f5b;
			}
			
			.radio-pretty.checked > span:before {
				color: #f88600;
			}
			
			input {
				height: 62px;
			}
			
			.imgbot {
				width: 128px;
				height: 128px;
			}
			.am-form-field {
    display: inline;
    width: 100%;
    width: 90%;
    padding: .5em;
    font-size: 1.6rem;
    line-height: 1.2;
    color: #555;
    vertical-align: middle;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 0;
    -webkit-appearance: none;
    -webkit-transition: border-color .15s ease-in-out, -webkit-box-shadow .15s ease-in-out;
    transition: border-color .15s ease-in-out, -webkit-box-shadow .15s ease-in-out;
    transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
    transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out, -webkit-box-shadow .15s ease-in-out;
}
		</style>
	</head>

	<body>
		<!--<div class="am-g" style="margin-top: 25px;">
			
		</div>-->
		<div style="background-color: #F8F8F8;padding-top: 40px;">
		<div class="am-g" >
			<div class="logo"> <img src="img/logo1.png" style=" width:50px;height: 50px;float: left;background-color: #666" />
				<p style="font-size: 16px;color: #3d3d3d;margin-left: 16px;font-weight: bold;margin-top: 20px;    float: left">忘记密码</p>
			</div>
			<div style="width: 1200px;margin: 0 auto;font-size: 12px;margin-top: -38px;"> <span style="float: right;color: #333333;"><a href="" style="color: #333333;">注册</a><span style="margin-left: 20px;margin-right: 20px;">|</span><a href="" style="color: #333333;">登录</a><span style="margin-left: 20px;margin-right: 20px;">|</span><a href="" style="color: #333333;">天天商城</a></span>
			</div>
		</div>
		</div>
		<div style="background-color: #ffffff;padding-top: 30px;margin-top: 21px;">
			<div class="am-g content" style="margin-top: 45px;">
				<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
					<ul class="am-tabs-nav1" style="margin-top: 20px;display:flex;list-style: none;text-align: center;">
						<li style="max-width: 95px; margin-left: 100px;"></li>
						<li style="max-width: 80px;"><span class="am-badge1 am-round am-badge-warning-active " style="background-color: #F89406;font-size: 18px;">1</span>
							<br />
							<p class="bottitle active">验证身份</p>
						</li>
						<li style="max-width: 273px;">
							<hr style="width: 273px;    border-top: 3px #F89406 solid;">
						</li>
						<li style="max-width: 80px;margin-left: 10px;"><span class="am-badge1  am-round am-badge-warning-active" style="background-color: #F89406;font-size: 18px">2</span>
							<br />
							<p class="bottitle active">输入手机</p>
						</li>
						<li style="max-width: 273px;">
							<hr style="height: 3px;">
						</li>
						<li style="max-width: 80px;margin-left: 10px;"><span class="am-badge1  am-round" style="background-image: url(../static/img/duihao.png);background-repeat: no-repeat;background-position: center;background-position-x: 5px;"></span>
							<br />
							<p style="margin-left: -10px" class="bottitle">完成</p>
						</li>
					</ul>
					<!--输入账户名-->
					<div class="am-tabs-bd" style="margin-left: 200px;">
						<div data-tab-panel-0 class="am-tab-panel am-active" style="margin-top: 20px;">
							<div class="am-g">
								<img src="img/jinggao.png" />
								<span style="font-weight:bold;margin-left: 10px;font-size: 14px;color: #3d3d3d">我们不会泄露您的手机信息</span>
							</div>
							
							<div class="am-g" style="margin-top: 20px;margin-left: 55px;">
								<span >手机号码:</span>
								<input class="am-form-field" id="phone" name="phone" type="text" style="width: 285px;height: 45px;margin-left: 22px;" />
								<span id="mobile_prompt" style="color: red;"></span>
							</div>
							<div class="am-g" id="send" style="margin-top: 20px;margin-left:50px;">
								<input type="button" style="width: 114px;height: 47px;margin-left: 80px; background-color: #C2C2C2;color: #fff;border: 0px;border-radius: 5px;"  value="免费获取验证码"/>
							</div>
							
							<div class="am-g" style="margin-top: 20px;margin-left: 65px;">
								<span >验证码:</span>
								<input class="am-form-field" id="code" type="text" style="width: 285px;height: 45px;margin-left: 22px;padding-left: 10px;font-size:12px" placeholder="请入验证码" />
								<span id="send_prompt" style="color: red;"></span>
							</div>
							<div class="am-g" style="margin-top: 30px;margin-left: 135px;">
								<button type="button" class="am-btn am-btn-warning" style="width: 265px;height: 50px;font-size: 16px;border: 1px rgba(187, 187, 187, 0.5)B solid;margin: 0 auto;border-radius: 5px;">确定</button>
							</div>
							<div class="am-g" style="padding-top:40px;padding-left:50px;border: 1px rgba(241,161,69, 0.18) solid;   margin-left:0px;margin-top:50px;height: 169px;width: 718px;background-color: #FEFBEE;">
							
							<span style="font-size: 14px;font-weight: bold;">没收到短信验证码</span>	
							<p style="font-size: 12px;margin-top: 10px;">1.网络通信异常可能会造成短信丢失,请重新获取或稍后重试</p>
							<p style="font-size: 12px;margin-top: -16px;">2.请核实手机是否已欠费停机,或者屏蔽了系统短信</p>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="am-g " style="margin-top: 81px;text-align: center;font-size: 12px;">
			<div class="bottomLine" style="margin:0 auto;width:700px;height: 35px;">
				<span style="float: left;word-spacing:0.52rem;    text-align: center;    width: 100%;">关于我们 | 联系我们 | 商家入驻 | 友情链接 | 站点地图 | 手机商城 | 销售联盟 | 商城社区 | 企业文化 | 帮助中心 
			</span>
			</div>
		</div>
		<div class="am-g">
			<div class="bot ">
				<div style="margin:0 auto;width:700px;height: 30px;">
					<p style="font-size: 12px;float: left;">© &nbsp;2005-2016 买啦网 版权所有 ，并保留所有权利 <span style="margin-left: 30px;">天天商城 Tel ：4008125181 </span><span style="margin-left: 30px;">E-mai：tiantian@163.com</span> </p>
				</div>
			</div>
		</div>
		</div>
	</body>

</html>