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
    <title>添加作品</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="col-lg-4 col-md-6 col-sm-8 col-xm-12">
        <form class="form-horizontal" action="resworks_add.action" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label">作品名称：</label>
                <input type="text" class="form-control" name="name" placeholder="请输入上传文件名称(如 hello.txt)" required>
            </div>
            <div class="form-group">
                <label class="control-label">作品介绍：</label>
                <input type="text" class="form-control" name="description" required>
            </div>
            <div class="form-group">
                <label class="control-label">上传作品：</label>
                <input type="file" class="form-control" name="file" required>
            </div>
        
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="添加作品">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
