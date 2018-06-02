<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/17
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="icon" href="resources/images/favicon.ico">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/7.0.0/normalize.min.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <!--页面头部开始-->
    <div class="head">
        <div class="head-logo">
            <img src="resources/images/bbs_logo.png" alt="教学论坛" class="img-responsive center-block" />
        </div>

        <div class="panel panel-default">
            <div class="panel-body">
                <span class="hidden-xs"><span class="glyphicon glyphicon-calendar"></span> 2017 年 8 / 23 星期三</span>
                <span class="pull-right"><span class="glyphicon glyphicon-bullhorn"></span> 特别通知：教学论坛开始公测啦，欢迎各位同学使用！</span>
            </div>
        </div>

        <!--论坛导航开始-->
        <div class="container-fluid">
            <div class="row bbs-nav">
                <ul class="nav nav-pills">
                    <li><a href="#">C语言</a></li>
                    <li><a href="#">C++</a></li>
                    <li><a href="#">Java</a></li>
                    <li><a href="#">C#</a></li>
                    <li><a href="#">数字电子实验</a></li>
                    <li><a href="#">单片机</a></li>
                    <form action="" method="get" class="form-inline pull-right">
                        <div class="input-group">
                            <input type="text" name="key" class="form-control" placeholder="搜索帖子" size="15"/>
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                            </div>
                        </div>
                    </form>
                </ul>
            </div>
        </div>
        <!--论坛导航结束-->
    </div>
    <!--页面头部结束-->

    <!--页面主体开始-->
    <div class="main"  style="margin-top: 10px;">
        <div class="row container">
            <div class="col-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title text-center"><span class="glyphicon glyphicon-user"></span> 当前用户</h4>
                    </div>
                    <div class="panel-body text-center">
                        <a href="user_toEdit.action"><img src="resources/images/avatar.jpg" alt="用户头像" class="img-circle img-thumbnail" width="100" height="100"/></a>
                        <div class="caption">
                            <h5>${sessionScope.user.name}</h5>
                            <p>发帖数量：<span>12</span></p>
                            <p><a href="post_toAdd.action" class="btn btn-info">我要发帖</a> <a href="post_toMine.action" class="btn btn-info">我的帖子</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
                <form class="form-horizontal" action="user_editPassword.action" data-toggle="validator">
                    <input type="hidden" name="id" value="${session.user.id}">
                    <div class="form-group">
                        <label class="control-label">原密码：</label>
                        <input type="password" class="form-control" name="oldPassword" required>
                        <s:fielderror name="editPassword"/>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label">新密码：</label>
                        <input type="password" class="form-control" id="password" name="password" data-minlength="6" required>
                        <span class="glyphicon form-control-feedback"></span>
                        <span class="help-block">至少6个字符</span>
                    </div>
                    <div class="form-group">
                        <label class="control-label">确认新密码：</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" data-match="#password" data-match-error="两次输入的密码不一致！" required>
                        <span class="help-block with-errors"></span>
                    </div>
                    <div class="form-inline">
                        <input type="submit" class="btn btn-primary" value="确认修改">
                        <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--页面主体结束-->

    <!--页面底部开始-->
    <div class="foot">
        <hr />
        <p class="text-center">版权所有：XXX实验室中心&nbsp;&nbsp;&nbsp;技术支持：FH团队</p>
    </div>
    <!--页面底部结束-->
</div>
<script src="resources/plugins/jquery-1.12.4/jquery.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="resources/plugins/validator/validator.min.js"></script>
</body>
</html>
