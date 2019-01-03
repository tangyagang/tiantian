<html xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>天天商城-用户注册</title>
    <link rel="stylesheet" href="css/base_login.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="css/login-register.css" />
    <style  rel="stylesheet" type="text/css">
        #code:hover{
            cursor:pointer;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function check(){
            if($("#ty").is(':checked')){
                $("#ty").attr("value", true);
                return true;
            }else{
                $("#ty").attr("value", false);
                return false;
            }
        };
        //设置获取验证码按钮的倒计时时间
        var countdown=60;

        function settime(val) {

            if (countdown == 0) {
                val.style.width=70+"px";
                val.removeAttribute("disabled");
                val.value="获取验证码";
                countdown = 60;
            } else {
                if(countdown<10){
                    val.style.width=74+"px";
                }else{
                    val.style.width=82+"px";
                }
                val.setAttribute("disabled", true);
                val.value="重新发送(" + countdown + ")";
                countdown--;
                setTimeout(function() {
                    settime(val)
                },1000)
            }
        }

        function getCode(val){
            var Phone=$("#phone").val();
            $.post("code",{"Phone":phones},function () {
            });
            settime(val);
        }

        $(function () {

            // 判断用户是否存在
            $("#userName").blur(function () {
                var userName=$(this).val();
                $.post('SuserName',{"userName":userName},function (rs) {
                    if(rs){
                        $("#Is_Exists_User").text("	");
                    }else {

                        $("#Is_Exists_User").text("该用户已存在");
                    }
                })
            });
            // 判断密码是否一致
            $("#repwd").blur(function () {
                //密码
                var su_password=$("#su_password").val();
                //确认密码
                var repwd=$(this).val();
                if(su_password==repwd){
                    $("#Is_repwd").text(" ");
                }else {
                    $("#Is_repwd").text("密码不一致，请重新输入");
                }
            });
        });
    </script>
</head>
<body>
<div class="header wrap1000">
    <a href=""><img src="img/捕获.PNG" height="100" alt="" /></a>
</div>
<div class="main">
    <div class="login-form fr">
        <div class="form-hd">
            <h3>用户注册</h3>
        </div>
        <div class="form-bd">
            <form action="http://localhost:8080/Mall/Register" method="POST" onsubmit="return check()">
                <dl>
                    <dt>用户名</dt>
                    <dd>
                        <input id="userName"  type="text" name="userName" class="text" required placeholder="用户名长度为3~12" minlength="3" maxlength="12"/>
                    </dd>
                    <dd id="Is_Exists_User" style="color: red;position: relative;top:10px;left:80px;"></dd>
                </dl>
                <dl>
                    <dt>密码</dt>
                    <dd><input id="password"   type="password" name="password" class="text" required placeholder="密码长度为6~20" minlength="6" maxlength="20"/>
                    </dd>
                    <dd id="pwdSize" style="color: red;position: relative;top:10px;left:80px;"></dd>
                </dl>
                <dl>
                    <dt>确认密码</dt>
                    <dd>
                        <input id="repwd"  type="password"    name="repwd" class="text" required placeholder="请输入确认密码" minlength="6"/>
                    </dd>
                    <dd id="Is_repwd" style="color: red;position: relative;top:10px;left:80px;"></dd>
                </dl>
                <dl>
                    <dt>邮箱</dt>
                    <dd><input id="email"  type="email" name="email" class="text" placeholder="00000000@qq.com" pattern="/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/"/></dd>
                </dl>
                <dl>
                    <dt>手机号</dt>
                    <dd>
                        <input id="phone"  style="width:150px;"  name="phone" class="text" pattern="(^(\d{3,4}-)?\d{7,8})$|^(13|15|18|14)\d{9}$" placeholder="您的手机号码" maxlength="11" minlength="11" />
                        <input type="bottom" style="width:70px;font-size:12px;background-color:blue;color:white;padding:5px;border:none;" id="code" value="获取验证码"  onclick="getCode(this)">
                    </dd>
                </dl>
                <dl>
                    <dt>验证码</dt>
                    <dd><input type="text" name="phoneCode" id="phoneCode" class="text" placeholder="请输入手机验证码"/>

                    </dd>
                    <dd id="codemess" style="color: red" ></dd>

                </dl>
                <dl>
                    <dt>&nbsp;</dt>
                    <dd><input type="submit" value="立即注册" class="submit"/>
                        <input type= "checkbox" checked="checked" id="ty"/>阅读并同意
                        <a href="" class="forget">服务协议</a>
                    </dd>
                </dl>
            </form>
            <script>
                email.oninvalid=function(){
                    email.setCustomValidity("邮箱格式不正确，请输入正确的格式");
                };
                password.oninvalid=function(){
                    password.setCustomValidity("密码长度为6~20");
                };
                userName.oninvalid=function(){
                    userName.setCustomValidity("用户名长度为3~12");
                };
                phone.oninvalid=function(){
                    phone.setCustomValidity("请输入正确的手机号码");
                };
            </script>
        </div>
        <div class="form-ft">
        </div>
    </div>
    <div class="login-form-left fl">
        <img src="img/图层-285.png" width="400" height="200">
        <div class="if">
            <h2>已有账户</h2>
            <p>立即 <a href="login.html" class="register">登录</a>忘记密码？<a href="" class="findpwd">找回密码</a></p>
        </div>
    </div>
</div>
<div class="footer clear wrap1000">
    <p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">关于天天商城</a> | <a href="">广告合作</a> | <a href="">联系我们</a></p>
    <p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
</div>
</body>
</html>
