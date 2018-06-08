package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.LabEquipmentDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabEquipment;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class LabEquipmentDaoImpl extends BaseDaoImpl<LabEquipment> implements LabEquipmentDao {
    @Override
    public List<LabEquipment> findAll(Department department) {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<LabEquipment> labEquipmentList = session.createQuery("FROM LabEquipment WHERE labInfo.department = ?")
                .setParameter(0, department)
                .list();
        return labEquipmentList;
    }
}
