package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.express.model.ExpressOrder;
import cn.edu.upc.yb.integrate.express.repository.ExpressAddressRepository;
import cn.edu.upc.yb.integrate.express.repository.ExpressOrderRepository;
import cn.edu.upc.yb.integrate.express.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by wh980 on 2016/9/7.
 */
@RequestMapping("/express")
public class ExpressIndexController {
    @Autowired
    ExpressOrderRepository expressOrderRepository;

    @Autowired
    YibanBasicUserInfo yibanBasicUserInfo;

    @Autowired
    YibanOAuth yibanOAuth;

    @Autowired
    HttpSession httpSession;

    @Autowired
    ExpressAddressRepository expressAddressRepository;

    @RequestMapping("/")
    public Object showOrderToUser(){
         if (httpSession.getAttribute("user")==null) {
             return new JsonMes(-1,"您未认证");
         }
         yibanBasicUserInfo=(YibanBasicUserInfo) httpSession.getAttribute("user");
        int yibanid=yibanBasicUserInfo.visit_user.userid;
        Iterable<ExpressOrder> expressOrders=expressOrderRepository.findByYibanid(yibanid);
        return  expressOrders;
    }

    @RequestMapping(value = "/usercreatorder",method = RequestMethod.GET)
    public Object usercreatorder(String number, String company, String details,int addressid){

        Date date;

      return 0;



    }

    @RequestMapping(value = "/userdeleteorder",method = RequestMethod.GET)
    public Object userdeleteOrder(int id){
        expressOrderRepository.delete(id);
        return new JsonMes(1,"删除成功");
    }



    

}
