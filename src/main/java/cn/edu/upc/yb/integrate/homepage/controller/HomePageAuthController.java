package cn.edu.upc.yb.integrate.homepage.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.homepage.config.HomePageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ybdevelop on 2016/10/21.
 */
@RestController
@RequestMapping("/homepage")
public class HomePageAuthController {
    @Autowired
    HomePageConfig homePageConfig;
    @Autowired
    YibanOAuth yibanOAuth;
    @Autowired
    CommonAdminService commonAdminService;

    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, homePageConfig.appid, homePageConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
