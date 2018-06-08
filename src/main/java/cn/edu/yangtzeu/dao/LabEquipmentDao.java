package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabEquipment;

import java.util.List;

public interface LabEquipmentDao extends BaseDao<LabEquipment> {
    List<LabEquipment> findAll(Department department);
}
