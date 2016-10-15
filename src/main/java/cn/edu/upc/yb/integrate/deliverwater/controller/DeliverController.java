package cn.edu.upc.yb.integrate.deliverwater.controller;

import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import cn.edu.upc.yb.integrate.deliverwater.service.WriteExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Iterator;

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

    @Autowired
    WriteExcelService writeExcelService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object create(String blockNumber,@RequestParam("dormitory") String dormitory, String name, String phone,@RequestParam(value = "num", defaultValue = "1") int num) {
        DeliverWater deliverWater = new DeliverWater(blockNumber, dormitory, name, phone,num);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");
    }

    @RequestMapping("/show")
    public Object dataShow() throws IOException {
        Iterable<DeliverWater> iterable =  deliverWaterDao.findByIsdeal(false);
        Iterator<DeliverWater> iterator = iterable.iterator();
        writeExcelService.writeExcel(iterator);
        return new JsonMes(1,"打印成功");
    }


}
