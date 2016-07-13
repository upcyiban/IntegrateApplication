package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.lostandfound.model.User;
import cn.edu.upc.yb.integrate.lostandfound.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by wanghaojun on 2016/7/12.
 */

@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundUserController {

    @Autowired
    private UserDao userDao;




    @RequestMapping("/findloser")
    public Object showFindloser(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {

        Pageable pageable = new PageRequest(page, size);
        Page<User> pages = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true, false, pageable);

        return pages;
    }

    @RequestMapping("/findthing")
    public Object showFindthing(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {

        Pageable pageable = new PageRequest(page,size);
        Page<User> pages = userDao.findByIsdeletNotAndIsloserNotOrderByDateDesc(true,true,pageable);
        return pages;
    }

//    @RequestMapping(value = "/publish", method = RequestMethod.POST)
//    public String publish(String title, String detail, String what, Model model) {
//
//        Boolean wa = true;
//        if(what.equals("1")){
//            wa = false;
//        }
//
//        String date = new Date().toString();
//
//      // YibanBasicUserInfo.VisitUser visitUser=
//
//        User user = new User(yibanBasicUserInfo.VisitUser.user.ybuserid,ybusername, ybusernick,ybsex,title,detail,0,date,null,false,wa);
//
//        return "result";
//    }


}
