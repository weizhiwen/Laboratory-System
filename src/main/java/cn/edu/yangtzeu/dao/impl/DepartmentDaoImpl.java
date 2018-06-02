package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.DepartmentDao;
import cn.edu.yangtzeu.entity.Department;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    @Override
    public List<Department> findAllNoSpecial() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<Department> departmentList = session.createQuery("FROM Department WHERE id != ?")
                .setParameter(0, (short)1)
                .list();
        return departmentList;
    }
}
