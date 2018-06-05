package cn.edu.yangtzeu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 *
 * @param id     院系序号
 * @param name   院系名称
 * @param admins 院系下的管理人员
 * @param labInfos 院系下的实验室信息
 * @param labAnnounces 院系下的实验室公告
 * @param labLayouts 院系下的实验室布局图
 * @param labEquipments 院系下的实验室设备
 * @author 魏志文
 */
public class Department {
    private int id;
    private String name;

    // 实体中的对象
    private Set<Admin> admins = new HashSet<Admin>();
    private Set<LabInfo> labInfos = new HashSet<LabInfo>();
    private Set<LabAnnounce> labAnnounces = new HashSet<LabAnnounce>();
    private Set<LabLayout> labLayouts = new HashSet<LabLayout>();
    private Set<LabEquipment> labEquipments = new HashSet<LabEquipment>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<LabInfo> getLabInfos() {
        return labInfos;
    }

    public void setLabInfos(Set<LabInfo> labInfos) {
        this.labInfos = labInfos;
    }

    public Set<LabAnnounce> getLabAnnounces() {
        return labAnnounces;
    }

    public void setLabAnnounces(Set<LabAnnounce> labAnnounces) {
        this.labAnnounces = labAnnounces;
    }

    public Set<LabLayout> getLabLayouts() {
        return labLayouts;
    }

    public void setLabLayouts(Set<LabLayout> labLayouts) {
        this.labLayouts = labLayouts;
    }

    public Set<LabEquipment> getLabEquipments() {
        return labEquipments;
    }

    public void setLabEquipments(Set<LabEquipment> labEquipments) {
        this.labEquipments = labEquipments;
    }
}
