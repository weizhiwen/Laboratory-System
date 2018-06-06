package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.LabAnnounceDao;
import cn.edu.yangtzeu.entity.LabAnnounce;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.yangtzeu.entity.Department;

import java.util.List;

@Transactional
public class LabAnnounceService {
    // 对象注入
    private LabAnnounceDao labAnnounceDao;

    public void setLabAnnounceDao(LabAnnounceDao labAnnounceDao) {
        this.labAnnounceDao = labAnnounceDao;
    }

    public List<LabAnnounce> findAll() {
        return labAnnounceDao.findAll();
    }

    public List<LabAnnounce> findAll(Department department) {
        return labAnnounceDao.findAll(department);
    }

    public void add(LabAnnounce announce) {
        labAnnounceDao.add(announce);
    }

    public LabAnnounce findOne(int id) {
        return labAnnounceDao.findOne(id);
    }

    public void delete(LabAnnounce labAnnounce) {
        labAnnounceDao.delete(labAnnounce);
    }

    public void update(LabAnnounce labAnnounce) {
        labAnnounceDao.update(labAnnounce);
    }
}
