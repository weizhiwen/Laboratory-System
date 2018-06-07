package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.LabLayoutDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabLayout;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class LabLayoutDaoImpl extends BaseDaoImpl<LabLayout> implements LabLayoutDao {

    @Override
    public List<LabLayout> findAll(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<LabLayout> labLayoutList = session.createQuery("FROM LabLayout WHERE department = ?")
                .setParameter(0, department)
                .list();
        return labLayoutList;
    }
}
