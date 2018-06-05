package cn.edu.yangtzeu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 实验室信息实体类
 *
 * @param id           实验室序号
 * @param title        实验室名称
 * @param introduce    实验室介绍
 * @param location     实验室位置
 * @param number     容纳人数
 * @param creator      创建人
 * @param createTime   创建时间
 * @param labEquipment 实验室所拥有的设备
 * @param department   设备所属院系
 * @author 解智鹏
 */
public class LabInfo {
    private int id;
    private String title;
    private String introduce;
    private String location;
    private int number;
    private String creator;
    private String createTime;

    // 实体类中的对象
    private Department department;
    private Set<LabEquipment> labEquipment = new HashSet<LabEquipment>();

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Set<LabEquipment> getLabEquipment() {
        return labEquipment;
    }

    public void setLabEquipment(Set<LabEquipment> labEquipment) {
        this.labEquipment = labEquipment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
