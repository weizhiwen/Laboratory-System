package cn.edu.yangtzeu.dao.impl;

import cn.edu.yangtzeu.dao.PrivilegeDao;
import cn.edu.yangtzeu.entity.Privilege;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

    @Override
    public List<Privilege> findTopList() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        List<Privilege> privilegeList = (List<Privilege>) hibernateTemplate.find("FROM Privilege WHERE parent IS NULL");
        return privilegeList;
    }

    @Override
    public List<String> findAllPrivilegeUrl() {
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        List<String> privilegeUrlList = session.createQuery("SELECT DISTINCT url FROM Privilege WHERE url IS NOT NULL").list();
        return privilegeUrlList;
    }
}
