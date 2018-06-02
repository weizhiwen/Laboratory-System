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
            <div class="table-responsive">
                <p style="font-size: 1.2em; color: #c0392b">新增的管理员，暂未分配角色</p>
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
                    <s:iterator value="#request.adminListNoRoles">
                        <tr>
                            <td>${id}</td>
                            <td>${name}</td>
                            <td>${tel}</td>
                            <td>${email}</td>
                            <td>${department.name}</td>
                            <td>
                                <s:if test="%{identity == '3'}">实验室管理员</s:if>
                                <s:if test="%{identity == '4'}">系主任</s:if>
                                <s:if test="%{identity == '5'}">院实验室中心主任</s:if>
                                <s:if test="%{identity == '6'}">校实验室中心主任</s:if>
                                <s:if test="%{identity == '' || identity == NULL}">没有选择身份</s:if>
                            </td>
                            <td>
                                <s:a action="admin_delete.action?id=%{id}" onclick="return confirm('确认要删除吗？')"><i class="zmdi zmdi-close"></i> 删除</s:a>
                                &nbsp;
                                <s:a action="admin_toSet.action?id=%{id}"><i class="zmdi zmdi-run"></i> 分配角色</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
                <p style="font-size: 1.2em; color: #2e6da4">已分配过角色的管理员</p>
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
                    <s:iterator value="#request.adminListWithRoles">
                        <tr>
                            <td>${id}</td>
                            <td>${name}</td>
                            <td>${tel}</td>
                            <td>${email}</td>
                            <td>${department.name}</td>
                            <td>
                                <s:if test="%{identity == '3'}">实验室管理员</s:if>
                                <s:elseif test="%{identity == '4'}">系主任</s:elseif>
                                <s:elseif test="%{identity == '5'}">院实验室中心主任</s:elseif>
                                <s:elseif test="%{identity == '6'}">校实验室中心主任</s:elseif>
                                <s:else>未设置身份</s:else>
                            </td>
                            <td>
                                <s:a action="admin_delete.action?id=%{id}" onclick="return confirm('确认要删除吗？')"><i class="zmdi zmdi-close"></i> 删除</s:a>
                                &nbsp;
                                <s:a action="admin_toSet.action?id=%{id}"><i class="zmdi zmdi-run"></i> 分配角色</s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
