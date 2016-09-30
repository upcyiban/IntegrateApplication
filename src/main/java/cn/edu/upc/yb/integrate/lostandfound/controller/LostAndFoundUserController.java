package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.common.auth.YibanOAuth;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.lostandfound.dao.OfficialDao;
import cn.edu.upc.yb.integrate.lostandfound.model.Official;
import cn.edu.upc.yb.integrate.lostandfound.model.User;
import cn.edu.upc.yb.integrate.lostandfound.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by wanghaojun on 2016/7/12.
 */

@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundUserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    OfficialDao officialDao;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private  CommonAdminService commonAdminService;


    @RequestMapping("/findloser")
    public Object showFindloser(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");

        Iterable<User> users = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true, false);

        return users;
    }

    @RequestMapping("/findthing")
    public Object showFindthing(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");

       Iterable<User> users = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true, true);
        return users;
    }

    @RequestMapping("/publish")
    public Object showPublis() {
        return new JsonMes(1, "创建成功");
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Object publish(String title, String detail, String what, Model model) {
      if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        Boolean wa = true;
        if (what.equals("1")) {
            wa = false;
        }
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
        String date = new Date().toString();

        String ybuserid = Integer.toString(yibanBasicUserInfo.visit_user.userid);
        String ybusername = yibanBasicUserInfo.visit_user.username;
        String ybusernick = yibanBasicUserInfo.visit_user.username;
        String ybsex = Character.toString(yibanBasicUserInfo.visit_user.usersex);

        User user = new User(ybuserid, ybusername, ybusernick, ybsex, title, detail, 0, date, null, false, wa);
        userDao.save(user);
        return new JsonMes(1, "创建成功");
    }

//    @RequestMapping("/test")
//    public void contextLoads() {
//        for (int i = 0; i < 10; i++) {
//            DeliverWater user = new DeliverWater("id" + i, "name" + i, "nickname" + i, "M", "title" + i, "detail" + i, 1, new Date().toString(), null, false, true);
//            userDao.save(user);
//            Official official = new Official("123","456","789");
//
//            officialDao.save(official);
//        }
//    }



}
