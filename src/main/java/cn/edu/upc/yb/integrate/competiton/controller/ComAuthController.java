package cn.edu.upc.yb.integrate.competiton.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.competiton.config.CompetionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by wanghaojun on 2017/4/9.
 */
@RestController
@RequestMapping("/competition")
public class ComAuthController {


        @Autowired
        private HttpSession httpSession;

        @Autowired
        private CompetionConfig competionConfig;

        @Autowired
        private YibanOAuth yibanOAuth;

        @Autowired
        private CommonAdminService commonAdminService;

        @RequestMapping(value = "/auth")
        public int doAuth(String vq){
            try {
                yibanOAuth.dealYibanOauth(vq,competionConfig.appid,competionConfig.appkey);
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

