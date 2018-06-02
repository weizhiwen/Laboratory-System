package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.AdminDao;
import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AdminService {
    // 对象注入
    private AdminDao adminDao;
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin findUserByNameAndPassword(String id, String password) {
        return adminDao.findUserByNameAndPassword(id, password);
    }

    public void update(Admin admin) {
        adminDao.update(admin);
    }

    public Admin findOne(String id) {
        return adminDao.findOne(id);
    }

    public List<Admin> findAllLabAdmin() {
        return adminDao.findAllLabAdmin();
    }

    public List<Admin> findAllLabAdmin(Department department) {
        return adminDao.findAllLabAdmin(department);
    }

    public List<Admin> findAllDepartHead() {
        return adminDao.findAllDepartHead();
    }

    public List<Admin> findAllDepartHead(Department department) {
        return adminDao.findAllDepartHead(department);
    }
    public List<Admin> findAllLabCollegeHead() {
        return adminDao.findAllLabCollegeHead();
    }

    public List<Admin> findAllLabSchoolHead() {
        return adminDao.findAllLabSchoolHead();
    }

    public void add(Admin admin) {
        adminDao.add(admin);
    }

    public List<Admin> findAllNoAdmin() {
        return adminDao.findAllNoAdmin();
    }

    public List<Admin> findAllNoRoles(Department department) {
        return adminDao.findAllNoRoles(department);
    }
    public List<Admin> findAllNoRoles() {
        return adminDao.findAllNoRoles();
    }
    public List<Admin> findAllWithRoles(Department department) {
        return adminDao.findAllWithRoles(department);
    }
    public List<Admin> findAllWithRoles() {
        return adminDao.findAllWithRoles();
    }
    public void delete(Admin admin) {
        adminDao.delete(admin);
    }


}
