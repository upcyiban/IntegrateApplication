package cn.edu.upc.yb.integrate.calendar.controller;

import cn.edu.upc.yb.integrate.calendar.config.Config;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Jaxlying on 2016/7/10.
 */
@RestController
public class LoginController {

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/callogin",method = RequestMethod.POST)
    public Object login(String admin,String password){
        if(admin.equals(Config.admin)&&password.equals(Config.password)) {
            httpSession.setAttribute("admin", true);
            return new JsonMes(1, "登陆成功");
        }
        return new JsonMes(0,"用户名或密码错误");
    }




}
