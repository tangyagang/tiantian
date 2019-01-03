<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>天天商城-用户登录</title>
    <link rel="stylesheet" href="css/base_login.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="css/login-register.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

</head>
<body>
<div class="header wrap1000">
    <a href=""><img src="img/捕获.PNG"  width="130px" height="80px"alt="图片加载异常"/></a>
</div>
<div class="main" style="min-height:480px;">
    <div class="login-form fr">
        <div class="form-hd">
            <h3>用户登录</h3>
        </div>
        <div class="form-bd"style="line-height:50px;">
            <form action="${request.contextPath}/doLogin" method="POST" id="loadForm">
                <dl>
                    <dt style="position: relative;left: -15px;">用户名</dt>
                    <!--邮箱、以13、15、18开头的电话或者是2~4个汉字-->
                    <dd style="position: absolute;top: 205px;right:320px;"><input style="position: relative;left:-5px;" type="text" placeholder="请输入用户名/手机号/邮箱"required pattern="[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}|^1[3578]\d{9}$|^[\u4e00-\u9fa5]{2,4}$" name="userName" class="text"/></dd>
                </dl>
                <dl>
                    <dt style="position: relative;left: -15px;">密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
                    <!--密码6-10位数字-->
                    <dd style="position: absolute;top: 270px;right:320px;"><input style="position: relative;left: -5px;" type="password" placeholder="请输入密码" name="password" required pattern="^\w{6,10}$"class="text"/></dd>
                </dl>
                <!--<dl>
                    <dt>验证码</dt>
                    <dd><input type="text" name="code" class="text" size="10" style="width:58px;"> <img src="img/code.png" alt="" align="absmiddle" style="position:relative;top:-2px;"/> <a href="" style="color:#999;">看不清，换一张</a></dd>
                </dl>-->
                <dl>
                    <dt>&nbsp;</dt>
                    <dd><a href="index.html"><input type="submit" value="登  录" class="submit"/></a></dd>
                </dl>
            </form>
            <dl>
                <dt>&nbsp;</dt>
                <dd>没有账号，立即 <a href="register.html" class="register">注册</a></dd>
            </dl>
            <!--<dl class="other">
                <dt>&nbsp;</dt>
                <dd>
                    <p>您可以用合作伙伴账号登录：</p>
                    <a href="" class="qq"></a>
                    <a href="" class="sina"></a>
                </dd>-->
            </dl>
        </div>
        <div class="form-ft">
        </div>
    </div>

   <div class="login-form-left fl">
        <img src="img/9c0377aa-d9d9-4f94-88f5-6435550c7093.png" width="450px" height="300px" alt="天天商城" />
    </div>
</div>
<div class="footer clear wrap1000">
    <p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">关于天天商城</a> | <a href="">广告合作</a> | <a href="">联系我们</a></p>
    <p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
</div>
</body>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/loadpage.js"></script>
</html>
