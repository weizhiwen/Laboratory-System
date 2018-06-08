package cn.edu.yangtzeu.action;

import cn.edu.yangtzeu.entity.Admin;
import cn.edu.yangtzeu.entity.Department;
import cn.edu.yangtzeu.entity.LabLayout;
import cn.edu.yangtzeu.service.DepartmentService;
import cn.edu.yangtzeu.service.LabLayoutService;
import cn.edu.yangtzeu.util.TimeUtil;
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

public class LabLayoutAction extends ActionSupport implements ModelDriven<LabLayout> {
    // 模型驱动封装
    private LabLayout model = new LabLayout();

    @Override
    public LabLayout getModel() {
        return model;
    }

    // 对象注入
    private LabLayoutService labLayoutService;

    public void setLabLayoutService(LabLayoutService labLayoutService) {
        this.labLayoutService = labLayoutService;
    }

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 属性注入
    private File cover;
    private String coverFileName;
    private String coverContentType;

    private int departmentId;

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // 布局列表方法
    public String list() {
        /// 按院系划分查询
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        List<LabLayout> labLayoutList;
        if(admin.getDepartment().getId() == 1) {
            labLayoutList = labLayoutService.findAll();
        } else {
            labLayoutList = labLayoutService.findAll(admin.getDepartment());
        }
        ActionContext.getContext().put("labLayoutList", labLayoutList);
        return "list";
    }

    // 转到添加实验室布局
    public String toAdd() {
        // 准备院系数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toAdd";
    }

    // 添加布局方法
    public String add() throws IOException {
        if (cover != null) {
            // 将文件转为二进制文件
            model.setImg(FileUtils.readFileToByteArray(cover));
        }
        model.setCreateTime(TimeUtil.getCurrentTime());
        // 根据 id 查询院系
        Department department = departmentService.findOne(departmentId);
        model.setDepartment(department);
        labLayoutService.add(model);
        return "add";
    }

    // 显示图片的方法
    public String showImg() throws IOException {
        int id = model.getId();
        LabLayout labLayout = labLayoutService.findOne(id);
        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream out = response.getOutputStream();
        byte[] b = labLayout.getImg();
        out.write(b);
        out.flush();
        out.close();
        return NONE;
    }

    // 转到修改布局
    public String toEdit() {
        // 准备回显数据
        int id = model.getId();
        LabLayout labLayout = labLayoutService.findOne(id);
        departmentId = labLayout.getDepartment().getId();
        ActionContext.getContext().put("labLayout", labLayout);
        // 准备院系数据
        List<Department> departmentList = departmentService.findAll();
        ActionContext.getContext().put("departmentList", departmentList);
        return "toEdit";
    }

    // 修改布局方法
    public String edit() throws IOException {
        int id = model.getId();
        LabLayout labLayout = labLayoutService.findOne(id);
        // 如果图片被修改了，重新设置图片
        if (cover != null) {
            labLayout.setImg(FileUtils.readFileToByteArray(cover));
        }
        // 设置除图片外的其他属性值
        labLayout.setTitle(model.getTitle());
        labLayout.setCreator(model.getCreator());
        labLayout.setCreateTime(TimeUtil.getCurrentTime());
        Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
        // 不属于任何院系的人员可以重新设置院系
        if(admin.getDepartment().getId() == 1) {
            // 根据 id 查询院系
            Department department = departmentService.findOne(departmentId);
            labLayout.setDepartment(department);
        }
        labLayoutService.update(labLayout);
        return "edit";
    }

    // 删除布局
    public String delete() {
        // 先查询后删除
        int id = model.getId();
        LabLayout labLayout = labLayoutService.findOne(id);
        if (labLayout != null) {
            labLayoutService.delete(labLayout);
        }
        return "delete";
    }


}
