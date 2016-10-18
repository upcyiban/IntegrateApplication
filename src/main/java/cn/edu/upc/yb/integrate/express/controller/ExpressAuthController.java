package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.express.config.ExpressConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wh980 on 2016/9/19.
 */
@RestController
@RequestMapping("/express")
public class ExpressAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private ExpressConfig expressConfig;

    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, expressConfig.appid,expressConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
