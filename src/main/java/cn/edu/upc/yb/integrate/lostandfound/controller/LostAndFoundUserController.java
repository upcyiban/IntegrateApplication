package cn.edu.upc.yb.integrate.lostandfound.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.lostandfound.dao.LostAndFoundUserDao;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundUser;
import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpExchange;
import java.util.Date;

/**
 * Created by 17797 on 2017/5/30.
 */
@RestController
@RequestMapping("/lostandfound")
public class LostAndFoundUserController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private LostAndFoundUserDao userDao;

    @RequestMapping(value = "/showall")
    public Object showAll()
    {
        return userDao.findAll();
    }

    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public Object publish(String title,String detail,String what)
    {
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(0,"没有登陆");
        // what==0 丢东西，what==1 捡到东西
        Boolean wa = true;
        if(what.equals("1")){
            wa = false;
        }
        String date = new Date().toString();
        String ybuserid = httpSession.getAttribute("userid").toString();
        String ybusername = httpSession.getAttribute("username").toString();
        String ybusernick = httpSession.getAttribute("usernick").toString();
        String ybsex = httpSession.getAttribute("usersex").toString();
        LostAndFoundUser user = new LostAndFoundUser(ybuserid,ybusername, ybusernick,ybsex,title,detail,0,date,null,false,wa);
        userDao.save(user);
        return "发布成功";
    }

    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public Object shoeFindUser(){
        return userDao.findByIsdeletNotAndIsloserNotOrderByIdDesc(true,false);
    }

    @RequestMapping(value = "/findthing",method = RequestMethod.GET)
    public Object showFindthing()
    {
        return userDao.findByIsdeletNotAndIsloserNotOrderByIdDesc(true,true);
    }
}
