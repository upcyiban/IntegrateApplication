package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.config.CalendarConfig;
import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
public class CalendarAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private CalendarConfig calendarConfig;

    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, calendarConfig.appid, calendarConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
