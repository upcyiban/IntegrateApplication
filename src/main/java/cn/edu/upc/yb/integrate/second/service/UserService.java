package cn.edu.upc.yb.integrate.second.service;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.second.dto.YibanUserInfo;
import cn.edu.upc.yb.integrate.second.model.OurUser;
import cn.edu.upc.yb.integrate.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private YbInterfaceService ybInterfaceService;

    public boolean isOurUser(){
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        System.out.println(Yibanid);
        OurUser users = userRepository.findByUserid(Yibanid);
        if (users == null){
            return false;
        }else {
            return true;
        }
    }

    public Object registe() throws IOException {
        YibanUserInfo yibanUserInfo = ybInterfaceService.getYbUserInfo();
        OurUser user = new OurUser(yibanUserInfo.info.yb_userid,yibanUserInfo.info.yb_username,yibanUserInfo.info.yb_usernick,yibanUserInfo.info.yb_sex,yibanUserInfo.info.yb_userhead);
        userRepository.save(user);
        OurUser ouruser = userRepository.findTopByOrderByCreatetimeDesc();
        httpSession.setAttribute("ouruser",ouruser);
        return ouruser;
    }
}
