package cn.edu.upc.yb.integrate.material.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.material.model.BorrowMaterial;
import cn.edu.upc.yb.integrate.material.model.Material;
import cn.edu.upc.yb.integrate.material.repository.BorrowMaterialRepository;
import cn.edu.upc.yb.integrate.material.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

/**
 * Created by wanghaojun on 2017/2/10.
 */
@RestController
@RequestMapping(value = "/material/official")
public class MaterialOfficialController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private BorrowMaterialRepository borrowMaterialRepository;

    @Autowired
    private AppAdminService appAdminService;

    public Boolean isAdmin(){
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        return appAdminService.isAppAdmin("material",Yibanid);
    }


    @RequestMapping(value = "")
    public Object listBorrowMaterial(){
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        Iterable<BorrowMaterial> borrowMaterials = borrowMaterialRepository.findAll();
        return borrowMaterials;
    }

    @RequestMapping(value = "/creat",method = RequestMethod.GET)
    public Object creatMaterial(String name,String organization,String description,int totalnumber){
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        Material material=new Material(name,organization,description,totalnumber,totalnumber);
        materialRepository.save(material);

        return new JsonMes(1,"物资创建成功");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteMaterial(int materialId){
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        materialRepository.delete(materialId);
        return new JsonMes(1,"删除成功");
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public Object updateMaterial(int id,String name,String organization,String decription,int totalnumber) {
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        Material material = materialRepository.findOne(id);
        material.setName(name);
        material.setNumber(totalnumber);
        material.setDescription(decription);
        material.setOrganization(organization);
        materialRepository.save(material);

        return new JsonMes(1, "更改成功");
    }

    @RequestMapping(value = "/agree",method = RequestMethod.GET)
    public Object agreeBorrowMaterial(int borrowMaterialId,int isAgree){
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        BorrowMaterial borrowMaterial=borrowMaterialRepository.findOne(borrowMaterialId);
        borrowMaterial.setAgree(isAgree);
        borrowMaterialRepository.save(borrowMaterial);

        return new JsonMes(1,"操作完成");
    }
    @RequestMapping(value = "/evaluate",method = RequestMethod.GET)
    public Object evaluateBorrowMaterial(int borrowMaterialId,String returnStatus){
        if (isAdmin()==false) return new ErrorReporter(-1, "您没有权限操作");
        BorrowMaterial borrowMaterial = borrowMaterialRepository.findOne(borrowMaterialId);
        borrowMaterial.setReturn(true);
        borrowMaterial.setReturnStatus(returnStatus);
        borrowMaterialRepository.save(borrowMaterial);

        return new JsonMes(1,"评价成功");
    }
}
