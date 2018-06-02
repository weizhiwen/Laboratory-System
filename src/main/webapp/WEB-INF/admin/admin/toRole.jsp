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
    <title>给用户分配角色</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="admin_set.action">
            <div class="form-group">
                <label class="control-label">编号：</label>
                <input type="text" class="form-control" name="id" value="${requestScope.admin.id}" readonly>
            </div>
            <div class="form-group">
                <label class="control-label">用户名：</label>
                <input type="text" class="form-control" name="name" value="${requestScope.admin.name}">
            </div>
            <div class="form-group">
                <label class="control-label">身份：</label>
                <select class="form-control" readonly disabled>
                    <option <s:if test="#request.admin.identity == '' || #request.admin.identity == null">selected</s:if>>没有选择身份</option>
                    <option <s:if test="#request.admin.identity == '3'">selected</s:if>>实验室管理员</option>
                    <option <s:if test="#request.admin.identity == '0'">selected</s:if>>系统超级管理员</option>
                    <option <s:if test="#request.admin.identity == '4'">selected</s:if>>系主任</option>
                    <option <s:if test="#request.admin.identity == '5'">selected</s:if>>院实验室中心主任</option>
                    <option <s:if test="#request.admin.identity == '6'">selected</s:if>>校实验室中心主任</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">角色设置：</label>
                <select name="roleIds" class="form-control" multiple="multiple" title="按Ctrl键可以多选或取消">
                    <s:iterator value="#roleList">
                        <option value="${id}" <s:property value="%{id in roleIds ? 'selected' : ''}"/>>${name}</option>
                    </s:iterator>
                </select>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="确认分配">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
