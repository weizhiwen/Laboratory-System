package cn.edu.yangtzeu.entity;

/**
 * 实验室布局实体类
 *
 * @param id         实验室布局序号
 * @param title      布局标题
 * @param img        布局图片
 * @param creator    创建人
 * @param createTime 创建时间
 * @author 解智鹏
 */
public class LabLayout {
    private int id;
    private String title;
    private byte[] img;
    private String creator;
    private String createTime;

    // 实体类中的对象
    private Department department;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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
