package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabInfo;

import java.util.List;

public interface LabInfoDao extends BaseDao<LabInfo> {
    List<LabInfo> findAll(Department department);
}
