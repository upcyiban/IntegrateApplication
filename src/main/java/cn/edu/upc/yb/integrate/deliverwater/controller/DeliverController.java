package cn.edu.upc.yb.integrate.deliverwater.controller;


import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import cn.edu.upc.yb.integrate.deliverwater.service.WriteExcelService;
import cn.edu.upc.yb.integrate.deliverwater.util.Telephone;
import cn.edu.upc.yb.integrate.deliverwater.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    HttpSession httpSession;

    @Autowired
    DeliverWaterDao deliverWaterDao;

    @Autowired
    WriteExcelService writeExcelService;

    /*
    *给用户的接口，让用户填信息
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object create(String blockNumber, String dormitory, String name, String phone, @RequestParam(value = "num", defaultValue = "1") int num) {
//        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
//      //  int yibanid = yibanBasicUserInfo.visit_user.userid;
//        //String yibanName = yibanBasicUserInfo.visit_user.username;

        int yibanid = 1;
        String yibanName = "哈哈";
        if (!Telephone.isCellPhone(phone)) {
            return new JsonMes(-1, "你的电话号码有误");
        }
        DeliverWater deliverWater = new DeliverWater(yibanid, yibanName, blockNumber, dormitory, name, phone, num);
        System.out.println("yibanId:" + yibanid);
        System.out.println("name:" + yibanName);
        System.out.println("domitory: " + dormitory);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");
    }


    @RequestMapping("/show")
    public Object dataShow() throws IOException {
        Iterable<DeliverWater> iterable = deliverWaterDao.findByIsdeal(false);
        Iterator<DeliverWater> iterator = iterable.iterator();
        Time time = new Time();

        if (!time.judgeTime(iterator.next().getCreateAt())) {   //判断订单创建时间是否是今日20点前
            writeExcelService.writeExcel(iterator);
        }
        return new JsonMes(1, "打印成功");
    }


}
