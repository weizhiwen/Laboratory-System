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
    <title>修改公告</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="labannounce_edit.action">
            <input type="hidden" name="id" value="${requestScope.labAnnounce.id}">
            <div class="form-group">
                <label class="control-label">公告内容：</label>
                <input type="text" class="form-control" name="content" value="${requestScope.labAnnounce.content}" required>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改公告">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
