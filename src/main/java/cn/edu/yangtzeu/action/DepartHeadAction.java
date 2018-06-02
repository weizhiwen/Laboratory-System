package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.service.AdminService;
import cn.edu.yangtzeu.service.DepartmentService;
import cn.edu.yangtzeu.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class DepartHeadAction extends ActionSupport implements ModelDriven<Admin> {
    // 模型驱动封装
    private Admin model = new Admin();
    @Override
    public Admin getModel() {
        return model;
    }

    // 对象注入
    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 属性注入
    private short departmentId;
    public short getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    // 系主任列表方法
    public String list() {
        // 从 session 中取出用户的院系
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<Admin> adminList;
        if(admin.getDepartment().getId() == 1) {
            adminList = adminService.findAllDepartHead();
        } else {
            adminList = adminService.findAllDepartHead(admin.getDepartment());
        }
        ActionContext.getContext().put("adminList", adminList);
        return "list";
    }

    // 转到添加系主任
    public String toAdd() {
        // 准备院系数据
        List<Department> departmentList = departmentService.findAllNoSpecial();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toAdd";
    }

    // 添加系主任方法
    public String add() {
        // 根据 departmentId 查询 院系
        Department department = departmentService.findOne(departmentId);
        // 设置未填写的字段
        model.setPassword(model.getId());
        model.setIdentity('4');
        model.setDepartment(department);
        adminService.add(model);
        return "add";
    }

    // 初始化密码
    public String init(){
        Admin admin = adminService.findOne(model.getId());
        // 只修改密码
        admin.setPassword("123456");
        adminService.update(admin);
        return "init";
    }
}
