<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/8
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!--使IE浏览器用最新的edge引擎渲染页面-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--让页面的最大宽度等于设备的宽度，页面初始化为不缩放状态，当然这样还是可以缩放-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="renderer" content="webkit" />
    <!--360浏览器默认使用急速模式-->

    <title>错误</title>
    <style>
        .big-container{background-color: #FFFFFF;margin-top: 110px;}
        .img01,.text01{float: left;width: 50%;}
        .img01{text-align: right;padding: 40px;}
        .text01{padding-top: 30px;background-color: #fff;}
        .sorry{font-size: 40px;}
        .span01{font-size: 30px;color: gray;}
        .span02{font-size: 40px;color: gray;font-style: oblique;}
    </style>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid big-container">
    <!--左边包含图片div-->
    <div class="img01">
        <img src="resources/images/bt.jpg" width="200px" height="208px"/>
    </div>
    <!--右边提示文字div-->
    <div class="text01">
        <p class="sorry text-warning">
            对不起，
        </p>
        <p>
            <span class="span01">你上传的文件太大！，上传失败！</span>
            <span class="span02">！</span>
        </p>
        <p class="bt">
            <button class="btn btn-info" onclick="window.open('#')"><span class="back">点击返回</span></button>
        </p>
    </div>
</div>

<script src="resources/plugins/jquery-1.12.4/jquery.min.js"></script>
</body>
</html>