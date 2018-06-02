package cn.edu.yangtzeu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * @author 魏志文
 * @param id 院系序号
 * @param name 院系名称
 * @param admins 院系下的管理人员
 */
public class Department {
    private short id;
    private String name;

    // 实体中的对象
    private Set<Admin> admins = new HashSet<Admin>();

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

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }
}
