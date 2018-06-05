package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.LabInfoDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LabInfoService {
    // 对象注入
    private LabInfoDao labInfoDao;

    public void setLabInfoDao(LabInfoDao labInfoDao) {
        this.labInfoDao = labInfoDao;
    }

    public List<LabInfo> findAll() {
        return labInfoDao.findAll();
    }

    public List<LabInfo> findAll(Department department) {
        return labInfoDao.findAll(department);
    }

    public void add(LabInfo labInfo) {
        labInfoDao.add(labInfo);
    }

    public LabInfo findOne(int id) {
        return labInfoDao.findOne(id);
    }

    public void delete(LabInfo labInfo) {
        labInfoDao.delete(labInfo);
    }

    public void update(LabInfo labInfo) {
        labInfoDao.update(labInfo);
    }

}
