package cn.edu.yangtzeu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * @author 魏志文
 * @param id 登录号
 * @param name 登录名
 * @param password 登录密码
 * @param tel 电话号码
 * @param email 邮箱
 * @param identity 管理员身份
 * @param status 帐号状态
 * @param department 所属的院系
 * @param roles 所拥有角色
 */
public class Admin {
    private char[] id;
    private String name;
    private String password;
    private char[] tel;
    private String email;
    private char[] identity;
    private char[] status;

    // 实体中的对象
    private Department department;
    private Set<Role> roles = new HashSet<Role>();

    public char[] getId() {
        return id;
    }

    public void setId(char[] id) {
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

    public char[] getTel() {
        return tel;
    }

    public void setTel(char[] tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getIdentity() {
        return identity;
    }

    public void setIdentity(char[] identity) {
        this.identity = identity;
    }

    public char[] getStatus() {
        return status;
    }

    public void setStatus(char[] status) {
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
}
