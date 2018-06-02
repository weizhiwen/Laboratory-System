package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.service.AdminService;
import cn.edu.yangtzeu.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class LabSchoolHeadAction extends ActionSupport implements ModelDriven<Admin> {
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
    private RoleService roleService;
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    // 属性注入
    private Integer[] roleIds;
    public Integer[] getRoleIds() {
        return roleIds;
    }
    public void setRoleIds(Integer[] roleIds) {
        this.roleIds = roleIds;
    }

    // 校管理人员列表方法
    public String list() {
        List<Admin> adminList = adminService.findAllLabSchoolHead();
        ActionContext.getContext().put("adminList", adminList);
        return "list";
    }

    // 转到添加校实验室中心主任
    public String toAdd() {
        return "toAdd";
    }

    // 添加校实验室中心主任方法
    public String add() {
        // 设置未填写的字段
        model.setPassword(model.getId());
        model.setIdentity('6');
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
