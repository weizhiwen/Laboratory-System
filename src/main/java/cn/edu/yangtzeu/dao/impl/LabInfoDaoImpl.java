package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.LabInfoDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabInfo;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class LabInfoDaoImpl extends BaseDaoImpl<LabInfo> implements LabInfoDao {
    @Override
    public List<LabInfo> findAll(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<LabInfo> labInfoList = session.createQuery("FROM LabInfo WHERE department = ?")
                .setParameter(0, department)
                .list();
        return labInfoList;
    }
}
