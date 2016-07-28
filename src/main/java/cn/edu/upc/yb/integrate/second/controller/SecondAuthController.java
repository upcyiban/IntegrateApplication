package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.second.config.SecondConfig;
import cn.edu.upc.yb.integrate.second.repository.UserRepository;
import cn.edu.upc.yb.integrate.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second")
public class SecondAuthController {

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private SecondConfig secondConfig;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/auth")
    public void doAuth(String vq) {
        try {
            yibanOAuth.dealYibanOauth(vq, secondConfig.appid, secondConfig.appkey);
            int id =0;
            if(httpSession.getAttribute("user") != null) {
                id = ((YibanBasicUserInfo) httpSession.getAttribute("user")).visit_user.userid;
            }
            if (userService.isOurUser() == true) {
                httpSession.setAttribute("ouruser",userRepository.findByUserid(id));
            } else {
               userService.registe();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
