package cn.edu.upc.yb.integrate.deliverwater.controller;

import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
@RestController
@RequestMapping("/deliverwater")
public class DeliverController {
    @Autowired
    DeliverWaterDao userDao;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object create(String blockNumber, String dormitory, String name, String phone) {
        DeliverWater deliverWater = new DeliverWater(blockNumber, dormitory, name, phone);
        System.out.println("name:" + name);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Object store(String blockNumber, String dormitory, String name, String phone) {
        DeliverWater deliverWater = new DeliverWater(blockNumber, dormitory, name, phone);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");
    }
//    @RequestMapping(value = "/judgetime",method = RequestMethod.GET)
//    public Object judge(){
//
//
//    }

}
