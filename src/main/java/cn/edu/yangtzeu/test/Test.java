package cn.edu.yangtzeu.test;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class Test {
    @Resource
    private SessionFactory sessionFactory;


    @Transactional
    public void test() {
        Session session = sessionFactory.getCurrentSession();

        // 1.超级管理员
        Admin admin = new Admin();
        admin.setId("admin");
        admin.setName("超级管理员");
        admin.setPassword("admin");
        admin.setIdentity('0');
        admin.setStatus('1');
        Department department = new Department();
        department.setId((short) 1);
        admin.setDepartment(department);
        session.save(admin);
    }

    public static void main(String[] args) {
        System.out.println("正在执行安装...");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Test test = (Test) ac.getBean("test");
        test.test();
        System.out.println("==安装完毕==");
    }
}
