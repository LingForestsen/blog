<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sen
  Date: 2019/9/20
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8" lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title> &lsaquo; 登录</title>
    <link rel="stylesheet" href="/static/assets/plugin/font-awesome/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/static/assets/img/blog_net.png">
    <link rel='stylesheet' id='dashicons-css'  href='/static/assets/plugin/login/dashicons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='buttons-css'  href='/static/assets/plugin/login/buttons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='forms-css'  href='/static/assets/plugin/login/forms.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='l10n-css'  href='/static/assets/plugin/login/l10n.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='login-css'  href='/static/assets/plugin/login/login.min.css' type='text/css' media='all' />
    <style type="text/css">
        body{
            font-family: "Microsoft YaHei", Helvetica, Arial, Lucida Grande, Tahoma, sans-serif;
            background: url(/static/assets/img/loginBg.jpg);
            width:100%;
            height:100%;
        }
        .login h1 a {
            background-size: 220px 50px;
            width: 220px;
            height: 50px;
            padding: 0;
            margin: 0 auto 1em;
        }
        .login form {
            background: #fff;
            background: rgba(255, 255, 255, 0.6);
            border-radius: 2px;
            border: 1px solid #fff;
        }
        .login label {
            color: #000;
            font-weight: bold;
        }

        #backtoblog a, #nav a {
            color: #fff !important;
        }

    </style><meta name='robots' content='noindex,follow' />
    <meta name="viewport" content="width=device-width" />
    <style>
        body {
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body class="login login-action-login wp-core-ui  locale-zh-cn">
<div id="login">
    <h1><a href="/" title="欢迎您光临本站！" tabindex="-1"></a></h1>

    <form action="/login" name="loginForm" id="loginForm"  method="post">
        <p>
            <label for="user_login">用户名或电子邮件地址<br />
                <input type="text" name="name" id="user_login" class="input" size="20" required/>
            </label>
        </p>
        <p>
            <label for="user_pass">密码<br />
                <input type="password" name="pass" id="user_pass" class="input" size="20" required/>
            </label>
        </p>

        <p>
            <label for="kaptcha">验证码<br />
                <div>
                <input style="width:140px; margin:auto;float: left" type="text" name="kaptcha" id="kaptcha"size="5" required/>
                <img style="margin:auto; padding: 3px;height: 39px;float: right;" id="validateCode" src="/kaptcha" onclick="changValidateCode()" title="看不清？换一张">
                </div>
            </label>
        </p>
        <p class="forgetmenot"><label for="rememberme"><input name="rememberMe" type="checkbox" id="rememberme" value="1" checked /> 记住密码</label></p>
        <p class="submit">
            <button style="margin-top: 30px;width: 100px" class="button button-primary">登录</button>
        </p>
    </form>
    <p id="backtoblog"><a href="/">&larr; 返回博客首页</a></p>
</div>
<div class="clear"></div>
<script src="/static/assets/js/jquery.min.js"></script>

<script type="text/javascript">
    $(function () {
        var message = '${message}';
        if (message != null && message.length > 0) {
            alert(message)
        }
    });
    //用户更换验证码
    function changValidateCode() {
        $("#validateCode").attr("src","/kaptcha?" + Math.floor(Math.random()*100));
    }
</script>
</body>
</html>
