<%--
  Created by IntelliJ IDEA.
  User: weizhiwen
  Date: 2018/5/8
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="http://www.yangtzeu.edu.cn/images/logo_ico.png" />
    <title>开放式实验室管理后台</title>
    <link href="resources/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.6/waves.min.css" rel="stylesheet"/>
    <link href="resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="resources/css/admin.css" rel="stylesheet"/>
</head>
<body>
<header id="header">
    <ul id="menu">
        <li id="guide" class="line-trigger">
            <div class="line-wrap">
                <div class="line top"></div>
                <div class="line center"></div>
                <div class="line bottom"></div>
            </div>
        </li>
        <li id="logo" class="hidden-xs">
            <span id="system_title">开放式实验室管理后台</span>
        </li>
        <li class="pull-right">
            <ul class="hi-menu">
                <li class="dropdown">
                    <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                        <i class="him-icon zmdi zmdi-more-vert"></i>
                    </a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li class="hidden-xs">
                            <a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="admin_logout.action"><i class="zmdi zmdi-run"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</header>
<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img src="resources/images/avatar.jpg"/>
                </div>
                <div class="sp-info">
                    ${sessionScope.admin.name}，您好！
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">
                <li>
                    <a class="waves-effect" href="javascript:Tab.addTab('修改资料', '${pageContext.request.contextPath}/admin_toEdit.action');"><i class="zmdi zmdi-account"></i> 个人资料</a>
                </li>
                </li>
                <li>
                    <a class="waves-effect" href="admin_logout.action"><i class="zmdi zmdi-run"></i> 退出登录</a>
                </li>
            </ul>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu">
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i> 首页</a>
            </li>
            <%--顶级菜单--%>
		    <s:iterator value="#application.topPrivilegeList">
		        <s:if test="%{#session.admin.hasPrivilegeByName(name)}">
		            <li class="sub-menu system_menus">
		                <a class="waves-effect" href="javascript:;"><i class="${icon}"></i>${name}</a>
		                    <%--二级菜单--%>
		                <ul>
		                    <s:iterator value="children">
		                        <s:if test="%{#session.admin.hasPrivilegeByName(name)}">
		                            <li>
		                                <a class="waves-effect" href="javascript:Tab.addTab('${name}', '${pageContext.request.contextPath}/${url}.action');">${name}</a>
		                            </li>
		                        </s:if>
		                    </s:iterator>
		                </ul>
		            </li>
		        </s:if>
		    </s:iterator>
            <li>
                <div class="upms-version">
                    版权所有&copy;长江大学 技术支持：FH 团队
                </div>
            </li>
        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">
        <div class="content_tab" style="background: #29A176;">
            <div class="tab_left">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
            </div>
            <div class="tab_right">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
            </div>
            <ul id="tabs" class="tabs">
                <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                    <a class="waves-effect waves-light">首页</a>
                </li>
            </ul>
        </div>
        <div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <p><h4>开放式实验室管理后台 </h4></p>
                <p><b>系统简介</b>：本系统是基于RBAC模型的权限控制的开放式实验室管理后台 </p><br/>
                <p><h4>系统功能概述：</h4></p>
                <p><b>系统管理</b>：整个系统的核心管理，包括系统角色和分配角色</p><br/>
                <p><b>实验室管理</b>：实验室相关的管理，包括实验室的基本信息，实验室的设备</p><br/>
                <p><b>资源管理</b>：实验资源相关的管理，包括教学资源和优秀学生作品</p><br/>
                <p><b>论坛管理</b>：教学论坛相关的管理，包括论坛中的版块，帖子和评论</p><br/>
                <p><b>人员管理</b>：管理员用户信息管理，包括实验室管理员，系主任，院实验室中心主任和校实验室主任的信息</p><br/>
                <p><h4>系统负责人</h4></p>
                <p><b>姓　　名</b>：魏志文</p>
                <p><b>电话</b>：17639600474</p>
                <p><b>电子邮箱</b>：763107756@qq.com</p>
            </div>
        </div>
    </section>
</section>
<footer id="footer"></footer>

<script src="resources/plugins/jquery-1.12.4/jquery.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="resources/plugins/waves-0.7.6/waves.min.js"></script>
<script src="resources/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="resources/plugins/BootstrapMenu.min.js"></script>
<script src="resources/plugins/device.min.js"></script>
<script src="resources/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="resources/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="resources/js/admin.js"></script>
</body>
</html>