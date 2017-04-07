package cn.edu.upc.yb.integrate.speaktoteacher.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.speaktoteacher.config.SttConfig;
import cn.edu.upc.yb.integrate.speaktoteacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@RestController
@RequestMapping("/speaktoteacher")
public class SttAuthController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private SttConfig sttConfig;

    @Autowired
    private YibanOAuth yibanOAuth;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/auth")
    public int doAuth(String vq){
        try {
            yibanOAuth.dealYibanOauth(vq,sttConfig.appid,sttConfig.appkey);
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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object isTeacher(int ybid) {
        if(httpSession.getAttribute("user")==null) return new ErrorReporter(-1,"没有登陆");
        return teacherService.isTeacher(ybid);
    }
}
