package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.LabAnnounceDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabAnnounce;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class LabAnnounceDaoImpl extends BaseDaoImpl<LabAnnounce> implements LabAnnounceDao {
	@Override
    public List<LabAnnounce> findAll(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<LabAnnounce> labAnnounceList = session.createQuery("FROM LabAnnounce WHERE department = ?")
                .setParameter(0, department)
                .list();
        return labAnnounceList;
    }	
}
