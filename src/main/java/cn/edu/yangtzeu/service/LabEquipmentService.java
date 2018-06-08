package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.LabEquipmentDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabEquipment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LabEquipmentService {
    // 对象注入
    private LabEquipmentDao labEquipmentDao;

    public void setLabEquipmentDao(LabEquipmentDao labEquipmentDao) {
        this.labEquipmentDao = labEquipmentDao;
    }

    public List<LabEquipment> findAll() {
        return labEquipmentDao.findAll();
    }

    public List<LabEquipment> findAll(Department department) {
        return labEquipmentDao.findAll(department);
    }
    public void add(LabEquipment labEquipment) {
        labEquipmentDao.add(labEquipment);
    }

    public LabEquipment findOne(int id) {
        return labEquipmentDao.findOne(id);
    }

    public void delete(LabEquipment labEquipment) {
        labEquipmentDao.delete(labEquipment);
    }

    public void update(LabEquipment labEquipment) {
        labEquipmentDao.update(labEquipment);
    }

}
