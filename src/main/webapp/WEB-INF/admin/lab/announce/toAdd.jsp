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
    <title>添加公告</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="labannounce_add.action">
            <div class="form-group">
                <label class="control-label">公告内容：</label>
                <input type="text" class="form-control" name="content" required>
            </div>
            <input type="hidden" name=creator value="<s:property value="#session.admin.id"></s:property> <s:property value="#session.admin.name"></s:property>">
            <div class="form-group">
                <label class="control-label">所属院系：</label>
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
                <input type="submit" class="btn btn-primary" value="添加公告">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
