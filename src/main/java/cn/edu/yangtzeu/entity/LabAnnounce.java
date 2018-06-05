package cn.edu.yangtzeu.entity;

/**
 * 实验室公告实体类
 *
 * @param id         实验室公告序号
 * @param content    实验室公告内容
 * @param creator    创建人
 * @param createTime 创建时间
 * @param department 院系
 * @author 解智鹏
 */
public class LabAnnounce {
    private int id;
    private String content;
    private String creator;
    private String createTime;

    // 实体中的对象
    private Department department;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
