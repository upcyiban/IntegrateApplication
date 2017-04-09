package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.config.DeliciousFoodConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by chenzifeng on 2017/4/7.
 */
@RequestMapping("/food")
@RestController
public class FoodAuthController {

    @Autowired
    YibanOAuth yibanOAuth;

    @Autowired
    HttpSession httpSession;

    @Autowired
    DeliciousFoodConfig deliciousFoodConfig;

    @Autowired
    CommonAdminService commonAdminService;


    @RequestMapping("/auth")
    public int doAuth(String vq){
            try {
                yibanOAuth.dealYibanOauth(vq,deliciousFoodConfig.appid,deliciousFoodConfig.appkey);
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
