package cn.edu.upc.yb.integrate.common.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2017/4/2.
 */
@RestController
public class AppAdminController {

    @Autowired
    private AppAdminService appAdminService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/isadmin")
    public Object isadmin(String appName){
        YibanBasicUserInfo yibanBasicUserInfo =(YibanBasicUserInfo) httpSession.getAttribute("user");
        if (yibanBasicUserInfo == null)
            return new ErrorReporter(-1,"没有登陆");
        if(appAdminService.isAppAdmin(appName,yibanBasicUserInfo.visit_user.userid) == false){
            return false;
        }
        return true;
    }
}
