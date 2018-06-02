package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.AdminDao;
import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.Collections;
import java.util.List;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
    @Override
    public Admin findUserByNameAndPassword(String id, String password) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Admin admin = (Admin) session.createQuery("FROM Admin WHERE id = ? AND password = ?")
                .setParameter(0, id)
                .setParameter(1, password)
                .uniqueResult();
        return admin;
    }

    @Override
    public List<Admin> findAllLabAdmin() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ?")
                .setParameter(0, '3')
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllLabAdmin(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ? AND department = ?")
                .setParameter(0, '3')
                .setParameter(1, department)
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllDepartHead() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ?")
                .setParameter(0, '4')
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllDepartHead(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ? AND department = ?")
                .setParameter(0, '4')
                .setParameter(1, department)
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllLabCollegeHead() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ?")
                .setParameter(0, '5')
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllLabSchoolHead() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE identity = ?")
                .setParameter(0, '6')
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllNoAdmin() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE id != ?")
                .setParameter(0, "admin")
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllNoRoles(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE status != '1' AND department = ? AND id != ?")
                .setParameter(0, department)
                .setParameter(1, "admin")
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllNoRoles() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE status != '1' AND id != ?")
                .setParameter(0, "admin")
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllWithRoles(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE status = ? AND department = ? AND id != ?")
                .setParameter(0, '1')
                .setParameter(1, department)
                .setParameter(2, "admin")
                .list();
        return adminList;
    }

    @Override
    public List<Admin> findAllWithRoles() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Admin> adminList = session.createQuery("FROM Admin WHERE status = ? AND id != ?")
                .setParameter(0, '1')
                .setParameter(1, "admin")
                .list();
        return adminList;
    }

}
