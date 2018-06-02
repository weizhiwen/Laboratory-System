<%--
  Created by eclipse.
  User: xzp
  Date: 2018/5/14
  Time: 22.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改资源</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="resteach_edit.action">
            <input type="hidden" name="id" value="${requestScope.resTeach.id}">
            <div class="form-group">
                <label class="control-label">资源名称：</label>
                <input type="text" class="form-control" name="name" value="${requestScope.resTeach.name}" required>
            </div>
            <div class="form-group">
                <label class="control-label">资源介绍：</label>
                <input type="text" class="form-control" name="description" value="${requestScope.resTeach.description}" required>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改资源信息">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
