package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabLayout;

import java.util.List;

public interface LabLayoutDao extends BaseDao<LabLayout> {
    List<LabLayout> findAll(Department department);
}
