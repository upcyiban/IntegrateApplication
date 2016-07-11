package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.bulletinboard.config.BulletinBoardOauthConfig;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private BulletinBoardOauthConfig b;

    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, b.appid, b.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
