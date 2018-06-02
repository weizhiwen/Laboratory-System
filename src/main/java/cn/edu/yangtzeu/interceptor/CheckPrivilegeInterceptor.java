package cn.edu.yangtzeu.interceptor;

import cn.edu.yangtzeu.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        // 获取当前用户
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        // 获取当前访问的URL，去掉当前应用程序的前缀（即 namespace + actionName）
        String namespace = actionInvocation.getProxy().getNamespace();
        System.out.println("---namespace---"+namespace);
        String actionName = actionInvocation.getProxy().getActionName();
        System.out.println("---action---"+actionName);
        String privilegeUrl = null;
        if(namespace.endsWith("/")) {
            privilegeUrl = namespace + actionName;
        }else {
            privilegeUrl = namespace + "/" + actionName;
        }

        // 要去掉开头的 "/"
        if(privilegeUrl.startsWith("/")) {
            privilegeUrl = privilegeUrl.substring(1);
        }

        // 如果未登录用户
        if(admin == null) {
            if(privilegeUrl.startsWith("admin_toLogin") || privilegeUrl.startsWith("admin_login")) {
                // 正在使用登录功能
                return actionInvocation.invoke();
            }else {
                return "toLogin"; // 全局配置的 action
            }
        } else {
            if(admin.hasPrivilegeByUrl(privilegeUrl)) {
                return actionInvocation.invoke(); // 放行
            } else {
                return "noPrivilege"; // 全局配置的 action
            }
        }
    }
}
