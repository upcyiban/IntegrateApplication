package cn.edu.upc.yb.integrate.material.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
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
 * Created by wanghaojun on 2017/2/11.
 */
@RestController
@RequestMapping(value = "/material")
public class MaterialController {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    BorrowMaterialRepository borrowMaterialRepository;

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object listMaterial(){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");

        long time = System.currentTimeMillis();
        Iterable<Material> materials = materialRepository.findAll();
        Iterator<Material> materialIterator = materials.iterator();
        while (materialIterator.hasNext()){
            int number = 0;//存放正在被借用的此类物资数目
            Material material = materialIterator.next();
            try {
                Iterable<BorrowMaterial> borrowMaterials = borrowMaterialRepository.findByMaterialId(material.getId());
                Iterator<BorrowMaterial> borrowMaterialIterator = borrowMaterials.iterator();
                while (borrowMaterialIterator.hasNext()){
                    BorrowMaterial borrowMaterial=borrowMaterialIterator.next();
                    if(borrowMaterial.getStartTime()<=time && !borrowMaterial.isReturn() && borrowMaterial.isAgree()){
                        number = borrowMaterial.getBorrowNumber()+number;
                        System.out.println(number);
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                if (number == 0){
                    material.setNumber(material.getTotalNumber());
                }
                else {
                    material.setNumber(material.getTotalNumber()-number);
                }
            }
        }


        return materialRepository.findAll();

    }

    @RequestMapping(value = "/creat",method = RequestMethod.GET)
    public Object creatBorrowMaterial(String borrowerName, String borrowerNumber,String reason,int materialId, int borrowNumber,long startTime,long endTime ){
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo yibanBasicUserInfo=(YibanBasicUserInfo) httpSession.getAttribute("user");
        int borrowerYibanId = yibanBasicUserInfo.visit_user.userid;

        long creatTime = System.currentTimeMillis();
        System.out.println(creatTime);
        System.out.println(borrowerName+borrowerNumber+borrowerYibanId+materialId+borrowNumber+reason);
        BorrowMaterial borrowMaterial=new BorrowMaterial(borrowerName,borrowerNumber,borrowerYibanId,reason,startTime,endTime,creatTime,materialId,borrowNumber);
        borrowMaterial.setAgree(false);
        borrowMaterial.setReturn(false);
        borrowMaterialRepository.save(borrowMaterial);
        return new JsonMes(1,"创建成功");
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Object listUserBorrowMaterial(){
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo yibanBasicUserInfo=(YibanBasicUserInfo) httpSession.getAttribute("user");
        int ybid = yibanBasicUserInfo.visit_user.userid;
        return borrowMaterialRepository.findByBorrowerYibanId(ybid);
    }

    @RequestMapping(value = "/getOneMaterial",method = RequestMethod.GET)
    public Object getOneMaterial(int materialId){
        int number = 0;
        Material material=materialRepository.findOne(materialId);
        long time = System.currentTimeMillis();
        try {
            Iterable<BorrowMaterial> borrowMaterials = borrowMaterialRepository.findByMaterialId(material.getId());
            Iterator<BorrowMaterial> borrowMaterialIterator = borrowMaterials.iterator();
            while (borrowMaterialIterator.hasNext()){
                BorrowMaterial borrowMaterial=borrowMaterialIterator.next();
                if(borrowMaterial.getStartTime()<=time && !borrowMaterial.isReturn() && borrowMaterial.isAgree()){
                    number = borrowMaterial.getBorrowNumber()+number;
                    System.out.println(number);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (number == 0){
                material.setNumber(material.getTotalNumber());
            }
            else {
                material.setNumber(material.getTotalNumber()-number);
            }
        }

        return material;
    }
}
