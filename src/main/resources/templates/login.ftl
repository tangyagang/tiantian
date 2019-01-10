<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <title>天天商城</title>
</head>
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#userName").blur(checkL);
        $("#password").blur(checkRName);
        $("#zhuce").submit(function() {
            var flag=true;
            if(!checkL())
                flag = false;
            if(!checkRName()) flag = false;
            return flag;
        });
    });

    function checkL(){
        //var $lo= $("#lo");
        var $uName = $("#userName");
        $(".uName").html("");
        if($uName.val()==""){
            $(".uName").html("用户名不能为空");
            return false;
        }
        return true;
    }
    function checkRName(){
        //var $lo= $("#lo");
        var $pass = $("#password");
        $(".pass").html("");
        if($pass.val()==""){
            $(".pass").html("密码不能为空");
            return false;
        }
        return true;
    }


</script>
<body>
<div class="shangbiao"><img src="img/log.png" height="115px" width="100px"/></div>
<div class="header">

    <div class="b">

        <div class="ul">
            <form action="${request.contextPath}/doLogin" method="post" id="zhuce">
                <ul class="centre">
                    <li>
                        <div class="a1">用户登录</div>
                        <div class="a2">新用户,<a href="#">马上注册</a></div>
                        <div class="c">

                            <div class="centre-left"><span class="pan">*</span>用户名</div>
                            <div class="centre-right"><input type="text"name="userName" id="userName"/>
                                <p class="centre-right-bottom">请您填写您的用户名</p>
                            </div>
                            <div class="uName"></div>
                        </div>
                    </li>
                    <li>
                        <div class="c1">
                            <div class="centre-left"><span class="pan">*</span>密码</div>
                            <div class="centre-right"><input type="text"name="password" id="password"/>
                                <p class="centre-right-bottom">请您填写您的密码</p>
                            </div>
                            <div class="pass"></div>
                        </div>
                    </li>
                </ul>
                <div>
                    <button type="submit" id="button"><span class="button-span">登录</span></button>
                </div>
            </form>
        </div>
    </div>

</div>
<div class="bottom-p">

    <p>© &nbsp;2005-2016 天天商城网 版权所有 ，并保留所有权利
        <span >天天商城 Tel ：4008125181 </span>&nbsp;&nbsp;<span  >E-mai：maila@163.com </span>  </p>
    <p>增值电信业务经营许可证： 浙B2-20110446
        市场名称登记证：工商网市字3301004119号
        出版物网络交易平台服务经营备案证： 新出发浙备字第001号</p>

</div>
</body>
</html>
