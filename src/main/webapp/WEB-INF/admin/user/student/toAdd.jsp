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
    <title>添加普通用户</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="student_add.action">
            <div class="form-group">
                <label class="control-label">学号：</label>
                <input type="text" class="form-control" name="id" required>
            </div>
            <div class="form-group">
                <label class="control-label">姓名：</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            <div class="form-group">
                <label class="control-label">身份：</label>
                <input type="text" class="form-control" value="学生" readonly>
            </div>
            <div class="form-group">
                <label class="control-label">班级：</label>
                <select class="form-control" name="banjiId" required>
                    <s:iterator value="#request.banjiList">
                        <option value="${id}">${name}</option>
                    </s:iterator>
                </select>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="新增学生">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
