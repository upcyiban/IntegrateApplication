package cn.edu.upc.yb.integrate.lottery.controller;

import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/7/12.
 */
@RestController
@RequestMapping("/lottery")
public class LotteryAuthController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/isauth")
    public int isAuth(){
        if (httpSession.getAttribute("user")!=null){
            return 1;
        }else {
            return 0;
        }
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
