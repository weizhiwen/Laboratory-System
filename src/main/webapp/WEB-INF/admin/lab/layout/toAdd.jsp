<%--
  Created by eclipse.
  User: xzp
  Date: 2018/5/14
  Time: 22.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加布局</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="lablayout_add.action" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label">布局标题：</label>
                <input type="text" class="form-control" name="title" required>
            </div>
            <div class="form-group">
                <label class="control-label">添加图片：</label>
                <input type="file" id="img" name="cover" required>
            </div>
            <input type="hidden" name=creator value="<s:property value="#session.admin.id"></s:property> <s:property value="#session.admin.name"></s:property>">
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="添加布局">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
