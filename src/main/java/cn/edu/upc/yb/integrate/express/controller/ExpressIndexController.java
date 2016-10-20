package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.express.model.ExpressOrder;
import cn.edu.upc.yb.integrate.express.repository.ExpressOrderRepository;
import cn.edu.upc.yb.integrate.express.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

/**
 * Created by wh980 on 2016/9/7.
 */
@RequestMapping("/express")
public class ExpressIndexController {
    @Autowired
    ExpressOrderRepository orderRepository;

    @Autowired
    YibanBasicUserInfo yibanBasicUserInfo;

    @Autowired
    YibanOAuth yibanOAuth;

    @Autowired
    HttpSession httpSession;

    @RequestMapping("/")
    public Object showOrderToUser(){
         if (httpSession.getAttribute("user")==null) {
             return new JsonMes(-1,"您未认证");
         }
         yibanBasicUserInfo=(YibanBasicUserInfo) httpSession.getAttribute("user");
        int yibanid=yibanBasicUserInfo.visit_user.userid;
        Iterable<ExpressOrder> expressOrders=orderRepository.findByYibanid(yibanid);
        return  expressOrders;
    }

    

}
