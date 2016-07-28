package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.second.repository.UserRepository;
import cn.edu.upc.yb.integrate.second.service.UserService;
import cn.edu.upc.yb.integrate.second.service.YbInterfaceService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private YbInterfaceService ybInterfaceService;

    @RequestMapping("/getuserinfo")
    @JsonIgnore
    public Object getUserInforMation() throws IOException {
        int id =0;
        if(httpSession.getAttribute("user") != null) {
            id = ((YibanBasicUserInfo) httpSession.getAttribute("user")).visit_user.userid;
        }
        if (userService.isOurUser() == true) {
            httpSession.setAttribute("ouruser",userRepository.findByUserid(id));
            return userRepository.findByUserid(id);
        } else {
            return userService.registe();
        }
    }

    @RequestMapping("/user/other")
    public Object getOther(int id) throws IOException {
        return ybInterfaceService.getOtherInfo(id);
    }
}
