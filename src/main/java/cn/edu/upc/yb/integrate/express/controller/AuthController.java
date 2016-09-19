package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.express.config.ExpressConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wh980 on 2016/9/19.
 */
@RequestMapping("/express")
public class AuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private ExpressConfig expressConfig;

    @Autowired
    private CommonAdminService commonAdminService;

    public AuthController(){}

    public AuthController(YibanOAuth yibanOAuth){
        this.yibanOAuth=yibanOAuth;
    }

    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, expressConfig.appid,expressConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
