package cn.edu.upc.yb.integrate.speaktoteacher.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.speaktoteacher.config.SttConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/3/29.
 */
public class SttAuthController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private SttConfig sttConfig;

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping(value = "/auth")
    public int doAuth(String vq){
        try {
            yibanOAuth.dealYibanOauth(vq,sttConfig.appid,sttConfig.appkey);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping(value = "/isauth")
    public int isAuth(){
        System.out.println(yibanOAuth.isAuth());
        return yibanOAuth.isAuth();
    }

    @RequestMapping("/logout")
    public int logOut(){
        httpSession.removeAttribute("user");
        return 1;
    }

    @RequestMapping("/isadmin")
    public int isAdmin() {
        if (commonAdminService.isCommonAdmin()) {
            return 1;
        } else {
            return 0;
        }
    }
}
