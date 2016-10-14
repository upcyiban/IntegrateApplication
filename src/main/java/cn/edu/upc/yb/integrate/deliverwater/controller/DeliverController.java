package cn.edu.upc.yb.integrate.deliverwater.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
@RestController
@RequestMapping("/deliverwater")
public class DeliverController {
    @Autowired
    DeliverWaterDao userDao;

    @Autowired
    private CommonAdminService commonAdminService;

    @Autowired
    DeliverWaterDao deliverWaterDao;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object create(String blockNumber, String dormitory, String name, String phone,@RequestParam(value = "num", defaultValue = "1") int num) {
        DeliverWater deliverWater = new DeliverWater(blockNumber, dormitory, name, phone,num);
        System.out.println("name:" + name);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");
    }

//    @RequestMapping("/show")
//    public Object dataShow(){
//        deliverWaterDao.findByIsdeal(false);
//    }


}
