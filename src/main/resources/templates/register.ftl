<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style_reg.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function(){
            var $userName =  $("input").first();
            var $veryCode = $("input:eq(10)");
            /* $("#rand").click(function () {

                $("#veryCode").attr({src:"/getVerify?xxx="+Math.random()});
             });*/

            //表单验证
            $userName.blur(function(){
                if($(this).val()==""){
                    $(this).next().show();
                    $(this).next().html("用户名不能为空");
                    return;
                }else{
                    checkUserName($userName);
                }

            });
            $("input:eq(1)").blur(function(){
                if($(this).val()==""){
                    $(this).next().show();
                    $(this).next().html("密码不能为空");
                    return;
                }else{
                    $(this).next().hide();
                    $(this).next().html("");
                }
            });
            $("input:eq(2)").blur(function(){
                if($(this).val()==""){
                    $(this).next().show();
                    $(this).next().html("密码不能为空");
                    return;
                }else if($(this).val()!=$("input:eq(1)").val()){
                    $(this).next().show();
                    $(this).next().html("两次密码不一致");
                    return;
                }else{
                    $(this).next().hide();
                    $(this).next().html("");
                }
            });
            $("input:eq(3)").blur(function(){
                if($(this).val()==""){
                    $(this).next().show();
                    $(this).next().html("真实姓名不能为空");
                    return;
                }else{
                    $(this).next().hide();
                    $(this).next().html("");
                }
            });
            var flagBirthday = true;
            $("input:eq(6)").blur(function(){
                 if($(this).val().length>0 ||$(this).val() != ""){
                     var reg=/((19\d{2})|(200\d)|(201[0-9]))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/; //1990-2018年
                     if(reg.test($(this).val())){
                         $(this).next().hide();
                         $(this).next().html("");
                         flagBirthday = true;
                     }else {
                         $(this).next().show();
                         $(this).next().html("格式不正确");
                         flagBirthday = false;
                         return;
                     }
                 }else{
                     $(this).next().hide();
                     $(this).next().html("");
                 }
            });
            $veryCode.blur(function(){
                if($(this).val()==""){
                    $("#rand").next().show();
                    $("#rand").next().html("验证码不能为空");
                    return;
                }else{
                    checkVeryCode($veryCode);
                }

            });
            //切换验证码图片
            $("#rand").click(function () {
                $("#veryCode").attr({src:"${request.contextPath}/getVerify?xxx="+Math.random()});
            })
            //提取表单数据并发送Ajax请求
            var $inputs = $("#regForm").find("input:text,input:password,input:radio,input[name=birthday],select");
            $("input").last().click(function(){
                if($("input").first().val()==""){
                    $("input").first().next().show();
                    $("input").first().next().html("用户名不能为空");
                }else if($("input:eq(1)").val()==""){
                    $("input:eq(1)").next().show();
                    $("input:eq(1)").next().html("密码不能为空");
                }else if($("input:eq(2)").val()==""){
                    $("input:eq(2)").next().show();
                    $("input:eq(2)").next().html("密码不能为空");
                }else if($("input:eq(3)").val()==""){
                    $("input:eq(3)").next().show();
                    $("input:eq(3)").next().html("真实姓名不能为空");
                }else if($("input:eq(10)").val()==""){
                    $("#rand").next().show();
                    $("#rand").next().html("验证码不能为空");
                }else{
                    checkVeryCode($veryCode);
                    checkUserName($userName);
                    if (flagUserName && flagVeryCode && flagBirthday){
                        submit();
                    }
                }
            });
             function submit() {
                 var paramsArray = $inputs.serialize(); //提取表单元素的值，封装成参数化字符串
                 $.post("${request.contextPath}/doRegister",paramsArray,function(data){
                     if(data >= 1){
                         alert("注册成功");
                         window.location.href="${request.contextPath}/login";
                     }else{
                         alert("注册失败");
                     }
                 });
            }
            var flagUserName = false;
            function  checkUserName($userName) {
                $.post("${request.contextPath}/isExistUser","userName="+$userName.val(),function(data){
                    if(data=="Y"){
                        $userName.next().show();
                        $userName.next().html("用户名已被占用");
                    }else{
                        $userName.next().hide();
                        $userName.next().html("");
                        flagUserName = true;
                    }
                });
            }
            var flagVeryCode = false;
            function checkVeryCode($veryCode) {
                $.get("${request.contextPath}/validImage","veryCode="+$veryCode.val(),function(data){
                    if(data=="N"){
                        $("#rand").first().next().show();
                        $("#rand").first().next().html("验证码错误");
                    }else if (data=="x"){
                        $("#rand").first().next().show();
                        $("#rand").first().next().html("验证码已失效，请重新输入");
                    } else{
                        $("#rand").first().next().hide();
                        $("#rand").first().next().html("");
                        flagVeryCode = true;
                    }
                });
            }
        });

    </script>
</head>
<body>
<div id="header" class="wrap" >
    <div id="logo"><img  src="img/logo1.png" style="width: 130px;height: 149px"/></div>
    <div class="help"><span>已有天天购物账号了？</span><a href="#">去登陆</a>

    </div>
    <div class="navbar">

    </div>
</div>
<div id="childNav">

</div>
<div id="register" class="wrap">
    <div class="shadow">
        <em class="corner lb"></em>
        <em class="corner rt"></em>
        <div class="box">
            <h1>欢迎注册天天购物商城</h1>
            <ul class="steps clearfix">
                <li class="current"><em></em>填写注册信息</li>
                <li class="last"><em></em>注册成功</li>
            </ul>
            <form id="regForm" method="post" action="${request.contextPath}/doRegister">
                <table>

                    <tr>
                        <td class="field"><strong style="color:red">* </strong>用户名：</td>
                        <td><input class="text" type="text" name="userName" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field"><strong style="color:red">* </strong>登录密码：</td>
                        <td><input class="text" type="password" id="passWord" name="password" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field"><strong style="color:red">* </strong>确认密码：</td>
                        <td><input class="text" type="password" name="rePassword" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field"><strong style="color:red">* </strong>真实姓名：</td>
                        <td><input class="text" type="text" name="realName" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">性别：</td>
                        <td>
                            <input type="radio" name="sex" value="1" checked/>男
                            <input type="radio" name="sex" value="2"/>女
                        </td>
                    </tr>
                    <tr>
                        <td class="field"><strong style="color:red"></strong>生日：</td>
                        <td><input placeholder="日期格式：yyyy-MM-dd" class="text" type="text" name="strBirthday" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">身份证号码：</td>
                        <td><input class="text" type="text" name="identity" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">电子邮箱：</td>
                        <td><input class="text" type="text" name="email" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">手机号：</td>
                        <td><input class="text" type="text" name="phone" /><span></span></td>
                    </tr>

                    <tr>
                        <td class="field">验证码：</td>
                        <td><input class="text verycode" type="text" name="veryCode" /><img id="veryCode" src="${request.contextPath}/getVerify" /><a id="rand" onclick="getVerify(this);" href="javascript:void(0)">看不清 换一张</a><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">登录状态：</td>
                        <td>
                            <select name="userType">
                                <option value="1">普通用户</option>
                                <option value="2">管理员</option>
                            </select>
                            <span></span>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-green"><input type="button" name="button" value="提交注册" /></label></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
