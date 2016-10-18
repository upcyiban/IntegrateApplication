package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.express.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wh980 on 2016/9/7.
 */
@RequestMapping("/express")
public class IndexController {
    @Autowired
    OrderDao orderDao;

    @Autowired
    YibanBasicUserInfo yibanBasicUserInfo;

    @Autowired
    YibanOAuth yibanOAuth;

    @RequestMapping("/")
    public Object userIndex(){


        return  0;
    }

}
