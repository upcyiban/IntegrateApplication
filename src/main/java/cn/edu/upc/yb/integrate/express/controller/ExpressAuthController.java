package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.express.config.ExpressConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/auth")
    public int doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, expressConfig.appid,expressConfig.appkey);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping("/isauth")
    public int isAuth() {
        return yibanOAuth.isAuth();
    }

    @RequestMapping("/logout")
    public int logout(){
        httpSession.removeAttribute("user");
        return 1;
    }

    @RequestMapping("/isAdmin")
    public int isAdmin(){
        if (commonAdminService.isCommonAdmin()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
