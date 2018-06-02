package cn.edu.yangtzeu.listener;

import cn.edu.yangtzeu.entity.Privilege;
import cn.edu.yangtzeu.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class InitServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();

        // 得到 Service 的实例对象
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
        System.out.println("整个web应用启动啦！");
        PrivilegeService privilegeService = (PrivilegeService) applicationContext.getBean("privilegeService");

        // 准备所有顶级的权限集合
        List<Privilege> topPrivilegeList = privilegeService.findTopList();
        application.setAttribute("topPrivilegeList", topPrivilegeList);
        System.out.println("---已准备好顶级权限数据---");

        // 准备所有权限的URL集合
        List<String> privilegeUrlList = privilegeService.findAllPrivilegeUrl();
        application.setAttribute("privilegeUrlList", privilegeUrlList);
        System.out.println(privilegeUrlList);
        System.out.println("---已准备好权限的URL数据---");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("整个web应用关闭啦！");
    }
}
