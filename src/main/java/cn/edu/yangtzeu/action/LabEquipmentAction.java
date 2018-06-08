package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.LabEquipment;
import cn.edu.yangtzeu.entity.LabInfo;
import cn.edu.yangtzeu.service.LabEquipmentService;
import cn.edu.yangtzeu.service.LabInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LabEquipmentAction extends ActionSupport implements ModelDriven<LabEquipment> {
    // 模型驱动封装
    private LabEquipment model = new LabEquipment();

    @Override
    public LabEquipment getModel() {
        return model;
    }

    // 对象注入
    private LabEquipmentService labEquipmentService;

    public void setLabEquipmentService(LabEquipmentService labEquipmentService) {
        this.labEquipmentService = labEquipmentService;
    }

    private LabInfoService labInfoService;

    public void setLabInfoService(LabInfoService labInfoService) {
        this.labInfoService = labInfoService;
    }

    // 属性注入
    private String coverContentType;

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    private File cover;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
        System.out.println("cover");
    }

    private String coverFileName;

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    private int labId;

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        System.out.println(labId);
        this.labId = labId;
    }

    // 设备列表方法
    public String list() {
        // 按院系划分查询
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<LabEquipment> labEquipmentList;
        if(admin.getDepartment().getId() == 1) {
            labEquipmentList = labEquipmentService.findAll();
        } else {
            labEquipmentList = labEquipmentService.findAll(admin.getDepartment());
        }
        ActionContext.getContext().put("labEquipmentList", labEquipmentList);
        return "list";
    }

    // 转到添加设备
    public String toAdd() {
        // 按院系划分查询
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<LabInfo> labInfoList;
        if(admin.getDepartment().getId() == 1) {
            labInfoList = labInfoService.findAll();
        } else {
            labInfoList = labInfoService.findAll(admin.getDepartment());
        }
        ActionContext.getContext().put("labInfoList", labInfoList);
        return "toAdd";
    }

    // 添加设备方法
    public String add() throws IOException {
        if (cover != null) {
            // 将文件转为二进制文件
            model.setImg(FileUtils.readFileToByteArray(cover));
        }
        LabInfo labInfo = labInfoService.findOne(labId);
        model.setLabInfo(labInfo);
        labEquipmentService.add(model);
        return "add";
    }

    // 显示图片的方法
    public String showImg() throws IOException {
        int id = model.getId();
        LabEquipment labEquipment = labEquipmentService.findOne(id);
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream out = response.getOutputStream();
        byte[] b = labEquipment.getImg();
        out.write(b);
        out.flush();
        out.close();
        return NONE;
    }

    // 转到修改设备
    public String toEdit() {
        // 准备回显数据
        int id = model.getId();
        LabEquipment labEquipment = labEquipmentService.findOne(id);
        ActionContext.getContext().put("labEquipment", labEquipment);
        // 按院系查找实验室
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<LabInfo> labInfoList;
        if(admin.getDepartment().getId() == 1) {
            labInfoList = labInfoService.findAll();
        } else {
            labInfoList = labInfoService.findAll(admin.getDepartment());
        }
        ActionContext.getContext().put("labInfoList", labInfoList);
        labId = labEquipment.getLabInfo().getId();
        return "toEdit";
    }

    // 修改设备方法
    public String edit() throws IOException {
        int id = model.getId();
        LabEquipment labEquipment = labEquipmentService.findOne(id);
        // 如果图片被修改了，重新设置图片
        if (cover != null) {
            // 将文件转为二进制文件
            labEquipment.setImg(FileUtils.readFileToByteArray(cover));
        }
        // 设置除图片外的其他属性
        labEquipment.setName(model.getName());
        labEquipment.setStatus(model.getStatus());
        labEquipment.setDescription(model.getDescription());
        // 根据 labId 查询实验室
        LabInfo labInfo = labInfoService.findOne(labId);
        labEquipment.setLabInfo(labInfo);
        labEquipmentService.update(labEquipment);
        return "edit";
    }

    // 删除设备
    public String delete() {
        // 先查询后删除
        int id = model.getId();
        LabEquipment labEquipment = labEquipmentService.findOne(id);
        if (labEquipment != null) {
            labEquipmentService.delete(labEquipment);
        }
        return "delete";
    }

}
