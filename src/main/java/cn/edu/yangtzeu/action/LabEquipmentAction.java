package cn.edu.yangtzeu.action;

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
        List<LabEquipment> labEquipmentList = labEquipmentService.findAll();
        ActionContext.getContext().put("labEquipmentList", labEquipmentList);
        return "list";
    }

    // 转到添加设备
    public String toAdd() {
        List<LabInfo> labInfoList = labInfoService.findAll();
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
        List<LabInfo> labInfoList = labInfoService.findAll();
        ActionContext.getContext().put("labInfoList", labInfoList);
        setLabId(labEquipment.getLabInfo().getId());
        return "toEdit";
    }

    // 修改设备方法
    public String edit() throws IOException {
        if (cover != null) {
            // 将文件转为二进制文件
            model.setImg(FileUtils.readFileToByteArray(cover));
            LabInfo labInfo = labInfoService.findOne(labId);
            model.setLabInfo(labInfo);
            labEquipmentService.update(model);
            return "edit";
        } else {
            int id = model.getId();
            LabEquipment labEquipment = labEquipmentService.findOne(id);
            byte[] b = labEquipment.getImg();
            if (labEquipment != null) {
                labEquipmentService.delete(labEquipment);
            }
            model.setImg(b);
            LabInfo labInfo = labInfoService.findOne(labId);
            model.setLabInfo(labInfo);
            labEquipmentService.add(model);
            return "edit";
        }
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
