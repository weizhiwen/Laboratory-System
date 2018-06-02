<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/18
  Time: 10:29
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
    <title>教学论坛-发布发帖</title>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
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
    <div class="main">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">发布帖子<small>（默认为Markdown编辑器）</small></h3>
            </div>
            <div class="panel-body">
                <form action="post_add.action" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-md-1 control-label">帖子类型</label>
                        <div class="col-md-4">
                            <select class="form-control" name="sectionId">
                                <s:iterator value="#bbsSectionList">
                                    <option value="${id}">${name}</option>
                                </s:iterator>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="PostTitle" class="col-md-1 control-label">帖子标题</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="title" id="PostTitle" placeholder="帖子标题不超过 35个字" size="12"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <textarea id="editor" placeholder="发篇帖子吧"></textarea>
                        <textarea name="content" id="content" hidden></textarea>
                    </div>
                    <input type="hidden" name="userId" value="${sessionScope.user.id}">
                    <div class="form-group text-center">
                        <input type="submit" class="btn btn-primary btn-sm" onclick="getHtml()" value="发布"/>
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
<script type="text/javascript" src="resources/js/mditor.js"></script>
<script>
    // 初始化 mditor
    var postEditor = document.getElementById('editor');
    var meditor = new mditor(postEditor);
    // 在发布帖子时将 Markdown 转为 Html 存到数据库中
    function getHtml(){
        var content = document.getElementById('content');
        content.value =  meditor.getHtml();
    }
</script>
</body>
</html>
