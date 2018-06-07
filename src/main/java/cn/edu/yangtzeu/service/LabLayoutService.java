package cn.edu.yangtzeu.service;

import cn.edu.yangtzeu.dao.LabLayoutDao;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabLayout;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LabLayoutService {
    // 对象注入
    private LabLayoutDao labLayoutDao;

    public void setLabLayoutDao(LabLayoutDao labLayoutDao) {
        this.labLayoutDao = labLayoutDao;
    }

    public List<LabLayout> findAll() {
        return labLayoutDao.findAll();
    }

    public List<LabLayout> findAll(Department department) {
        return labLayoutDao.findAll(department);
    }

    public void add(LabLayout labLayout) {
        labLayoutDao.add(labLayout);
    }

    public LabLayout findOne(int id) {
        return labLayoutDao.findOne(id);
    }

    public void delete(LabLayout labLayout) {
        labLayoutDao.delete(labLayout);
    }

    public void update(LabLayout labLayout) {
        labLayoutDao.update(labLayout);
    }
}
