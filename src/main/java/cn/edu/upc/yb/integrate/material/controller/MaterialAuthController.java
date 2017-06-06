package cn.edu.upc.yb.integrate.material.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.material.config.MaterialConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/2/16.
 */
@RestController
@RequestMapping("/material")
public class MaterialAuthController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private MaterialConfig materialConfig;

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private AppAdminService appAdminService;

    @RequestMapping(value = "/auth")
    public int doAuth(String vq){
        try {
            yibanOAuth.dealYibanOauth(vq,materialConfig.appid,materialConfig.appkey);
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
        if (httpSession.getAttribute("user") == null){
            return 0;
        }
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        if (appAdminService.isAppAdmin("material",Yibanid)) {
            return 1;
        } else {
            return 0;
        }
    }

}
