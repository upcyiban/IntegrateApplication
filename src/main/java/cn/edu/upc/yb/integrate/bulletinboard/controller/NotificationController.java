package cn.edu.upc.yb.integrate.bulletinboard.controller;

import cn.edu.upc.yb.integrate.bulletinboard.dao.NotificationDao;
import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/7/8.
 */
@RestController
@RequestMapping("/bbs")
public class NotificationController {

    @Autowired
    private NotificationDao notificationDao;

    @RequestMapping("/getnewest")
    public Notification getNewestMessage(){
        return notificationDao.findFirstByOrderByIdDesc();
    }

    @RequestMapping("/getall")
    public Iterable<Notification> getAllMessage(){
        return notificationDao.findAll();
    }



}
