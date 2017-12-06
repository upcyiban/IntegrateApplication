package cn.edu.upc.yb.integrate.common.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2017/4/3.
 */
@RestController
@RequestMapping("/userinfo")
public class UserInforController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/getid")
    public Object getId(){
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
        if(yibanBasicUserInfo == null)
            return new ErrorReporter(-1,"没有登陆");
        return yibanBasicUserInfo.visit_user.userid;
    }
}
