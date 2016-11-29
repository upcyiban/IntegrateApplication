package cn.edu.upc.yb.integrate.ballot.controller;

import cn.edu.upc.yb.integrate.bulletinboard.config.BulletinBoardOauthConfig;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Jaxlying on 2016/11/29.
 */
@RestController
@RequestMapping("/ballot")
public class BallotAuthController {

    @Autowired
    private HttpSession httpSession;

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

    @RequestMapping("/isauth")
    public int isAuth() {
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