package cn.edu.upc.yb.integrate.deliverwater.controller;

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


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(String blockNumber, String dormitory, String name, String phone, @RequestParam(value = "num", defaultValue = "0") int num) {
        if (0 == num) {
            DeliverWater deliverWater = new DeliverWater(blockNumber, dormitory, name, phone);
            userDao.save(deliverWater);
        }else{
            DeliverWater deliverWater = new DeliverWater(blockNumber,dormitory,name,phone,num);
            userDao.save(deliverWater);
        }
        return new JsonMes(1,"提交成功");

    }
}
