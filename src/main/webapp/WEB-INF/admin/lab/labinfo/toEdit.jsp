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
    <title>修改实验室</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="labinfo_edit.action">
            <input type="hidden" name="id" value="${requestScope.labInfo.id}">
            <div class="form-group">
                <label class="control-label">实验室名称：</label>
                <input type="text" class="form-control" name="title" value="${requestScope.labInfo.title}" required>
            </div>
            <div class="form-group">
                <label class="control-label">实验室介绍：</label>
                <input type="text" class="form-control" name="introduce" value="${requestScope.labInfo.introduce}" required>
            </div>
            <div class="form-group">
                <label class="control-label">实验室位置：</label>
                <input type="text" class="form-control" name="location" value="${requestScope.labInfo.location}" required>
            </div>
            <%--<div class="form-group">--%>
                <%--<label class="control-label">创建人：</label>--%>
                <%--<input type="text" class="form-control" name="creator" value="${requestScope.labInfo.creator}" required>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="control-label">创建时间：</label>--%>
                <%--<input type="text" class="form-control" name="createTime" value="${requestScope.labInfo.createTime}" required>--%>
            <%--</div>--%>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改实验室信息">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>