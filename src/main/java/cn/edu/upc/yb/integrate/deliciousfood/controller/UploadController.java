package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.common.service.FileUploadService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliciousfood.dto.ResultData;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by 陈子枫 on 2017/2/23.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    public static final String ROOT = "imgpath";

    @Autowired
    CommonAdminService commonAdminService;

    @Autowired
    VarietyOfDishesDao varietyOfDishesDao;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping(method =  RequestMethod.POST,value = "/photo")
    public Object storePhoto(MultipartFile file,int dishid){
        YibanBasicUserInfo yibanBasicUserInfo =(YibanBasicUserInfo) httpSession.getAttribute("user");
        String name = "deliciousfood"+ yibanBasicUserInfo.visit_user.userid+System.currentTimeMillis();
        VarietyOfDishes varietyOfDishes = varietyOfDishesDao.findOne(dishid);
        if(varietyOfDishes == null)
            return new JsonMes(-1,"未找到");
        varietyOfDishes.setPath("file/img/"+name);
        varietyOfDishesDao.save(varietyOfDishes);
        fileUploadService.store(file,name);
        return new JsonMes(1,"上传成功");
    }

}
