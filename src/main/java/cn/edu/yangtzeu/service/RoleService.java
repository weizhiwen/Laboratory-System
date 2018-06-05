package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.RoleDao;
import cn.edu.yangtzeu.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class RoleService {
    // 对象注入
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public void add(Role role) {
        roleDao.add(role);
    }

    public Role findOne(Integer id) {
        return roleDao.findOne(id);
    }

    public void delete(Role role) {
        roleDao.delete(role);
    }

    public void update(Role role) {
        roleDao.update(role);
    }

    public List<Role> findSome(Integer[] roleIds) {
        return roleDao.findSome(roleIds);
    }
}
