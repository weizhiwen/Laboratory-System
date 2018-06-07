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
    <title>修改布局</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="lablayout_edit.action" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${requestScope.labLayout.id}">
            <div class="form-group">
                <label class="control-label">布局标题：</label>
                <input type="text" class="form-control" name="title" value="${requestScope.labLayout.title}" required>
            </div>
            <div class="form-group">
                <label class="control-label">布局图片：</label>
                <img src="lablayout_showImg.action?id=${id}"  width="30" height="30">
                <input type="file" id="img" name="cover">
            </div>
            <s:if test="#session.admin.department.id == 1">
                <div class="form-group">
                    <label class="control-label">所属院系：</label>
                    <select name="departmentId" class="form-control">
                        <s:iterator value="departmentList">
                            <option value="${id}" <s:if test="id == departmentId">selected</s:if>>${name}</option>
                        </s:iterator>
                    </select>
                </div>
            </s:if>
            <div class="form-group">
                <label class="control-label">创建人：</label>
                <input type="text" class="form-control" name="creator" value="${requestScope.labLayout.creator}" required>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改布局信息">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
