package cn.edu.yangtzeu.entity;

/**
 * 实验室设备实体类
 *
 * @param id          实验室设备序号
 * @param name        设备名称
 * @param status      设备状态
 * @param description 设备介绍
 * @param img         设备图片
 * @param inTime      设备录入时间
 * @param labInfo     设备所在实验室
 * @author 解智鹏
 */
public class LabEquipment {
    private int id;
    private String name;
    private String status;
    private String description;
    private byte[] img;
    private String inTime;

    // 实体类中的对象
    private LabInfo labInfo;

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }


    public LabInfo getLabInfo() {
        return labInfo;
    }

    public void setLabInfo(LabInfo labInfo) {
        this.labInfo = labInfo;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
