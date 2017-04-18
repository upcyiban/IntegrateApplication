package cn.edu.upc.yb.integrate.ballot;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2017/2/2.
 */
public class Debug {

    @Autowired
    private HttpSession httpSession;

    public void debug(){
        YibanBasicUserInfo yb = new YibanBasicUserInfo();
        yb.visit_time = 1;
        yb.visit_user.userid = 1;
        yb.visit_user.username = "admin";
        yb.visit_user.usernick = "admin";
        yb.visit_user.usernick = "admin";
        httpSession.setAttribute("user",yb);
    }
}
