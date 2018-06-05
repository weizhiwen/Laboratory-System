package cn.edu.yangtzeu.entity;

import com.opensymphony.xwork2.ActionContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 管理员实体类
 *
 * @param id         登录号
 * @param name       登录名
 * @param password   登录密码
 * @param tel        电话号码
 * @param email      邮箱
 * @param identity   管理员身份
 * @param status     帐号状态
 * @param department 所属的院系
 * @param roles      所拥有角色
 * @author 魏志文
 */
public class Admin {
    private String id;
    private String name;
    private String password;
    private String tel;
    private String email;
    private char identity;
    private char status;

    // 实体中的对象
    private Department department;
    private Set<Role> roles = new HashSet<Role>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getIdentity() {
        return identity;
    }

    public void setIdentity(char identity) {
        this.identity = identity;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * 判断管理员是否有权限访问该 url
     *
     * @param privilegeUrl
     * @return
     */
    public boolean hasPrivilegeByUrl(String privilegeUrl) {
        // 超级管理员直接跳过
        if (isAdmin()) {
            return true;
        }
        // url 中有 to，先去掉 to，并将剩下的字符串首字母大小写转换，得到相应的权限名（admin_add 权限和 admin_toAdd 权限认为时同一个权限）
        if (privilegeUrl.contains("to")) {
            int pos = privilegeUrl.indexOf("_");
            String preStr = privilegeUrl.substring(0, pos + 1);
            String aftStr = privilegeUrl.substring(pos + 3);
            aftStr = aftStr.substring(0, 1).toLowerCase().concat(aftStr.substring(1)); // 将剩下字符串大写字母转为小写
            privilegeUrl = preStr + aftStr;
            System.out.println("url转换后为：" + privilegeUrl);
        }
        // 有权限则返回 true
        List<String> allPrivilegeUrls = (List<String>) ActionContext.getContext().getApplication().get("privilegeUrlList");
        // 如果权限表中未包含的 url，则说明此 url 不做权限验证，否则要验证后才可以使用权限
        if (!allPrivilegeUrls.contains(privilegeUrl)) {
            return true;
        } else {
            for (Role role : roles) {
                for (Privilege privilege : role.getPrivileges()) {
                    if (privilegeUrl.equals(privilege.getUrl())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 根据 id 判断是否是超级管理员
     *
     * @return
     */
    private boolean isAdmin() {
        return "admin".equals(id);
    }


    public boolean hasPrivilegeByName(String privilegeName) {
        // 超级管理员直接跳过
        if (isAdmin()) {
            return true;
        }
        // 普通用户有权限返回 true
        for (Role role : roles) {
            for (Privilege privilege : role.getPrivileges()) {
                if (privilege.getName().equals(privilegeName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
