package cn.edu.yangtzeu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 魏志文
 * @param id 权限序号
 * @param name 权限名
 * @param url 权限url
 * @param icon 菜单图标
 * @param parent 父级权限
 * @param children 下级权限
 * @param roles 所属角色
 */
public class Privilege {
    private short id;
    private String name;
    private String url;
    private String icon;

    // 实体中的对象
    private Privilege parent;
    private Set<Privilege> children = new HashSet<Privilege>();
    private Set<Role> roles = new HashSet<Role>();

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Privilege getParent() {
        return parent;
    }

    public void setParent(Privilege parent) {
        this.parent = parent;
    }

    public Set<Privilege> getChildren() {
        return children;
    }

    public void setChildren(Set<Privilege> children) {
        this.children = children;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
