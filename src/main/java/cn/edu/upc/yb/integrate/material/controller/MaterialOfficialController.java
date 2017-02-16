package cn.edu.upc.yb.integrate.material.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.material.model.BorrowMaterial;
import cn.edu.upc.yb.integrate.material.model.Material;
import cn.edu.upc.yb.integrate.material.repository.BorrowMaterialRepository;
import cn.edu.upc.yb.integrate.material.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private BorrowMaterialRepository borrowMaterialRepository;

    @Autowired
    private CommonAdminService commonAdminService;


    @RequestMapping(value = "")
    public Object listBorrowMaterial(){
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Iterable<BorrowMaterial> borrowMaterials = borrowMaterialRepository.findAll();
        return borrowMaterials;
    }

    @RequestMapping(value = "/creat",method = RequestMethod.POST)
    public Object creatMaterial(String name,String organization,String description,int totalnumber){
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Material material=new Material(name,organization,description,totalnumber,totalnumber);
        materialRepository.save(material);

        return new JsonMes(1,"物资创建成功");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleteMaterial(int materialId){
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        materialRepository.delete(materialId);
        return new JsonMes(1,"删除成功");
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateMaterial(int id,String name,String organization,String decription,int totalnumber) {
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Material material = materialRepository.findOne(id);
        material.setName(name);
        material.setNumber(totalnumber);
        material.setDescription(decription);
        material.setOrganization(organization);
        materialRepository.save(material);

        return new JsonMes(1, "更改成功");
    }

    @RequestMapping(value = "/agree",method = RequestMethod.POST)
    public Object agreeBorrowMaterial(int borrowMaterialId){
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        BorrowMaterial borrowMaterial=borrowMaterialRepository.findOne(borrowMaterialId);
        borrowMaterial.setAgree(true);
        borrowMaterialRepository.save(borrowMaterial);

        return new JsonMes(1,"已同意");
    }
    @RequestMapping(value = "/evaluate",method = RequestMethod.POST)
    public Object evaluateBorrowMaterial(int borrowMaterialId,String returnStatus){
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        BorrowMaterial borrowMaterial = borrowMaterialRepository.findOne(borrowMaterialId);
        borrowMaterial.setReturn(true);
        borrowMaterial.setReturnStatus(returnStatus);
        borrowMaterialRepository.save(borrowMaterial);

        return new JsonMes(1,"评价成功");
    }
}
