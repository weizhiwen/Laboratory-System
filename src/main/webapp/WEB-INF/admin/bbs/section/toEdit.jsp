<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/12
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改角色</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="bbsection_edit.action">
            <input type="hidden" name="id" value="${requestScope.bbsSection.id}">
            <div class="form-group">
                <label class="control-label">板块名称：</label>
                <input type="text" class="form-control" name="name" value="${requestScope.bbsSection.name}" required>
            </div>
            <div class="form-group">
                <label class="control-label">版块描述：</label>
                <input type="text" class="form-control" name="description" value="${requestScope.bbsSection.description}" required>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="确认修改">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
