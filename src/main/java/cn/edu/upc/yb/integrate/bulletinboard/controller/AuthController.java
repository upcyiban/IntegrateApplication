package cn.edu.upc.yb.integrate.bulletinboard.controller;

import cn.edu.upc.yb.integrate.bulletinboard.config.BulletinBoardOauthConfig;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/7/8.
 */
@RestController
@RequestMapping("/bbs")
public class AuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private BulletinBoardOauthConfig b;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/auth")
    public int doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, b.appid, b.appkey);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/isadmin")
    public int isAdmin(){
        if (commonAdminService.isCommonAdmin()){
            return 1;
        }else {
            return 0;
        }
    }

}
