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
    <title>修改密码</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="admin_editPassword.action" data-toggle="validator">
            <input type="hidden" name="id" value="${session.admin.id}">
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
                <input type="submit" class="btn btn-primary" value="修改密码">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
<script src="resources/plugins/jquery-1.12.4/jquery.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="resources/plugins/validator/validator.min.js"></script>
</body>
</html>
