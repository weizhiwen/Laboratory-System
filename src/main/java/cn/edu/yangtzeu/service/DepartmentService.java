package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.DepartmentDao;
import cn.edu.yangtzeu.entity.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DepartmentService {
    // 对象注入
    private DepartmentDao departmentDao;
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    public Department findOne(int departmentId) {
        return departmentDao.findOne(departmentId);
    }

    public List<Department> findAllNoSpecial() {
        return departmentDao.findAllNoSpecial();
    }
}
