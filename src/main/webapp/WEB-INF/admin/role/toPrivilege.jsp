<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/13
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>设置权限</title>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/treeview/treeview.css" rel="stylesheet"/>
    <script src="resources/plugins/treeview/jquery.min.js"></script>
    <script src="resources/plugins/treeview/treeview.js"></script>
    <script type="text/javascript">
        $(function(){
            // 给所有的权限复选框添加事件
            $("[name=privilegeIds]").click(function(){

                // 自己选中或取消时，把所有的下级权限也都同时选中或取消
                $(this).siblings("ul").find("input").attr("checked", this.checked);

                // 当选中一个权限时，也要同时选中所有的直系上级权限
                if(this.checked){
                    $(this).parents("li").children("input").attr("checked", true);
                }
                // 当取消一个权限时，同级没有选中的权限了，就也取消他的上级权限，再向上也这样做。
                else{
                    if( $(this).parent().siblings("li").children("input:checked").size() == 0 ){
                        $(this).parent().parent().siblings("input").attr("checked", false);

                        var start = $(this).parent().parent();
                        if( start.parent().siblings("li").children("input:checked").size() == 0 ){
                            start.parent().parent().siblings("input").attr("checked", false);
                        }
                    }
                }
            });

        });
    </script>
</head>
<body>
    <div class="container-fluid">
    <p style="font-size: 1.2em;">为 <strong style="color: #2c3e50">${requestScope.role.name}</strong> 设置权限<br></p>
        <form action="role_set.action">
            <input type="hidden" name="id" value="${requestScope.role.id}">
            <ul id="root" class="treeview">
                <%-- 第一级 --%>
                <s:iterator value="#topPrivilegeList">
                    <li>
                        <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                        <label for="cb_${id}"><span class="folder">${name}</span></label>
                        <ul>
                                <%-- 第二级 --%>
                            <s:iterator value="children">
                                <li>
                                    <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                                    <label for="cb_${id}"><span class="folder">${name}</span></label>
                                    <ul>
                                            <%-- 第三级 --%>
                                        <s:iterator value="children">
                                            <li>
                                                <input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/> >
                                                <label for="cb_${id}"><span class="folder">${name}</span></label>
                                            </li>
                                        </s:iterator>
                                    </ul>
                                </li>
                            </s:iterator>
                        </ul>
                    </li>
                </s:iterator>
            </ul>
            <script type="text/javascript">
                $("#root").treeview();
            </script>
            <div class="form-inline">
                <input type="submit" class="btn btn-primary" value="确认分配">
                <a class="btn btn-primary" href="javascript:history.go(-1);">返回</a>
            </div>
        </form>
    </div>
</body>
</html>
