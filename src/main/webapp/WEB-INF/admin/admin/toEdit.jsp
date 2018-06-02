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
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>修改个人资料</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="admin_edit.action">
            <div class="form-group">
                <label class="control-label">编号：</label>
                <input type="text" class="form-control" name="id" value="${requestScope.admin.id}" readonly>
            </div>
            <div class="form-group">
                <label class="control-label">名称：</label>
                <input type="text" class="form-control" name="name" value="${requestScope.admin.name}">
            </div>
            <div class="form-group">
                <label class="control-label">电话：</label>
                <input type="tel" class="form-control" name="tel" value="${requestScope.admin.tel}">
            </div>
            <div class="form-group">
                <label class="control-label">邮箱：</label>
                <input type="email" class="form-control" name="email" value="${requestScope.admin.email}">
            </div>
            <div class="form-group">
                <label class="control-label">院系：</label>
                <input type="email" class="form-control" value="${requestScope.admin.department.name}" readonly>
            </div>
            <div class="form-group">
                <label class="control-label">身份：</label>
                <s:if test="#request.admin.identity == '0'">
                    <input type="text" class="form-control" value="系统超级管理员" readonly>
                </s:if>
                <s:elseif test="#request.admin.identity == '3'">
                    <input type="text" class="form-control" value="实验室管理员" readonly>
                </s:elseif>
                <s:elseif test="#request.admin.identity == '4'">
                    <input type="text" class="form-control" value="院系主任" readonly>
                </s:elseif>
                <s:elseif test="#request.admin.identity == '5'">
                    <input type="text" class="form-control" value="院实验室中心主任" readonly>
                </s:elseif>
                <s:elseif test="#request.admin.identity == '6'">
                    <input type="text" class="form-control" value="校实验室中心主任" readonly>
                </s:elseif>
                <s:else>
                    <input type="text" class="form-control" value="没有选择身份" readonly>
                </s:else>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改资料">
                <a class="btn btn-primary" href="admin_toEditPassword.action">修改密码</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
