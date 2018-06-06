package cn.edu.yangtzeu.dao;

import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabAnnounce;

import java.util.List;

public interface LabAnnounceDao extends BaseDao<LabAnnounce> {
	List<LabAnnounce> findAll(Department department);
}
