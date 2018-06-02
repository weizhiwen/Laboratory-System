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
    <title>添加管理员用户</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="labadmin_add.action">
            <div class="form-group">
                <label class="control-label">登录编号：</label>
                <input type="text" class="form-control" name="id" required>
            </div>
            <div class="form-group">
                <label class="control-label">登录名：</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            <div class="form-group">
                <label class="control-label">电话：</label>
                <input type="tel" class="form-control" name="tel">
            </div>
            <div class="form-group">
                <label class="control-label">邮箱：</label>
                <input type="email" class="form-control" name="email">
            </div>
            <div class="form-group">
                <label class="control-label">身份：</label>
                <input type="text" class="form-control" value="实验室管理员" readonly>
            </div>
            <div class="form-group">
                <label class="control-label">院系：</label>
                <s:if test="#session.admin.department.id != 1">
                    <input type="hidden" name="departmentId" value="${sessionScope.admin.department.id}">
                    <input type="text" class="form-control" value="${sessionScope.admin.department.name}" readonly>
                </s:if>
                <s:else>
                    <select name="departmentId" class="form-control">
                        <s:iterator value="departmentList">
                            <option value="${id}">${name}</option>
                        </s:iterator>
                    </select>
                </s:else>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="新增实验室管理员">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
