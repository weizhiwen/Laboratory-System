package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.PrivilegeDao;
import cn.edu.yangtzeu.entity.Privilege;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class PrivilegeService {
    // 对象注入
    private PrivilegeDao privilegeDao;
    public void setPrivilegeDao(PrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;
    }

    public List<Privilege> findTopList() {
        return privilegeDao.findTopList();
    }

    public List<String> findAllPrivilegeUrl() {
        return privilegeDao.findAllPrivilegeUrl();
    }

    public List<Privilege> findSome(Integer[] privilegeIds) {
        return privilegeDao.findSome(privilegeIds);
    }
}
