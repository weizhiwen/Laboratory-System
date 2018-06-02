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
    <title>管理员列表</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.6/waves.min.css" rel="stylesheet"/>
    <link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
    <div class="container-fluid">
        <div class="main">
            <div id="toolbar">
                <a class="waves-effect waves-button" href="labadmin_toAdd.action" ><i class="zmdi zmdi-plus"></i> 新增实验室管理员</a>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>邮箱</th>
                        <th>院系</th>
                        <th>身份</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="#request.adminList">
                        <tr>
                            <td>${id}</td>
                            <td>${name}</td>
                            <td>${tel}</td>
                            <td>${email}</td>
                            <td>${department.name}</td>
                            <td>
                                实验室管理员
                            <td>
                                <s:a action="labadmin_init.action?id=%{id}" onclick="return confirm('确认要初始化密码吗？')"><i class="zmdi zmdi-lock-open"></i> 初始化密码</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
