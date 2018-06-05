package cn.edu.yangtzeu.action;


import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabAnnounce;
import cn.edu.yangtzeu.service.DepartmentService;
import cn.edu.yangtzeu.service.LabAnnounceService;
import cn.edu.yangtzeu.util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class LabAnnounceAction extends ActionSupport implements ModelDriven<LabAnnounce> {
    // 模型驱动封装
    private LabAnnounce model = new LabAnnounce();

    @Override
    public LabAnnounce getModel() {
        return model;
    }

    // 对象注入
    private LabAnnounceService labAnnounceService;

    public void setLabAnnounceService(LabAnnounceService labAnnounceService) {
        this.labAnnounceService = labAnnounceService;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 属性注入
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // 公告列表方法
    public String list() {
        List<LabAnnounce> labAnnounceList = labAnnounceService.findAll();
        ActionContext.getContext().put("labAnnounceList", labAnnounceList);
        return "list";
    }

    // 转到添加公告
    public String toAdd() {
        // 准备院系数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toAdd";
    }

    // 添加公告方法
    public String add() {
        model.setCreateTime(TimeUtil.getCurrentTime());
        // 根据 id 查询院系
        Department department = departmentService.findOne(departmentId);
        model.setDepartment(department);
        labAnnounceService.add(model);
        return "add";
    }

    // 转到修改公告
    public String toEdit() {
        // 准备回显数据
        int id = model.getId();
        LabAnnounce labAnnounce = labAnnounceService.findOne(id);
        ActionContext.getContext().put("labAnnounce", labAnnounce);
        return "toEdit";
    }

    // 修改公告方法
    public String edit() {
        // 只修改可以修改的内容
        LabAnnounce labAnnounce = labAnnounceService.findOne(model.getId());
        labAnnounce.setContent(model.getContent());
        labAnnounceService.update(labAnnounce);
        return "edit";
    }

    // 删除公告
    public String delete() {
        // 先查询后删除
        int id = model.getId();
        LabAnnounce labAnnounce = labAnnounceService.findOne(id);
        if (labAnnounce != null) {
            labAnnounceService.delete(labAnnounce);
        }
        return "delete";
    }

}
