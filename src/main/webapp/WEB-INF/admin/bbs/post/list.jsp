<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/13
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>论坛帖子列表</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.6/waves.min.css" rel="stylesheet"/>
    <link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
    <div class="container-fluid">
        <div class="main">
            <div id="toolbar">
                <%--<a class="waves-effect waves-button" href="bbspost_toAdd" ><i class="zmdi zmdi-plus"></i> 新增论坛版块</a>--%>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>帖子序号（倒序）</th>
                        <th>帖子标题</th>
                        <th>所属版块</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="#request.bbsPostList">
                        <tr>
                            <td>${id}</td>
                            <td>${title}</td>
                            <td>${bbsSection.name}</td>
                            <td>${creator}</td>
                            <td>${creatTime}</td>
                            <td>
                                <s:a action="bbspost_delete.action?id=%{id}" onclick="return confirm('确认要删除吗？')"><i class="zmdi zmdi-close"></i> 删除</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
