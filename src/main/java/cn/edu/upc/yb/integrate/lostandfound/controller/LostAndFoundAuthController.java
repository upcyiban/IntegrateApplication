package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.lostandfound.config.LostAndFoundConfig;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaojun on 2016/7/12.
 */
@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private LostAndFoundConfig lostAndFoundConfig;

    @Autowired
    private CommonAdminService commonAdminService;

    public LostAndFoundAuthController(){}

    public LostAndFoundAuthController(YibanOAuth yibanOAuth) {
        this.yibanOAuth = yibanOAuth;
    }



    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, lostAndFoundConfig.appid,lostAndFoundConfig.appkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
