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
    <title>修改设备</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="labequipment_edit.action" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${requestScope.labEquipment.id}">
            <div class="form-group">
                <label class="control-label">设备名称：</label>
                <input type="text" class="form-control" name="name" value="${requestScope.labEquipment.name}" required>
            </div>
            <div class="form-group">
                <label class="control-label">设备状态：</label>
                <select name="status" class="form-control" required>
                    <option value="正常工作" <s:if test='#request.labEquipment.status == "正常工作"'>selected</s:if>>正常工作</option>
                    <option value="缺失" <s:if test='#request.labEquipment.status == "缺失"'>selected</s:if>>缺失</option>
                    <option value="损坏" <s:if test='#request.labEquipment.status == "损坏"'>selected</s:if>>损坏</option>
                    <option value="需要维护" <s:if test='#request.labEquipment.status == "需要维护"'>selected</s:if>>需要维护</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">设备介绍：</label>
                <input type="text" class="form-control" name="description" value="${requestScope.labEquipment.description}" required>
            </div>
            <div class="form-group">
                <label class="control-label">设备图片：</label>
                <img src="labequipment_showImg.action?id=${id}"  width="30" height="30">
                <input type="file" id="img" name="cover" >
            </div>
            <div class="form-group">
                <label class="control-label">设备所在实验室：</label>
                <select class="form-control" name="labId">
                    <s:iterator value="#labInfoList">
                        <option value="${id}" <s:if test="%{id == labId}">selected</s:if>>${title}</option>
                    </s:iterator>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">录入时间：</label>
                <input type="date" class="form-control" name="inTime" value="${requestScope.labEquipment.inTime}" required>
            </div>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="修改实验室信息">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
