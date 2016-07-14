package cn.edu.upc.yb.integrate.bulletinboard.controller;

import cn.edu.upc.yb.integrate.bulletinboard.dao.NotificationDao;
import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import cn.edu.upc.yb.integrate.bulletinboard.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/7/8.
 */
@RestController
@RequestMapping("/bbs")
public class NotificationController {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/getnewest")
    public Notification getNewestMessage(){
        return notificationDao.findFirstByOrderByIdDesc();
    }

    @RequestMapping("/getall")
    public Iterable<Notification> getAllMessage(){
        return notificationDao.findAllByOrderByIdDesc();
    }

    @RequestMapping(value = "/postnew", method = RequestMethod.POST)
    public Object postNew(String title, String message, String tag){
        return notificationService.postNew(title, message, tag);
    }

    @RequestMapping("/detele")
    public Object deleteNotification(int Nid){
        return notificationService.deleteOne(Nid);
    }

}
