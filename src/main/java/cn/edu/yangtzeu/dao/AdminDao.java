package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;

import java.util.List;

public interface AdminDao extends BaseDao<Admin> {

    Admin findUserByNameAndPassword(String id, String password);

    List<Admin> findAllLabAdmin();

    List<Admin> findAllDepartHead();

    List<Admin> findAllLabCollegeHead();

    List<Admin> findAllLabSchoolHead();

    List<Admin> findAllNoAdmin();

    List<Admin> findAllNoRoles(Department department);

    List<Admin> findAllNoRoles();

    List<Admin> findAllWithRoles(Department department);

    List<Admin> findAllWithRoles();

    List<Admin> findAllDepartHead(Department department);

    List<Admin> findAllLabAdmin(Department department);
}
