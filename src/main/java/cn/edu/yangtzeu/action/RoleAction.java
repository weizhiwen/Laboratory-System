package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Privilege;
import cn.edu.yangtzeu.entity.Role;
import cn.edu.yangtzeu.service.PrivilegeService;
import cn.edu.yangtzeu.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RoleAction extends ActionSupport implements ModelDriven<Role>{
    // 模型驱动封装
    private Role model = new Role();
    @Override
    public Role getModel() {
        return model;
    }

    // 对象注入
    private RoleService roleService;
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    private PrivilegeService privilegeService;
    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    // 属性注入
    private Short[] privilegeIds;

    public Short[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(Short[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }

    // 角色列表方法
    public String list() {
        List<Role> roleList =  roleService.findAll();
        ActionContext.getContext().put("roleList", roleList);
        return "list";
    }

    // 转到添加角色
    public String toAdd() {
        return "toAdd";
    }

    // 添加角色方法
    public String add() {
        roleService.add(model);
        return "add";
    }

    // 转到修改角色
    public String toEdit(){
        // 准备回显数据
        short id = model.getId();
        Role role = roleService.findOne(id);
        ActionContext.getContext().put("role", role);
        return "toEdit";
    }

    // 修改角色方法
    public String edit() {
        roleService.update(model);
        return "edit";
    }

    // 删除角色
    public String delete() {
        // 先查询后删除
        short id = model.getId();
        Role role = roleService.findOne(id);
        if(role != null) {
            roleService.delete(role);
        }
        return "delete";
    }

    // 转到设置权限
    public String toSet() {
        // 准备数据
        short id = model.getId();
        Role role = roleService.findOne(id);
        ActionContext.getContext().put("role", role);
        List<Privilege> topPrivilegeList = privilegeService.findTopList();
        ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);

        // 准备回显数据
        int size = role.getPrivileges().size();
        privilegeIds = new Short[size];
        Collection<Privilege> privileges = role.getPrivileges();
        int index = 0;
        for(Privilege privilege : privileges) {
            privilegeIds[index++] = privilege.getId();
        }
        return "toSet";
    }

    // 给角色设置权限
    public String set() {
        // 查询角色
        Role role = roleService.findOne(model.getId());
        // 设置要修改的属性
        List<Privilege> privilegeList = privilegeService.findSome(privilegeIds);
        role.setPrivileges(new HashSet<Privilege>(privilegeList));
        roleService.update(role);
        return "set";
    }
}
