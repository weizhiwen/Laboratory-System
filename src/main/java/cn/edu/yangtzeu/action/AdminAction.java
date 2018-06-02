package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.Role;
import cn.edu.yangtzeu.service.AdminService;
import cn.edu.yangtzeu.service.DepartmentService;
import cn.edu.yangtzeu.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
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
    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 属性注入
    private String oldPassword;
    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    private Short[] roleIds;

    public Short[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Short[] roleIds) {
        this.roleIds = roleIds;
    }

    // 转到登录页面
    public String toLogin() {
        return "toLogin";
    }


    // 登录方法
    public String login() {
        Admin admin = adminService.findUserByNameAndPassword(model.getId(), model.getPassword());
        if(admin == null) {
            addFieldError("login", "用户或密码不正确");
            return "toLogin";
        }else {
            ActionContext.getContext().getSession().put("admin", admin); // 存放到 session 中
            return "login";
        }
    }

    // 注销方法
    public String logout() {
        ActionContext.getContext().getSession().remove("admin");
        return "logout";
    }

    // 转到个人页面
    public String toEdit() {
        // 准备个人数据
        Admin a = (Admin) ActionContext.getContext().getSession().get("admin");
        Admin admin = adminService.findOne(a.getId());
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("admin", admin);
        return "toEdit";
    }

    // 修改方法
    public String edit() {
        // 表单中有不可修改的数据，所以要先把原来的数据查询出来
        Admin admin = adminService.findOne(model.getId());
        // 重新根据表单中的值设置可以修改的数据
        admin.setName(model.getName());
        admin.setTel(model.getTel());
        admin.setEmail(model.getEmail());
        // 提交修改
        adminService.update(admin);
        return "edit";
    }

    // 转到修改密码
    public String toEditPassword() {
        return "toEditPassword";
    }

    // 修改密码的方法
    public String editPassword() {
        // 表单中有不可修改的数据，所以要先把原来的数据查询出来
        Admin admin = adminService.findOne(model.getId());
        String password = admin.getPassword();
        // 验证旧密码
        if(!password.equals(oldPassword)) {
            addFieldError("editPassword", "原密码错误！");
            return "toEditPassword";
        }
        // 重新根据表单中的值设置可以修改的数据
        admin.setPassword(model.getPassword());
        // 提交修改
        adminService.update(admin);
        return "editPassword";
    }

    // 查询管理员用户的方法，分为未分配角色的用户和有角色的用户列表
    public String list() {
        // 从 session 中取出用户的院系
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        // 用户按院系划分，即院系主任只能看到自己院系的管理人员，而不属于任何院系的人员，如校实验室管理员，超级管理员则可以看到全校的管理人员
        List<Admin> adminListNoRoles; // 未分配角色用户
        List<Admin> adminListWithRoles; // 已分配角色用户
        if(admin.getDepartment().getId() == 1) {
            adminListNoRoles = adminService.findAllNoRoles();
            adminListWithRoles = adminService.findAllWithRoles();
        } else {
            adminListNoRoles = adminService.findAllNoRoles(admin.getDepartment());
            adminListWithRoles = adminService.findAllWithRoles(admin.getDepartment());
        }
        ActionContext.getContext().put("adminListNoRoles", adminListNoRoles);
        ActionContext.getContext().put("adminListWithRoles", adminListWithRoles);
        return "list";
    }

    // 删除管理员用户的方法
    public String delete() {
        // 先查询后删除
        String id = model.getId();
        Admin admin = adminService.findOne(id);
        if(admin != null) {
            adminService.delete(admin);
        }
        return "delete";
    }

    // 转到给用户设置角色页面
    public String toSet() {
        // 准备用户角色数据，只能设置自己角色范围内的角色
        Admin a = (Admin) ActionContext.getContext().getSession().get("admin");
        // 超级管理员拥有所有权限，也即是拥有所有角色
        List<Role> roleList;
        if(a.getIdentity() == '0') {
             roleList = roleService.findAll();
        } else {
            roleList = new ArrayList<Role>(a.getRoles());
        }
        ActionContext.getContext().put("roleList", roleList);

        // 准备回显数据
        Admin admin = adminService.findOne(model.getId());
        ActionContext.getContext().put("admin", admin);
        int size = admin.getRoles().size();
        roleIds = new Short[size];
        Collection<Role> roles = admin.getRoles();
        int index = 0;
        for(Role role : roles) {
            roleIds[index++] = role.getId();
        }
        return "toSet";
    }

    // 给用户设置角色的方法
    public String set() {
        // 查询用户
        Admin admin = adminService.findOne(model.getId());
        // 只设置用户的角色
        List<Role> roleList = roleService.findSome(roleIds);
        admin.setRoles(new HashSet<Role>(roleList));
        // 设置用户的帐号状态为可用角色
        admin.setStatus('1');
        adminService.update(admin);
        return "set";
    }
}
