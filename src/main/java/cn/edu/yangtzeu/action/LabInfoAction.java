package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabInfo;
import cn.edu.yangtzeu.service.DepartmentService;
import cn.edu.yangtzeu.service.LabInfoService;
import cn.edu.yangtzeu.util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class LabInfoAction extends ActionSupport implements ModelDriven<LabInfo> {
    // 模型驱动封装
    private LabInfo model = new LabInfo();

    @Override
    public LabInfo getModel() {
        return model;
    }

    // 对象注入
    private LabInfoService labInfoService;

    public void setLabInfoService(LabInfoService labInfoService) {
        this.labInfoService = labInfoService;
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

    // 实验室列表方法
    public String list() {
        // 按院系划分查询
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<LabInfo> labInfoList;
        if(admin.getDepartment().getId() == 1) {
            labInfoList = labInfoService.findAll();
        } else {
            labInfoList = labInfoService.findAll(admin.getDepartment());
        }
        ActionContext.getContext().put("labInfoList", labInfoList);
        return "list";
    }

    // 转到添加实验室
    public String toAdd() {
        // 准备院系数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toAdd";
    }

    // 添加实验室方法
    public String add() {
        model.setCreateTime(TimeUtil.getCurrentTime());
        // 根据 id 查询院系
        Department department = departmentService.findOne(departmentId);
        model.setDepartment(department);
        labInfoService.add(model);
        return "add";
    }

    // 转到修改实验室
    public String toEdit() {
        // 准备回显数据
        int id = model.getId();
        LabInfo labInfo = labInfoService.findOne(id);
        ActionContext.getContext().put("labInfo", labInfo);
        // 准备院系数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toEdit";
    }

    // 修改实验室方法
    public String edit() {
        // 只能修改可以修改的数据
        LabInfo labInfo = labInfoService.findOne(model.getId());
        labInfo.setTitle(model.getTitle());
        labInfo.setIntroduce(model.getIntroduce());
        labInfo.setLocation(model.getLocation());
        labInfo.setNumber(model.getNumber());
        // 根据 id 查询院系
        Department department = departmentService.findOne(departmentId);
        labInfo.setDepartment(department);
        labInfoService.update(labInfo);
        return "edit";
    }

    // 删除实验室
    public String delete() {
        // 先查询后删除
        int id = model.getId();
        LabInfo labInfo = labInfoService.findOne(id);
        if (labInfo != null) {
            labInfoService.delete(labInfo);
        }
        return "delete";
    }

}
