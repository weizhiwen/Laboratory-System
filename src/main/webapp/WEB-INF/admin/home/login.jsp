<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/8
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="http://www.yangtzeu.edu.cn/images/logo_ico.png" />
    <title>登录-开放式实验室管理后台</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/login.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid login">
    <div class="form-login">
        <form action="admin_login.action" method="post">
            <h2 class="form-title">开放式实验室管理后台</h2>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                    <input type="text" id="id" name="id" class="form-control input-lg" placeholder="请输入管理员编号" required autofocus>
                </div>
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                    <input type="password" id="password" name="password" class="form-control input-lg" placeholder="请输入密码" required>
                </div>
                <s:fielderror name="login"/>
                <%--<div class="checkbox">--%>
                    <%--<label class="remember"><input type="checkbox" name="remember" value="yes"/>记住密码？</label>--%>
                <%--</div>--%>
            </div>
            <input type="submit" value="登 录" class="btn btn-lg btn-info btn-block"/>
        </form>
    </div>
</div>

<script src="resources/plugins/jquery-1.12.4/jquery.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
