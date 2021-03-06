<%--
  Created by eclipse.
  User: xzp
  Date: 2018/5/14
  Time: 22.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>资源列表</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.6/waves.min.css" rel="stylesheet"/>
    <link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
    <div class="container-fluid">
        <div class="main">
            <div id="toolbar">
                <a class="waves-effect waves-button" href="resworks_toAdd" ><i class="zmdi zmdi-plus"></i> 新增优秀作品</a>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>作品序号</th>
                        <th>作品名称</th>
                        <th>作品介绍</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="#request.resWorksList">
                        <tr>
                            <td>${id}</td>
                            <td>${name}</td>
                            <td>${description}</td>
                            <td>
                                <s:a action="resworks_delete.action?id=%{id}" onclick="return confirm('确认要删除吗？')"><i class="zmdi zmdi-close"></i> 删除</s:a>
                                &nbsp;
                                <s:a action="resworks_toEdit.action?id=%{id}"><i class="zmdi zmdi-edit"></i> 修改</s:a>&nbsp;
                                <s:a action="resworks_downFile.action?id=%{id}"><i class="zmdi zmdi-edit"></i> 下载</s:a>&nbsp;
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
