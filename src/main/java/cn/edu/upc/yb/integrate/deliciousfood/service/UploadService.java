package cn.edu.upc.yb.integrate.deliciousfood.service;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.common.service.FileUploadService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by chenzifeng on 2017/4/22.
 */
@Service
public class UploadService {

    @Autowired
    CommonAdminService commonAdminService;

    @Autowired
    VarietyOfDishesDao varietyOfDishesDao;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    HttpSession httpSession;

    public void storePhoto(MultipartFile file, int dishid,int ybid){
        String name = "deliciousfood"+ ybid+System.currentTimeMillis();
        VarietyOfDishes varietyOfDishes = varietyOfDishesDao.findOne(dishid);
        varietyOfDishes.setPath("file/img/"+name);
        varietyOfDishesDao.save(varietyOfDishes);
        fileUploadService.store(file,name);
    }
}
