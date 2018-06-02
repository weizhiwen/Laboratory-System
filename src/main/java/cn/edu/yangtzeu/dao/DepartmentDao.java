package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Department;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department>{
    List<Department> findAllNoSpecial();
}
